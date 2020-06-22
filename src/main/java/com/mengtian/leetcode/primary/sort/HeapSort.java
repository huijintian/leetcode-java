package com.mengtian.leetcode.primary.sort;

import java.util.Arrays;

/**
 * Created by mengtian on 2020/6/4
 * 堆排序
 * 实际就是构建一个最大二叉堆，然后循环删除堆顶的元素，将删除元素移除到集合尾部，这样最终得到一个排序的集合
 */
public class HeapSort {

    /**
     * 下沉
     *
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust(array, i, array.length - 1);
        }
        System.out.println(Arrays.toString(array));
        for (int i = array.length - 1; i > 0; i--) {
            //最后一个元素和第一个元素进行交换(即“删除最大值”)
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
