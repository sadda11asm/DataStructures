package csci.impl.testing;

import csci.impl.LinkedListSortedQueue;
import csci152.adt.SortedQueue;

public class TestStudentSortingClass {
    public static void main(String[] args) {
        SortedQueue<Student> q = new LinkedListSortedQueue<>();
        for (int i=90;i>=0;i-=10) {
            Student pupil = new Student(i, "Bob # " + (100-i));
            q.insert(pupil);
        }
        System.out.println(q.toString());
        System.out.println(q.getSize());
    }


}
