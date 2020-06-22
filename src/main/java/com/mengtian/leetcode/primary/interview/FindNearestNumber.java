package com.mengtian.leetcode.primary.interview;

import java.util.Arrays;

/**
 * Created by mengtian on 2020/6/10
 * <p>
 * 寻找全排列的下一个数
 * 例：12345的全排列的下一个数是12435
 * <p>
 * 1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
 * 2. 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置
 * 3. 把原来的逆序区域转为顺序状态
 */
public class FindNearestNumber {

    public static int[] findNearestNumber(int[] numbers) {
        //1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字置换边界是0，说明数组已经逆序，无法得到更大的相同数
        if (index == 0) {
            return null;
        }
        //2. 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        //3. 把原来的逆序区域转为顺序状态
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int[] reverse(int[] numbersCopy, int index) {
        for (int i = index, j = numbersCopy.length - 1; i < j; i++, j--) {
            int temp = numbersCopy[i];
            numbersCopy[i] = numbersCopy[j];
            numbersCopy[j] = numbersCopy[i];
        }
        return numbersCopy;
    }

    private static int[] exchangeHead(int[] numbersCopy, int index) {
        int head = numbersCopy[index - 1];
        for (int i = numbersCopy.length - 1; i > 0; i--) {
            if (head < numbersCopy[i]) {
                numbersCopy[index - 1] = numbersCopy[i];
                numbersCopy[i] = head;
                break;
            }
        }
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            int[] nearestNumber = findNearestNumber(numbers);
            System.out.println(Arrays.toString(nearestNumber));
        }
    }
}
