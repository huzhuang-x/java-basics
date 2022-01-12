package com.hz;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 *
 * @author HuZhuang
 * @date 2020/7/19
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("手机组装开始");
        //组装手机线程开始
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上游工序已完成，可以组装");
        }).start();
        //其他上游工序线程启动
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(()->{

                System.out.println("上游工序已完成");
                countDownLatch.countDown();
            }).start();
        }


    }
}
