package com.algo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public Solution() {
    }

    class Node {
        Character ch;
        List<Node> nodeList;

        Node(Character ch) {
            this.ch = ch;
            nodeList = new ArrayList<>();
        }

    }

    public String findOrder(String[] dict, int N, int K) {

        HashMap<Character, Node> nodeMap = new HashMap<>();
        int i = 0, j = 1, k = 0, l = 0;
        while (j < dict.length) {
            k = 0;
            l = 0;
            String firstWord = dict[i];
            String secondWord = dict[j];
            while (firstWord.charAt(k) == secondWord.charAt(l)) {
                k++;
                l++;
            }
            Character firstChar = firstWord.charAt(k);
            Character secondChar = secondWord.charAt(l);

            Node firstCharNode = nodeMap.getOrDefault(firstChar, new Node(firstChar));

            Node secondCharNode = nodeMap.getOrDefault(secondChar, new Node(secondChar));

            firstCharNode.nodeList.add(secondCharNode);
            nodeMap.put(firstChar, firstCharNode);
            nodeMap.put(secondChar, secondCharNode);
            i++;
            j++;
        }

        for (Map.Entry<Character, Node> entry : nodeMap.entrySet()) {
            boolean cycle = checkCycles(entry.getValue(), new HashSet<>());
            if (cycle) {
                return "0";
            }
        }

        return "1";
    }

    private boolean checkCycles(Node value, Set<Character> charSet) {
        if (value == null) {
            return true;
        }
        if (!charSet.add(value.ch)) {
            return false;
        }
        boolean ans = false;
        for (Node ll : value.nodeList) {
            ans = checkCycles(ll, charSet);
        }
        return ans;
    }
}
