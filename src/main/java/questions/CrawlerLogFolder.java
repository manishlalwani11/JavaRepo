package questions;

import collections.stack.Stack;

/**
 * https://leetcode.com/problems/crawler-log-folder/description/
 * <p>
 * The Leetcode file system keeps a log each time some user performs a change folder operation.
 * <p>
 * The operations are described below:
 * <p>
 * "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
 * "./" : Remain in the same folder.
 * "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 * <p>
 * The file system starts in the main folder, then the operations in logs are performed.
 * <p>
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 */

public class CrawlerLogFolder {

    public static void main(String[] args) throws Stack.StackUnderFlowException, Stack.StackOverFlowException {

        String[] logs = new String[]{"./", "../", "./"};

        int minOperations = getMinOperations(logs);

        System.out.println("min Ops: " + minOperations);

    }

    private static int getMinOperations(String[] logs) throws Stack.StackUnderFlowException, Stack.StackOverFlowException {
        java.util.Stack<String> stack = new java.util.Stack<>();
        for (String s : logs) {

            if (s.trim().equalsIgnoreCase("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.trim().equalsIgnoreCase("./")) {
                continue;
            } else {
                stack.push(s);
            }
        }

        return stack.size();
    }
}
