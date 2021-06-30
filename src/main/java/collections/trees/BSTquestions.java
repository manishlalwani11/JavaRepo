package collections.trees;

import java.util.HashSet;
import java.util.Set;

public class BSTquestions {

    public static void main(String[] args) {


        BinarySearchTree bst = new BinarySearchTree();

        bst.add(2);
        bst.add(null);
        bst.add(3);
        //bst.add(2);
        System.out.println("root node: " + bst.getRoot());

        boolean res = BSTquestions.checkValues(bst.getRoot(), 6, new HashSet<>());
        System.out.println("result: " + res);

    }


    /*
     Given the root of a Binary Search Tree and a target number k, return true if there exist
     two elements in the BST such that their sum is equal to the given target.
     */
    private static boolean findTarget(Node root, int targetValue) {

        Set<Integer> set = new HashSet<>();

        if (root == null) {
            System.out.println("root node is null");
            return false;
        }

        return false;
    }

    public static boolean checkValues(Node current, int targetValue, Set<Integer> set) {
        int sumValue1 = 0;
        boolean leftSideCheck = false;
        boolean rightSideCheck = false;

        if(current == null) return false;

        sumValue1 = targetValue - current.getData();


        if (set.contains(sumValue1)) {
            return true;
        } else {
            set.add(current.getData());
        }

        leftSideCheck = checkValues(current.getLeftNode(), targetValue, set);
        rightSideCheck = checkValues(current.getRightNode(), targetValue, set);
        System.out.println("leftSideCheck: " + leftSideCheck);
        System.out.println("rightSideCheck: " + rightSideCheck);

        return leftSideCheck || rightSideCheck;
    }
}
