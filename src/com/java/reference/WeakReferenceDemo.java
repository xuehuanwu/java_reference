package com.java.reference;

import java.lang.ref.WeakReference;

/**
 * WeakReference：弱引用，只要垃圾回收机制一运行，不够JVM内存空间是否足够，都会回收该对象占用的内存
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        // 弱引用
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
