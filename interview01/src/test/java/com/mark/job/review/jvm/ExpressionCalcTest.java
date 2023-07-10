package com.mark.job.review.jvm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionCalcTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void test01() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        Assert.assertEquals(4, i);
        Assert.assertEquals(1, j);
        Assert.assertEquals(11, k);
    }
}