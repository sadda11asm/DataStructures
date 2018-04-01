package csci.impl;

import csci152.adt.IntStack;

public class ArrayIntStack implements IntStack {

    private int[] values;
    private int size;

    public ArrayIntStack () {
        values = new int[10];
        size=0;
    }


    @Override
    public void push(int value) {
        if (size>=10) {
            int[] temporary = new int[2*size];
            for (int i=0;i<size;i++) {
                temporary[i]=values[i];
            }
            values = new int[2*size];
            for (int i=0;i<size;i++) {
                values[i]=temporary[i];
            }
        }
        values[size]=value;
        size++;
    }

    @Override
    public int pop() throws Exception {
        if (size==0) {
            throw new Exception("The size is zero, you can not pop the element!");
        }
        int value = values[size-1];
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
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
