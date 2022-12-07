package com.hz.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            char[] arr = str.toCharArray();
            // 考虑单字符情况
            if (str.length() == 1) {
                System.out.println(1);
            } else {
                // 记录第i个字符(i为对称字符串最中心的左侧字符下标)处最长有效密码的长度
                int[] abbaResult = new int[arr.length];
                int[] abaResult = new int[arr.length];
                // ABBA型情况
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] == arr[i + 1]) {
                        // 分别向两侧遍历
                        for (int left = i, right = i + 1; left >= 0 && right < arr.length;) {
                            if (arr[left] == arr[right]) {
                                left--;
                                right++;
                                abbaResult[i] += 2;
                            }else {
                                break;
                            }
                        }
                    }
                }
                // ABA型情况
                for (int i = 0; i < arr.length - 2; i++) {
                    if (arr[i] == arr[i + 2]) {
                        abaResult[i] = 1;
                        // 分别向两侧遍历
                        for (int left = i , right = i + 2; left >= 0 && right < arr.length;) {
                            if (arr[left] == arr[right]) {
                                left--;
                                right++;
                                abaResult[i] += 2;
                            }else {
                                break;
                            }
                        }
                    }
                }
                int max = 0;
                Arrays.sort(abbaResult);
                Arrays.sort(abaResult);
                max = Math.max(abbaResult[abbaResult.length -1],abaResult[abaResult.length - 1]);
                System.out.println(max);
            }
        }
    }
}
