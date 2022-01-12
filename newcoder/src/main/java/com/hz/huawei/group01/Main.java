package com.hz.huawei.group01;

import java.util.Scanner;

/**
 * @author HuZhuang
 * @date 2022-01-11 15:28
 */
public class Main {
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
        for (int num : numList) {
            if (num == 0) {
                continue;
            }
            int resultNum = 0;
            doFunc(num, resultNum);
        }
    }

    /**
     * 核心方法
     * @param num
     */
    private static void doFunc(int num, int resultNum) {
        if (num < 2) {
            System.out.println(resultNum);
            return;
        }
        if (num == 2) {
            System.out.println(resultNum + 1);
            return;
        }
        int tempNum = num / 3;
        int mod = num % 3;
        resultNum += tempNum;
        doFunc(tempNum + mod,resultNum);
    }
}
