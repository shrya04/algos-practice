package com.algo.practice;

import java.util.Arrays;

public class BuildTree {


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


        public static void main(String[] args) {
            TreeNode node = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        }

        private static TreeNode buildTree(int[] preorder, int[] inorder) {

            return buildTree(preorder, inorder, 0);
            
        }

        private static TreeNode buildTree(int[] preorder, int[] inorder, int idx) {
            if(inorder.length<=0){
                return null;
            }
            int root = preorder[idx];
            int mid = -1;



            for(int i=0;i<inorder.length;i++){
                if(inorder[i]==root){
                    mid = i;
                    break;
                }
            }

            int[] inorderLeft = Arrays.copyOfRange(inorder, 0, mid);
            int[] inorderRight = Arrays.copyOfRange(inorder, mid+1, inorder.length);

            int preOrderLeftIdx = -1;
            for(int i =0;i< preorder.length;i++){
                for (int k : inorderLeft) {
                    if (preorder[i] == k) {
                        preOrderLeftIdx = i;
                        break;
                    }
                }
                if(preOrderLeftIdx!=-1){
                    break;
                }
            }

            int preOrderRightIdx = -1;
            for(int i =0;i< preorder.length;i++) {
                for (int k : inorderRight) {
                    if (preorder[i] == k) {
                        preOrderRightIdx = i;
                        break;
                    }
                }
                if(preOrderRightIdx !=-1){
                    break;
                }
            }


            TreeNode node = new TreeNode(root);
            node.left = buildTree(preorder, inorderLeft, preOrderLeftIdx);
            node.right = buildTree(preorder, inorderRight, preOrderRightIdx);
            return node;
        }
    }
    }
