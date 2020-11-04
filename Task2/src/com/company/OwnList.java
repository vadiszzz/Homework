package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OwnList<type> implements List<type> {
    private Node<type> head, tail;
    private int size;

    public OwnList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return size;
    }

    public boolean add(type data) {
        if (data == null) {
            throw new NullPointerException("Adding Null value");
        } else {
            if (isEmpty()) {
                Node<type> nodeToAdd = new Node<>(null, data);
                size = 1;
                head = nodeToAdd;
                tail = nodeToAdd;
            } else {
                Node<type> nodeToAdd = new Node<>(null, data);
                tail.next = nodeToAdd;
                tail = nodeToAdd;
                size++;
            }
            return true;
        }
    }

    public boolean contains(Object dataToCheck) {
        if (dataToCheck == null) {
            throw new NullPointerException("Null argument in function 'contains'");
        } else {
            Node<type> curr = head;
            while (curr != null) {
                if (curr.data == dataToCheck) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }

    public type remove(int index) {
        if ((index > (size - 1)) || (index < 0)) {
            throw new IndexOutOfBoundsException("Index > list size or negative index");
        } else {
            if (size == 1) {
                type toReturn = head.data;
                head = null;
                tail = null;
                size = 0;
                return toReturn;
            }
            if (index == 0) {
                type toReturn = head.data;
                head = head.next;
                size--;
                return toReturn;
            }
            Node<type> currNode = head;
            for (int i = 1; i < index; i++) {
                currNode = currNode.next;
            }
            type toReturn = currNode.next.data;
            currNode.next = currNode.next.next;
            if (index == (size - 1)) {
                tail = currNode;
            }
            size--;
            return toReturn;

        }
    }

    public type get(int index) {
        if ((index > (size - 1)) || (index < 0)) {
            throw new IndexOutOfBoundsException("Index > list size or Index < 0");
        } else {
            Node<type> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode.data;
        }
    }

    public void add(int index, type data) {
        if (data == null) {
            throw new NullPointerException("Adding Null value");
        } else if ((index > size) || (index < 0)) {
            throw new IndexOutOfBoundsException("Index > list size or Index < 0");
        } else {
            if (index == 0) {
                Node<type> node = new Node<>(head, data);
                head = node;
                size++;
                return;
            }
            Node<type> currNode = head;
            for (int i = 1; i < index; i++) {
                currNode = currNode.next;
            }
            Node<type> node = new Node<>(currNode.next, data);
            currNode.next = node;
            if (index == size) {
                tail = node;
            }
            size++;
        }
    }

    @Override
    public Iterator<type> iterator() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("This operation is not supported");
    }


    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean addAll(Collection<? extends type> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean addAll(int index, Collection<? extends type> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public type set(int index, type element) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public ListIterator<type> listIterator() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public ListIterator<type> listIterator(int index) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public List<type> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
