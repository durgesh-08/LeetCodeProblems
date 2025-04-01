package com.problem.solving;

import java.util.*;

// link: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/?envType=problem-list-v2&envId=sliding-window
public class FindXSumOfKLongsSubArrays {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                if(Objects.equals(map.get(a), map.get(b)))    {
                    return b - a;
                }
                return map.get(b) - map.get(a);
            });
            pq.addAll(map.keySet());
            int ct = x;
            while(ct-- > 0 && !pq.isEmpty()) {
                int top = pq.remove();
                result[i] += top * map.get(top);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        var nums = new int[]{1,1,2,2,3,4,2,3};
        FindXSumOfKLongsSubArrays findXSumOfKLongsSubArrays = new FindXSumOfKLongsSubArrays();
        Arrays.stream(findXSumOfKLongsSubArrays.findXSum(nums, 6, 2)).forEach(System.out::println);
    }

}
