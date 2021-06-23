package collections.queue;

import collections.stack.Stack;

public class QueueUsing2Stacks {
    private Stack<Integer> forwardStack = new Stack<>();
    private Stack<Integer> reverseStack = new Stack<>();

    public void enqeue(int data) throws QueueOverFlowException, Stack.StackOverFlowException, Stack.StackUnderFlowException {
        if (isFull()) {
            throw new QueueOverFlowException("Queue is Full");
        }

        if (forwardStack.isEmpty()) {
            if (reverseStack.isEmpty()){
                forwardStack.push(data);
                return;
            }
            else {
                while(reverseStack.isEmpty()){
                    forwardStack.push(reverseStack.pop());
                }
            }
        }

        forwardStack.push(data);
    }

    public int dequeue() throws QueueUnderFlowException, Stack.StackUnderFlowException, Stack.StackOverFlowException {
        if (isEmpty()) {
            throw new QueueUnderFlowException("Queue is empty");
        }

        while(forwardStack.isEmpty()){
            int data = forwardStack.pop();
            reverseStack.push(data);
        }

        return reverseStack.pop();
    }

    private boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    private boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

    public static class QueueOverFlowException extends Exception {
        public QueueOverFlowException(String msg) {
            super(msg);
        }
    }

    public static class QueueUnderFlowException extends Exception {
        public QueueUnderFlowException(String msg) {
            super(msg);
        }
    }


}
