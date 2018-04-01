package csci.impl;

import csci152.adt.IntQueue;
import csci152.adt.IntStack;
import csci152.adt.Queue;
import csci152.adt.Stack;

public class Eight {

    public static void main(String args[]) {

        Stack<Integer> s1 = new ArrayStack();
        Stack<Integer> s2 = new ArrayStack();

        Queue<Integer> q1 = new ArrayQueue();
        Queue<Integer> q2 = new ArrayQueue();

        for (int i=0;i<12;i++) {
            s1.push(i);
            q1.enqueue(i);
            q2.enqueue(i);
        }
        for (int i=11;i>-1;i--) {
            q2.enqueue(i);
            s2.push((15-i));
        }

        System.out.println("s1: "+ s1);
        System.out.println("s2: "+s2);
        System.out.println("q1: "+q1);
        System.out.println("q2: "+q2);


        System.out.println("How many even numbers are in s1? " + evenCount(s1));

        System.out.println("The copy of s1 is: " + copyStack(s1).toString());

        System.out.println("Is q1 palindrome? " + IsPalindrome(q1));
        System.out.println("Is q2 palindrome? " + IsPalindrome(q2));

        System.out.println("Stack merged from s1 and s2 is: " + merge(s1,s2) + ". Now, s1 and s2 are empty!");
    }

    public static int evenCount(Stack<Integer> stk) {
        IntStack temp = new ArrayIntStack();
        int cnt=0;
        int size = stk.getSize();
        for (int i=0;i<size;i++) {
            try {
                int a=stk.pop();
                if (a%2==0) cnt++;
                temp.push(a);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (int i=0;i<size;i++) {
            try {
                int a=temp.pop();
                stk.push(a);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return cnt;
    }

    public static IntStack copyStack(Stack<Integer> orig) {
        IntStack temp = new ArrayIntStack();
        IntStack res = new ArrayIntStack();
        int size = orig.getSize();
        for (int i=0;i<size;i++) {
            try {
                int a=orig.pop();
                temp.push(a);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (int i=0;i<size;i++) {
            try {
                int a=temp.pop();
                res.push(a);
                orig.push(a);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return res;
    }

    public static boolean IsPalindrome(Queue<Integer> q) {
        IntStack s = new ArrayIntStack();
        IntQueue temp = new ArrayIntQueue();
        IntQueue res = new ArrayIntQueue();
        int size = q.getSize();
        for (int i=0;i<size;i++) {
            try{
                int a = q.dequeue();
                s.push(a);
                temp.enqueue(a);
                res.enqueue(a);
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + " error1");
            }
        }
        //System.out.println("res is: " + res);
        for (int i=0;i<size;i++) {
            try{
                int a = res.dequeue();
                q.enqueue(a);
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + " error2");
            }
        }
        for (int i=0;i<size;i++) {
            try {
                int a = s.pop();
                int b = temp.dequeue();
                if (a!=b) return false;
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + " error3");
            }
        }
        return true;
    }

    public static IntStack merge(Stack<Integer> s1, Stack<Integer> s2) {
        IntStack temp = new ArrayIntStack();
        IntStack res = new ArrayIntStack();
        while ((s1.getSize() + s2.getSize()) > 0) {
            try {
                if (s1.getSize()==0) {
                    temp.push(s2.pop());
                    continue;
                }
                if (s2.getSize()==0) {
                    temp.push(s1.pop());
                    continue;
                }
                int a = s1.pop();
                int b = s2.pop();
                if (a > b) {
                    temp.push(a);
                    s2.push(b);
                } else {
                    temp.push(b);
                    s1.push(a);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        int size = temp.getSize();
        for (int i = 0; i < size; i++) {
            try {
                res.push(temp.pop());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return res;
    }
}
