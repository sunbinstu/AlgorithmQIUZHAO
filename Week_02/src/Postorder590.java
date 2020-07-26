package com.leetcode.homework;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:  N叉树的后序遍历
 * @author: 孙彬
 */
public class Postorder590 {
    //递归后序
    public List<Integer> postorder0(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(Node root, List < Integer > res) {
        if (root != null) {
            List<Node> child = root.children;
            for (Node n : child) {
                if (n != null)
                    helper(n,res);
            }
            res.add(root.val);
        }
    }


    //循环
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> out = new LinkedList<>();
        LinkedList<Node> dqu = new LinkedList<>();
        if (root == null) return out;
        dqu.add(root);
        while (!dqu.isEmpty()) {
            Node node =  dqu.pollLast();
            out.addFirst(node.val);
            List<Node> child = node.children;
            if (child != null) {
                for (Node n : child) {
                    dqu.add(n);
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
