package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAnagrams {
    public static void main(String args[]){
        List<Integer> ans = findAnagrams("cbaebabacd", "abc");
        for(int i : ans){
            System.out.println(i);
        }
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();
        if(p.length()>s.length()){
            return ans;
        }

        char[] tempArray = p.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);
        String sortedP = new String(tempArray);
        for(int i =0;i<s.length()-p.length();i++){
            String str = s.substring(i, i+p.length());
            char t[] = str.toCharArray();
            Arrays.sort(t);
            if(new String(t).equals(sortedP)){
                ans.add(i);
            }
        }
        return ans;

    }
}
