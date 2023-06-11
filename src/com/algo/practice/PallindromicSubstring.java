package com.algo.practice;

public class PallindromicSubstring {
    public static void main(String []args) {
        System.out.println(getSubstrings("aaa"));
    }

    private static int getSubstrings(String str) {
        int ans = str.length();
        for(int start=0;start<str.length()-1;start++){
            if(isPallindromeEven(str, start)){
                ans++;
            }
            if(isPallindromeOdd(str, start)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isPallindromeEven(String str, int start) {
        int i = start;
        int j = start+1;
        boolean foundPallindrome = false;
        while(i>=0 && j<str.length()){
            if(str.charAt(i)== str.charAt(j)){
                i--;
                j++;
                foundPallindrome = true;
            } else {
                break;
            }
        }
        return foundPallindrome;
    }

    private static boolean isPallindromeOdd(String str, int start) {
        int i = start-1;
        int j = start+1;
        boolean foundPallindrome = false;
        while(i>=0 && j<str.length()){
            if(str.charAt(i)== str.charAt(j)){
              i--;
              j++;
              foundPallindrome = true;
            } else {
                break;
            }
        }
        return foundPallindrome;
    }
}
