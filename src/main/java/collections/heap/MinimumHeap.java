package collections.heap;

public class MinimumHeap<T extends Comparable> extends Heap<T> {

    public MinimumHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinimumHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    /**
     * @param index :  Index which has to be shifted DOWN_WARDS at the
     *              right position
     * @throws Exception
     */
    @Override
    public void siftDown(int index) throws Exception {

        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if (leftChildIndex != -1 && rightChildIndex != -1) {
            smallerIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) < 0 ? leftChildIndex : rightChildIndex;
        } else if (leftChildIndex != -1) {
            smallerIndex = leftChildIndex;
        } else if (rightChildIndex != -1) {
            smallerIndex = rightChildIndex;
        }

        if (smallerIndex == -1) {
            return;
        }

        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }

    }

    /**
     * @param index :  Index which has to be shifted UPWARDS at the
     *              right position
     * @throws Exception
     */
    @Override
    public void siftUp(int index) throws Exception {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 && getElementAtIndex(parentIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }


}
