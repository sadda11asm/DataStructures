package csci.impl;

import csci152.adt.HashTableSet;
import csci152.adt.HashTableStats;
import csci152.adt.Set;

public class LLQHashTableSet<T> implements HashTableSet<T> {

    private LinkedListQueue<T>[] buckets;
    private int size;

    public LLQHashTableSet(int k) {
        buckets = new LinkedListQueue[k];
        size=0;
    }
    @Override
    public void add(T value) {
        if (contains(value)) return;
        size++;
        int no = Math.abs(value.hashCode())%buckets.length;
        if (buckets[no]==null) {
            buckets[no]=new LinkedListQueue<>();
        }
        buckets[no].enqueue(value);
    }

    @Override
    public boolean contains(T value) {
        int no = Math.abs(value.hashCode())%buckets.length;
        if (buckets[no]==null) return false;
        for (int i=0;i<buckets[no].getSize();i++) {
            try {
                T temp = buckets[no].dequeue();
                buckets[no].enqueue(temp);
                if (temp.equals(value)) return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) return false;
        size--;
        int no = Math.abs(value.hashCode())%buckets.length;
        for (int i=0;i<buckets[no].getSize();i++) {
            try {
                T temp = buckets[no].dequeue();
                if (temp.equals(value)) return true;
                buckets[no].enqueue(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if (size==0) throw new Exception("The set is empty!");
        size--;
        for (int i=0;i<buckets.length;i++) {
            if (buckets[i].getSize()!=0) {
                T el = buckets[i].dequeue();
                return el;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[buckets.length];
    }

    @Override
    public String toString() {
        String s="Set: ";
        for (int i=0;i<buckets.length;i++) {
            if (buckets[i]==null) continue;
            s+=buckets[i].toString()+"\n";
        }
        return s;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index<0 || index>=buckets.length) throw new Exception("There is not such bucket!");
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        if(buckets.length==0) return 0;
        return size/buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        int k = buckets.length;
        if (k==0) return 0;
        double stdev = 0;

        for (int i = 0; i < k; i++) {
            if (buckets[i]==null) continue;
            stdev+=Math.pow(buckets[i].getSize()-getLoadFactor(), 2);
        }
        stdev/=k;
        stdev=Math.sqrt(stdev);
        return stdev;
    }

    @Override
    public String bucketsToString() {
        return null;
    }
}
