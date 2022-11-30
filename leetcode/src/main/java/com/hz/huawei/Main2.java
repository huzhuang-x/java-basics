package com.hz.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 十六进制转换
 */
public class Main2 {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String strIn = in.nextLine();
            int resultNum = 0;
            String str = strIn.substring(2,strIn.length());
            char[] charArray = str.toCharArray();
            int k = 0;
            for(int i = charArray.length -1; i >=0; i--) {
                char temp = charArray[i];
                if(temp >='A' && temp <='F') {
                    resultNum += map.get(temp) * Math.pow(16,k);
                }else{
                    resultNum += Integer.parseInt(temp + "") * Math.pow(16,k);
                }
                k++;
            }
            System.out.println(resultNum);
        }
    }
}
