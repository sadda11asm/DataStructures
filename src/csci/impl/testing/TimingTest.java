package csci.impl.testing;

import csci.impl.LLQHashTableSet;
import csci152.adt.Set;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Stack;

public class TimingTest {
    public static void main(String[] args) {

//        //115+32=147
//        LinkedList<Integer> a = new LinkedList<>();
//        a.push(5);
//        a.push(4);
//        a.push(5);
//        LinkedList<Integer> b = new LinkedList<>();
//        b.push(4);
//        b.push(5);
//        b.push(5);
//        System.out.println(a.toString());
//        System.out.println(b.toString());
//        System.out.println(getSum(a, b));
//        int[] de = {-10,3,5, 4, 2};
//        int[] de2 = {};
//        int[] de3 = {-10,-1};
//        System.out.println(min_max(de));
//        System.out.println(min_max(de2));
//        System.out.println(min_max(de3));
//        System.out.println(min_max(null));

        System.out.println(path("/a/./b/../../c"));

    }

    public static String path(String a) {
        String[] b = a.split("/");
        Stack<String> st = new Stack<>();
        for (int i=0;i<b.length;i++) {
            if (b[i].equals("..")) {
                st.pop();
            } else if (b[i].equals(".") || b[i].equals("")) continue;
            else {
                st.push(b[i]);
            }
        }
        Stack<String> st2 = new Stack<>();
        while (st.size()!=0) {
            st2.push(st.peek());
            st.pop();
        }
        String ans ="";
        for (int i=0;i<st2.size();i++) {
            ans+="/"+st2.peek();
            st2.pop();
        }
        return ans;
    }

    public static int min_max(int[] arr) {
        if (arr== null || arr.length==0) {
            return 0;
        }
        int ma = arr[0], mi = arr[0];
        for (int i=0;i<arr.length;i++) {
            ma = Math.max(arr[i], ma);
            mi = Math.min(arr[i],mi);
        }
        return mi+ma;
    }
    public static LinkedList<Integer> getSum(LinkedList<Integer> a, LinkedList<Integer> b) {
        int n=0, m=0;
        for (int i=0;i<a.size();i++) {
            n+=(int) Math.pow(10,i)*a.get(i);
        }
        System.out.println(n);
        for (int i=0;i<b.size();i++) {
            m+=(int) Math.pow(10,i)*b.get(i);
        }
        System.out.println(m);
        int k = n+m;
        System.out.println(k);
        Stack<Integer> perm = new Stack<>();
        LinkedList<Integer> c = new LinkedList<>();
        while(k!=0) {
            perm.push(k%10);
            k/=10;
        }
        while(perm.size()!=0) {
            c.push(perm.peek());
            perm.pop();
        }
        return c;
     }
}
