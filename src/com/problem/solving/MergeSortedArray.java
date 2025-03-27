package com.problem.solving;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }   else if(m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int i = 0, j = 0, k =0;
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        while(i < m && j < n)    {
            if(temp[i] < nums2[j]) {
                nums1[k] = temp[i];
                i++;
            }   else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m)    {
            nums1[k] = temp[i];
            i++;
            k++;
        }
        while(j < n)    {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }

}
