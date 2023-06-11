//package com.test.SyncPairs;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Practice3 {
//    public static void main(String args[]) {
//        System.out.println(getHint("1122", "1222"));
//        System.out.println(getHint("1807", "7810"));
//    }
//
//    private static String getHint(String secret, String guess) {
//        int x = 0;
//        int y = 0;
//        int i=0;
//        Set<Character> list = new HashSet<>();
//        for(Character ch: guess.toCharArray()){
//            list.add(ch);
//        }
//        for(;i<secret.length();i++ ){
//            if(secret.charAt(i)==guess.charAt(i)){
//                x++;
//                list.remove(secret.charAt(i));
//            }
//            else {
//                if(list.contains(secret.charAt(i))){
//                    y++;
//                    list.remove(secret.charAt(i));
//                }
//            }
//        }
//
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(Character.forDigit(x,10));
//        sb.append('A');
//        sb.append(Character.forDigit(y,10));
//        sb.append('B');
//        return sb.toString();
//    }
//}
