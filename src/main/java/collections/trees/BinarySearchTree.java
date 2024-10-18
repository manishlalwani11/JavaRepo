package collections.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Integer data) {
        root = insertData(root, data);
    }

    public Node getNode(Integer data) {
       return searchNode(root, data);
    }

    private Node insertData(Node current, Integer data) {

        if (current == null) {
            return new Node(data);
        }

        if (data != null && data < current.getData()) {
            Node node = insertData(current.getLeftNode(), data);
            if (current.getLeftNode() == null) {
                current.setLeftNode(node);
            }
        } else if (data != null && data > current.getData()) {
            Node node = insertData(current.getRightNode(), data);
            if (current.getRightNode() == null) {
                current.setRightNode(node);
            }
        } else {
            // Data already present in BST
            System.out.println("data already present: " + data);
            return current;
        }

        return current;
    }

    public Node searchNode(Node current, Integer value) {

        if (value == current.getData()) {
            return current;
        }

        if (value < current.getData()) {
            Node node = searchNode(current.getLeftNode(), value);
            return node;
        } else if (value > current.getData()) {
            Node node = searchNode(current.getRightNode(), value);
            return node;
        } else {
            System.out.println("Node not found: " + current.getData());
            return null;
        }

    }

    public Node minimumValue(Node current) {
        Node minimumValueNode = null;

            if (current.getLeftNode() == null) {
                return current;
            } else {
                minimumValueNode = minimumValue(current.getLeftNode());
            }

        return minimumValueNode;
    }


    public int maxDepthofBST(Node current) {
        if (current == null) {
            return 0;
        }

        if(current.getLeftNode() == null && current.getRightNode() == null){
            return 0;
        }

        int maxLeftDepth = 1 + maxDepthofBST(current.getLeftNode());
        int maxRightDepth = 1 + maxDepthofBST(current.getRightNode());

        return Math.max(maxLeftDepth, maxRightDepth);
    }

    public void traverseInOrder(Node node) {

        if (node != null) {
            traverseInOrder(node.getLeftNode());
            System.out.println("value: " + node.getData());
            traverseInOrder(node.getRightNode());

        }
    }

    public void printAllNodesInRange(Node current, int minRange, int maxRange) {

        if (current == null) {
            return;
        }

        printAllNodesInRange(current.getLeftNode(), minRange, maxRange);

        if (current.getData() >= minRange && current.getData() <= maxRange) {
            System.out.println("Nodes with range: " + current);
        }

        printAllNodesInRange(current.getRightNode(), minRange, maxRange);

    }

    public void printAllPaths(Node current) {
        List<String> allPaths = new ArrayList<>();


        allPaths = getPathsToLeafNodes(current, String.valueOf(current.getData()), allPaths);
        System.out.println("All paths: " + allPaths);
        //StringBuilder s = new StringBuilder();
        String s = "";
        PathsToLeafNodes(current, s);

    }

    private List<String> getPathsToLeafNodes(Node node,
                                              String path,
                                              List<String> allPaths) {
        if(node == null){
            return Collections.EMPTY_LIST;
        }

        if (node.getLeftNode() == null && node.getRightNode() == null) {
            allPaths.add(path);
        }

        getPathsToLeafNodes(node.getLeftNode(), "->" + String.valueOf(node.getData()), allPaths);
        getPathsToLeafNodes(node.getRightNode(), "->" + String.valueOf(node.getData()), allPaths);

        return allPaths;
    }

    private void PathsToLeafNodes(Node current, String s) {
        if (current == null) {
            return;
        }

         s = String.join("->", String.valueOf(current.getData()));
        /*if (s.length() != 0) {
            s.append("->").append(current.getData());
        }*/

        if (current.getLeftNode() == null && current.getRightNode() == null){
            // now print since we reached the leaf node
            System.out.println(s.toString());
        }

        PathsToLeafNodes(current.getLeftNode(), s);
        PathsToLeafNodes(current.getRightNode(), s);
    }


}
