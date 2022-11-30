package com.hz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int count = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            char[] charArr = a.toCharArray();
            for(int i =0;i < charArr.length;i++) {
                String str = charArr[i] + "";
                if(str.equalsIgnoreCase(b)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}