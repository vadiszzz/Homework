package com.company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class OwnStackTest {
    @Test
    public void testPushToEmpty(){
        OwnStack<Integer> testStack= new OwnStack<Integer>();
        Assertions.assertEquals(testStack.push(5),testStack.peek());
    }
    @Test
    public void testPushToNotEmpty(){
        OwnStack<Integer> testStack= new OwnStack<Integer>();
        testStack.push(4);
        Assertions.assertEquals(testStack.push(5),testStack.peek());
    }
    @Test
    public void testPushNull(){
        OwnStack<Integer> testStack= new OwnStack<Integer>();
        testStack.push(4);
        Assertions.assertThrows(NullPointerException.class, () ->testStack.push(null));
    }
    @Test
    public void testPeekEmpty() {
        OwnStack<Integer> testStack = new OwnStack<Integer>();
        Assertions.assertThrows(NoSuchElementException.class, () -> testStack.peek());
    }
    @Test
    public void testPeekNotEmpty() {
        OwnStack<Integer> testStack = new OwnStack<Integer>();
        testStack.push(5);
        Assertions.assertEquals(5, testStack.peek());
    }
    @Test
    public void testIsEmptyForEmptyStack(){
        OwnStack<Integer> testStack= new OwnStack<>();
        Assertions.assertEquals(true,testStack.empty());
    }
    @Test
    public void testIsEmptyForNotEmptyStack() {
        OwnStack<Integer> testStack = new OwnStack<>();
        testStack.push(5);
        Assertions.assertEquals(false, testStack.empty());
    }
    }
