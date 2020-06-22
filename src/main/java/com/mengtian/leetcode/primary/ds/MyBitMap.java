package com.mengtian.leetcode.primary.ds;

/**
 * Created by mengtian on 2020/6/11
 */
public class MyBitMap {
    //每个word时一个long类型元素，对应一个64位二进制数据
    private long[] words;
    //bitmap的位数大小
    private int size;

    public MyBitMap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1) + 1)];
    }

    /**
     * 判断bitmap某一位的状态
     *
     * @param bitIndex 位图的第bitIndex位（bitIndex=0代表bitmap左数第1位）
     * @return
     */
    public boolean getBit(int bitIndex) {
        checkBitBound(bitIndex);
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把bitmap某一位设置为true
     *
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        checkBitBound(bitIndex);
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 检查边界
     *
     * @param bitIndex
     */
    private void checkBitBound(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }
    }

    /**
     * 定位bitmap某一位所对应的word
     *
     * @param bitIndex
     * @return
     */
    private int getWordIndex(int bitIndex) {
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        MyBitMap bitMap = new MyBitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(78));
    }
}
