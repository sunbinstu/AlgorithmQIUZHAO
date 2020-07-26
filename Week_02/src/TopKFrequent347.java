package com.leetcode.homework;

import java.util.*;

/**
 * @description: 前K个高频元素
 * @author: 孙彬
 */
public class TopKFrequent347 {
    //使用大顶堆
    public int[] topKFrequent(int[] nums, int k) {
        //使用hashmap存储每个元素重复的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int v = map.getOrDefault(n, 0) + 1;
            map.put(n, v);
        }
        //使用大顶堆,用元素的次数比大小，堆内只存储K个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k)
                pq.poll();
        }
        //将堆内K个元素存入数组
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], value);
        }
        //二维数组的方式，每个一维数组中的元素次数一致
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null)
                bucket[count] = new ArrayList();
            bucket[count].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && res.size() < k; i--) {
            if (bucket[i] == null) continue;
            res.addAll(bucket[i]);
        }
        return res;
    }
}
