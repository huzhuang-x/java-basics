package com.hz.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2.
 * 字符集合
 * 输入一个字符串，求出该字符串包含的字符集合，按照字母输入的顺序输出。
 *
 * 数据范围：输入的字符串长度满足  ，且只包含大小写字母，区分大小写。
 *
 * 本题有多组输入
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 32M，其他语言64M
 * 输入描述：
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 * 输出描述：
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * 示例1
 * 输入例子：
 * abcqweracb
 * 输出例子：
 * abcqwer
 * 示例2
 * 输入例子：
 * aaa
 * 输出例子：
 * a
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            List<String> set = new ArrayList<>();
            String strIn= in.next();
            char[] arrs = strIn.toCharArray();
            for (int i = 0; i < arrs.length; i++) {
                if (!set.contains(arrs[i] + "")) {
                    set.add(arrs[i] + "");
                }
            }
            ArrayList<String> list = new ArrayList<>(set);
            for (int j = 0; j < list.size(); j ++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }
}
