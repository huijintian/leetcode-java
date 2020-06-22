package com.mengtian.leetcode.primary.ds;

import java.util.Arrays;

/**
 * Created by mengtian on 2020/6/2
 * 二叉堆
 * 以最小二叉堆为例，最小二叉堆中的父节点值一定比左右节点值小
 * 基于数组构建，index=0的即为二叉堆堆顶
 * 父节点 parent
 * 左右子节点计算：2 * parent + 1, 2 * parent + 2
 * 主要操作：插入、删除、构建
 * 上浮和下沉
 * <p>
 * 二叉堆插入的数据都是在数组的最后一个index中
 */
public class BinaryHeap {

    /**
     * “上浮”调整
     *
     * @param array
     */
    public static void upAdjust(int[] array) {
        //最后一个节点
        int childIndex = array.length - 1;
        //通过子节点得到父节点
        int parentIndex = (childIndex - 1) / 2;
        //保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        //当前子节点不在堆顶且新插入的数据比父节点小
        //父节点下沉，子节点上浮
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        //执行第33行中的后续数据交换
        array[childIndex] = temp;
    }

    /**
     * “下沉”调整
     *
     * @param array
     * @param parentIndex 要“下沉”的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //保存父节点的值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        //一直查找到最后一个元素
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //当父节点值比左右孩子值小，跳出循环
            if (temp <= array[childIndex]) {
                break;
            }
            //否则，将子节点的值上浮，父节点下沉
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建堆
     *
     * @param array
     */
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次做下沉处理
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
