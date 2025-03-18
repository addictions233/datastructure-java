package com.one.slidingwindow;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 2779. 数组的最大美丽值
 * @author: wanjunjie
 * @date: 2025/03/18
 */
public class MaximumBeauty {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int left = 0;
        int result = 1;
        for (int right = 1; right < nums.length; right++) {
            //当窗口中的元素不满足条件时, left右移,直到窗口满足条件
            while(nums[right] - nums[left] > 2*k) {
                left++;
            }
            // 窗口满足条件, 更新结果
            result = Math.max(result, right - left + 1);
            // right右移, 继续寻找满足条件的窗口
        }
        return result;
    }
}
