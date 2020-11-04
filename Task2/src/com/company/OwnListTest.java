package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OwnListTest {
    @Test
    public void testIsEmptyForEmptyList(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        Assertions.assertEquals(true,testlist.isEmpty());
    }
    @Test
    public void testIsEmptyForNotEmptyList(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(0);
        Assertions.assertEquals(false,testlist.isEmpty());
    }
    @Test
    public void testAddNullToList(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        Assertions.assertThrows(NullPointerException.class, () -> testlist.add(null));
    }
    @Test
    public void testAddToEmptyList(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertEquals(5,testlist.get(0));
    }
    @Test
    public void testContainsNull(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        Assertions.assertThrows(NullPointerException.class, () -> testlist.contains(null));
    }
    @Test
    public void testContainsTrue(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertEquals(true,testlist.contains(5));
    }
    @Test
    public void testContainsFalse(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertEquals(false,testlist.contains(4));
    }
    @Test
    public void testRemoveNegativeIndex(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testlist.remove(-5));
    }
    @Test
    public void testRemoveIndexGreaterSize(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testlist.remove(2));
    }
    @Test
    public void testRemoveHead(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        testlist.add(4);
        Assertions.assertEquals(5,testlist.remove(0));
        Assertions.assertEquals(4,testlist.get(0));
    }
    @Test
    public void testGetNegativeIndex(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testlist.get(-5));
    }
    @Test
    public void testGetIndexGreaterSize(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testlist.get(2));
    }
    @Test
    public void testGet(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertEquals(5, testlist.get(0));
    }
    @Test
    public void testAddToIndexNullData(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(NullPointerException.class, () -> testlist.add(0,null));
    }
    @Test
    public void testAddToIndexHead(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        testlist.add(0,4);
        Assertions.assertEquals(4,testlist.get(0));
    }
    @Test
    public void testAddToIndexTail(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        testlist.add(1,4);
        Assertions.assertEquals(4,testlist.get(1));
    }
    @Test
    public void testAddToNegativeIndex(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testlist.add(-1,4));
    }
    @Test
    public void testAddToIndexGreaterSize(){
        OwnList<Integer> testlist= new OwnList<Integer>();
        testlist.add(5);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testlist.add(2,4));
    }
}
