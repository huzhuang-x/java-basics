package com.hz.thread;

/**
 * @description:子线程循环3次,接着主线程循环5次,接着再子线程循环3次,主线程循环5次,如此反复,循环3次.
 * @author: HuZhuang
 * @time: 2020/4/5 1:37
 */
public class CrossCirculate {
    public static void main(String[] args) {
        final ThreadFunction threadFunction = new ThreadFunction();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                threadFunction.subFunc();
            }
        },"子线程").start();

        for (int i = 0; i < 3; i++) {
            threadFunction.mainFunc();
        }
    }

    /**
     * 功能类实现子线程和主线程功能
     */
    static class ThreadFunction {
        private boolean flag = false;

        /**
         * 主线程实现功能
         */
        public synchronized void mainFunc(){
            System.out.println(Thread.currentThread().getName() + "获取锁");
            while (!flag) {
                try {
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + "等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            this.notify();
            flag = false;
        }

        public synchronized void subFunc(){
            System.out.println(Thread.currentThread().getName() + "获取锁");
            while (flag) {
                try {
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + "等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            this.notify();
            flag = true;
        }
    }
}
