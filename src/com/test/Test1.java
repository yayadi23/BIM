package com.test;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.io.FileUtils;
import org.neo4j.graphdb.*;
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
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Diak on 2017/5/27.
 * bloomfilter查询试验与cypher查询试验
 */
public class Test1 {
    private String dbPath;
    private long nodeCount;

    private static enum RelTypes implements RelationshipType {
        aggragetes;//����ֻ��֧��һ�ֹ�ϵ
    }

    public Test1(String dbPath, long nodeCount){
        this.dbPath = dbPath;
        this.nodeCount = nodeCount;
    }

    private void clearDB(){
        try{
            FileUtils.deleteDirectory(new File(dbPath));//�������Ĳ���
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
                    inserter.createNode(i, nodeMap, Label.label("First"));//����Ҫ����label
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

    public void storeDepthData(){
        BatchInserter inserter = null;
        try{
            long start,end;
//            clearDB();
            inserter = BatchInserters.inserter(new File(dbPath));
            Map<String, Object> nodeMap = new HashMap<>();
            start = System.currentTimeMillis();
            for(long i = 100; i < 200; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject1"));
            }
            for(long i = 1000; i < 2000; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject2"));
            }
            for(long i = 10000; i < 20000; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject3"));
            }
            for(long i = 100000; i < 200000; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject4"));
            }
            for(long i = 1000000; i < 2000000; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject5"));
            }
            for(long i = 2000000; i < 3000000; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject6"));
            }
            for(long i = 3000000; i < 4000000; i++){
                nodeMap.put("name","name" + i);
                inserter.createNode(i, nodeMap, Label.label("IfcObject7"));
            }
            end = System.currentTimeMillis();
            System.out.println("insert-node-time:" + (end-start));

            //create relationship
            //1 aid to 10 bid  aid*10+(0/1/2/3/4/5/6/7/8/9)
            start = System.currentTimeMillis();
            for(long i = 100; i < 200; i++){
                for(int j = 0; j < 10; j++){
                    inserter.createRelationship(i, i*10 + j,RelTypes.aggragetes,null);
                }
            }
            for(long i = 1000; i < 2000; i++){
                for(int j = 0; j < 10; j++){
                    inserter.createRelationship(i, i*10 + j,RelTypes.aggragetes,null);
                }
            }
            for(long i = 10000; i < 20000; i++){
                for(int j = 0; j < 10; j++){
                    inserter.createRelationship(i, i*10 + j,RelTypes.aggragetes,null);
                }
            }
            for(long i = 100000; i < 200000; i++){
                for(int j = 0; j < 10; j++){
                    inserter.createRelationship(i, i*10 + j,RelTypes.aggragetes,null);
                }
            }
            for(long i = 100; i <200; i++ ){
                for(int j = 0; j < 10000; j++){
                    inserter.createRelationship(i, i*10000 + j + 1000000,RelTypes.aggragetes,null);
                }
            }
            for(long i = 1000; i <2000; i++ ){
                for(int j = 0; j < 1000; j++){
                    inserter.createRelationship(i, i*1000 + j + 2000000,RelTypes.aggragetes,null);
                }
            }
            end = System.currentTimeMillis();
            System.out.println("insert-rel-time:" + (end-start));

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inserter != null){
                inserter.shutdown();
            }
        }
    }
    public void query(GraphDatabaseService graphdb){
        long start,end;
        Result result;
        String[] querys = {
//                "match (n{attribute1:9}) return count(n)",//query-node-attribute1   1
//                "match (n{attribute2:9}) return count(n)",//query-node-attribute2   2
//                "match (n{attribute3:9}) return count(n)",//query-node-attribute3   3
//                "match (n{attribute4:9}) return count(n)",//query-node-attribute4   4
//                "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4",//query-node-id   0
//                "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4",
//                "match (n) where id(n)=9999 return count(n),id(n),n.label,n.attribute1,n.attribute2,n.attribute3,n.attribute4"
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

    public void newQuery(GraphDatabaseService graphdb){
        long start, end;
        //neoe4j create index
        String[] createIndex = {
                "create index on :IfcObject1(name)",
                "create index on :IfcObject2(name)",
                "create index on :IfcObject3(name)",
                "create index on :IfcObject4(name)",
                "create index on :IfcObject5(name)",
                "create index on :IfcObject6(name)",
                "create index on :IfcObject7(name)"
        };

//        Transaction transaction;
//        transaction = graphdb.beginTx();
        for(int i = 0; i < createIndex.length; i++){
            graphdb.execute(createIndex[i]);
        }
//        Iterator<IndexDefinition> iterator = graphdb.schema().getIndexes().iterator();
//        int indexCount = 0;
//        while (iterator.hasNext()){
//            iterator.next();
//            indexCount++;
//        }
//        transaction.success();
//        transaction.close();
//        System.out.println("indexCount: " + indexCount);
//        System.out.println();

        //construct bloomfilter
        int expectedInsertions = 1000000;
        double fpp = 0.000001;
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), expectedInsertions, fpp);
        start = System.currentTimeMillis();
        for(int j = 100;j < 200; j++) {
            for (int k = 0; k < 10; k++) {
                for (int t = 0; t < 1000; t++) {
                    bloomFilter.put(String.valueOf(j) + String.valueOf(j*10 + k) + String.valueOf((j*10 + k)*1000 + t + 2000000));
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("create-bloomfilter-time: " + String.valueOf(end - start) + " ms");
        System.out.println();

        //neo4j depth data query

//        transaction = graphdb.beginTx();
        for(int i = 1; i < 4; i++){
            //��ֵ������������;��ֵ��ѯ����д��
            start = System.currentTimeMillis();
            Result result = null;
            String queryStr = null;
            List<String> keyList = null;
            Map<String, Object> row = null;
            int inGraphCount = 0;
            int outofGraphCount = 0;
            for(int j = 100;j < 110; j++){
                for(int k = 0; k < 10; k++){
                    for(int t = 0; t < 100; t++){
                        queryStr = "match (n:IfcObject1{name:\"name" + j + "\"})"
                                + " - [r1] -> " + "(m:IfcObject2{name:\"name" + String.valueOf(j*10 + k) + "\"})"
                                + " - [r2] -> " + "(s:IfcObject7{name:\"name"+ String.valueOf((j*10 + k)*1000 + t + 2000000) + "\"})"
                                + " return id(n),id(m),id(s)";
//                        if(j == 101 && k == 2 && t == 3){
//                            System.out.println(queryStr);
//                        }
                        result = graphdb.execute(queryStr);
                        if(result.hasNext()){
                            keyList = result.columns();
                            row = result.next();
                            row.get(keyList.get(0));
                            row.get(keyList.get(1));
                            row.get(keyList.get(2));
                            inGraphCount++;
                        } else{
                            outofGraphCount++;
                        }
                    }
                }
            }
            end = System.currentTimeMillis();
            System.out.println(i + "th" + "-lookup-time based on Cypher: " + String.valueOf(end - start) + " ms");
//            System.out.println("inGraphCount: " + inGraphCount);
//            System.out.println("outofGraphCount: " + outofGraphCount);
            System.out.println();
        }
//        transaction.success();
//        transaction.close();


        //my way to query


//        transaction = graphdb.beginTx();
        for(int i = 1; i < 4; i++){
            //��ֵ������������;��ֵ��ѯ����д��
            Result myResult = null;
            String bfQueryStr = null; //�����ֵҪ�������һ�£�
            StringBuilder composedId = null;
            List<String> keyList = null;
            int inbfCount = 0;
            int outofbfCount = 0;
            start = System.currentTimeMillis();
            for(int j = 100;j < 110; j++){
                for(int k = 0; k < 10; k++){
                    for(int t = 0; t < 100; t++){
                        composedId = new StringBuilder();
                        bfQueryStr = "match (n:IfcObject1{name:\"name" + j + "\"}) return id(n)";
                        myResult = graphdb.execute(bfQueryStr);
                        keyList = myResult.columns();
                        if(myResult.hasNext()){
                            composedId.append(myResult.next().get(keyList.get(0)));
                        } else {
                            outofbfCount++;
                            break;
                        }

                        bfQueryStr = "match (m:IfcObject2{name:\"name" + String.valueOf(j*10 + k) + "\"}) return id(m)";
                        myResult = graphdb.execute(bfQueryStr);
                        keyList = myResult.columns();
                        if (myResult.hasNext()){
                            composedId.append(myResult.next().get(keyList.get(0)));
                        } else {
                            outofbfCount++;
                            break;
                        }

                        bfQueryStr = "match (s:IfcObject7{name:\"name" + String.valueOf((j*10 + k)*1000 + t + 2000000) + "\"}) return id(s)";
                        myResult = graphdb.execute(bfQueryStr);
                        keyList = myResult.columns();
                        if (myResult.hasNext()){
                            composedId.append(myResult.next().get(keyList.get(0)));
                        } else {
                            outofbfCount++;
                            break;
                        }

                        if (bloomFilter.mightContain(composedId.toString())){
                            inbfCount++;
                        }
                    }
                }
            }

            end = System.currentTimeMillis();
            System.out.println(i + "th" + "-lookup-time based on BloomFilter: " + String.valueOf(end - start) + " ms");
//            System.out.println("inbfCount: " + inbfCount);
//            System.out.println("outofbfCount: " + outofbfCount);
            System.out.println();
        }
//        transaction.success();
//        transaction.close();
    }

    public static void main(String args[]){
        Test1 test1 = new Test1(args[0],Long.parseLong(args[1]));

//        test1.storeDepthData();

        GraphDatabaseService graphdb = test1.openDB();
        test1.newQuery(graphdb);


//        String query = "match (n) return count(n)";
//        String query = "match (n:IfcObject1{name:\"name100\"}) - [r1] -> (m:IfcObject2{name:\"name1000\"}) - [r2] -> (s:IfcObject7{name:\"name3000000\"}) return id(n),id(m),id(s)";
//        Result result = graphdb.execute(query);
//        Map<String, Object> row = null;
//        while(result.hasNext()){
//            row = result.next();
//            System.out.println(row.get(result.columns().get(0)));
//        }

        graphdb.shutdown();


    }
}
