package com.java.reference;

/**
 * java提供了4中引用类型，默认支持强引用模式。
 * Reference：强引用，就算出现了OOM，也不会对该对象进行回收。因此强引用是造成内存泄漏的主要原因
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        // 这样定义默认就是强引用
        Object o1 = new Object();
        // o2引用赋值
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o2);
    }
}
