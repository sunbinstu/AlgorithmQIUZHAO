package com.leetcode.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: N叉树的层序遍历
 * @author: 孙彬
 */
public class LevelOrder429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> out = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return out;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            out.add(level);
        }
        return out;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
