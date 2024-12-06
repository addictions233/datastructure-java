package com.one.divideandconquer;

/**
 * @author one
 * @description 最大连续子串
 * @date 2024-12-2
 */
public class MaxSubArray {

    public int maxSubArray2(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return nums[left];
        }
        int middle = (left + right) >> 1;
        int lMax = maxSubArray2(nums, left, middle);
        int rMax = maxSubArray2(nums, middle, right);
        int mLeftMax = Integer.MIN_VALUE;
        int sum1 = 0;
        for (int i = middle - 1; i >= left; i--) {
            sum1 += nums[i];
            mLeftMax = Math.max(mLeftMax, sum1);
        }

        int mRightMax = Integer.MIN_VALUE;
        int sum2 = 0;
        for (int i = middle; i < right; i++) {
            sum2 += nums[i];
            mRightMax = Math.max(mRightMax, sum2);
        }

        return Math.max(Math.max(lMax, rMax), mLeftMax + mRightMax);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArray(nums, 0,  nums.length);
    }

    public int maxSubArray(int[] nums, int left, int right) {
        if (right - left < 2) {
            return nums[left];
        }
        int middle = (left + right) >> 1;
        int lmax = Integer.MIN_VALUE;
        int lsum  = 0;
        for (int i = middle - 1; i >= left; i--) {
            lsum += nums[i];
            lmax = Math.max(lmax, lsum);
        }

        int rmax = Integer.MIN_VALUE;
        int rsum = 0;
        for (int i = middle; i < right; i++) {
            rsum += nums[i];
            rmax = Math.max(rmax, rsum);
        }

        int leftMax = maxSubArray(nums, left, middle);
        int rightMax = maxSubArray(nums, middle, right);
        return Math.max(lmax + rmax, Math.max(leftMax, rightMax));
    }

    private static int mthod1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
