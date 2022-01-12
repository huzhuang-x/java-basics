package com.hz.huawei.group02;

import java.util.Scanner;

/**
 * 循环链表问题
 * 有一个数组 a[N] 顺序存放 0 ~ N-1 ，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 以 8 个数 (N=7) 为例 :｛ 0，1，2，3，4，5，6，7 ｝，0 -> 1 -> 2 (删除) -> 3 -> 4 -> 5 (删除) -> 6 -> 7 -> 0 (删除),如此循环直到最后一个数被删除。
 *
 * @author HuZhuang
 * @date 2022-01-12 14:27
 */
public class Main01 {
    public static void main(String[] args) {
        //接收输入
        int inInt = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            inInt = sc.nextInt();
        }
        int delete = doDelete(inInt);
        System.out.println(delete);
    }

    /**
     * 删除方法
     * @param num
     * @return
     */
    private static int doDelete(int num) {
        MyNode<Integer> head = new MyNode<>();
        head.item = 0;
        head.next = null;
        MyNode<Integer> p = head;
        for (int i = 0; i < num; i++) {
            MyNode<Integer> temp = new MyNode<>();
            temp.item = i;
            temp.next = null;
            head.next = temp;
            head = head.next;
        }
        //最后尾指针指向头
        head.next = p;
        //结束条件为仅剩一个元素
        while(p != p.next){
            p.next.next = p.next.next.next;
            p = p.next.next;
        }
        return p.item;
    }

    /**
     * 定义Node泛型类
     *
     * @param <E>
     */
    private static class MyNode<E> {
        E item;
        MyNode<E> next;
    }
}
