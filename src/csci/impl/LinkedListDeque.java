package csci.impl;

import csci152.adt.Deque;

public class LinkedListDeque<T> implements Deque<T> {

    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;
    public LinkedListDeque() {
        front=null;
        back=null;
        size=0;
    }

    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode node = new DoublyLinkedNode(value);
        if (size==0) {
            front = node;
            back=node;
            size=1;
            return;
        }
        node.setNext(front);
        front.setPrevious(node);
        front=node;
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode(value);
        if (size==0) {
            front = node;
            back=node;
            size=1;
            return;
        }
        back.setNext(node);
        node.setPrevious(back);
        back=node;
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        if (size==0) throw new Exception("Empty deque!");
        DoublyLinkedNode<T> node = front;
        if (size==1) {
            front=null;
            back=null;
            size=0;
            return node.getValue();
        }
        front = front.getNext();
        size--;
        return node.getValue();
    }

    @Override
    public T popFromBack() throws Exception {
        if (size==0) throw new Exception("Empty deque!");
        DoublyLinkedNode<T> node = back;
        if (size==1) {
            front=null;
            back=null;
            size=0;
            return node.getValue();
        }
        size--;
        back = back.getPrevious();
        return node.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front=null;
        back=null;
        size=0;
    }

    @Override
    public String toString() {
        String s="front[";
        int i=0;
        DoublyLinkedNode<T> node = front;
        while (i<size) {
            s+=node.getValue()+" ";
            node=node.getNext();
            i++;
        }
        s+="]back";
        return s;
    }

    public class DoublyLinkedNode<T>{
        private T value;

        private DoublyLinkedNode<T> previous;
        private DoublyLinkedNode<T> next;

        /**
         * Construct a doubly-linked node with the given value,
         * and null previous and next links
         *
         * @param val to set on the node
         */
        public DoublyLinkedNode(T val) {
            value = val;
            previous = null;
            next = null;
        }

        /**
         * @return the value
         */
        public T getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(T value) {
            this.value = value;
        }

        /**
         * @return the previous
         */
        public DoublyLinkedNode<T> getPrevious() {
            return previous;
        }

        /**
         * @param previous the previous to set
         */
        public void setPrevious(DoublyLinkedNode<T> previous) {
            this.previous = previous;
        }

        /**
         * @return the next
         */
        public DoublyLinkedNode<T> getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(DoublyLinkedNode<T> next) {
            this.next = next;
        }

        /**
         * @return the string representation of the value
         */
        @Override
        public String toString() {
            return value.toString();
        }
    }

}
