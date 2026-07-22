package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /root/release/classes.dex */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}
