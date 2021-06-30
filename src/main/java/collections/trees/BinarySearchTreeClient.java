package collections.trees;

import java.util.HashSet;

public class BinarySearchTreeClient {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // Our BST handles -ve integers too

        bst.add(5);
        bst.add(4);
        bst.add(10);
        bst.add(-22);
        bst.add(7);
        bst.add(1);
        bst.add(-11);

        System.out.println("root node: " + bst.getRoot());

        Node searchedNode = bst.getNode(5);
        System.out.println("value of searchedNode: " + searchedNode);

        boolean res = BSTquestions.checkValues(bst.getRoot(), 12, new HashSet<Integer>());
        System.out.println("result: " + res);

        bst.traverseInOrder(bst.getRoot());

        // Our BST handles -ve integers too
        Node minimunValueInBST = bst.minimumValue(bst.getRoot());
        System.out.println("minimunValueInBST: " + minimunValueInBST);

        int maxDepth = bst.maxDepthofBST(bst.getRoot());
        System.out.println("maxDepth of this BST: " + maxDepth);

        bst.printAllNodesInRange(bst.getRoot(), 3, 7);
    }
}
