package com.company;

import java.util.NoSuchElementException;
import java.util.Stack;

public class OwnStack<type> extends Stack<type> {
    private OwnList<type> stack;

    public OwnStack() {
        stack = new OwnList<>();
    }

    public type push(type item) {
        stack.add(item);
        return (item);
    }

    public type pop() {
        int index = stack.size() - 1;
        type data = stack.get(index);
        stack.remove(index);
        return data;
    }

    public type peek() {
        if (stack.size()==0){
            throw new NoSuchElementException("Deleting element from empty stack");
        }
        int index = stack.size() - 1;
        type data = stack.get(index);
        return data;
    }

    public boolean empty() {
        return (stack.isEmpty());
    }

    public int search(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
