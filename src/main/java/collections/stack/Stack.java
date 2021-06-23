package collections.stack;

public class Stack<T> {

    private Element<T> top;
    private static final int STACK_MAX_SIZE = 40;
    private int size = 0;

    public void push(T data) throws StackOverFlowException {
        if (size == STACK_MAX_SIZE) {
            throw new StackOverFlowException("max size reached");
        }

        Element<T> element = new Element<T>(data, top);
        element.setNextElement(top);
        top = element;
        size++;
    }

    public T pop() throws StackUnderFlowException {
        if (size == 0) {
            throw new StackUnderFlowException("no elements in the stack");
        }

        T data = top.getData();
        top = top.getNextElement();
        size--;
        return data;
    }

    public T peek() throws StackUnderFlowException {
        if (size == 0) {
            throw new StackUnderFlowException("no elements in the stack");
        }

        return top.getData();
    }

    public boolean isFull() {
        return size == STACK_MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static class StackOverFlowException extends Exception {
        public StackOverFlowException(String message) {
            super(message);
        }
    }

    public static class StackUnderFlowException extends Exception {
        public StackUnderFlowException(String message) {
            super(message);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("{ ");
        Element<T> currentElement = top;
        int stackSize = size;

        while (stackSize != 0) {
            ret.append(currentElement.toString()).append(" ,");
            currentElement = currentElement.getNextElement();
            stackSize--;
        }

        return ret + " }";
    }
}
