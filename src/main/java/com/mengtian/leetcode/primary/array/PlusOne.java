package com.mengtian.leetcode.primary.array;

/**
 * Created by mengtian on 2019/3/14
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{8, 9, 9, 9};
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(digits);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] plusOne(int[] digits) {
        boolean plus = false;

        for (int length = digits.length - 1; length >= 0; length--) {
            if (digits[length] + 1 > 9) {
                plus = true;
                digits[length] = 0;
            } else {
                digits[length] = digits[length] + 1;
                plus = false;
                break;
            }
        }
        if (plus) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
