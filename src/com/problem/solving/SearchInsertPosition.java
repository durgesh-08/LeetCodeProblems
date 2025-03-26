package com.problem.solving;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int low = 0, mid = 0, high = nums.length -1;
        while(low <= high)  {
            mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target)  {
                low = mid + 1;
            }   else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        var nums = new int[]{1, 3};
        System.out.println(searchInsert(nums, 2));
    }
}
