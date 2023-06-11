package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class StringSteps {
    public static void main (String args[]){
        List<String> wordList = new ArrayList<>(Arrays.asList("Luis", "Hector", "Selena", "Emmanuel", "Amish"));

        List<String> ans = connectStrings(wordList);
        for(String s : ans){
            System.out.println(s);
        }
    }


    private static List<String> connectStrings(List<String> wordList) {
//        List<String> wordList = new ArrayList<>();
//        for(String s: list){
//            wordList.add(s.toLowerCase());
//        }
        HashMap<Character, String> endChars = new HashMap<>();
        HashMap<Character, String> startChars = new HashMap<>();
        Set<Character> startCharacter = new HashSet<>();
        for(String s: wordList){
            endChars.put(s.charAt(s.length()-1), s);
            startChars.put(Character.toLowerCase(s.charAt(0)), s);
        }
        for(Map.Entry<Character, String> map: startChars.entrySet()){
            startCharacter.add(map.getKey());
        }
        for(Map.Entry<Character, String> map: endChars.entrySet()){
            startCharacter.remove(Character.toLowerCase(map.getKey()));
        }
        if(startCharacter.size()>1){
            return new ArrayList<>();
        }
        List<String> ans = new LinkedList<>();
        Character start = new ArrayList<>(startCharacter).get(0);
        for(int i =0;i< wordList.size();i++){
            String word =  startChars.get(start);
            ans.add(word);
            start = word.charAt(word.length()-1);
        }
        return ans;
    }
}
