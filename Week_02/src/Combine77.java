package com.leetcode.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合
 * @author: 孙彬
 */
public class Combine77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        _combine(1, new LinkedList<Integer>(), res, n, k);
        return res;
    }

    private void _combine(int first, LinkedList<Integer> level, List<List<Integer>> res, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = first; i <= n; i++) {
            level.add(i);
            _combine(i + 1, level, res, n, k - 1);
            level.removeLast();
        }
    }
}
