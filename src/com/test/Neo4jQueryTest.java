package com.test;

import org.apache.commons.io.FileUtils;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserterIndex;
import org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider;
import org.neo4j.unsafe.batchinsert.BatchInserters;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Diak on 2017/4/23.
 */
public class Neo4jQueryTest {

//    private String dbPath = "D:\\BIMTest\\databases\\QueryTestDB";
    private String dbPath;
    private long nodeCount;
    private Label label1 = new Label() {
        @Override
        public String name() {
            return "First";
        }
    };
    private Label label2 = new Label() {
        @Override
        public String name() {
            return "Second";
        }
    };

    public Neo4jQueryTest(String dbPath, long nodeCount){
        this.dbPath = dbPath;
        this.nodeCount = nodeCount;
    }

    private static enum RelTypes implements RelationshipType {
        relationship1;
    }

    private void clearDB(){
        try{
            FileUtils.deleteDirectory(new File(dbPath));//变成输入的参数
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //store a node                          存储单个节点
    //index a node                          索引单个节点


    //store nodes by batch without index    批量存储海量节点，不建索引
    public void storeWithoutIndex(){
        try{
            clearDB();
            long start,end;
            BatchInserter inserter = BatchInserters.inserter(new File(dbPath));
            Map<String, Object> nodeMap = new HashMap<>();
            start = System.currentTimeMillis();
            for(long i = 1; i < nodeCount; i++){
                nodeMap.put("attribute1",i%10);
                nodeMap.put("attribute2",i%1000);
                nodeMap.put("attribute3",i%100000);
                nodeMap.put("attribute4", i % 10000000);
                if(i<(nodeCount/2)){
                    inserter.createNode(i, nodeMap, label1);//这里要加上label
                }else{
                    inserter.createNode(i, nodeMap, label2);
                }
            }
            end = System.currentTimeMillis();
            System.out.println("create-node-time:" + (end - start) + "ms");

            //create relationship           创建关系
            long relID;
            start = System.currentTimeMillis();
            Map<String, Object> relMap = new HashMap<>();
            for(long i = 1; i < nodeCount-1; i++){
                relMap.put("relAttribute1",i);
                relID = inserter.createRelationship(i, i + 1,RelTypes.relationship1,relMap);
            }
            end = System.currentTimeMillis();
            System.out.println("create-relationship-time:" + (end - start) + "ms");

            inserter.shutdown();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //store nodes by batch with index       批量存储海量节点，批量建索引（这是指节点的每个属性都建立索引吗？如果是的话，那建立索引的时间一样吗？）
    public void StoreWithIndex(){
        try{
            clearDB();
            BatchInserter inserter = BatchInserters.inserter(new File(dbPath));
            BatchInserterIndexProvider indexProvider = new LuceneBatchInserterIndexProvider(inserter);
            BatchInserterIndex nodeIndex = indexProvider.nodeIndex("nodes", MapUtil.stringMap("type","exact"));
            BatchInserterIndex relationshipIndex = indexProvider.relationshipIndex("relationships", MapUtil.stringMap("type", "exact"));
            long start,end;
            Map<String, Object> nodeMap = new HashMap<>();
            start = System.currentTimeMillis();
            for(long i = 1; i < nodeCount; i++){
                nodeMap.put("attribute1",i%10);
                nodeMap.put("attribute2", i % 1000);
                nodeMap.put("attribute3", i % 100000);
                nodeMap.put("attribute4", i % 10000000);
                if(i<(nodeCount/2)){
                    inserter.createNode(i, nodeMap, label1);//这里要加上label
                }else{
                    inserter.createNode(i, nodeMap, label2);
                }
                nodeIndex.add(i, nodeMap);//所有的属性都键入了index
            }
            end = System.currentTimeMillis();
            System.out.println("create-node-time:" + (end - start) + "ms");


            //create relationship           创建关系
            long relID;
            start = System.currentTimeMillis();
            Map<String, Object> relMap = new HashMap<>();
            for(long i = 1; i < nodeCount-1; i++){
                relMap.put("relAttribute1",i);
                relID = inserter.createRelationship(i, i + 1,RelTypes.relationship1,relMap);
                relationshipIndex.add(relID,relMap);
            }
            end = System.currentTimeMillis();
            System.out.println("create-relationship&index-time:" + (end - start) + "ms");


            indexProvider.shutdown();
            inserter.shutdown();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //get GraphDB                           获取graphdbservice实例
    public GraphDatabaseService getGraphDBService(){
        long start,end;
        start = System.currentTimeMillis();
        GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(dbPath));
        end = System.currentTimeMillis();
        System.out.println("getGraphDBService-time:" + (end - start) + "ms");
        return graphdb;
    }

    //query non-index nodes                 查询无索引节点
    //query index nodes                     查询有索引节点
    //这两种情况下都可以直接用cypher来进行查询。API当然满足不了绝大部分的查询；在有索引的情况下，cypher的执行计划会自动使用索引。
    //使用profile可以探测执行计划有多少次db访问
    public void cypherQuery(GraphDatabaseService graphDatabaseService){
        //在数据量为1千万的情况下，使用无/有索引数据库
        //query 1: 查询id为9999的node
        //query 2: 查询label1,attribute1为9的node
        //query 3: 查询label1,attribute2为9的node
        //query 4: 查询label1,attribute3为9的node
        //query 5: 查询label1,attribute4为9的node
        //query 6: 查询关联关系（要对比es的表连接查询）
        long start, end;
        Result result;
        String query1 = "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4";
        String query2 = "match (n{attribute1:9}) return count(n)";
        String query3 = "match (n{attribute2:9}) return count(n)";
        String query4 = "match (n{attribute3:9}) return count(n)";
        String query5 = "match (n{attribute4:9}) return count(n)";
        String query6 = "match (n:First{attribute1:9}) return count(n)";
        String query7 = ":schema";
//        String query6 = "match (n)-()";//1.这个relationship有没有添加索引？2.有没有定义不同的relType？

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query1);
        end = System.currentTimeMillis();
        System.out.println("query-byID-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query2);
        end = System.currentTimeMillis();
        System.out.println("query-attribute1-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query3);
        end = System.currentTimeMillis();
        System.out.println("query-attribute2-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query4);
        end = System.currentTimeMillis();
        System.out.println("query-attribute3-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query5);
        end = System.currentTimeMillis();
        System.out.println("query-attribute4-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query6);
        end = System.currentTimeMillis();
        System.out.println("query-First-attribute1-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }
    }

    public void shutdownDBS(GraphDatabaseService graphDatabaseService){
        graphDatabaseService.shutdown();
    }
    public void dynamicRun(Neo4jQueryTest test){
//        String path = dbPath.substring(dbPath.lastIndexOf("\\") + 1);
//        if(path.startsWith("indexed")){
//            test.StoreWithIndex();//存储为带索引数据库,数据库名包含索引
//        }else if(path.startsWith("unindexed")){
//            test.storeWithoutIndex();//存储为不带索引的数据库，数据库名不包含索引
//        }
        GraphDatabaseService graphDatabaseService = test.getGraphDBService();
        Transaction tx = graphDatabaseService.beginTx();
        try{
            Iterable<IndexDefinition> indexs = graphDatabaseService.schema().getIndexes(label1);
            for(IndexDefinition indexDefinition : indexs){
                System.out.println("index-name:" + indexDefinition.getLabel().name());
                System.out.print("Property-keys:");
                Iterable<String> keys = indexDefinition.getPropertyKeys();
                for(String key : keys){
                    System.out.print(key + " ");
                }
            }
            tx.success();
        }catch (Exception e){
            e.printStackTrace();
            tx.failure();
        }finally {
            tx.close();
        }
        System.out.println("\n");
//        test.cypherQuery(graphDatabaseService);
        graphDatabaseService.shutdown();
    }

    public static void main(String[] args){
        Neo4jQueryTest test = new Neo4jQueryTest(args[0], Long.parseLong(args[1]));
        System.out.println(args[0] + " " + Long.parseLong(args[1]) + "\n");
        test.dynamicRun(test);
    }
}
