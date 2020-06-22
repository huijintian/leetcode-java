package com.mengtian.leetcode.primary.interview;

/**
 * Created by mengtian on 2020/6/5
 * 是否是2的整数次幂
 */
public class PowerOf2 {

    public static boolean isPowerOf2V1(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp * 2;
        }
        return false;
    }

    /**
     * isPowerOf2V2 只是优化了*2的计算方式
     *
     * @param num
     * @return
     */
    public static boolean isPowerOf2V2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            //乘2改为左移1位
            temp = temp << 1;
        }
        return false;
    }

    /**
     * 2的整数次幂二进制第一位都是1，其他位则是0
     * 2的整数次幂减1的二进制第一位都是0，其他位则是1
     *
     * @param num
     * @return
     */
    public static boolean isPowerOf2V3(int num) {
        return (num & num - 1) == 0;
    }
}
