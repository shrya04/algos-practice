package com.algo.practice;

public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        node.right = new TreeNode(6, new TreeNode(4), new TreeNode(7));
        TreeNode newTree = deleteNode(node, 3);
        TreeNode a = newTree;

    }

    private static TreeNode deleteNode(TreeNode node, int k) {
        if (node == null) return null;
        else if (node.val == k && node.left == null && node.right == null) return null;
        TreeNode newNode;

        if(k<node.val){
            newNode = new TreeNode(node.val);
            newNode.left = deleteNode(node.left, k);
            newNode.right = node.right;
        } else if (k>node.val){
            newNode = new TreeNode(node.val);
            newNode.left = node.left;
            newNode.right = deleteNode(node.left, k);
        } else {
            TreeNode currleft = node.left;

            TreeNode rightSubtree = node.right;
            newNode = new TreeNode(currleft.val);
            newNode.left = currleft.left;

            attachTreeNode(node.right, rightSubtree);

        }
        return newNode;
    }

    private static void attachTreeNode(TreeNode node, TreeNode rightSubtree) {
        if(node!=null){
            if(node.left==null){
                node.left = rightSubtree;
            }
            attachTreeNode(node.left, rightSubtree);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
