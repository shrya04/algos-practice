package com.algo.practice;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length()][word1.length()];
        for (int i = 0; i < word2.length(); i++) {
            for (int j = 0; j < word1.length(); j++) {
                if (i == 0 && j == 0) {
                    if (word2.charAt(i) == word1.charAt(j)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                else if (i == 0) {
                    if (word2.charAt(i) == word1.charAt(j)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                } else if (j == 0) {
                    if (word2.charAt(i) == word1.charAt(j)) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                } else {
                    if (word2.charAt(i) == word1.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }
        }

        return dp[word2.length() - 1][word1.length() - 1];
    }

    public static void main(String args[]) {
        System.out.println(minDistance("horse", "ros"));
    }
}
