package com.hz.pc.way3;

import com.hz.pc.IStorage;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author HuZhuang
 * @description 缓冲区,使用BlockingQueue阻塞队列方法实现
 * @date 2021-04-05 18:09
 */
public class Storage3 implements IStorage {
    //仓库载体
    public static final LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(10);

    @Override
    public void produce() {
        try {
            list.put(new Object());
            System.out.printf("生产者[%s]生产一个产品,现在库存[%s]个\n", Thread.currentThread().getName(), list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consume() {
        try {
            list.take();
            System.out.printf("消费者[%s]消费一个产品,现在库存[%s]个\n", Thread.currentThread().getName(), list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
