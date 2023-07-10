package com.mark.job.review.singleton;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Singleton2Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test01() {
        System.out.println("Singleton2.INSTANCE.toString() = " + Singleton2.INSTANCE);
        System.out.println("Singleton2.valueOf(\"INSTANCE\") = " + Singleton2.valueOf("INSTANCE"));
    }

    @Test(expected = IllegalArgumentException.class, timeout = 10L)
    public void test02() {
        System.out.println("Singleton2.valueOf(\"INSTANCE1\") = " + Singleton2.valueOf("INSTANCE1"));
    }

}