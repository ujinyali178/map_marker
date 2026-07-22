package javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: /root/release/classes.dex */
public @interface Named {
    String value() default "";
}
