package csci.impl;

import csci152.adt.IntQueue;
import csci152.adt.Queue;

public class ArrayQueue<T> implements Queue<T> {

    private int front;
    private int back;
    private int size;
    private T[] values;

    public ArrayQueue() {
        front=-1;
        back=-1;
        size=0;
        values = (T[]) new Object[5];
    }

    @Override
    public void enqueue(T value) {
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
            T[] temp = (T[])new Object[2*size];
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
    public T dequeue() throws Exception {
        if (size==0) {
            throw new Exception("The queue is still empty! You can not dequeue any element!");
        }
        T el = values[front];
        values[front]=null;
        size--;
        front=(front+1)%values.length;
        if (size==0) {
            front=-1;
            back=-1;
        }
        return el;
    }

    @Override
    public int getSize() {return size;}

    @Override
    public void clear() {
        for (int i=0;i<size;i++) {
            values[i]=null;
        }
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
