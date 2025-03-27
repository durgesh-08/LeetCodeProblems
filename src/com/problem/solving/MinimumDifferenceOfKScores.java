package com.problem.solving;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/?envType=problem-list-v2&envId=sorting
public class MinimumDifferenceOfKScores {

    public static void merge(int[] numbers, int low, int mid, int high) {
        var n1 = mid - low + 1;
        var n2 = high - mid;
        //Create a copy of left and right arrys
        int[] left = new int[n1];
        int[] right = new int[n2];
        System.arraycopy(numbers, low, left, 0, n1);
        System.arraycopy(numbers, mid + 1, right, 0, n2);
        int l = 0, r = 0, k = low;
        while(l < n1 && r < n2) {
            if(left[l] < right[r]) {
                numbers[k] = left[l];
                l++;
            }   else {
                numbers[k] = right[r];
                r++;
            }
            k++;
        }

        while(l < n1)   {
            numbers[k] = left[l];
            l++;
            k++;
        }
        while(r < n2)   {
            numbers[k] = right[r];
            r++;
            k++;
        }
    }

    public static void sortElements(int[] numbers, int low, int high) {
        if(low < high)   {
            var mid = low + (high - low) / 2;
            sortElements(numbers, low, mid);
            sortElements(numbers, mid + 1, high);
            merge(numbers, low, mid, high);
        }
    }

    public static int minimumDifference(int[] nums, int k) {
        sortElements(nums, 0, nums.length -1);
        int i = 0, j = k - 1, min = Integer.MAX_VALUE;
        while(j < nums.length)  {
            if((nums[j] - nums[i]) < min)   {
                min = nums[j] - nums[i];
            }
            i++;
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        var numbers = new ArrayList<>(List.of(90));
        System.out.println(minimumDifference(numbers.stream().mapToInt(Integer::intValue).toArray(), 1));

    }
}
