package com.algo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class Courses {
    public static void main(String args[]) {
        int []ans  = findOrder(4, new int[][]{{1,0},{2,3}, {2,1}});
        for(int i : ans){
            System.out.print(" " + i);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> map = new HashMap<>();

        Set<Integer> startCourses = new HashSet<>();
        Set<Integer> endCourses = new HashSet<>();

        HashMap<Integer, Integer> indegrees = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int startCourse = prerequisites[i][1];
            int finishCourse = prerequisites[i][0];

            startCourses.add(startCourse);
            endCourses.add(finishCourse);

            indegrees.put(startCourse, indegrees.getOrDefault(startCourse, 0));
            indegrees.put(finishCourse, indegrees.getOrDefault(finishCourse, 0)+ 1);

            if (map.containsKey(startCourse)) {
                if(map.containsKey(finishCourse)){
                    map.get(startCourse).nodes.add(map.get(finishCourse));
                } else{
                    Node courseNode = new Node(finishCourse);
                    map.get(startCourse).nodes.add(courseNode);
                    map.put(finishCourse, courseNode);
                }
            } else {
                Node courseNode = new Node(startCourse);
                Node finishNode = map.getOrDefault(finishCourse, new Node(finishCourse));
                courseNode.nodes.add(finishNode);
                map.put(startCourse, courseNode);
                map.put(finishCourse, finishNode);
            }
        }
        startCourses.removeAll(endCourses);
        List<Integer> courses = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        startCourses.forEach(e-> q.add(map.get(e)));


        getCourses(courses, q);


        return courses.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static void getCourses(List<Integer> courses, Queue<Node> q) {
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(courses.contains(curr.id)) continue;
            courses.add(curr.id);
            q.addAll(curr.nodes);
        }
    }

    static class Node {
        int id;
        List<Node> nodes;

        Node(int id) {
            this.id = id;
            nodes = new ArrayList<>();
        }
    }
}
