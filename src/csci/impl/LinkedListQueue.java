package csci.impl;

import csci152.adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedListQueue () {
        front = null;
        back=null;
        size=0;
    }
    @Override
    public void enqueue(T value) {
        Node<T> el = new Node(value);
        Node<T> temp = back;
        back = el;
        if (size==0) {
            front = el;
            size++;
            return;
        }
        temp.setLink(el);
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size==0) throw new Exception("The queue is empty!");
        T el = front.getValue();
        if (size==1) {
            front = null;
            back=null;
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
        front = null;
        back=null;
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
