package com.problem.solving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// link: https://leetcode.com/problems/minimum-positive-sum-subarray/?envType=problem-list-v2&envId=sliding-window
public class MinimumPositiveSumSubArray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        var min = Integer.MAX_VALUE;
        int left = l, right = r;
        while(left <= right)    {
            int firstWindowSum = 0;
            for (int i = 0; i < left; i++) {
                firstWindowSum += nums.get(i);
            }
            if(firstWindowSum > 0)  {
                 min = Math.min(firstWindowSum, min);
            }
            for (int i = left; i < nums.size(); i++) {
                firstWindowSum -= nums.get(i - left);
                firstWindowSum += nums.get(i);
                if(firstWindowSum > 0)  {
                    min = Math.min(firstWindowSum, min);
                }
            }
            left ++;
        }
        if(min == Integer.MAX_VALUE)    {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        var list = new ArrayList<>(List.of(5,8,-6));
        var minimumPositiveSumSubArray = new MinimumPositiveSumSubArray();
        System.out.println(minimumPositiveSumSubArray.minimumSumSubarray(list, 1,3));
    }
}
