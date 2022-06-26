package com.one.tools;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName: Times
 * @Description: 测试执行时间工具类
 * @Author: one
 * @Date: 2022/05/24
 */
public class Times {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public interface Task{
        void execute();
    }

    public static void test(String title, Task task) {
        if (task == null) {
            return;
        }
        System.out.println(title);
        System.out.println("开始时间：" + dateTimeFormatter.format(LocalDateTime.now()));
        long l1 = Instant.now().toEpochMilli();
        task.execute();
        long l2 = Instant.now().toEpochMilli();
        System.out.println("结束时间：" + dateTimeFormatter.format(LocalDateTime.now()));
        double cost = (l2 - l1) / 1000.0; // 将毫秒时间转换为秒
        System.out.println("耗时：" + cost + "秒");
        System.out.println("------------------------------------------");
    }
}
