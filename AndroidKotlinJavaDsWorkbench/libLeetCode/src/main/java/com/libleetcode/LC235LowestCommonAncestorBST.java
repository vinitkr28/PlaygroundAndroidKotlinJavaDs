package com.libleetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC235LowestCommonAncestorBST {

    static protected class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static protected class BSTConstruction {

        public static TreeNode constructBST(Integer[] root) {
            if (root.length == 0) {
                return null;
            }

            TreeNode rootNode = new TreeNode(root[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(rootNode);

            int i = 1;
            while (i < root.length) {
                TreeNode current = queue.poll();
                if (current != null) {
                    if (i < root.length && root[i] != null) {
                        current.left = new TreeNode(root[i]);
                        queue.offer(current.left);
                    }
                    i++;

                    if (i < root.length && root[i] != null) {
                        current.right = new TreeNode(root[i]);
                        queue.offer(current.right);
                    }
                    i++;
                }
            }

            return rootNode;
        }
    }

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        TreeNode parent = null;

        List<TreeNode> firstPath = new LinkedList<>();
        List<TreeNode> secondPath = new LinkedList<>();

        getPathToNode(root, p, firstPath);
        getPathToNode(root, q, secondPath);

        int smallListSize = Math.abs(firstPath.size() - secondPath.size());

        for (int i = 0; i < smallListSize; i++) {
            if (firstPath.get(i) == secondPath.get(i)) {
                parent = firstPath.get(i);
                break;
            }
        }

        return parent;
    }

    public static void getPathToNode(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root.val > p.val) {
            if (root.left == null) {
                path = new LinkedList<>();
                return;
            } else {
                path.add(root);
                getPathToNode(root.left, p, path);
            }
        } else if (root.val < p.val) {
            if (root.right == null) {
                path = new LinkedList<>();
                return;
            } else {
                path.add(root);
                getPathToNode(root.right, p, path);
            }

        } else {
            path.add(root);
            return;
        }

    }


    // Example usage:
    public static void main(String[] args) {
        Integer[] input = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};

        TreeNode rootNode = BSTConstruction.constructBST(input);

        TreeNode p = lowestCommonAncestor(rootNode, new TreeNode(2), new TreeNode(8));

        if (p != null) {
            System.out.println(">>>>\t" + p.val);
        } else System.out.println(">>>> p is null");
    }
}
