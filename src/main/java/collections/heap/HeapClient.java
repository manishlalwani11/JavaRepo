package collections.heap;

public class HeapClient {

    public static void main(String[] args) throws Exception {
        MinimumHeap<Integer> minHeap = new MinimumHeap<>(Integer.class);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(10);

       // minHeap.printHeap();

        System.out.println("Priority min value: " + minHeap.remove());

        /** Custom object Person in Heap */

        MinimumHeap<Person> minimumHeap = new MinimumHeap<>(Person.class);
        minimumHeap.insert(new Person("Mike", 11));
        minimumHeap.insert(new Person("Andrew", 34));
        minimumHeap.insert(new Person("Brian", 55));
        minimumHeap.insert(new Person("Jay", 20));

        minimumHeap.printHeap();

        System.out.println("Priority min value in Person HEAP: " + minimumHeap.remove());

    }




}
