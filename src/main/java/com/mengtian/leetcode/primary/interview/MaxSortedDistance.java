package com.mengtian.leetcode.primary.interview;

/**
 * Created by mengtian on 2020/6/5
 * 无序数组排序后的最大相邻差
 * 时间复杂度 O(n)
 */
public class MaxSortedDistance {

    private static class Bucket {
        Integer min;
        Integer max;
    }

    public static int getMaxSortedDistance(int[] array) {
        int max, min;
        max = min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        // 表示所有元素都相等
        if (d == 0) {
            return 0;
        }
        //初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        //遍历原数组
        for (int i = 0; i < array.length; i++) {
            //确定数组元素所归属的桶下标
            int index = (array[i] - min) * (bucketNum - 1) / d;
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }

        //遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 3, 4, 5, 10, 9};
        System.out.println(getMaxSortedDistance(array));
    }
}
