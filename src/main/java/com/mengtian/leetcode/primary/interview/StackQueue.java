package com.mengtian.leetcode.primary.interview;

import java.util.Stack;

/**
 * Created by mengtian on 2020/6/5
 * 栈实现队列
 */
public class StackQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     * 出队操作
     *
     * @return
     */
    public Integer deQueue() {
        if (stackB.empty()) {
            if (stackA.empty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 将栈A元素转移到栈B
     */
    private void transfer() {
        while (!stackA.empty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }

}
