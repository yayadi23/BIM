package com.test;

import org.apache.commons.io.FileUtils;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
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
import java.util.Map;

/**
 * Created by Diak on 2017/5/27.
 */
public class Test1 {
    private String dbPath;
    private long nodeCount;


    public Test1(String dbPath, long nodeCount){
        this.dbPath = dbPath;
        this.nodeCount = nodeCount;
    }

    private void clearDB(){
        try{
            FileUtils.deleteDirectory(new File(dbPath));//变成输入的参数
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeWithoutIndex(){
        BatchInserter inserter = null;
        try{
            long start,end;
            clearDB();
            inserter = BatchInserters.inserter(new File(dbPath));
            Map<String, Object> nodeMap = new HashMap<>();
            start = System.currentTimeMillis();
            for(long i = 1; i < nodeCount; i++){
                nodeMap.put("attribute1",i%10);
                nodeMap.put("attribute2",i%1000);
                nodeMap.put("attribute3",i%100000);
                nodeMap.put("attribute4",i%10000000);
                if(i<(nodeCount/2)){
                    inserter.createNode(i, nodeMap, Label.label("First"));//这里要加上label
                }else{
                    inserter.createNode(i, nodeMap, Label.label("Second"));
                }
            }
            end = System.currentTimeMillis();
            System.out.println("create-node-time:" + (end - start) + "ms");

//            GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(dbPath));
//            String query1 = "explain ";
//            Transaction tx = graphdb.beginTx();
//            try {
//                Iterable<IndexDefinition> indexs = graphdb.schema().getIndexes(label1);
//                tx.success();
//            } catch (Exception e){
//                e.printStackTrace();
//                tx.failure();
//            }finally {
//                tx.close();
//            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inserter != null){
                inserter.shutdown();
            }
        }
    }

    public GraphDatabaseService openDB(){
        GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(dbPath));
        return graphdb;
    }

    public void query(GraphDatabaseService graphdb){
        long start,end;
        Result result;
        String[] querys = {
//                "match (n{attribute1:9}) return count(n)",//query-node-attribute1   1
//                "match (n{attribute2:9}) return count(n)",//query-node-attribute2   2
//                "match (n{attribute3:9}) return count(n)",//query-node-attribute3   3
                "match (n{attribute4:9}) return count(n)",//query-node-attribute4   4
                "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4",//query-node-id   0
                "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4",
                "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4"
//                "match (n:First{attribute1:9}) return count(n)",//query-node-label-attribute1   5
//                "match (n:First{attribute2:9}) return count(n)",//query-node-label-attribute2   6
//                "match (n:First{attribute3:9}) return count(n)",//query-node-label-attribute3   7
//                "match (n:First{attribute4:9}) return count(n)",//query-node-label-attribute4   8
//                "create index on:First(attribute1)",//create-index-First-attribute1     9
//                "create index on:First(attribute2)",//create-index-First-attribute2     10
//                "create index on:First(attribute3)",//create-index-First-attribute3     11
//                "create index on:First(attribute4)",//create-index-First-attribute4     12
//                "match (n{attribute1:9}) return count(n)",//query-node-attribute1      13
//                "match (n{attribute2:9}) return count(n)",//query-node-attribute2      14
//                "match (n{attribute3:9}) return count(n)",//query-node-attribute3       15
//                "match (n{attribute4:9}) return count(n)",//query-node-attribute4       16
//                "match (n:First{attribute1:9}) return count(n)",//query-node-label-attribute1   17
//                "match (n:First{attribute2:9}) return count(n)",//query-node-label-attribute2   18
//                "match (n:First{attribute3:9}) return count(n)",//query-node-label-attribute3   19
//                "match (n:First{attribute4:9}) return count(n)",//query-node-label-attribute4   20
        };

        for(int i = 0; i < querys.length; i++){
            start = System.currentTimeMillis();
            result = graphdb.execute(querys[i]);
            end = System.currentTimeMillis();
            System.out.println("querys[" + i + "]:" + (end - start) + "ms");
            Map<String, Object> row;
            while(result.hasNext()){
                row = result.next();
                for(String key : result.columns()){
                    System.out.print(key + ":" + row.get(key) + " ");
                }
                System.out.println("\n");
            }
        }
    }

    public static void main(String args[]){
        Test1 test1 = new Test1(args[0],Long.parseLong(args[1]));
        test1.storeWithoutIndex();
//        GraphDatabaseService graphgdb = test1.openDB();
//        test1.query(graphgdb);
//        graphgdb.shutdown();
    }
}
