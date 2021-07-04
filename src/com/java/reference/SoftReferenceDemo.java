package com.java.reference;

import java.lang.ref.SoftReference;

/**
 * SoftReference：软引用，通常在对内存敏感的程序中，比如高速缓存就有用到软引用，内存够用就保留，不够用就回收
 * =====================================================================================================================
 * 案例：一个应用需要读取大量的本地图片
 * 1、如果每次读取图片都从硬盘读取则会严重影响性能
 * 2、如果一次性全部加载到内存中又可能造成内存溢出
 * 思路：用一个HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，在内存不足时，jvm会自动回收这些缓存图片对象所占用的空间，从而有效地避免了OOM的问题。
 * Map<String, SoftReference<Bitmap>> imageCache = new HashMap<String, SoftReference<Bitmap>>();
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }

    /**
     * 内存够用的时候就保留，不够用就回收
     */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        // 软引用
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        // 手动gc
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让它内存不够用了导致OOM，看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        // 软引用
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            // 创建30M大对象
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }
}
