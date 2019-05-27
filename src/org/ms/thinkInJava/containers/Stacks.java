package org.ms.thinkInJava.containers;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 23:47
 */
public class Stacks {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values()){
            stack.push(m.toString());
        }
        System.out.println("stack = " + stack);

        //Treating a stack as a Vector:
        stack.addElement("The last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        System.out.println("popping elements:");
        while (!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        //Using a LinkedList as a Stack:
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values()){
            lstack.addFirst(m.toString());
        }
        System.out.println("lstack = " + lstack);
        while (!lstack.isEmpty()){
            System.out.print(lstack.removeFirst() + " ");
        }
        System.out.println();

        //Using the Stack class from the Holding Your Objects Chapter:
        org.ms.thinkInJava.util.Stack<String> stack2 = new org.ms.thinkInJava.util.Stack<String>();
        for (Month m : Month.values()){
            stack2.push(m.toString());
        }
        System.out.println("stack2 = " + stack2);
        while (!stack2.empty()){
            System.out.print(stack2.pop() + " ");
        }
        System.out.println();

    }

}
