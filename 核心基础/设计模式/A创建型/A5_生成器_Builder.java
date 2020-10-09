package 设计模式.A创建型;/* 2020/8/31 21:52 */

import java.util.*; //import java.io.*;

public class A5_生成器_Builder {
}

/**
 * 5. 生成器（Builder）
 * Intent
 * 封装一个对象的构造过程，并允许按步骤构造。
 */

class AbstractStringBuilder {
    protected char[] value;
    protected int count;

    public AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char c) {
        ensureCapacityTnternal(count + 1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacityTnternal(int mininumCapacity) {
        if (mininumCapacity - value.length > 0) {
            expandCapacity(mininumCapacity);
        }
    }

    void expandCapacity(int mininumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - mininumCapacity < 0) {
            newCapacity = mininumCapacity;
        }
        if (newCapacity < 0) {
            if (mininumCapacity < 0) { //overflow
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}

class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}

class Client5 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            sb.append((char) ('a' + i));
        }
        System.out.println(sb.toString());
    }
}
