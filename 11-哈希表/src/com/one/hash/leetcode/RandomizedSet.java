package com.one.hash.leetcode;

import java.util.*;

/**
 * @description: 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
class RandomizedSet {
    List<Integer> values;
    Map<Integer, Integer> indexMap;

    Random random;

    /**
     * 只有数组和哈希表的时间复杂度是O(1)
     */
    public RandomizedSet() {
        values = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        values.add(val);
        indexMap.put(val, values.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.remove(val);
        Integer last = values.get(values.size() - 1);
        values.set(index, last);
        indexMap.put(last, index);
        values.remove(values.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}