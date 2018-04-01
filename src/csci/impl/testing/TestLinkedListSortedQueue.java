package csci.impl.testing;

import csci.impl.LinkedListSortedQueue;
import csci152.adt.SortedQueue;

public class TestLinkedListSortedQueue {
    public static void main(String[] args) {
        SortedQueue<Integer> q= new LinkedListSortedQueue<>();

        for (int i=90;i>=10;i-=10) {
            q.insert(i);
        }
        System.out.println(q.toString());
        System.out.println(q.getSize());

        try{
            int t = q.dequeue();
            t = q.dequeue();
            t = q.dequeue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(q.toString());
        System.out.println(q.getSize());

        for (int i=100;i<1000;i+=100) {
            q.insert(i);
        }

        System.out.println(q.toString());
        System.out.println(q.getSize());

        try{
            int t = q.dequeue();
            t = q.dequeue();
            t = q.dequeue();
            t = q.dequeue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(q.toString());
        System.out.println(q.getSize());

        for(int i=5;i<=915;i+=10) {
            q.insert(i);
        }
        System.out.println(q.toString());
        System.out.println(q.getSize());

        while(q.getSize()!=0) {
            try {
                int t = q.dequeue();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(q.toString());
        System.out.println(q.getSize());

        q.insert(40);
        q.insert(33);
        q.insert(23);
        System.out.println(q.toString());
        System.out.println(q.getSize());

        q.clear();
        System.out.println(q.toString());
        System.out.println(q.getSize());

        q.insert(40);
        q.insert(33);
        q.insert(23);
        q.insert(34);
        System.out.println(q.toString());
        System.out.println(q.getSize());
    }

}
