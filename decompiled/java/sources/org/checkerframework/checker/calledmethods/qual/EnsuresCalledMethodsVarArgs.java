package org.checkerframework.checker.calledmethods.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
/* loaded from: /root/release/classes2.dex */
public @interface EnsuresCalledMethodsVarArgs {
    String[] value();
}
