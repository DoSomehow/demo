package org.ms.thinkInJava.holding;

import org.ms.thinkInJava.util.Stack;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 23:58
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "My dog has fleas".split(" ")){
            stack.push(s);
        }
        while (!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }

}
