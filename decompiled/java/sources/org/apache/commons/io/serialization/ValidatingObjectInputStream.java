package org.apache.commons.io.serialization;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /root/release/classes2.dex */
public class ValidatingObjectInputStream extends ObjectInputStream {
    private final List<ClassNameMatcher> acceptMatchers;
    private final List<ClassNameMatcher> rejectMatchers;

    public ValidatingObjectInputStream(InputStream inputStream) {
        super(inputStream);
        this.acceptMatchers = new ArrayList();
        this.rejectMatchers = new ArrayList();
    }

    private void validateClassName(String str) {
        Iterator<ClassNameMatcher> it = this.rejectMatchers.iterator();
        while (it.hasNext()) {
            if (it.next().matches(str)) {
                invalidClassNameFound(str);
            }
        }
        boolean z3 = false;
        Iterator<ClassNameMatcher> it2 = this.acceptMatchers.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (it2.next().matches(str)) {
                z3 = true;
                break;
            }
        }
        if (z3) {
            return;
        }
        invalidClassNameFound(str);
    }

    public ValidatingObjectInputStream accept(Pattern pattern) {
        this.acceptMatchers.add(new RegexpClassNameMatcher(pattern));
        return this;
    }

    public ValidatingObjectInputStream accept(ClassNameMatcher classNameMatcher) {
        this.acceptMatchers.add(classNameMatcher);
        return this;
    }

    public ValidatingObjectInputStream accept(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.acceptMatchers.add(new FullClassNameMatcher(cls.getName()));
        }
        return this;
    }

    public ValidatingObjectInputStream accept(String... strArr) {
        for (String str : strArr) {
            this.acceptMatchers.add(new WildcardClassNameMatcher(str));
        }
        return this;
    }

    protected void invalidClassNameFound(String str) {
        throw new InvalidClassException("Class name not accepted: " + str);
    }

    public ValidatingObjectInputStream reject(Pattern pattern) {
        this.rejectMatchers.add(new RegexpClassNameMatcher(pattern));
        return this;
    }

    public ValidatingObjectInputStream reject(ClassNameMatcher classNameMatcher) {
        this.rejectMatchers.add(classNameMatcher);
        return this;
    }

    public ValidatingObjectInputStream reject(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.rejectMatchers.add(new FullClassNameMatcher(cls.getName()));
        }
        return this;
    }

    public ValidatingObjectInputStream reject(String... strArr) {
        for (String str : strArr) {
            this.rejectMatchers.add(new WildcardClassNameMatcher(str));
        }
        return this;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        validateClassName(objectStreamClass.getName());
        return super.resolveClass(objectStreamClass);
    }
}
