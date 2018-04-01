package csci.impl.testing;

import csci.impl.BSTHashTableSet;
import csci.impl.LLQHashTableSet;
import csci152.adt.HashTableSet;
import csci152.adt.HashTableStats;

import java.util.Random;

public class TestHashCode {
    public static void main (String[] args) {


//        lesson19TestLLQ(10);
//        lesson19TestLLQ(100);
//        lesson19TestBST(10);
//        lesson19TestBST(100);


//        lesson20TestLLQ(10);
//        lesson20TestLLQ(100);
//        lesson20TestLLQ(5000);
//        lesson20TestBST(10);
//        lesson20TestBST(100);
        lesson20TestBST(5000);
    }

    public static void lesson19TestBST(int k) {
        HashTableSet<Student> set = new BSTHashTableSet<>(k);
        for (int i=0;i<200;i++) {
            set.add(new Student(100+i, "Bob"));
        }
//        System.out.println(set.toString());
        System.out.println("LoadFactor: " + set.getLoadFactor());
        System.out.println("Stdev: " + set.getBucketSizeStandardDev());
//        System.out.println(set.getSize());
    }

    public static void lesson19TestLLQ(int k) {
        HashTableSet<Student> set = new LLQHashTableSet<>(k);
        for (int i=0;i<200;i++) {
            set.add(new Student(100+i, "Bob"));
        }
//        System.out.println(set.toString());
        System.out.println("LoadFactor: " + set.getLoadFactor());
        System.out.println("Stdev: " + set.getBucketSizeStandardDev());
//        System.out.println(set.getSize());
    }

    public static void lesson20TestLLQ(int k) {
        Random random = new Random();

        HashTableSet<Integer> set = new LLQHashTableSet<>(k);
        long time1, time2, duration;
        System.out.println("Starting timing tests...");
        time1 = System.currentTimeMillis();

//        for (int i=0;i<50000;i++) {
//            set.add(i);
//        }
        for (int i=0;i<50000;i++) {
            set.add(random.nextInt());
        }

        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
//        System.out.println(set.toString());
        System.out.println("LoadFactor: " + set.getLoadFactor());
        System.out.println("Stdev: " + set.getBucketSizeStandardDev());
//        System.out.println(set.getSize());
    }

    public static void lesson20TestBST(int k) {
        Random random = new Random();

        HashTableSet<Integer> set = new BSTHashTableSet<>(k);
        long time1, time2, duration;
        System.out.println("Starting timing tests...");
        time1 = System.currentTimeMillis();

//        for (int i=0;i<50000;i++) {
//            set.add(i);
//        }

        for (int i=0;i<50000;i++) {
            set.add(random.nextInt());
        }
        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
//        System.out.println(set.toString());
        System.out.println("LoadFactor: " + set.getLoadFactor());
        System.out.println("Stdev: " + set.getBucketSizeStandardDev());
//        System.out.println(set.getSize());
    }

}
