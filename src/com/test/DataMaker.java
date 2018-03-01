package com.test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Diak on 2017/6/2.
 * IfcWall、IfcPropertySet、IfcPropertySingleValue三个文件试验
 */
public class DataMaker {
    private String filepath = "";
    private long start;
    private long end;


    public DataMaker(String filepath, long start, long end){
        this.filepath = filepath;
        this.start = start;
        this.end = end;
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
            for(long i = start; i < end; i++){
                stringBuilder = new StringBuilder();
                stringBuilder.append("{\"index\":{\"_id\":\"a" + i + "\"}}\n" + "{\"id\":\"a" + i + "\"");
                for(int j = 1; j < 50; j++){
                    stringBuilder.append(",\"attribute" + j + "\":\"aaaaaaaa" + i + "\"");
                }
                stringBuilder.append("}\n");
                fileWriter.write(stringBuilder.toString());
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
            for(long i = start; i < end; i = i + 5){
                for(int k = 0; k < 5; k++){
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("{\"index\":{\"_id\":\"b" + (i + k) + "\",\"_parent\":\"a" + i + "\"}}" + "\n" + "{\"id\":\"b" + (i + k) + "\"");
                    for(int j = 1; j < 50; j++){
                        stringBuilder.append(",\"attribute" + j + "\":\"bbbbbbbb" + (i + k) + "\"");
                    }
                    stringBuilder.append("}\n");
                    fileWriter.write(stringBuilder.toString());
                }
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
            for(long i = start; i < end; i = i + 10){
                for(int k = 0; k < 10; k++){
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("{\"index\":{\"_id\":\"c" + (i + k) + "\",\"_parent\":\"b" + i + "\"}}" + "\n" + "{\"id\":\"c" + (i + k) + "\"");
                    for(int j = 1; j < 50; j++){
                        stringBuilder.append(",\"attribute" + j + "\":\"cccccccc" + (i + k) + "\"");
                    }
                    stringBuilder.append("}\n");
                    fileWriter.write(stringBuilder.toString());
                }
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        DataMaker dataMaker = new DataMaker(args[0], Long.parseLong(args[1]), Long.parseLong(args[2]));
        dataMaker.makeIfcWall();
        dataMaker.makeIfcPropertySet();
        dataMaker.makeIfcPropertySingleValue();
    }
}
