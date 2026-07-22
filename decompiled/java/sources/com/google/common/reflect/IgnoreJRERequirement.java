package com.google.common.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
@interface IgnoreJRERequirement {
}
