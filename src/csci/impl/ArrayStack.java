package csci.impl;

import csci152.adt.IntStack;
import csci152.adt.Stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {

    private T[] values;
    private int size;

    public ArrayStack() {
        values = (T[]) new Object[10];
        size=0;
    }


    @Override
    public void push(T value) {
        if (size>=values.length) {
//            T[] temporary = (T[]) new Object[2*size];
//            for (int i=0;i<size;i++) {
//                temporary[i]=values[i];
//            }
//            values = (T[])new Object[2*size];
//            for (int i=0;i<size;i++) {
//                values[i]=temporary[i];
//            }
            values = Arrays.copyOf(values, 2*size);
        }
        values[size]=value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size==0) {
            throw new Exception("The size is zero, you can not pop the element!");
        }
        T value = values[size-1];
        values[size-1]=null;
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        for (int i=0;i<size;i++) {
            values[i]=null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        String represent="Bottom[";
        for (int i=0;i<size;i++) {
            represent+=values[i]+" ";
        }
        represent+="]top";
        return represent;
    }
}
