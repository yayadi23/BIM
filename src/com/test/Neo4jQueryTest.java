package com.test;

import org.apache.commons.io.FileUtils;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider;
import org.neo4j.kernel.internal.EmbeddedGraphDatabase;
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
 * 创建neo4j试验
 * 查询neo4j试验
 */
public class Neo4jQueryTest {

//    private String dbPath = "D:\\BIMTest\\databases\\QueryTestDB";
    private String dbPath;
    private long nodeCount;
    private Label label = Label.label("First");


    public Neo4jQueryTest(String dbPath, long nodeCount){
        this.dbPath = dbPath;
        this.nodeCount = nodeCount;
    }

    private enum RelTypes implements RelationshipType {
        relationship1;
    }



    private void clearDB(){
        try{
            FileUtils.deleteDirectory(new File(dbPath));//�������Ĳ���
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //store a node                          �洢�����ڵ�
    //index a node                          ���������ڵ�


    //store nodes by batch without index    �����洢�����ڵ㣬��������
    public void storeWithoutIndex1(){
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
                    label = Label.label("First");

                }else{
                    label = Label.label("Second");
                }
                inserter.createNode(i, nodeMap, label);//����Ҫ����label
            }
            end = System.currentTimeMillis();
            System.out.println("create-node-time:" + (end - start) + "ms");

            //create relationship           ������ϵ
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

    public void storeWithoutIndex(){
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
                    label = Label.label("First");

                }else{
                    label = Label.label("Second");
                }
                inserter.createNode(i, nodeMap, label);//����Ҫ����label
                nodeIndex.add(i, nodeMap);//���е����Զ�������index
            }
            end = System.currentTimeMillis();
            System.out.println("create-node-time:" + (end - start) + "ms");


            //create relationship           ������ϵ
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

