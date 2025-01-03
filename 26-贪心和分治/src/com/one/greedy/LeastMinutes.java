package com.one.greedy;

/**
 * @description: LCS 01. 下载插件
 * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
 * 使用当前带宽下载插件
 * 将带宽加倍（下载插件数量随之加倍）
 * 请返回小扣完成下载 n 个插件最少需要多少分钟。
 * 注意：实际的下载的插件数量可以超过 n 个
 * @author: wanjunjie
 * @date: 2025/01/03
 */
public class LeastMinutes {
    public int leastMinutes(int n) {
        int result = 0;
        int i = 1;
        while(n > 0) {
            n = n - i;
            result++;
            i = i *2;
        }
        return result;
    }
}
