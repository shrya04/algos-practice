package com.algo.practice;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String args[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(3,4);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            map.remove(entry.getKey());
        }

    }
}
