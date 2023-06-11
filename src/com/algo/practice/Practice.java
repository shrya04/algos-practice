package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice {
    public static void main(String args[]){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(0,1,10));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,2,20));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(3,4,10));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(7,8,10));

        List<List<Integer>> problem = new ArrayList<>(Arrays.asList(l1,l2,l3,l4));

        List<List<Integer>> score = getTopK(problem, 2);
        for(int i =0;i< score.size();i++){
            for(int j=0;j<score.get(i).size();j++){
                System.out.print(" " + score.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static class Node {
        int id;
        int weight;
        List<Node> nextNode;

        Node(){
            nextNode = new ArrayList<>();
        }

    }

    public  static class Pair {
        int hotel;
        int score;

        public Pair(int hotel, int score) {
            this.hotel = hotel;
            this.score = score;
        }
    }

    private static List<List<Integer>> getTopK(List<List<Integer>> problem, int k) {
        HashMap<Integer, Node> nodeHashMap = new HashMap<>();
        for(int i =0;i< problem.size();i++){
            List<Integer> row = problem.get(i);
            int parentHotelId = row.get(1);
            int hotelId = row.get(0);
            int weight = row.get(2);
            Node childNode;
            Node parentNode;
            if(nodeHashMap.containsKey(parentHotelId)){
                parentNode = nodeHashMap.get(parentHotelId);
            } else {
                parentNode = new Node();
                parentNode.id = parentHotelId;
                nodeHashMap.put(parentHotelId, parentNode);
            }
            if(nodeHashMap.containsKey(hotelId)) {
                childNode = nodeHashMap.get(hotelId);
            } else {
                childNode = new Node();
                childNode.id = hotelId;
                nodeHashMap.put(hotelId, childNode);
            }
            childNode.weight = weight;


            parentNode.nextNode.add(childNode);
            System.out.println();
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return b.score-a.score;});
        for(Map.Entry<Integer, Node> entry: nodeHashMap.entrySet()){
            Node current = entry.getValue();
            AtomicInteger score = new AtomicInteger();
            getScore(current, score);
            int s = score.get();
            Pair p = new Pair(entry.getKey(), s);
            pq.add(p);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<k;i++){
            Pair p = pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(p.hotel, p.score)));
        }
        return ans;
    }

    private static void getScore(Node current, AtomicInteger score){
        if(current == null){
            return;
        }
        for(Node n: current.nextNode){
            score.addAndGet(n.weight);
            getScore(n, score);
        }
    }
}
