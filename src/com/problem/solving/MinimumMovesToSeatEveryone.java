package com.problem.solving;

// link : https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/?envType=problem-list-v2&envId=sorting
public class MinimumMovesToSeatEveryone {

    public static void mergeSort(int[] nums, int low, int high) {
        if(low < high)  {
            var mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        var n1 = mid - low + 1;
        var n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];
        System.arraycopy(nums, low, left, 0, n1);
        System.arraycopy(nums, mid + 1, right,0, n2);
        int i = 0, j = 0, k = low;
        while(i < n1 && j < n2) {
            if(left[i] < right[j])  {
                nums[k] = left[i];
                i++;
            }   else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1)   {
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j < n2)   {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        mergeSort(seats, 0, seats.length - 1);
        mergeSort(students, 0, seats.length - 1);
        var sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        var nums1 = new int[]{4,1,5,9};
        var nums2 = new int[]{1,3,2,6};
        System.out.println(minMovesToSeat(nums1, nums2));
    }
}
