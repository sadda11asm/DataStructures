package csci.impl.testing;

import csci.impl.BST2Set;
import csci.impl.BSTSet;
import csci152.adt.Set;

public class TestBST2Set {
    public static void main(String[] args){

        Set<Integer> numbers = new BST2Set<>();
        numbers.add(5);
        numbers.add(12);
        numbers.add(3);
        numbers.add(6);
        numbers.add(14);
        numbers.add(2);
        numbers.add(-6);
        numbers.add(8);
        numbers.add(0);

        System.out.println(numbers +" size:"+ numbers.getSize());
        System.out.println(numbers.remove(14) + "\n" + numbers);
        System.out.println(numbers.remove(6) + "\n" + numbers);
        System.out.println(numbers.remove(-6) + "\n" + numbers);
        System.out.println(numbers.remove(-5) + "\n" + numbers);

        try {
            System.out.println("Removed any: "+ numbers.removeAny());
            System.out.println("After removeAny:" + numbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        numbers.add(5);
        System.out.println(numbers +" size:"+ numbers.getSize());




        System.out.println(numbers +" size:"+ numbers.getSize());
        System.out.println("Does set contain " + 12 + "? " + numbers.contains(12));
        System.out.println("Does set contain " + 7 + "? " + numbers.contains(7));
        System.out.println("Does set contain " + 2 + "? " + numbers.contains(2));
        System.out.println("Does set contain " + (-8) + "? " + numbers.contains(-8));
        System.out.println("Does set contain " + 5 + "? " + numbers.contains(5));
        System.out.println(numbers +" size:"+ numbers.getSize());
        numbers.clear();
        System.out.println(numbers +" size:"+ numbers.getSize());
        numbers.add(55);
        numbers.add(24);
        numbers.add(78);
        numbers.add(51);
        numbers.add(51);
        System.out.println(numbers +" size:"+ numbers.getSize());


        Set<Student> student = new BSTSet<>();


//        student.add(new Student(3242, "Anya"));
//        student.add(new Student(24, "Tanya"));
//        student.add(new Student(44324, "Vanya"));
//        student.add(new Student(4324, "Banya"));
//        student.add(new Student(4324, "Sanya"));
//        System.out.println(student.toString() + ", size:" + student.getSize());
//
//        student.add(new Student(527, "de"));
//        student.add(new Student(305, "me"));
//        System.out.println(student.toString() +", size:"+student.getSize());
//
//        student.clear();
//        student.add(new Student(111, "first"));
//        student.add(new Student(222, "second"));
//        student.add(new Student(202, "third"));
//        System.out.println(student.toString()+", size:"+student.getSize());
//
//        student.clear();
//
//        System.out.println(student.toString()+", size:"+student.getSize());
//
//        student.add(new Student(222, "de_again"));
//        student.add(new Student(202, "me_again"));
//        System.out.println(student.toString() +", size:"+student.getSize());

    }
}
