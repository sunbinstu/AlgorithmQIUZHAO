package com.leetcode.homework;

import java.util.*;

/**
 * @description: 全排列
 * @author: 孙彬
 */
public class PermuteUnique47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        Deque<Integer> dq = new ArrayDeque<>(len);
        dfs(nums,res,len,0,dq,used);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, int len, int depth, Deque<Integer> curr, boolean[] used) {
        if (len==depth) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0;i<len;i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            curr.addLast(nums[i]);
            used[i] = true;
            dfs(nums,res,len,depth + 1,curr,used);
            used[i] = false;
            curr.removeLast();
        }
    }
}
