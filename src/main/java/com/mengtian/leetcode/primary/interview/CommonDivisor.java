package com.mengtian.leetcode.primary.interview;

/**
 * Created by mengtian on 2020/6/5
 * 求两个整数的最大公约数
 */
public class CommonDivisor {

    /**
     * 辗转相除法
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV1(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisorV1(big % small, small);
    }

    /**
     * 更相相减法
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV2(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisorV2(big - small, small);
    }
}
