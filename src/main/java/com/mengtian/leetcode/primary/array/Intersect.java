package com.mengtian.leetcode.primary.array;

import java.util.Arrays;

/**
 * Created by mengtian on 2019/3/14
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        Intersect intersect = new Intersect();
        int[] nums = intersect.intersect(nums1, nums2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] nums = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }

        return Arrays.copyOf(nums, index);
    }
}
