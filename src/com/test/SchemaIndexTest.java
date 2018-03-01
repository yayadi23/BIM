package com.test;

import com.sun.xml.internal.ws.wsdl.writer.document.xsd.Schema;
import org.neo4j.graphdb.Label;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserters;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Diak on 2017/10/17.
 * 随机产生string试验
 * neo4j数据库生成试验
 */
public class SchemaIndexTest {
    private String dbPath;
    private long nodeCount;

    public SchemaIndexTest(String dbPath, long nodeCount){
        this.dbPath = dbPath;
        this.nodeCount = nodeCount;
    }

    public void createDB(){
        try{
            BatchInserter inserter = BatchInserters.inserter(new File(dbPath));
            Map<String, Object> nodeMap = new HashMap<>();
            Label label;
            String[] labels = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
            Random r = new Random();
            for(long i = 1; i < nodeCount; i++){
                for(int j = 0; j < 10; j++){
                    nodeMap.put("attribute" + j, getRandomString(r.nextInt(20)));
                }
                label = Label.label(labels[(int) (i % 10)]);
                inserter.createNode(i, nodeMap, label);//����Ҫ����label
            }
            inserter.shutdown();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getRandomString(int length){
        String base = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int number;
        for(int i = 0; i < length; i++){
            number = random.nextInt(62);
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        SchemaIndexTest test = new SchemaIndexTest("D:\\Experiment\\Neo4jDB\\SchemaTest100",1000000);
        test.createDB();
    }
}
