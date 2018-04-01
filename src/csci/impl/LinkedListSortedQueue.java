package csci.impl;

import csci152.adt.SortedQueue;

public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {

    private Node<T> front;
    private int size;

    public LinkedListSortedQueue() {
        front=null;
        size=0;
    }

    @Override
    public void insert(T value) {
        Node<T> temp = new Node<T>(value);
        if (size==0) {
            front = temp;
            size++;
        } else {
            if (value.compareTo(front.getValue())<=0) {
                temp.setLink(front);
                front = temp;
                size++;
            } else {
                Node<T> i = front;
                while (i.getLink()!=null) {
                    if (value.compareTo(i.getLink().getValue())<=0) {
                        temp.setLink(i.getLink());
                        i.setLink(temp);
                        size++;
                        return;
                    }
                    i=i.getLink();
                }
                i.setLink(temp);
                size++;
                return;
            }
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (size==0) throw new Exception("The queue is empty!");
        T el = front.getValue();
        if (size==1) {
            front = null;
            size--;
            return el;
        }
        size--;
        front = front.getLink();
        return el;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front=null;
        size=0;
    }

    @Override
    public String toString() {
        String s="front[";
        int i=0;
        Node<T> el = front;
        while (i<size) {
            s+=el.getValue()+" ";
            el=el.getLink();
            i++;
        }
        s+="]back";
        return s;
    }
}
