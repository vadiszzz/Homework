package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTTest {
    @Test
    public void testCapacityNegative(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new HashT<Integer, Integer>(-2));
    }
    @Test
    public void testFillRatioNegative(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new HashT<Integer, Integer>(2,-2));
    }
    @Test
    public void testIsEmptyForEmptyTable(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        Assertions.assertTrue(testTable.isEmpty());
    }
    @Test
    public void testIsNotEmptyForEmptyTable(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        Assertions.assertFalse(testTable.isEmpty());
    }
    @Test
    public void testPutNullKey(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        Assertions.assertThrows(NullPointerException.class,() ->testTable.put(null,1));
    }
    @Test
    public void testPutNullValue(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        Assertions.assertThrows(NullPointerException.class,() ->testTable.put(1,null));
    }
    @Test
    public void testPutAlreadyContains(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(5,3);
        Assertions.assertEquals(3,testTable.get(5));
    }
    @Test
    public void testPutAndRehash(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(6,6);
        testTable.put(4,8);
        testTable.put(3,9);
        testTable.put(2,10);
        testTable.put(1,20);
        Assertions.assertTrue(testTable.containsKey(1));
        Assertions.assertTrue(testTable.containsKey(2));
        Assertions.assertTrue(testTable.containsKey(3));
        Assertions.assertTrue(testTable.containsKey(4));
        Assertions.assertTrue(testTable.containsKey(5));
        Assertions.assertTrue(testTable.containsKey(6));
    }
    @Test
    public void testContainsKeyNull(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        Assertions.assertThrows(NullPointerException.class,() -> testTable.containsKey(null));
    }

    @Test
    public void testContainsKeyNotNull(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        Assertions.assertTrue(testTable.containsKey(3));
    }
    @Test
    public void testRemoveNotNull(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        testTable.remove(3);
        Assertions.assertFalse(testTable.containsKey(3));
    }
    @Test
    public void testRemoveNotNullNotContains(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        testTable.remove(3);
        Assertions.assertNull(testTable.remove(3));
    }
    @Test
    public void testRemoveNull(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        testTable.remove(3);
        Assertions.assertThrows(NullPointerException.class,() ->testTable.remove(null));
    }
    @Test
    public void testGet(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        Assertions.assertEquals(0,testTable.get(1));
    }
    @Test
    public void testGetNull(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        testTable.remove(3);
        Assertions.assertThrows(NullPointerException.class,() ->testTable.get(null));
    }
    @Test
    public void testGetNotContains(){
        HashT<Integer,Integer> testTable= new HashT<Integer, Integer>(5);
        testTable.put(5,4);
        testTable.put(3,2);
        testTable.put(1,0);
        testTable.remove(3);
        Assertions.assertNull(testTable.get(3));
    }
}
