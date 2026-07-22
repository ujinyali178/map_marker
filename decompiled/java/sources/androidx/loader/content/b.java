package androidx.loader.content;

import android.content.Context;
import com.google.maps.android.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /root/release/classes.dex */
public class b<D> {
    private Context mContext;
    private int mId;
    private InterfaceC0031b<D> mListener;
    private a<D> mOnLoadCanceledListener;
    private boolean mStarted = false;
    private boolean mAbandoned = false;
    private boolean mReset = true;
    private boolean mContentChanged = false;
    private boolean mProcessingChange = false;

    public interface a<D> {
        void a(b<D> bVar);
    }

    /* renamed from: androidx.loader.content.b$b, reason: collision with other inner class name */
    public interface InterfaceC0031b<D> {
        void a(b<D> bVar, D d3);
    }

    public b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d3) {
        String str;
        StringBuilder sb = new StringBuilder(64);
        if (d3 == null) {
            str = BuildConfig.TRAVIS;
        } else {
            Class<?> cls = d3.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(cls)));
            str = "}";
        }
        sb.append(str);
        return sb.toString();
    }

    public void deliverCancellation() {
        a<D> aVar = this.mOnLoadCanceledListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void deliverResult(D d3) {
        InterfaceC0031b<D> interfaceC0031b = this.mListener;
        if (interfaceC0031b != null) {
            interfaceC0031b.a(this, d3);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    protected void onAbandon() {
    }

    protected boolean onCancelLoad() {
        return false;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    protected void onForceLoad() {
    }

    protected void onReset() {
    }

    protected void onStartLoading() {
    }

    protected void onStopLoading() {
    }

    public void registerListener(int i3, InterfaceC0031b<D> interfaceC0031b) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = interfaceC0031b;
        this.mId = i3;
    }

    public void registerOnLoadCanceledListener(a<D> aVar) {
        if (this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = aVar;
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z3 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z3;
        return z3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        Class<?> cls = getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(InterfaceC0031b<D> interfaceC0031b) {
        InterfaceC0031b<D> interfaceC0031b2 = this.mListener;
        if (interfaceC0031b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0031b2 != interfaceC0031b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mListener = null;
    }

    public void unregisterOnLoadCanceledListener(a<D> aVar) {
        a<D> aVar2 = this.mOnLoadCanceledListener;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mOnLoadCanceledListener = null;
    }
}
