package com.hz.huawei.group02;

import java.util.*;

/**
 * 输入一个字符串，求出该字符串包含的字符集合，按照字母输入的顺序输出。
 * <p>
 * 数据范围：输入的字符串长度满足  ，且只包含大小写字母，区分大小写。
 *
 * @author HuZhuang
 * @date 2022-01-12 15:14
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String next = sc.next();
            char[] chars = next.toCharArray();
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (char c : chars) {
                if (set.add(c)){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
