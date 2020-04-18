package com.hz.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:子线程循环3次,接着主线程循环5次,接着再子线程循环3次,主线程循环5次,如此反复,循环3次.
 * @author: HuZhuang
 * @time: 2020/4/5 1:58
 */
public class CrossCirculate2 {
    public static void main(String[] args) {
        ThreadFunction2 function2 = new ThreadFunction2();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                function2.subFunc();
            }
        },"子线程").start();

        for (int i = 0; i < 3; i++) {
            function2.mainFunc();
        }
    }

    public static class ThreadFunction2 extends Thread {
        private boolean flag = false;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public void mainFunc() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始，flag：" + flag);
            lock.lock();
            try {
                while (!flag) {
                    System.out.println(name + "等待，flag：" + flag);
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + "开始循环5次，flag：" + flag);
                for (int i = 0; i < 5; i++) {
                    System.out.println(name + i);
                }
                flag = false;
                System.out.println("唤醒子线程，flag：" +flag);
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void subFunc() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始，flag：" + flag);
            lock.lock();
            try {
                while (flag) {
                    System.out.println(name + "等待，flag：" + flag);
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + "开始循环3次，flag：" + flag);
                for (int i = 0; i < 3; i++) {
                    System.out.println(name + i);
                }
                flag = true;
                System.out.println("唤醒主线程，flag：" +flag);
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
