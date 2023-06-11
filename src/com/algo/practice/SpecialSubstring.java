package com.algo.practice;

public class SpecialSubstring {
    public static void main(String[] args) {
        String str = "Featuring stylish rooms and moorings for recreation boats, Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam.";
        System.out.println(specialSubstring(str,5));
    }

    private static String specialSubstring(String str, int k) {
        String[] strings = str.split(" ");
        StringBuilder ans = new StringBuilder();
        int size = strings[0].length();
        int count =0;
        while(size<=k){
            ans.append(strings[count]).append(" ");
            size = size + strings[count].length() + 1;
            count++;
        }
        return ans.toString();
    }
}
