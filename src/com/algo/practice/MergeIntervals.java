package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String [] args){
        int [][] intervals= new int [][]{{1,4},{0,4}};
        int [][] ans= mergeIntervals(intervals);
        for(int[] a: ans){
            System.out.println(a[0]+":"+a[1]);
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        List<int[]> ll = new ArrayList<int[]>();
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });

        for(int i=0;i<intervals.length;i++){
            if(ll.isEmpty()){
                ll.add(new int[]{intervals[i][0], intervals[i][1]});

            } else {
                int [] lastEle = ll.get(ll.size()-1);
                if(lastEle[1]>intervals[i][0]){
                    int end = Math.max(lastEle[1], intervals[i][1]);
                    ll.remove(ll.size()-1);
                    ll.add(new int[]{lastEle[0],end});
                } else {
                    ll.add(new int[]{intervals[i][0], intervals[i][1]});
                }
            }
        }

        int [][]ans = new int[ll.size()][2];
        int count =0;
        for(int []a: ll){
            ans[count]=a;
            count++;
        }
        return ans;
    }
}
