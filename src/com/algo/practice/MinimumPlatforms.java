package com.algo.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumPlatforms {
    public static void main(String args[]) {
        int[] at = new int[]{41,1616,297,2042,1013,987,2050,525,636,109};
        int[] dt = new int[]{2275,2076,1580,2144,1231,1672,2137,1016,2234,1043};
        int k = at.length;
        System.out.println(calculateMinPatforms(at, dt, k));
    }

    static class Pairs {
        int arrival;
        int depart;
        Pairs(int arrival, int depart){
            this.arrival = arrival;
            this.depart = depart;
        }
    }

    private static  int calculateMinPatforms(int[] at, int[] dt, int n) {
        PriorityQueue<Pairs> pq = new PriorityQueue<Pairs>(Comparator.comparingInt(pairs -> pairs.arrival));
        for(int i =0;i<n;i++){
            pq.add(new Pairs(at[i], dt[i]));
        }
        int ans = 0;
        List<Pairs> ansArray = new ArrayList<>();
        ansArray.add(pq.poll());

        while(!pq.isEmpty()){
            Pairs curr = pq.poll();
            int i =0;
            while (i<ansArray.size()) {
                if(ansArray.get(i).depart < curr.arrival){
                    break;
                }
                i++;
            }
            if(i>=ansArray.size()){
                ansArray.add(i, curr);
            } else {
                ansArray.set(i, curr);
            }

        }
        return ansArray.size();
    }

}
