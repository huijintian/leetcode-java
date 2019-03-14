package com.mengtian.leetcode.primary.array;

/**
 * Created by mengtian on 2019/3/14
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 11};
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
