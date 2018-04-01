package csci.impl.testing;

import csci.impl.LLQueueSet;
import csci.impl.LLStackSet;
import csci152.adt.Set;
import csci152.adt.Stack;

public class TestLLStackSet {
    public static void main(String[] args) {

        Set<Student> student = new LLStackSet();

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

    public static class Student implements Comparable<Student>{
        private int ID;
        private String name;

        public Student(int id, String n) {
            ID = id;
            name = n;
        }

        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            String s = "Name: " + name + ", ID " + ID + ";";
            return s;
        }

        public boolean equals(Object o) {
            if (o instanceof Student) {
                Student obj = (Student) o;
                return obj.getID()==ID && obj.getName().equals(name);
            }
            return false;
        }

        @Override
        public int compareTo(Student o) {
//            if (ID<o.getID()) return -1;
//            if (ID==o.getID()) return 0;
//            return 1;
            if (name.compareTo(o.getName())<0) return -1;
            if (name==o.getName()) return 0;
            return 1;
        }


    }
}
