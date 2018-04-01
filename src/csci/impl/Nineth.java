package csci.impl;

import csci152.adt.Stack;

public class Nineth {
    public static void main(String[] args) {
        Stack<Double> myStack = new LinkedListStack<>();

        for (int i=0;i<12;i++) {
            myStack.push(Double.valueOf(i));
        }
        myStack.push(1.0);

        System.out.println(myStack.toString());
        //System.out.println(myStack.getSize());

        System.out.println(isIncreasing(myStack));

        System.out.println(myStack.toString());
        //System.out.println(myStack.getSize());
    }
    public static boolean isIncreasing (Stack<Double> st) {
        Stack<Double> temp = new LinkedListStack<>();
        double el;
        boolean ans = true;
        try {
            int i=0;
            el = st.pop();
            temp.push(el);
            int size = st.getSize();
            //System.out.println(size);
            while (i < size) {
                double tempEl = st.pop();
                //System.out.println(i);
                temp.push(tempEl);
                if (tempEl > el) {
                    ans = false;
                }
                el = tempEl;
                i++;
            }
            size = temp.getSize();
            for (int j = 0; j < size; j++) {
                st.push(temp.pop());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
}
