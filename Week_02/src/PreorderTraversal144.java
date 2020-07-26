package com.leetcode.homework;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树前序遍历
 * @author: 孙彬
 */
public class PreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return out;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            out.add(node.val);
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);
        }
        return out;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
