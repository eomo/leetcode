package com.hicsc.tree;

import java.util.LinkedList;
import java.util.Objects;

/**
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree104 {

    /**
     * Get the maximum depth of the binary tree by recursion
     *
     * @param root the root node of the binary tree
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Get the maximum depth of the binary tree by BFS
     *
     * @param root the root node of the binary tree
     * @return
     */
    public static int maxDepthByBFS(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node.left)) {
                    queue.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.addLast(node.right);
                }
            }
            maxLevel++;
        }
        return maxLevel;
    }


    public static void maxDepthTest() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node5.right = node9;

        System.out.println(maxDepth(node1));
        System.out.println(maxDepthByBFS(node1));
    }
}
