package com.hz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] arr = str.toCharArray();
            // 记录去除非英文字母的其他字符
            List<Character> tempList = new LinkedList<>();
            // 记录字符的位置
            List<Integer> indexList = new ArrayList<>();
            for(int i = 0;i< arr.length;i++) {
                if(isEn(arr[i])) {
                    tempList.add(arr[i]);
                }else{
                    indexList.add(i);
                }

            }
            Character[] tempArr = tempList.toArray(new Character[]{});
            for(int j = 0;j< tempList.size() - 1;j++) {
                char obj = tempList.get(j);
                char next = tempList.get(j + 1);

                char objUp = ((obj + "").toUpperCase()).toCharArray()[0];
                char nextUp = ((next + "").toUpperCase()).toCharArray()[0];
                if(nextUp > objUp) {

                }
            }
        }
    }

    public static boolean isEn(char a) {
        return (a >= 'A' && a <= 'Z') || (a >='a' && a <='z');
    }
    private static void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}