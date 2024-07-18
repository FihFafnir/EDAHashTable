package br.edu.ifpb.eda.linkedlist;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> root;
    private Node<T> current;

    public LinkedListIterator(Node<T> root) {
        this.root = root;
        this.current = root.next;
    }

    @Override
    public boolean hasNext() {
        return current != root;
    }

    @Override
    public T next() {
        T currentValue = current.value;
        current = current.next;
        return currentValue;
    }
}
