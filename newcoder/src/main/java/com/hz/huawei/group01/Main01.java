package com.hz.huawei.group01;

import java.util.Scanner;

/**
 * @author HuZhuang
 * @date 2022-01-11 15:28
 */
public class Main01 {
    private static int[] numList = new int[10];

    public static void main(String[] args) {
        //读取输入
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (sc.hasNext()) {
            int tempIn = sc.nextInt();
            if (tempIn ==0){
                break;
            }
            numList[index] = tempIn;
            index++;
        }
        sc.close();
        for (int num : numList) {
            if (num == 0) {
                continue;
            }
            System.out.println(num/2);
        }
    }
}
