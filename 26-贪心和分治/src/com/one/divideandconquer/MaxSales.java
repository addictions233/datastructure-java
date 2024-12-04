package com.one.divideandconquer;

/**
 * @description: LCR 161. 连续天数的最高销售额
 * @author: wanjunjie
 * @date: 2024/12/02
 */
public class MaxSales {

    static  class Sum {
        /**
         * 左区间最大值
         */
        public int lMax;

        /**
         * 右区间最大值
         */
        public int rMax;

        /**
         * 总区间最大值
         */
        public int mMax;

        /**
         * 总和
         */
        public int mSum;

        public Sum(int lMax, int rMax, int mMax, int mSum) {
            this.lMax = lMax;
            this.rMax = rMax;
            this.mMax = mMax;
            this.mSum = mSum;
        }
    }
    public int maxSales(int[] sales) {
        Sum sum = find(sales, 0, sales.length - 1);
        return sum.mMax;
    }

    public Sum find(int[] sales, int left, int right) {
        if (left == right) {
            return new Sum(sales[left], sales[left], sales[left], sales[left]);
        }
        int middle = (left + right) >> 1;
        Sum lSum = find(sales, left, middle);
        Sum rSum = find(sales, middle + 1, right);
        int lMax = Math.max(lSum.lMax, lSum.mSum + rSum.lMax);
        int rMax = Math.max(rSum.rMax, rSum.mSum + lSum.rMax);
        int mSum = lSum.mSum + rSum.mSum;
        int mMax = Math.max(lSum.rMax + rSum.lMax, Math.max(lSum.mMax, rSum.mMax));
        return new Sum(lMax, rMax, mMax, mSum);
    }
}
