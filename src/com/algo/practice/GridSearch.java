package com.algo.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GridSearch {
    public static void main(String[] args) throws IOException {

        List<String> G = new ArrayList<>(Arrays.asList("7283455864", "6731158619", "8988242643", "3830589324", "2229505813",
                "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"));
        List<String> P = new ArrayList<>(Arrays.asList("9505", "3845", "3530"));
        String result = gridSearch(G, P);
        System.out.println(result);
    }


    public static String gridSearch(List<String> G, List<String> P) {

        if (P.get(0).length() > G.get(0).length()) {
            return "NO";
        }

        for (int i = 0; i < G.size(); i++) {
            String str = G.get(i);

            for (int j = 0; j < str.length(); j++) {
                if(j+P.get(0).length() > str.length()){
                    continue;
                }
                if (str.substring(j, j+P.get(0).length()).equals(P.get(0))) {
                    List<String> sts = new ArrayList<>();
                    int a = i;
                    for (int l = i; l < G.size(); l++) {
                        if (a < i+P.size()) {
                            sts.add(G.get(a).substring(j, j+P.get(0).length()));
                            a++;
                        }
                    }
                    if (isfound(sts, P)) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";
    }

    static boolean isfound(List<String> a, List<String> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!Objects.equals(a.get(i), b.get(i))) {
                return false;
            }
        }
        return true;
    }
}
