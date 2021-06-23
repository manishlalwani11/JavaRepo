package collections.stack;

public class StackClient {

    public static void main(String[] args) throws Stack.StackOverFlowException, Stack.StackUnderFlowException {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(11);
        stack.push(1);

        System.out.println("stack is: " + stack);

        stack.pop();

        System.out.println("stack after pop : " + stack);

        System.out.println("stack size : " + stack.getSize());

        System.out.println("stack is Full? : " + stack.isFull());

        System.out.println("stack is Empty? : " + stack.isEmpty());
    }
}
