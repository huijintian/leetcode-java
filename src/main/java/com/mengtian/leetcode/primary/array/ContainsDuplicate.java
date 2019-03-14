package com.mengtian.leetcode.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengtian on 2019/3/14
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        return nums.length != sets.size();
    }
}
