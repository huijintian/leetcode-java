package com.mengtian.leetcode.primary.array;

/**
 * Created by mengtian on 2019/3/14
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Rotate rotate = new Rotate();
        rotate.rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void rotate(int[] nums, int k) {
        while (k > 0) {
            int num = nums[nums.length - 1];
            for (int length = nums.length - 1; length > 0; length--) {
                nums[length] = nums[length - 1];
            }
            nums[0] = num;
            k--;
        }
    }
}
