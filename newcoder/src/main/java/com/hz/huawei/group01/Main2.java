package com.hz.huawei.group01;


import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author HuZhuang
 * @date 2022-01-11 16:38
 */
public class Main2 {
    public static void main(String[] args) {
        //读取输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int nextInt = sc.nextInt();
                treeSet.add(nextInt);
            }
            for (int num : treeSet) {
                System.out.println(num);
            }
        }
    }
}
