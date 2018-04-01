package csci.impl;

import csci152.adt.Set;

public class BST2Set<T extends Comparable> implements Set<T> {
    private OnOffTreeNode<T> root;
    private int size;

    public BST2Set() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (contains(value)) return;
        size++;
        if (root==null) {
            root = new OnOffTreeNode<>(value);
        } else {
            addHelper(root, value);
        }
    }
    private void addHelper(OnOffTreeNode<T> child, T value) {
        if (child.getValue().compareTo(value)==0) {
            child.setActive(true);
            return;
        }
        if (child.getValue().compareTo(value)<0) {
            if (child.getRight()==null) {
                child.setRight(new OnOffTreeNode<>(value));
                return;
            }
            addHelper(child.getRight(), value);
            return;
        }
        if (child.getLeft()==null) {
            child.setLeft(new OnOffTreeNode<>(value));
            return;
        }
        addHelper(child.getLeft(), value);
    }


    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(OnOffTreeNode<T> child, T value) {
        if (child==null) return false;
        if (child.getValue().equals(value)) {
            return child.getActive();
        }
        if (value.compareTo(child.getValue())<0){
            return containsHelper(child.getLeft(), value);
        }
        return containsHelper(child.getRight(), value);
    }


    @Override
    public boolean remove(T value) {
        if (!contains(value)) return false;
        size--;
        OnOffTreeNode<T> node = root;
        if (node==null) return false;
        while (!node.getValue().equals(value)) {
            if (node==null) return false;
            if (node.getValue().compareTo(value)>0) {
                node = node.getLeft();
                continue;
            }
            node = node.getRight();
        }
        node.setActive(false);
        return true;
    }


    @Override
    public T removeAny() throws Exception {
        if(size==0) {
            throw new Exception("The size is 0!");
        }
        size--;
        return removeAnyHelper(root);
    }

    private T removeAnyHelper(OnOffTreeNode<T> node) {
        if (node==null) return null;
        if (node.getActive()) {
            node.setActive(false);
            return node.getValue();
        }
        if (removeAnyHelper(node.getLeft())!=null) return removeAnyHelper(node.getLeft());
        return removeAnyHelper(node.getRight());
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString() {
        return toStringHelper(root);
    }
    private String toStringHelper(OnOffTreeNode<T> node){
        if (node ==null){
            return "";
        }
        String s = toStringHelper(node.getLeft())+ " ";
        if (node.getActive()) s+=node.getValue()+ " ";
        s+=toStringHelper(node.getRight());
        return s;
    }
}
