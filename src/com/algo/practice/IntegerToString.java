package com.algo.practice;

import java.util.HashMap;
import java.util.Stack;

public class IntegerToString {
    static HashMap<Integer, String> map = new HashMap<Integer, String>() {
        {
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eightteen");
            put(19, "Nineteen");
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
            put(100, "Hundred");
            put(1000, "Thousand");
            put(1000000, "Million");
            put(1000000000, "Billion");
        }
    };

    static public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        int len = String.valueOf(num).length();
        Stack<String> stack = new Stack<>();
        int i =0;
        int j=0;
        if(num<=20){
            return map.get(num);
        }
        int a=0;
        int count = 0;
        while(num>0){
            int n = num%1000;
            num=num/1000;
            int num2 = n;
            a=a*1000+n;
            if(count ==1 && a!=0&& n!=0){
                stack.push(map.get(1000));
            }
            if(count==2 && a!=0 && n!=0){
                stack.push(map.get(1000000));
            }
            if(count==3 && a!=0 && n!=0){
                stack.push(map.get(1000000000));
            }

            int ones = num2%10;
            int tens = (num2%100)/10;
            int hundred = (num2%1000)/100;

            if( ones>0 && tens*10+ones <=20){
                stack.push(map.get(tens*10+ones));
            } else {
                if(ones!=0){
                    stack.push(map.get(ones));
                }
                if(tens!=0){
                    stack.push(map.get(tens*10));
                }
            }

            if(hundred>0){
                stack.push(map.get(100));
                stack.push(map.get(hundred));
            }

            count++;
        }
        String s = "";
        while(!stack.isEmpty()) {
            s = s + " " + stack.pop() ;
        }
        return s.substring(1);

    }

    public static void main(String args[]) {
        System.out.println(numberToWords(1000010));
    }

}
