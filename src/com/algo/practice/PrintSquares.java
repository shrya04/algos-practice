package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintSquares {
    public static void main(String args[]){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(3,1,4,5,19,6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(14,9,22,36,8,0,64,25));

        List<Integer>ans = printSquares(l1, l2);
        for(int i: ans){
            System.out.println(i);
        }
    }

    private static List<Integer> printSquares(List<Integer> numbers, List<Integer> squares) {
        List<Integer> answers = new ArrayList<>();
        Collections.sort(numbers);
        Collections.sort(squares);
        int n=0;
        int s=0;
        while(s<squares.size() && n< numbers.size()){
            int num = numbers.get(n);
            int square = squares.get(s);
            int es = num*num;
            if(square == es){
                answers.add(square);
                s++;
                n++;
            }
            else if (square < es){
                s++;
            } else {
                n++;
            }
        }

        return answers;
    }
}
