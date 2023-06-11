package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumberFromArray {
    public static void main(String args[]){
        List<Integer> ll = new ArrayList<Integer>();

        ll.add(0);
        ll.add(0);

        System.out.println(largestNumber(ll));

    }

    private static String largestNumber(List<Integer> ll) {
        String ans = "";

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
            String a1= String.valueOf(a);
            String b1= String.valueOf(b);
            String ans1 = a1+b1;
            String ans2 = b1+a1;
            for(int i =0 ;i< ans1.length();i++) {
                if(ans1.charAt(i) -'0' < ans2.charAt(i)-'0'){
                    return 1;
                } else if (ans1.charAt(i) -'0' > ans2.charAt(i)-'0'){
                    return -1;
                }
            }
            return 0;
        });

        pq.addAll(ll);

        while(!pq.isEmpty()){
            ans = ans + pq.poll();
        }
        while(ans.subSequence(0,1).equals("0") && ans.length()>1){
            ans = ans.substring(1);
        }
        return ans;
    }


}
