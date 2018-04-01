package csci.impl;

import csci152.adt.IntQueue;

public class ArrayIntQueue implements IntQueue{

    private int front;
    private int back;
    private int size;
    private int[] values;

    public ArrayIntQueue() {
        front=-1;
        back=-1;
        size=0;
        values = new int[5];
    }

    @Override
    public void enqueue(int value) {
        if (size==0) {
            front=0;
            back=0;
            size=1;
            values[0]=value;
            return;
        }
        if ((back+1)%values.length!=front) {
            values[(back+1)%values.length]=value;
            size++;
            back=(back+1)%values.length;
        } else {
            int[] temp = new int[2*size];
            int j=front;
            for (int i=0; i <size;i++) {
                temp[i] = values[j];
                j=(j+1)%values.length;
            }
            values=temp;
            values[size]=value;
            back=size;
            size++;
            front =0;
        }
    }

    @Override
    public int dequeue() throws Exception {
        if (size==0) {
            throw new Exception("The queue is still empty! You can not dequeue any element!");
        }
        int el = values[front];
        size--;
        front=(front+1)%values.length;
        if (size==0) {
            front=-1;
            back=-1;
        }
        return el;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size=0;
        front=-1;
        back=-1;
    }

    public String toString() {
        String s="front[";
        int i=front;
        int count=0;
        while (count<size) {
            s+=values[i]+" ";
            i=(i+1)%values.length;
            count++;
        }
        s+="]back";
        return s;
    }
}
