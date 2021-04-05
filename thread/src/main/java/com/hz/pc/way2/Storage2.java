package com.hz.pc.way2;

import com.hz.pc.IStorage;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HuZhuang
 * @description 缓冲区,使用await() / signal()方法实现
 * @date 2021-04-05 16:44
 */
public class Storage2 implements IStorage {

    public static final int MAX_SIZE = 10;
    //仓库存储的具体载体
    private final LinkedList<Object> list = new LinkedList<>();
    //锁
    private final ReentrantLock lock = new ReentrantLock();
    //仓库满的变量条件
    private final Condition full = lock.newCondition();
    //仓库空的变量条件
    private final Condition empty = lock.newCondition();

    @Override
    public void produce() {
        //获得锁
        lock.lock();
        while (list.size() >= MAX_SIZE) {
            //当缓冲区已满时，生产者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行；
            System.out.printf("生产者[%s]仓库已满\n", Thread.currentThread().getName());
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //否则生产者向缓冲区放入一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态；
        list.addFirst(new Object());
        System.out.printf("生产者[%s]生产一个产品,现在库存[%s]个\n", Thread.currentThread().getName(), list.size());
        empty.signalAll();
        lock.unlock();
    }

    @Override
    public void consume() {
        //获得锁
        lock.lock();
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
        full.signalAll();
        lock.unlock();
    }
}
