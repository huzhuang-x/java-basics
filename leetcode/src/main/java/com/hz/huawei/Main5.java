package com.hz.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 *
 * 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
 * 9
 *  +14
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：
 * 180
 * 复制
 * 输出：
 * 2 2 3 3 5
 */
public class Main5 {
    public static void main(String[] args) {
        HashSet<Long> set = new HashSet<>();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long n = in.nextLong();
            boolean bol;
            for(long i = 2;i <=n; ) {
                bol = false;
                for (Long val : set) {
                    if (i % val == 0) {
                        bol = true;
                    }
                }
                if (bol) {
                    i++;
                    continue;
                }
                if(n % i == 0) {
                    n /= i;
                    set.add(i);
                }else{
                    i++;
                }
            }
        }
    }
}
