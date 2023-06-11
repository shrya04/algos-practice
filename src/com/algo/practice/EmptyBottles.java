package com.algo.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EmptyBottles {
    public static void main(String args[]) {

//        System.out.println(numWaterBottles(9,3));
        System.out.println(numWaterBottles(15,4));
    }


    static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while(numBottles >= numExchange){
            int newBottles = numBottles/numExchange;
            ans +=newBottles;
            int remaining = numBottles%numExchange;
            numBottles = newBottles + remaining;
        }
        return ans;

    }
}
