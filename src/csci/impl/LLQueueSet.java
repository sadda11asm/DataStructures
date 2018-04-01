package csci.impl;

import csci152.adt.Queue;
import csci152.adt.Set;

public class LLQueueSet<T> implements Set<T> {

    private Queue<T> queue;

    public LLQueueSet() {
        queue = new LinkedListQueue<>();
    }
    @Override
    public void add(T value) {
        for (int i=0;i<queue.getSize();i++) {
            if (contains(value)) return;
        }
        queue.enqueue(value);
    }

    @Override
    public boolean contains(T value) {
        try {
            T val = queue.dequeue();
            queue.enqueue(val);
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
            for (int i=0;i<queue.getSize();i++) {
                try{
                    T val = queue.dequeue();
                    queue.enqueue(val);
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
                    queue.enqueue(temp.dequeue());
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
        if (queue.getSize()==0) throw new Exception("The empty set");
        return queue.dequeue();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public String toString() {
        String s= "{ ";
        for (int i=0;i<queue.getSize();i++) {
            try{
                T val = queue.dequeue();
                queue.enqueue(val);
                s+=val.toString()+" ";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        s+="}";
        return s;
    }
}
