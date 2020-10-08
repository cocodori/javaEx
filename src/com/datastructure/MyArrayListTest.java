package com.datastructure;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MyArrayListTest {
    protected List<Integer> myList;

    @Before
    public void setUp() throws Exception {
         myList = new MyArrayList<Integer>();
         myList.add(1);
         myList.add(2);
         myList.add(3);
    }

    @Test
    public void testMyList() {
        assertThat(myList.size(), is(3));
    }

    @Test
    public void testAddT() {
        for(int i = 4; i <29; i++) {
            myList.add(i);
        }
        assertThat(myList.get(18), is(19));
    }

    @Test
    public void testGet() {
        assertThat(myList.get(2), is(3));
    }

    @Test
    public void testSet() {
        Integer val = myList.set(1, 5);
        assertThat(val, is(2));

        val = myList.set(0,6);
        assertThat(val, is(1));

        val = myList.set(2, 7);
        assertThat(val, is(3));

        assertThat(myList.get(0), is(6));
        assertThat(myList.get(1), is(5));
        assertThat(myList.get(2), is(7));

        try{
            myList.set(-4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Good");
        }
    }
}
