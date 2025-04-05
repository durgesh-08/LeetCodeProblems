package com.problem.solving;

import java.util.*;
import java.util.stream.Collectors;

// link: https://leetcode.com/problems/two-sum/description/
public class TwoSums {

    // my first solution
//    public int[] twoSum(int[] nums, int target) {
//        var hashMap = new HashMap<Integer, List<Integer>>();
//        int[] indexOfNumbers = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if(hashMap.containsKey(nums[i]))    {
//                hashMap.get(nums[i]).add(i);
//            }   else {
//                var list = new ArrayList<Integer>();
//                list.add(i);
//                hashMap.put(nums[i], list);
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if(hashMap.containsKey(target - nums[i]))   {
//                if(hashMap.get(nums[i]).equals(hashMap.get(target - nums[i])))  {
//                    if(hashMap.get(nums[i]).size() > 1) {
//                        var list = hashMap.get(nums[i]);
//                        indexOfNumbers[0] = list.get(0);
//                        indexOfNumbers[1] = list.get(1);
//                    }
//                }   else {
//                    var list = hashMap.get(target - nums[i]);
//                    indexOfNumbers[0] = i;
//                    indexOfNumbers[1] = list.getFirst();
//                    break;
//                }
//            }
//        }
//        return indexOfNumbers;
//    }

    // Trying again
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))   {
                results[1] = i;
                results[0] = map.get(target - nums[i]);
                break;
            }   else {
                map.put(nums[i], i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        Arrays.stream(twoSums.twoSum(new int[]{3,3}, 6)).forEach(System.out::println);
    }
}
