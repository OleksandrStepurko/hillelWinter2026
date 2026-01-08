package com.hillel.cw_05.task;

//        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example 1:
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        ===================================
//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        ===================================
//        Example 3:
//        Input: nums = [3,3], target = 6
//        Output: [0,1]
public class SummTwo {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 12);
        System.out.println(result[0] + " " + result[1]) ;
    }

    public static int[] twoSum(int[] mass, int target){
        int[] rez = new int[2];
        for (int i = 0; i < mass.length; i++ ){
            for(int j = i + 1; j < mass.length; j++){
                if (mass[i] + mass[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return rez;
    }
}
