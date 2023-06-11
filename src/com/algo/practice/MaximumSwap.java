package com.algo.practice;

import java.util.PriorityQueue;

public class MaximumSwap {

    public static void main(String args[]) {
        int ans = maximumSwap(92368);
        System.out.println(ans);
        System.out.println(ans == 98863);
    }

    private static int maximumSwap(int num) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> b.value - a.value);
        String str = String.valueOf(num);
        Integer[] nums = new Integer[str.length()];
        for (int i = 0; i < nums.length; ) {
            nums[i] = str.charAt(i)-'0';
            pq.add(new Pair(str.charAt(i)-'0', i));
            i++;
        }
        for (int i = 0; i < str.length(); i++) {
            Pair top = pq.poll();
            assert top != null;
            if (nums[i] < top.value) {
                int idx = top.index;
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        int ans = 0;
        for (int i : nums) {
            ans = ans * 10 + i;
        }
        return ans;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
