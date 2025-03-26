package com.problem.solving;

import java.util.ArrayList;
import java.util.List;

public class MaximumCountOfPositiveAndNegativeIntegers {

    public static int upperBound(int[] nums)    {
        int low = 0, high = nums.length - 1;
        int index = nums.length;
        while(low <= high)  {
            var mid = low + (high - low) / 2;
            if(nums[mid] <= 0)  {
                low = mid + 1;
            }   else if(nums[mid] > 0) {
                high = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    public static int lowerBound(int[] nums)    {
        int low = 0, high = nums.length - 1;
        int index = nums.length;
        while(low <= high)  {
            var mid = low + (high - low) / 2;
            if(nums[mid] < 0)  {
                low = mid + 1;
            }   else if(nums[mid] >= 0) {
                high = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    public static int maximumCount(int[] nums)  {
        int upperBound = nums.length - upperBound(nums);
        int lowerBound = lowerBound(nums);
        return Math.max(upperBound, lowerBound);
    }

    public static void main(String[] args) {
        var numbers = new ArrayList<>(List.of(-3,-2,-1,0,0,1,2));
        var max = maximumCount(numbers.stream().mapToInt(Integer::intValue).toArray());
        System.out.println(max);
    }
}
