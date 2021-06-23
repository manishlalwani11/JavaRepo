package collections.queue;

import collections.stack.Stack;

public class QueueClient {
    public static void main(String[] args) throws QueueUsing2Stacks.QueueOverFlowException, Stack.StackOverFlowException, Stack.StackUnderFlowException, QueueUsing2Stacks.QueueUnderFlowException {

        QueueUsing2Stacks queue = new QueueUsing2Stacks();
        queue.enqeue(2);
        queue.enqeue(5);

        System.out.println("Dequeue data: " + queue.dequeue());
    }
}
