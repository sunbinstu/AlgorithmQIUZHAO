package com.leetcode.homework;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树中序遍历
 * @author: 孙彬
 */
public class InorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            out.add(curr.val);
            curr = curr.right;
        }
        return out;
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
