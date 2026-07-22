package b1;

import java.util.List;
import z0.d0;

/* loaded from: /root/release/classes.dex */
public abstract class b implements e {
    private Boolean j(String str) {
        Object c3 = c(str);
        if (c3 instanceof Boolean) {
            return (Boolean) c3;
        }
        return null;
    }

    private String l() {
        return (String) c("sql");
    }

    private List<Object> m() {
        return (List) c("arguments");
    }

    @Override // b1.e
    public d0 d() {
        return new d0(l(), m());
    }

    @Override // b1.e
    public boolean e() {
        return Boolean.TRUE.equals(c("noResult"));
    }

    @Override // b1.e
    public Integer f() {
        return (Integer) c("transactionId");
    }

    @Override // b1.e
    public boolean g() {
        return h("transactionId") && f() == null;
    }

    @Override // b1.e
    public Boolean i() {
        return j("inTransaction");
    }

    public boolean k() {
        return Boolean.TRUE.equals(c("continueOnError"));
    }

    public String toString() {
        return getMethod() + " " + l() + " " + m();
    }
}
