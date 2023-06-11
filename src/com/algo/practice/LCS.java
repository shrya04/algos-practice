package com.algo.practice;

public class LCS {
    public static void main(String ars[]){
        System.out.println(lcs("abcde","ace"));
    }

//    private static int lcs(String text1, String text2) {
//        int dp[][] = new int[text2.length()+1][text1.length()+1];
//        int r = text2.length()+1;
//        int c = text1.length()+1;
//        for(int i = 1;i<r;i++){
//            for(int j=1;j<c;j++){
//                if(text1.charAt(j-1)==text2.charAt(i-1)){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                } else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[r-1][c-1];
//    }

    private static String lcs(String text1, String text2){
        int dp[][] = new int[text2.length()+1][text1.length()+1];
        int r = text2.length()+1;
        int c = text1.length()+1;
        String s = "";
        for(int i = 1;i<r;i++){
            for(int j=1;j<c;j++){
                if(text1.charAt(j-1)==text2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = r-1;
        int j = c-1;
        while(i>0){
            while(j>0){
                if(dp[i][j]==dp[i-1][j-1]+1){
                    s=s+text1.charAt(j-1);
                    i--;
                    j--;
                }  else {
                    if(dp[i][j]==dp[i-1][j]+1){
                        i--;
                    } else {
                        j--;
                    }
                }
            }
        }

        return s;
    }
}
