package com.hz.pc.way1;

import com.hz.pc.Consumer;
import com.hz.pc.IStorage;
import com.hz.pc.Producer;

/**
 * @author HuZhuang
 * @description 生产者, 消费者模型
 * @date 2021-04-05 15:47
 */
public class ProduceConsumeDemo {

    public static void main(String[] args) {
        IStorage storage = new Storage1();
        Producer producer = new Producer(storage);
        Thread p1 = new Thread(producer,"p1");
        Thread p2 = new Thread(producer,"p2");
        Thread p3 = new Thread(producer,"p3");

        Consumer consumer = new Consumer(storage);
        Thread c1 = new Thread(consumer,"c1");
        Thread c2 = new Thread(consumer,"c2");
        Thread c3 = new Thread(consumer,"c3");

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
