package com.hz.pc.way1;

import com.hz.pc.IStorage;

import java.util.LinkedList;

/**
 * @author HuZhuang
 * @description 缓冲区,使用wait() / notify()方法实现
 * @date 2021-04-05 16:44
 */
public class Storage1 implements IStorage {

    public static final int MAX_SIZE = 10;
    //仓库存储的具体载体
    private final LinkedList<Object> list = new LinkedList<>();

    @Override
    public void produce() {
        synchronized (list) {
            while (list.size() >= MAX_SIZE) {
                //当缓冲区已满时，生产者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行；
                System.out.printf("生产者[%s]仓库已满\n", Thread.currentThread().getName());
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //否则生产者向缓冲区放入一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态；
            list.addFirst(new Object());
            System.out.printf("生产者[%s]生产一个产品,现在库存[%s]个\n", Thread.currentThread().getName(), list.size());
            list.notifyAll();
        }
    }

    @Override
    public void consume() {
        synchronized (list) {
            while (list.size() == 0) {
                //当缓冲区已满时，生产者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行；
                System.out.printf("消费者[%s]仓库已空\n", Thread.currentThread().getName());
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //否则生产者向缓冲区放入一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态；
            list.removeFirst();
            System.out.printf("消费者[%s]消费一个产品,现在库存[%s]个\n", Thread.currentThread().getName(), list.size());
            list.notifyAll();
        }
    }
}
