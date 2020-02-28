package com.nlu;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * Created by yanghuitao on 2020/2/27.
 */
public class NluContextHolder {
    private static ThreadLocal<NluContext> holder = new TransmittableThreadLocal<>();;

    public static void set(NluContext entity) {
        holder.set(entity);
    }

    public static NluContext get() {
        return holder.get();
    }

    public static void remove() {
        holder.remove();
    }


}