package csci.impl;

import csci152.adt.Queue;
import csci152.adt.Set;
import csci152.adt.Stack;

public class LLStackSet<T> implements Set<T> {
    private Stack<T> stack;

    public LLStackSet() {
        stack = new LinkedListStack<>();
    }
    @Override
    public void add(T value) {
        for (int i=0;i<stack.getSize();i++) {
            if (contains(value)) return;
        }
        stack.push(value);
    }

    @Override
    public boolean contains(T value) {
        try {
            T val = stack.pop();
            stack.push(val);
            if (val.equals(value)) return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value)) {
            Queue<T> temp = new LinkedListQueue();
            for (int i=0;i<stack.getSize();i++) {
                try{
                    T val = stack.pop();
                    stack.push(val);
                    if (!val.equals(value)) {
                        temp.enqueue(val);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            int size = temp.getSize();
            for (int i =0;i<size;i++) {
                try {
                    stack.push(temp.dequeue());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (stack.getSize()==0) throw new Exception("The empty set");
        return stack.pop();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public String toString() {
        String s= "{ ";
        for (int i=0;i<stack.getSize();i++) {
            try{
                T val = stack.pop();
                stack.push(val);
                s+=val.toString()+" ";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        s+="}";
        return s;
    }
}
