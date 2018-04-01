package csci.impl.testing;

import csci.impl.LLQueueSet;
import csci152.adt.Set;

import java.util.Comparator;

public class TestLLQueueSet {
    public static void main(String[] args) {

        Set<Student> student = new LLQueueSet<>();

        try {
            student.removeAny();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        student.add(new Student(3242, "Anya"));
        student.add(new Student(24, "Tanya"));
        student.add(new Student(44324, "Vanya"));
        student.add(new Student(4324, "Banya"));
        student.add(new Student(4324, "Sanya"));
        System.out.println(student.toString() + ", size:" + student.getSize());
        try {
            student.remove(new Student(23432, "Nadya"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(student.toString() + ", size:"+student.getSize());

        student.add(new Student(527, "de"));
        student.add(new Student(305, "me"));
        System.out.println(student.toString() +", size:"+student.getSize());

        student.add(new Student(111, "first"));
        student.add(new Student(222, "second"));
        student.add(new Student(202, "third"));
        System.out.println(student.toString()+", size:"+student.getSize());

        try {
            System.out.println("removed: "+ student.removeAny());
            System.out.println("removed: "+ student.removeAny());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(student.toString()+", size:"+student.getSize());

        student.clear();
        System.out.println(student.toString()+", size:"+student.getSize());

        student.add(new Student(222, "deagain"));
        student.add(new Student(202, "meagain"));
        System.out.println(student.toString() +", size:"+student.getSize());





    }
}
