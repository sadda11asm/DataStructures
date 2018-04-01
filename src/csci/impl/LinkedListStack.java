package csci.impl;

import csci152.adt.Stack;

public class LinkedListStack<T> implements Stack<T> {

    private int size;
    private Node<T> top;

    public LinkedListStack() {
        top = null;
        size=0;
    }
    @Override
    public void push(T value) {
        Node<T> el= new Node<>(value);
        if (size==0) {
            top = el;
            size++;
            return;
        }
        size++;
        Node<T> last = top;
        top=el;
        top.setLink(last);
    }

    @Override
    public T pop() throws Exception {
        if (size==0) {
            throw new Exception("There is 0 number of nodes in the linked list");
        }
        if (size==1) {
            size=0;
            T value = top.getValue();
            top=null;
            return value;
        }
        size--;
        T el = top.getValue();
        top=top.getLink();
        return el;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        while (size>0) {
            try {
                pop();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        String s ="top[";
        int i=0;
        Node<T> el = top;
        while (i<size) {
            s+=el.getValue()+" ";
            el = el.getLink();
            i++;
        }
        s+="]bottom";
        return s;
    }
}
