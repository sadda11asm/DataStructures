package csci.impl;

import csci152.adt.Set;
import sun.reflect.generics.tree.Tree;

public class BSTSet<T extends Comparable> implements Set<T> {
    private TreeNode<T> root;
    private int size;

    public BSTSet() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (contains(value)) return;
        size++;
        if (root==null) {
            root = new TreeNode<>(value);
        } else {
            addHelper(root, value);
        }
    }
    private void addHelper(TreeNode<T> child, T value) {
        if (child.getValue().compareTo(value)<0) {
            if (child.getRight()==null) {
                child.setRight(new TreeNode<>(value));
                return;
            }
            addHelper(child.getRight(), value);
            return;
        }
        if (child.getLeft()==null) {
            child.setLeft(new TreeNode<>(value));
            return;
        }
        addHelper(child.getLeft(), value);
    }


    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(TreeNode<T> child, T value) {
        if (child==null) return false;
        if (child.getValue().equals(value)) {
            return true;
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
        if (root.getValue().equals(value)) {
            root.setValue(removeHelper(root).getValue());
            return true;
        }
        TreeNode<T> node = root;
        while ((!node.getLeft().getValue().equals(value)|| node.getLeft()==null) && (node.getRight()==null || !node.getRight().getValue().equals(value))) {
            if (node.getValue().compareTo(value)>0) {
                node = node.getLeft();
                continue;
            }
            node = node.getRight();
        }
        if (node.getRight()!= null && node.getRight().getValue().equals(value)) {
            node.setRight(removeHelper(node.getRight()));
            return true;
        }
        node.setLeft(removeHelper(node.getLeft()));
        return true;
    }

    private TreeNode<T> removeHelper(TreeNode<T> child) {
        if (child.getLeft()== null && child.getRight()==null) {
            return null;
        }
        if (child.getRight()==null) {
            return child.getLeft();
        }
        if (child.getLeft()==null) {
            return child.getRight();
        }
        TreeNode<T> temp = child.getRight();
        TreeNode<T> parent = child;
        while (temp.getLeft()!=null) {
            parent = temp;
            temp = temp.getLeft();
        }
        parent.setLeft(temp.getRight());
        return temp;
    }

    @Override
    public T removeAny() throws Exception {
        if(size==0) {
            throw new Exception("The size is 0!");
        }
        T value =  root.getValue();
        boolean a = remove(root.getValue());
        return value;
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
    private String toStringHelper(TreeNode<T> node){
        if (node ==null){
            return "";
        }
        return toStringHelper(node.getLeft())+ "\t" +
                node.getValue()+ "\t" +
                toStringHelper(node.getRight());
    }
}
