package com.hz.pc;

import com.hz.pc.IStorage;

import java.util.concurrent.TimeUnit;

/**
 * @author HuZhuang
 * @description 模拟生产者线程
 * @date 2021-04-05 15:50
 */
public class Producer implements Runnable {

    private final IStorage storage;

    public Producer(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1L);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
