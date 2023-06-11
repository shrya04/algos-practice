package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrepImplementation {

    public static void main(String[] args){
        List<String> listOfWords = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "booking","alpha", "beta", "gamma"));
        List<String> words = grep(listOfWords, 3, "beta");
        for(String s:words){
            System.out.println(s);
        }
    }

    private static List<String> grep(List<String> listOfWords, int size, String word) {

        List<String> cappedList = new ArrayList<String>(size) {
            @Override
            public boolean add(String s) {
                if(size()>=size){
                    super.remove(0);
                }
                return super.add(s);
            }
        };

        for(String s: listOfWords){
            if(s.equals(word)){
                break;
            }
            cappedList.add(s);

        }
        List<String> ans = new ArrayList<>(cappedList);
        ans.add(word);
        return ans;
    }
}
