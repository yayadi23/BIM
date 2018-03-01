package com.test;

/**
 * 华为测试试验
 */

//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s;
//        char[] chars;
//        while(scan.hasNextLine()){
//            s = scan.nextLine();
//            chars = s.toCharArray();
//            Arrays.sort(chars);
//            s = String.valueOf(chars);
//            if(s.charAt(0) != '0'){
//                System.out.println(s);
//            } else{
//                String s1,s2,s3;
//                int i;
//                for(i= 1;i<s.length();i++){//��������һ����1��
//                    if(s.charAt(i) != '0'){
//                        if(i == s.length() -1){
//                            s1 = s.substring(0,i);
//                            s2 = s.substring(i);
//                            System.out.println(s2 + s1);
//                            break;
//                        }
//                        s1 = s.substring(0,i);
//                        s2 = s.substring(i,i+1);
//                        s3 = s.substring(i+1);
//                        System.out.println(s2 + s1 + s3);
//                        break;
//                    }
//                }
//                if(i == s.length()){
//                    System.out.println(0);
//                }
//            }
//
//        }
//    }
//
//}
//
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int object = scan.nextInt();
//        int n;
//        List<Integer> numbers = new ArrayList<>();
//        List<Integer> numbers1 = new ArrayList<>();
//        while (scan.hasNextInt()) {
//            n = scan.nextInt();
//            numbers.add(n);
//            numbers1.add(0 - n);
//        }
//        for(int i = 0; i < numbers.size(); i++){
//            for ()
//        }
//    }
//}

//import java.util.ArrayList;
//
//public class Main {
//    private static ArrayList <Integer>tmpArr = new ArrayList<>();
//    public static void main(String[] args) {
//        int [] com = {7,5,6,1,3,2,4,8};
//        int k = 8;
//        if(k > com.length || com.length <= 0){
//            return ;
//        }
//        combine(0 ,k ,com);
//    }
//    public static void combine(int index,int k,int []arr) {
//        if(k == 1){
//            for (int i = index; i < arr.length; i++) {
//                tmpArr.add(arr[i]);
//                System.out.println(tmpArr.toString());
//                tmpArr.remove((Object)arr[i]);
//            }
//        }else if(k > 1){
//            for (int i = index; i <= arr.length - k; i++) {
//                tmpArr.add(arr[i]);
//                combine(i + 1,k - 1, arr);
//                tmpArr.remove((Object)arr[i]);
//            }
//        }else{
//            return ;
//        }
//    }
//}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = "";
        String s1;
        char[] chars;
        int ii;
        int[] numbers;
        while(scan.hasNextInt()){
            scan.nextInt();
            s = s.substring(1, s.length() - 1);
            chars = s.toCharArray();
            numbers = new int[chars.length];
            int j = 0;
            for(int i = 0; i < chars.length; i++){
                if(chars[i]>='0'&&chars[i]<='9'){
                    numbers[j++] = chars[i] - '0';
                }
            }
            System.out.println(getLIS(numbers));
        }
//        int[] nums = {7,2,3,1,5,8,9,10};
//        System.out.println(getLIS(nums));
    }

    public static int getLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        for (int item : nums) {
            if (dp.size() == 0 || dp.get(dp.size() - 1) < item) {
                dp.add(item);
            } else {
                int i = Collections.binarySearch(dp, item);
                dp.set(i < 0 ? -i - 1 : i, item);
            }
        }
        return dp.size();
    }
}
