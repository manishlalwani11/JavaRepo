package collections.linkedlist;

public class LinkedListClient {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(11);
        linkedList.insertAtHead(1);

        System.out.println("list :" + linkedList);
        System.out.println("list length :" + linkedList.lengthOfTheLinkedList());
      /*  linkedList.deletingTheHeadNode();
        System.out.println("list after deletingTheHeadNode :" + linkedList);*/
        System.out.println("list after search for an item :" + linkedList.searchForAnItem(1));
    }


}