    //store nodes by batch with index       �����洢�����ڵ㣬����������������ָ�ڵ��ÿ�����Զ���������������ǵĻ����ǽ���������ʱ��һ���𣿣�
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
                    label = Label.label("First");

                }else{
                    label = Label.label("Second");
                }
                inserter.createNode(i, nodeMap, label);//����Ҫ����label
                nodeIndex.add(i, nodeMap);//���е����Զ�������index
            }
            end = System.currentTimeMillis();
            System.out.println("create-node-time:" + (end - start) + "ms");


            //create relationship           ������ϵ
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

    //get GraphDB                           ��ȡgraphdbserviceʵ��
    public GraphDatabaseService getGraphDBService(){
        long start,end;
        start = System.currentTimeMillis();
        GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(dbPath));
        end = System.currentTimeMillis();
        System.out.println("getGraphDBService-time:" + (end - start) + "ms");
        return graphdb;
    }

    //query non-index nodes                 ��ѯ�������ڵ�
    //query index nodes                     ��ѯ�������ڵ�
    //����������¶�����ֱ����cypher�����в�ѯ��API��Ȼ���㲻�˾��󲿷ֵĲ�ѯ����������������£�cypher��ִ�мƻ����Զ�ʹ��������
    //ʹ��profile����̽��ִ�мƻ��ж��ٴ�db����
    public void cypherQuery(GraphDatabaseService graphDatabaseService){
        //��������Ϊ1ǧ�������£�ʹ����/���������ݿ�
        //query 1: ��ѯidΪ9999��node
        //query 2: ��ѯlabel1,attribute1Ϊ9��node
        //query 3: ��ѯlabel1,attribute2Ϊ9��node
        //query 4: ��ѯlabel1,attribute3Ϊ9��node
        //query 5: ��ѯlabel1,attribute4Ϊ9��node
        //query 6: ��ѯ������ϵ��Ҫ�Ա�es�ı����Ӳ�ѯ��
        long start, end;
        Result result;
        String query1 = "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4";
        String query2 = "match (n{attribute1:9}) return count(n)";
        String query3 = "match (n{attribute2:9}) return count(n)";
        String query4 = "match (n{attribute3:9}) return count(n)";
        String query5 = "match (n{attribute4:9}) return count(n)";
        String query6 = "match (n:First{attribute1:9}) return count(n)";
        String query7 = ":schema";
        String query8 = "match (n:First{attribute1:9}) - [r] -> (m:Second) return count(m)";
//        String query6 = "match (n)-()";//1.���relationship��û�����������2.��û�ж��岻ͬ��relType��

//        start = System.currentTimeMillis();
//        result = graphDatabaseService.execute(query1);
//        end = System.currentTimeMillis();
//        System.out.println("query-byID-time:" + (end - start) + "ms");
//        while(result.hasNext()){
//            Map<String, Object> row = result.next();
//            for(String key : result.columns()){
//                System.out.println(key + ":" + row.get(key) + " ");
//            }
//            System.out.println("\n");
//        }

        start = System.currentTimeMillis();
        result = graphDatabaseService.execute(query8);
        end = System.currentTimeMillis();
        System.out.println("query-attribute1-time:" + (end - start) + "ms");
        while(result.hasNext()){
            Map<String, Object> row = result.next();
            for(String key : result.columns()){
                System.out.println(key + ":" + row.get(key) + " ");
            }
            System.out.println("\n");
        }

//        start = System.currentTimeMillis();
//        result = graphDatabaseService.execute(query3);
//        end = System.currentTimeMillis();
//        System.out.println("query-attribute2-time:" + (end - start) + "ms");
//        while(result.hasNext()){
//            Map<String, Object> row = result.next();
//            for(String key : result.columns()){
//                System.out.println(key + ":" + row.get(key) + " ");
//            }
//            System.out.println("\n");
//        }

//        start = System.currentTimeMillis();
//        result = graphDatabaseService.execute(query4);
//        end = System.currentTimeMillis();
//        System.out.println("query-attribute3-time:" + (end - start) + "ms");
//        while(result.hasNext()){
//            Map<String, Object> row = result.next();
//            for(String key : result.columns()){
//                System.out.println(key + ":" + row.get(key) + " ");
//            }
//            System.out.println("\n");
//        }

//        start = System.currentTimeMillis();
//        result = graphDatabaseService.execute(query5);
//        end = System.currentTimeMillis();
//        System.out.println("query-attribute4-time:" + (end - start) + "ms");
//        while(result.hasNext()){
//            Map<String, Object> row = result.next();
//            for(String key : result.columns()){
//                System.out.println(key + ":" + row.get(key) + " ");
//            }
//            System.out.println("\n");
//        }

//        start = System.currentTimeMillis();
//        result = graphDatabaseService.execute(query6);
//        end = System.currentTimeMillis();
//        System.out.println("query-First-attribute1-time:" + (end - start) + "ms");
//        while(result.hasNext()){
//            Map<String, Object> row = result.next();
//            for(String key : result.columns()){
//                System.out.println(key + ":" + row.get(key) + " ");
//            }
//            System.out.println("\n");
//        }
    }

    public void shutdownDBS(GraphDatabaseService graphDatabaseService){
        graphDatabaseService.shutdown();
    }
    public void dynamicRun(Neo4jQueryTest test){
//        String path = dbPath.substring(dbPath.lastIndexOf("\\") + 1);
//        if(path.startsWith("indexed")){
//            test.StoreWithIndex();//�洢Ϊ���������ݿ�,���ݿ�����������
//        }else if(path.startsWith("unindexed")){
//            test.storeWithoutIndex();//�洢Ϊ�������������ݿ⣬���ݿ�������������
//        }
        GraphDatabaseService graphDatabaseService = test.getGraphDBService();
        Transaction tx = graphDatabaseService.beginTx();
        try{
            Iterable<IndexDefinition> indexs = graphDatabaseService.schema().getIndexes(label);
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
//        test.dynamicRun(test);
//        test.storeWithoutIndex();
        GraphDatabaseService graphdb = test.getGraphDBService();
        test.cypherQuery(graphdb);
        graphdb.shutdown();
    }
}
