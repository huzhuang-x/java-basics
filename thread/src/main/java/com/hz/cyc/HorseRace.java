package com.hz.cyc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author HuZhuang
 * @description
 * @date 2021-11-22 21:33
 */
public class HorseRace implements Runnable {

    private static final int FINISH_LINE = 75;
    private static List<Horse> horses = new ArrayList<>();
    private static ExecutorService service = Executors.newFixedThreadPool(7);

    @Override
    public void run() {
        StringBuilder s = new StringBuilder();
        //打印赛道
        for (int i = 0; i < FINISH_LINE; i++) {
            s.append("=");
        }
        System.out.println(s);
        System.out.println("开始打印轨迹...");
        //打印赛马轨迹
        for (Horse horse : horses) {
            System.out.println(horse.tracks());
        }
        //判断是否结束
        for (Horse horse : horses) {
            if (horse.getStrides() >= FINISH_LINE) {
                System.out.println(horse + "WIN!");
                service.shutdown();
                return;
            }
        }
        try {
            System.out.println("等待下一次轨迹打印...");
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,new HorseRace());
        for (int i = 0; i < 7; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            service.execute(horse);
        }
    }
}
