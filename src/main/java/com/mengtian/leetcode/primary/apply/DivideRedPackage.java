package com.mengtian.leetcode.primary.apply;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mengtian on 2020/6/11
 * 拆分红包，红包的拆分应该在确认的红包金额以及人数之后就分好，避免高并发问题
 * <p>
 * 二倍均值法（保证每次随机金额的平均值是均等的）：每次抢到的红包 = 随机区间[0.01, m/n * 2 - 0.01]元  （m为剩余红包金额，n为剩余人数）
 */
public class DivideRedPackage {
    /**
     * 拆分红包
     *
     * @param totalAmount    总金额（以分为单位）
     * @param totalPeopleNum 总人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        //剩余红包
        Integer restAmout = totalAmount;
        //剩余人数
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            int amount = random.nextInt(restAmout / restPeopleNum * 2 - 2) + 1;
            restAmout -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmout);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amounts = divideRedPackage(1000, 10);
        for (Integer amount : amounts) {
            System.out.println(new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }
}
