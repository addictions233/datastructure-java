package com.one.slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: wanjunjie
 * @date: 2025/03/17
 */
public class SystemMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        Integer[] array = Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] target = new Integer[array.length*2];
        for (int i = 0; i < target.length; i++) {
            target[i] = array[i % array.length];
        }
        int start = 0;
        int result = 0;
        int length = 0;
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            // 1, 初始化窗口
            sum += target[i];
            if (sum <= n) {
                int curLength = i - start;
                // 2. 计算结果
                if (curLength > length) {
                    result = start;
                    length = curLength;
                }
                continue;
            }
            do {
                // 3. 出窗
                sum -= target[start];
                start++;
            } while (sum > n);
        }
        System.out.println(result);
    }
}
