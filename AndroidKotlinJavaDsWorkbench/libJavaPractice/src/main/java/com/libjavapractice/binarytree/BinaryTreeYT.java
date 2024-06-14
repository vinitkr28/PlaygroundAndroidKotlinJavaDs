package com.libjavapractice.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeYT {
    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    static class BinaryTree {


        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //Time complexity : O(n)
        public static void preorder(Node root) {
            if (root == null) return;

            System.out.print(root.data + "\t");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + "\t");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + "\t");
        }

        private static void levelOrder(Node root) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currentNode = q.remove();
                if (currentNode == null) {
                    if (q.isEmpty()) break;
                    System.out.println();
                    q.add(null);
                } else {
                    System.out.print(currentNode.data + "	");
                    if (currentNode.left != null) q.add(currentNode.left);
                    if (currentNode.right != null) q.add(currentNode.right);
                }
            }
        }

        public static void main(String[] args) {
            int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        BinaryTree tree = new BinaryTree();
//        Node root = BinaryTree.buildTree(nodes);

//        System.out.println("Insertion: Root >> " + (root != null ? root.data : -1));

//        BinaryTree.preorder(BinaryTree.buildTree(nodes));
//        BinaryTree.inorder(BinaryTree.buildTree(nodes));
//            BinaryTree.postorder(BinaryTree.buildTree(nodes));
            BinaryTree.levelOrder(BinaryTree.buildTree(nodes));
        }
    }
}
