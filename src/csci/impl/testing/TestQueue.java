package csci.impl.testing;

import csci.impl.ArrayQueue;
import csci152.adt.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q= new ArrayQueue();

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
    }
}
