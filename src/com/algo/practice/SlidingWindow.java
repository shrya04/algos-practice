package com.algo.practice;

import java.util.PriorityQueue;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] ans = maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a, b) -> {
            if (b.val - a.val != 0) {
                return b.val - a.val;
            } else {
                return b.index - a.index;
            }
        });

        int start = 0;
        int i = 0;

        for (; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }

        int ansIdx = 0;
        start = i;
        int ans[] = new int[nums.length - k + 1];
        ans[ansIdx] = pq.peek().val;
        ansIdx++;
        int max = pq.peek().val;
        for (i = start; i < nums.length; i++) {
            Pair top = pq.peek();

            while (top.index <= i - k && !pq.isEmpty()) {
                pq.poll();
            }

            if (pq.isEmpty()) {
                max = nums[i];
            } else {
                top = pq.peek();
                max = Math.max(top.val, nums[i]);
            }
            pq.add(new Pair(nums[i], i));

            ans[ansIdx] = max;
            ansIdx++;

        }
        return ans;

    }

    static class Pair {
        public int val;
        public int index;

        Pair(int i, int k) {
            this.val = i;
            this.index = k;
        }
    }
}
