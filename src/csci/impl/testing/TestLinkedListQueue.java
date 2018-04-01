package csci.impl.testing;

import csci.impl.LinkedListQueue;
import csci.impl.LinkedListStack;
import csci152.adt.Queue;
import csci152.adt.Stack;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        Queue<Integer> q= new LinkedListQueue<>();

        try {
            q.dequeue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i=0;i<8;i++) {
            q.enqueue(i);
        }

        System.out.println(q.toString());
        System.out.println(q.getSize());

        try {
            q.dequeue();
            q.dequeue();
            q.dequeue();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(q.toString());
        System.out.println(q.getSize());


        for (int i=0;i<9;i++) {
            q.enqueue(i);
            q.enqueue(i);
            try {
                q.dequeue();
                q.dequeue();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println(q.toString());
            System.out.println(q.getSize());
        }


        for (int i=0;i<22;i++) {
            q.enqueue(i);
        }

        System.out.println(q.toString());
        System.out.println(q.getSize());


        //////10.2

        Queue<Character> par = new LinkedListQueue<>();
        par.enqueue('{');
        par.enqueue('(');
        par.enqueue(')');
        par.enqueue('}');
        System.out.println(par.toString());
        try {
            System.out.println("Is par balanced? " + isBalanced(par));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(par.toString());
    }

    public static boolean isBalanced(Queue<Character> q) throws Exception {
        Queue<Character> p = new LinkedListQueue<>();
        Stack<Integer> s = new LinkedListStack<>();
        int size=q.getSize();
        boolean ans=true;
        int i=0;
        while(i<size) {
            char c = q.dequeue();
            p.enqueue(c);
            if (c=='(') {
                s.push(1);
            } else
            if (c=='[') {
                s.push(2);
            } else
            if (c=='{') {
                s.push(2);
            } else
            if (c==')') {
                try {
                    int t = s.pop();
                    if (t != 1) {
                        ans = false;
                        System.out.println("1");
                    }
                } catch (Exception e){
                    ans=false;
                }
            } else
            if (c==']') {
                try {
                    int t = s.pop();
                    if (t != 2) {
                        ans = false;
                        System.out.println("2");
                    }
                } catch (Exception e){
                ans=false;
            }
            } else
            if (c=='}') {
                try {
                    int t = s.pop();
                    if (t!=3) {
                        ans=false;
                        System.out.println("3");
                    }
                } catch (Exception e){
                    ans=false;
                }
            } else throw new Exception("Not valid character!");
            i++;
        }
        i=0;
        while(i<size) {
            q.enqueue(p.dequeue());
            i++;
        }
        return ans;
    }
}
