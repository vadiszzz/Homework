package com.company;

public class Node<type> {
    Node<type> next;
    type data;

    public Node(Node<type> nextToAdd, type dataToAdd) {
        next = nextToAdd;
        data = dataToAdd;
    }
}