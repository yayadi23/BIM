package com.test.bulk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileUtil {

    public static void createFile(String fileName, Integer count){
        String filePath = "D:\\Experiment\\bulktest\\";
        FileWriter fileWriter = null;
        File f = new File(filePath + fileName);
        if(f.exists()){
            f.delete();
        }
        try {
            f.createNewFile();
            fileWriter = new FileWriter(f);
            StringBuilder stringBuilder = null;
            Random random = new Random();
            int i = 0;
            for(; i < 15000 && f.length() < count; i++){ //写这么多条记录
                stringBuilder = new StringBuilder();
                stringBuilder.append("{\"index\":{\"_id\":\"" + i + "\"}}\n" + "{\"id\":\"" + i + "\"");
                for(int j = 1; j < 50; j++){
                    stringBuilder.append(",\"attribute" + j + "\":\"aaaaaaaa" + random.nextInt(100000) + "\"");
                }
                stringBuilder.append("}\n");
                fileWriter.write(stringBuilder.toString());
            }
            System.out.println(fileName +  " docs行数：" + i);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
