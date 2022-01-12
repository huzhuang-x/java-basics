package com.hz.pc;

import com.hz.pc.IStorage;

import java.util.concurrent.TimeUnit;

/**
 * @author HuZhuang
 * @description 模拟消费者线程
 * @date 2021-04-05 15:50
 */
public class Consumer implements Runnable{

    private final IStorage storage;

    public Consumer(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(3L);
                storage.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
