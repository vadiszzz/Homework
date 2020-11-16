package com.company;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMap implements Map {
    private HashT<Object,Object> map;
    public HashMap(){
        map = new HashT(5);
    }
    public Object put(Object key, Object value) {
        return (map.put(key, value));
    }
    public Object get(Object key){
        return (map.get(key));
    }

    public boolean containsKey(Object key){
        return (map.containsKey(key));
    }

    public boolean isEmpty(){
        return (map.isEmpty());
    }
    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException("This operation is not supported");
    }



    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("This operation is not supported");
    }



}
