package com.hz.huawei;

import java.util.Scanner;

/**
 * 描述
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 * <p>
 * 设KK位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T_1,T_2,…,T_KT
 * 1
 * ​
 * ,T
 * 2
 * ​
 * ,…,T
 * K
 * ​
 * ，若存在i(1\leq i\leq K)i(1≤i≤K) 使得T_1<T_2<......<T_{i-1}<T_iT
 * 1
 * ​
 * <T
 * 2
 * ​
 * <......<T
 * i−1
 * ​
 * <T
 * i
 * ​
 * 且 T_i>T_{i+1}>......>T_KT
 * i
 * ​
 * >T
 * i+1
 * ​
 * >......>T
 * K
 * ​
 * ，则称这KK名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 * <p>
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * <p>
 * 数据范围： 1 \le n \le 3000 \1≤n≤3000
 * <p>
 * 输入描述：
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 * <p>
 * 输出描述：
 * 最少需要几位同学出列
 * <p>
 * 示例1
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 复制
 * 输出：
 * 4
 * 复制
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            // 存储每个数左边小于其数的个数
            int[] left = new int[n];
            // 存储每个数右边小于其数的个数
            int[] right = new int[n];
            //最左，最右的数都设为1
            left[0] = 1;
            right[n - 1] = 1;
            // 计算每个位置左侧的最长递增子串
            for (int i = 0; i < n; i++) {
                left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {  //动态规划
                        left[i] = Math.max(left[j] + 1, left[i]);
                    }
                }
            }
            //计算每个位置右侧的最长递减子串
            for (int i = n - 1; i >= 0; i--) {
                right[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {
                        right[i] = Math.max(right[j] + 1, right[i]);
                    }
                }
            }
            // 记录每个位置的值
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = left[i] + right[i] - 1;
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                max = Math.max(result[i], max);
            }
            System.out.println(n - max);
        }
    }
}
