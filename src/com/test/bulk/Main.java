package com.test.bulk;

public class Main {
    public static void main(String args[]){
        String fileName = null;
        for(int i = 1; i <= 20; i++){
            fileName = "docs" + i + "M.json";
//            System.out.println(fileName + " " + Integer.parseInt(i + "000000"));
            FileUtil.createFile(fileName, Integer.parseInt(i + "000000"));
        }
    }
}
