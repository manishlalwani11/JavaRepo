package questions.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-preorder-traversal/description/
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) {
            return list;
        }

        list.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }
}
