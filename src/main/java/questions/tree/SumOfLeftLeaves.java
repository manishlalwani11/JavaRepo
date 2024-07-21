package questions.tree;


/*

Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0
 */

import collections.trees.Node;


// TODO NOTE ---> Its a BINARY TREE QUESTION !!!!  (NOT BINARY SEARCH TREE)

/*
The Binary Tree allows duplicate node values.  AND 	The Binary Search Tree does not allow any duplicate node values.

A Binary Tree can have 0,1 or 2 nodes..... The BST or Binary Search Tree is also a Binary Tree (same behaviour)

 */
public class SumOfLeftLeaves {
    public int sum = 0;
    public static void main(String[] args) {
        TreeNode node = new TreeNode();

        // [3,9,20,null,null,15,7]

        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();

        int resultSum = sumOfLeftLeaves.getSumOfLeafNodes(node);

    }

    private int getSumOfLeafNodes(TreeNode root
    ) {

        if (root == null) {
            return 0;
        }
        getSum(root);

        return sum;
    }

    private void getSum(TreeNode node) {

        if(node == null) {
            return;
        }

        if (node.left != null) {
            if (isLeftLeafNode(node.left)) {
                sum += node.left.val;
            }
        }

        getSum(node.left);
        getSum(node.right);

    }

    private boolean isLeftLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }


}


