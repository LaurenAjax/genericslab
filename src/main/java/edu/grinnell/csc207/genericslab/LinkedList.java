/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

/**
 *
 * @author ajaxlaur
 */
public class LinkedList<T> {
        private class Node {
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
    
    public void intersperce(T sep) {
        Node cur = this.first;
        while (cur.next != null){
            Node newNode = new Node(sep, cur.next);
            this.first.next = newNode;
            cur = cur.next.next;
        }
    }
    
    /**
     * Cannot implement maximum because it requires T to be an integer
     * @return 
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        String str = "[" + this.first.value;
        for (Node cur = this.first.next; !(cur == null); cur = cur.next) {
            str = str + ", " + cur.value;
        }
        str = str + "]";
        return str;
    }
    
    /**
     * Cannot implement insertionSort because what it would sort by depends on
     * what T is
     */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }
}
