package csci.impl.testing;

import csci.impl.LLQHashTableSet;
import csci152.adt.HashTableSet;
import csci152.adt.Set;

public class TestLLQHashTableSet {
    public static void main(String[] args) {
        HashTableSet<Integer> numbers = new LLQHashTableSet<>(10);
        try {
            numbers.removeAny();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        for (int i=1;i<=20;i++) {
            numbers.add(i);
        }
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        for (int i=1;i<=20;i++) {
            if (i%2==0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        System.out.println(numbers.remove(10));
        System.out.println(numbers.remove(100));
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        for (int i=1;i<=30;i++) {
            numbers.add(i);
        }
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        for (int i=0;i<10;i++) {
            try {
                numbers.removeAny();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        numbers.clear();
        System.out.println(numbers.toString() + "size: " + numbers.getSize());
        for (int i=50;i<=80;i++) {
            if (i%2==1) {
                numbers.add(i);
            }
        }
        System.out.println(numbers.toString() + "size: " + numbers.getSize());

    }
}
