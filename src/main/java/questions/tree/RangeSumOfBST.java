package questions.tree;

import collections.trees.BinarySearchTree;
import collections.trees.Node;

/*
https://leetcode.com/problems/range-sum-of-bst/description/
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

 */
public class RangeSumOfBST {

    int leftSum = 0;
    int rightSum =0;
    int sum =0;
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        //Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(13);
        bst.add(18);
        bst.add(1);
        //bst.add(null);
        bst.add(6);

        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();

        int rangeSum = rangeSumOfBST.getRangeSumBST(bst.getRoot(), 6, 10);
        System.out.println("rangeSumBST:" + rangeSum);

    }

    private int getRangeSumBST(Node node,
                                      int low,
                                      int high) {

        if (node == null) {
            return 0;
        }

        if (node.getData() >= low && node.getData() <= high) {
            sum += node.getData();
        }

        getRangeSumBST(node.getLeftNode(), low, high);
        getRangeSumBST(node.getRightNode(), low, high);

        return sum;
    }

    private static int traverse(Node node,
                                int low,
                                int high) {

        if (node == null) {
            return 0;
        }

        if (node.getData() >= low && node.getData() <= high) {
            return node.getData();
        }
        return 0;
    }
}
