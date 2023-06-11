package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Practice2 {
    public static void main(String args[]){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,4,4));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4,5,6,3));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(7,8,9,3));
        List<List<Integer>> ques = new ArrayList<>(Arrays.asList(l1, l2, l3));
        List<Integer> repeated = visitedByAl(ques);
        for(int i: repeated){
            System.out.print(i +" ");
        }
    }

    public static class Pair {
        int count;
        int iter;

        public Pair(int count, int iter) {
            this.count = count;
            this.iter = iter;
        }
    }

    private static List<Integer> visitedByAl(List<List<Integer>> ques) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Pair> hashMapval = new HashMap<>();
        for(int i = 0;i<ques.size();i++){
            int iter = i;
            List<Integer> row = ques.get(i);
            for(int j =0;j<row.size();j++){
                if(hashMapval.containsKey(row.get(j))){
                    Pair p = hashMapval.get(row.get(j));
                    if(p.iter == i){
                        continue;
                    } else{
                        hashMapval.put(row.get(j), new Pair(p.count+1, i));
                    }
                } else {
                    Pair p = new Pair(1, i);
                    hashMapval.put(row.get(j),p);
                }
            }
        }
        for(HashMap.Entry<Integer, Pair> entry: hashMapval.entrySet()){
            if(entry.getValue().count==ques.size()){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
