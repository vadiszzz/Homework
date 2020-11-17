package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class HashT<type, V> {
    private ArrayList<Node<type, V>> table;
    private final float fillRatio;
    private int size, capacity;

    public HashT(int capacity, float fillRatio) {
        if ((fillRatio>=1)||(fillRatio<=0)){
            throw new IllegalArgumentException("Fill Ratio must be >0 and <1");
        }
        if (capacity<=0){
            throw new IllegalArgumentException("Capacity must be positive");
        }
        table = new ArrayList<>();
        this.fillRatio = fillRatio;
        this.capacity = capacity;
        size = 0;
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
    }

    public HashT(int capacity) {
        if (capacity<=0){
            throw new IllegalArgumentException("Capacity must be positive");
        }
        table = new ArrayList<>();
        fillRatio = 0.75f;
        this.capacity = capacity;
        size = 0;
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
    }

    public boolean isEmpty(){
        return (size==0);
    }

    private int calculateIndex(type key) {
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        int hash = key.hashCode();
        return Math.abs(hash % table.size());
    }

    public boolean containsKey(type key) {
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        int index = calculateIndex(key);
        ListIterator<Node<type, V>> iter = table.listIterator(index);
        while (table.get(index) != null) {
            if (table.get(index).key.equals(key)) {
                return true;
            } else {
                iter.next();
                index++;
            }
        }
        return false;
    }

    public V remove(type key) {
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        int index = calculateIndex(key);
        ListIterator<Node<type, V>> iter = table.listIterator(index);
        if (index>=(capacity-1))
        {
            iter.previous();
            iter.next();
        }
        else {
            iter.next();
            iter.previous();
        }
        while (table.get(index) != null) {
            if (table.get(index).key.equals(key)) {
                break;
            } else {
                iter.next();
                index++;
            }
        }
        if (table.get(index) == null) {
            return null;
        }
        V v = table.get(index).value;
        iter.remove();
        return v;
    }

    private void rehash() {
        capacity*=2;
        size = 0;
        ArrayList<Node<type, V>> oldTable = table;
        table = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }

        for (int index=0;index<oldTable.size();index++){
            if(oldTable.get(index)!=null) {
                put(oldTable.get(index).key, oldTable.get(index).value);
            }
        }

    }

    public V put(type key, V value) {
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        if (value==null){
            throw new NullPointerException("Value cannot be null");
        }
        if ((((float) (size+1) / capacity) > fillRatio)&&(!containsKey(key))) {
            rehash();
            return (put(key,value));
        }
        int index = calculateIndex(key);
        ListIterator<Node<type, V>> iter = table.listIterator(index);
        if (index>=(capacity-1))
        {
            iter.previous();
            iter.next();
        }
        else {
            iter.next();
            iter.previous();
        }
        while ((index<table.size())&&(table.get(index) != null)) {
            if (table.get(index).key.equals(key)) {
                V v = table.get(index).value;
                Node<type, V> toAdd = new Node<>(key, value);
                iter.set(toAdd);
                return v;
            }
            iter.next();
            index++;
        }
        Node<type, V> toAdd = new Node<>(key, value);
        table.set(index, toAdd);
        size++;

        return null;
    }

    public V get(type key){
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        if (containsKey(key)){
            int index = calculateIndex(key);
            while (table.get(index) != null) {
                if (table.get(index).key.equals(key)) {
                    return (table.get(index).value);
                } else {
                    index++;
                }
            }
        }
        return null;
    }

}

