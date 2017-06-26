package com.test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Diak on 2017/6/2.
 */
public class DataMaker {
    private String filepath = "";
    private long count;

    public DataMaker(String filepath, long count){
        this.filepath = filepath;
        this.count = count;
    }
    public void makeIfcWall(){
        try{
            StringBuilder stringBuilder;
            FileWriter fileWriter = null;
            File file = new File(filepath + "\\IfcWall.json");
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            fileWriter = new FileWriter(file);
            for(long i = 0; i < count; i++){
                stringBuilder = new StringBuilder();
                stringBuilder.append("{\"index\":{\"_id\":\"a" + i + "\"}}\n" + "{\"id\":\"" + i + "\"");
                for(int j = 1; j < 50; j++){
                    stringBuilder.append(",\"attribute" + j + "\":\"" + i + "\"");
                }
                stringBuilder.append("}\n");
                fileWriter.write(stringBuilder.toString());
                stringBuilder = null;
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void makeIfcPropertySet(){
        try{
            StringBuilder stringBuilder = null;
            FileWriter fileWriter = null;
            File file = new File(filepath + "\\IfcPropertySet.json");
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            fileWriter = new FileWriter(file);
            for(long i = 0; i < count; i++){
                stringBuilder = new StringBuilder();
                stringBuilder.append("{\"index\":{\"_id\":\"b" + i + "\",\"_parent\":\"a" + i + "\"}}" + "\n" + "{\"id\":\"" + i + "\"");
                for(int j = 1; j < 50; j++){
                    stringBuilder.append(",\"attribute" + j + "\":\"" + i + "\"");
                }
                stringBuilder.append("}\n");
                fileWriter.write(stringBuilder.toString());
                stringBuilder = null;
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void makeIfcPropertySingleValue(){
        try{
            StringBuilder stringBuilder = null;
            FileWriter fileWriter = null;
            File file = new File(filepath + "\\IfcPropertySingleValue.json");
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            fileWriter = new FileWriter(file);
            for(long i = 0; i < count; i++){
                stringBuilder = new StringBuilder();
                stringBuilder.append("{\"index\":{\"_id\":\"c" + i + "\",\"_parent\":\"b" + i + "\"}}" + "\n" + "{\"id\":\"" + i + "\"");
                for(int j = 1; j < 50; j++){
                    stringBuilder.append(",\"attribute" + j + "\":\"" + i + "\"");
                }
                stringBuilder.append("}\n");
                fileWriter.write(stringBuilder.toString());
                stringBuilder = null;
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        DataMaker dataMaker = new DataMaker(args[0], Long.parseLong(args[1]));
        //dataMaker.makeIfcWall();
        dataMaker.makeIfcPropertySet();
        dataMaker.makeIfcPropertySingleValue();
    }
}
