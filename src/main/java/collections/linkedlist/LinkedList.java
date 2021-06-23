package collections.linkedlist;

public class LinkedList {
    Node head;

    // inserting a new node at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    // length of the linked list
    public int lengthOfTheLinkedList() {
        Node currentNode = this.head;
        int length = 0;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNextNode();
        }

        return length;
    }

    // deleting head Node
    public void deletingTheHeadNode(){
        this.head = this.head.getNextNode();
    }

    // search For An Item in list
    public Node searchForAnItem(int data){
        Node currentNode = this.head;

        while (currentNode != null){

            if(currentNode.getData() == data){
                return currentNode;
            }

            currentNode = currentNode.getNextNode();

        }
        return null;
    }

    @Override
    public String toString() {
        String result = "{";

        Node currentNode = this.head;
        while (currentNode != null) {
            result = result + currentNode.toString() + " , ";
            currentNode = currentNode.getNextNode();
        }

        result = result + "}";
        return result;
    }
}
