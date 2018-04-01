package csci.impl.testing;

import csci.impl.LinkedListStack;
import csci152.adt.Stack;

public class TestLinkedList {
    public static void main(String[] args) {
        Stack<Integer> myStack = new LinkedListStack<>();

        try {
            int takeOut = myStack.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i=0;i<12;i++) {
            myStack.push(i);
        }


        System.out.println(myStack.toString());
        System.out.println(myStack.getSize());
        try {
            int take = myStack.pop();
            take = myStack.pop();
            take = myStack.pop();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(myStack.toString());
        System.out.println(myStack.getSize());

        myStack.clear();

        System.out.println(myStack.toString());
        System.out.println(myStack.getSize());

        for (int i=0;i<22;i++) {
            myStack.push(i);
        }

        System.out.println(myStack.toString());
        System.out.println(myStack.getSize());
    }
}
