package com.algo.practice;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String args[]){
        System.out.println(subsetSum(new int[]{3,34,4,12,5,2}, 9));
    }

    private static boolean subsetSum(int[] arr, int sum) {
        boolean[][] dp = new boolean[sum+1][arr.length];
        for(int i =0;i<=sum;i++){
            for(int j =0;j<arr.length;j++){
                dp[i][j] = false;
            }

        }

        Arrays.sort(arr);
        // Arrays.fill(dp, false);
        for(int i=1;i<=sum;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    dp[i][j] = true;
                    break;
                }
                else if (arr[j]>i){
                    dp[i][j]=false;
                    break;
                }
                else {
                    int row = i - arr[j];
                    if(row<=0){
                        dp[i][j] = false;
                    } else {
                        for(int k =0;k<j;k++){
                            if(dp[row][k]){
                                dp[i][j] = true;
                                break;
                            }
                        }
                    }

                }
            }
        }
        for(int i =0;i<=sum;i++){
            for(int j =0;j<arr.length;j++){
                System.out.print(" "+dp[i][j]);
            }
            System.out.println();
        }

        for(int i = 0;i<arr.length;i++){
            if(dp[sum][i]){
                return true;
            }
        }
        return false;
    }
}
