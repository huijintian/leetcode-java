package com.mengtian.leetcode.primary.sort;

import java.util.Arrays;

/**
 * Created by mengtian on 2020/6/3
 */
public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //标志是否有序，避免对已经有序数据再比较，减少循环次数
            boolean isSorted = true;
            //无序数列的边界，每次只需要比较到这里为止，减少排序数据的边界
            int sortBorder = array.length - 1;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                    sortBorder = j;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
