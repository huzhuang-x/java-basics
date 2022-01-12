package com.hz.huawei.group01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 16进制转10进制
 * @author HuZhuang
 * @date 2022-01-11 16:38
 */
public class Main3 {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        //读取输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str == null) {
                break;
            }
            strList.add(str);
            doFunc(str);

        }
//        for (String str : strList) {
//        }
    }

    private static void doFunc(String str) {
        long num = 0;
        for (int i = 2; i < str.length(); i++) {
            num *= 16;
            char c = str.charAt(i);

            int n = 0;
            if (c >= 'A' && c <= 'F') {
                n = c - 'A' + 10;
            }else if (c >= 'a' && c <= 'f') {
                n = c - 'a' + 10;
            }else {
                n = c - '0';
            }
            num += n ;
        }
        System.out.println(num);
    }
}
