package com.mengtian.leetcode.primary.array;

/**
 * Created by mengtian on 2019/3/14
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int f_index = 0, n_index = 1;
        for (; n_index < nums.length; n_index++) {
            if(nums[f_index] == nums[n_index]){
                continue;
            }else {
                if(f_index + 1 != n_index){
                    nums[f_index + 1] = nums[n_index];
                }
                f_index++;
            }
        }
        return f_index + 1;
    }
}
