package com.mengtian.leetcode.primary.interview;

/**
 * Created by mengtian on 2020/6/10
 * 大整数相加
 */
public class BigNumberSum {

    public static String bigNumberSum(String numberA, String numberB) {
        //1. 把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = numberA.length() > numberB.length() ? numberA.length() : numberB.length();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < numberA.length(); i++) {
            arrayA[i] = numberA.charAt(numberA.length() - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < numberB.length(); i++) {
            arrayB[i] = numberB.charAt(numberB.length() - 1 - i) - '0';
        }
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp >= 10) {
                temp = temp - 10;
                //进位
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        //逆序输出
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }
}
