package com.hz.huawei.group02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author HuZhuang
 * @date 2022-01-12 15:42
 */
public class Main01Quick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int inInt = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < inInt; i++) {
                list.add(i);
            }
            int i = 0;
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
