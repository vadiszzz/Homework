package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {
    @Test
    public void testIsEmptyForEmptyTable(){
        HashMap testMap = new HashMap();
        Assertions.assertTrue(testMap.isEmpty());
    }
    @Test
    public void testIsNotEmptyForEmptyTable(){
        HashMap testMap = new HashMap();
        testMap.put(5,4);
        Assertions.assertFalse(testMap.isEmpty());
    }
    @Test
    public void testContainsKey(){
        HashMap testMap = new HashMap();
        testMap.put(5,5);
        Assertions.assertTrue(testMap.containsKey(5));
    }
    @Test
    public void testContainsKeyNull(){
        HashMap testMap = new HashMap();
        Assertions.assertThrows(NullPointerException.class,() -> testMap.containsKey(null));
    }
    @Test
    public void testPutNullKey(){
        HashMap testMap= new HashMap();
        testMap.put(5,4);
        Assertions.assertThrows(NullPointerException.class,() ->testMap.put(null,1));
    }
    @Test
    public void testPutNullValue(){
        HashMap testMap= new HashMap();
        testMap.put(5,4);
        Assertions.assertThrows(NullPointerException.class,() ->testMap.put(1,null));
    }
    @Test
    public void testPutAlreadyContains(){
        HashMap testMap= new HashMap();
        testMap.put(5,4);
        testMap.put(5,3);
        Assertions.assertEquals(3,testMap.get(5));
    }
    @Test
    public void testPutAndRehash(){
        HashMap testMap= new HashMap();
        testMap.put(5,4);
        testMap.put(6,6);
        testMap.put(4,8);
        testMap.put(3,9);
        testMap.put(2,10);
        testMap.put(1,20);
        Assertions.assertTrue(testMap.containsKey(1));
        Assertions.assertTrue(testMap.containsKey(2));
        Assertions.assertTrue(testMap.containsKey(3));
        Assertions.assertTrue(testMap.containsKey(4));
        Assertions.assertTrue(testMap.containsKey(5));
        Assertions.assertTrue(testMap.containsKey(6));
    }
    @Test
    public void testGet(){
        HashMap testMap= new HashMap();
        testMap.put(5,4);
        testMap.put(3,2);
        testMap.put(1,0);
        Assertions.assertEquals(0,testMap.get(1));
    }
    @Test
    public void testGetNull(){
        HashMap testMap = new HashMap();
        testMap.put(5,4);
        testMap.put(3,2);
        testMap.put(1,0);
        Assertions.assertThrows(NullPointerException.class,() ->testMap.get(null));
    }
    @Test
    public void testGetNotContains(){
        HashMap testMap= new HashMap();
        testMap.put(5,4);
        testMap.put(3,2);
        testMap.put(1,0);
        Assertions.assertNull(testMap.get(2));
    }
}
