package csci.impl;

import csci152.adt.HashTableSet;
import csci152.adt.HashTableStats;
import csci152.adt.Set;

public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {

    private BSTSet<T>[] buckets;
    private int size;

    public BSTHashTableSet(int k) {
        buckets = new BSTSet[k];
        size=0;
    }
    @Override
    public void add(T value) {
        if (contains(value)) return;
        size++;
        int no = Math.abs(value.hashCode())%buckets.length;
        if (buckets[no]==null) {
            buckets[no]=new BSTSet<>();
        }
        buckets[no].add(value);
    }

    @Override
    public boolean contains(T value) {
        int no = Math.abs(value.hashCode())%buckets.length;
        if (buckets[no]==null) return false;
        if (buckets[no].contains(value)) return true;
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) return false;
        size--;
        int no = Math.abs(value.hashCode())%buckets.length;
        return buckets[no].remove(value);
    }

    @Override
    public T removeAny() throws Exception {
        if (size==0) throw new Exception("The set is empty!");
        size--;
        for (int i=0;i<buckets.length;i++) {
            if (buckets[i].getSize()!=0) {
                T el = buckets[i].removeAny();
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
        buckets = new BSTSet[buckets.length];
    }
    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index<0 || index>=buckets.length) throw new Exception("There is no such bucket!");
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
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
