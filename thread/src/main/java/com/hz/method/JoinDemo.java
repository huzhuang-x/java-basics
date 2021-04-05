package com.hz.method;

/**
 * @Author HuZhuang
 * @Date 2021-04-04 23:11
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }, "子线程");
        thread.start();

        //主线程
        thread.join();
        for (int i = 0; i < 5; i++) {
                //i为200时调用thread.join(),则当前线程阻塞,一直等待thread线程执行完毕后才继续执行
            System.out.println("main" + i);
        }
    }
}
