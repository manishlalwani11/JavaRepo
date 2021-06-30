package collections.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable> {

    private static int MAX_SIZE = 40;
    private T[] array;
    private int count;

    public Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);

    }

    public abstract void siftDown(int index) throws Exception;

    public abstract void siftUp(int index) throws Exception;

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;

        if (leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;

        if (rightChildIndex >= count) {
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > count) {
            return -1;
        }
        return (index - 1) / 2;
    }

    public T getElementAtIndex(int index) throws Exception {
        if (index < 0 || index > count) {
            throw new Exception("Index is not valid" + index);
        }

        return array[index];
    }

    public void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }


    /**
     *
     * @param data: Value to be inserted in the Heap.
     *            Firstly is added at the end, then
     *            is shifted upwards.
     * @throws Exception
     */
    public void insert(T data) throws Exception {
        if (count >= array.length) {
            throw new Exception("Heap is already full");
        }

        array[count] = data;
        siftUp(count);

        count++;
    }

    /**
     * Priority element is removed and the last element is brough to the root place
     * and called shift downwards to follow HEAP constraints.
     * @return
     * @throws Exception
     */
    public T remove() throws Exception {
        T priorityElement = getElementAtIndex(0);

        array[0] = array[count - 1];
        count--;
        siftDown(0);

        return priorityElement;

    }

    public void printHeap() {
        for (T arrElement : array) {
            System.out.println("values:" + arrElement);
        }
    }



}
