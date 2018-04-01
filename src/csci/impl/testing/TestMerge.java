package csci.impl.testing;

import csci.impl.LinkedListDeque;
import csci152.adt.Deque;

public class TestMerge {
    public static void main(String[] args) {
        Deque<Integer> d1 = new LinkedListDeque<>();
        Deque<Integer> d2 = new LinkedListDeque<>();
        d1.pushToFront(2);
        d1.pushToFront(8);
        d1.pushToFront(3);
        d1.pushToFront(4);
        d1.pushToFront(18);
        d1.pushToFront(1);
        d1.pushToFront(4);
        d1.pushToFront(3);

        System.out.println(mergeSort(d1));
    }

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
        Deque result = new LinkedListDeque();
        int l1 = d1.getSize();
        int l2 = d2.getSize();
        int l = l1 + l2;
        for (int i = 0; i < l; i++) {
            int c1 = 100000, c2 = 100000;
            if (d1.getSize() > 0) {
                try {
                    c1 = d1.popFromFront();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (d2.getSize() > 0) {
                try {
                    c2 = d2.popFromFront();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //int n1=0,n2=0;
            if (c1 >= c2) {
                result.pushToBack(c2);
                d1.pushToFront(c1);
            } else {
                result.pushToBack(c1);
                d2.pushToFront(c2);
            }

        }
        return result;
    }

    public static Deque<Integer> mergeSort(Deque<Integer> q) {
        if (q.getSize()==0) {
            return q;
        }
        if (q.getSize()==1) {
            return q;
        }

        Deque<Integer> q1 = new LinkedListDeque<>();
        Deque<Integer> q2 = new LinkedListDeque<>();
        int size = q.getSize();
        for (int i=0;i<size/2;i++) {
            try {
                q1.pushToBack(q.popFromFront());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i=size/2;i<size;i++) {
            try {
                q2.pushToBack(q.popFromFront());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        q1 = mergeSort(q1);
        //System.out.println(q1);
        q2 = mergeSort(q2);
        //System.out.println(q2);
        return merge(q1, q2);
    }
}
