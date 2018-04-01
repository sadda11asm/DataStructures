package csci.impl.testing;

import csci.impl.LLQueueSet;
import csci152.adt.Set;

public class TestSet3_4_5 {

    public static void main(String[] args) {

        //3 ex
        Set<Integer> set1 = new LLQueueSet<>();
        Set<Integer> set2 = new LLQueueSet<>();
        for (int i = 0; i < 20; i++) {
            set2.add(i);
        }
        for (int i = 10; i > 7; i--) {
            set1.add(i);
        }

        System.out.println(isSubset(set1, set2));

        //4 ex

        Set<String> st1 = new LLQueueSet<>();
        Set<String> st2 = new LLQueueSet<>();
        for (int i = 0; i < 20; i++) {
            st2.add(String.valueOf(i));
        }
        for (int i = 15; i > 1; i--) {
            st1.add(String.valueOf(i));
        }
        System.out.println(union(st1, st2));

        //5 ex

        Set<Integer> s1 = new LLQueueSet<>();
        Set<Integer> s2 = new LLQueueSet<>();
        for (int i = 0; i < 10; i++) {
            s2.add(i);
        }
        for (int i = 9; i > 4; i--) {
            s1.add(i);
        }
        System.out.println(intersection(s1, s2));


    }

    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        int size = set1.getSize();
        System.out.println("sets: "+ set1+ " and "+ set2);
        for (int i = 0; i < size; i++) {
            try {
                Integer temp = set1.removeAny();
                set1.add(temp);
                if(!set2.contains(temp)) return false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return true;
    }

    public static Set<String> union(Set<String> set1, Set<String> set2){
        System.out.println("sets:\n"+set1+" and "+set2);

        Set<String> res = new LLQueueSet<>();
        int sz1 = set1.getSize();
        int sz2 = set2.getSize();
        for (int i = 0; i < sz1; i++) {
            try {
                String temp = set1.removeAny();
                set1.add(temp);
                res.add(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < sz2; i++) {
            try {
                String temp = set2.removeAny();
                set2.add(temp);
                res.add(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return res;
    }


    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        System.out.println("sets:\n"+set1+" and "+set2);
        Set<Integer> result = new LLQueueSet<>();
        int size = set1.getSize();
        for (int i = 0; i < size; i++) {
            try {
                Integer temp = set1.removeAny();
                set1.add(temp);
                if(set2.contains(temp)) result.add(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result;

    }
}
