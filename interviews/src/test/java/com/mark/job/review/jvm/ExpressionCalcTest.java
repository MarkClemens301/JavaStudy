package com.mark.job.review.jvm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test02() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        Assert.assertEquals(100, list.size());
        System.out.println("list = " + list);
    }
}