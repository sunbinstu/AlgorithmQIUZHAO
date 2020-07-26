package com.leetcode.homework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: N叉树的前序遍历
 * @author: 孙彬
 */
public class Preorder589 {

    public List<Integer> preorder(Node root) {
        List<Integer> out = new LinkedList<>();
        LinkedList<Node> dque = new LinkedList<>();
        if (root == null) return out;
        dque.add(root);
        while (!dque.isEmpty()) {
            Node node = dque.pollLast();
            out.add(node.val);
            List<Node> child = node.children;
            if (child != null) {
                Collections.reverse(child);
                for (Node n : node.children) {
                    dque.add(n);
                }
            }
        }
        return out;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
