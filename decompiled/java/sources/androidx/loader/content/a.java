package androidx.loader.content;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: /root/release/classes.dex */
public abstract class a<D> extends b<D> {
    private static final boolean DEBUG = false;
    private static final String TAG = "AsyncTaskLoader";
    private volatile a<D>.RunnableC0030a mCancellingTask;
    private Executor mExecutor;
    private Handler mHandler;
    private long mLastLoadCompleteTime;
    private volatile a<D>.RunnableC0030a mTask;
    private long mUpdateThrottle;

    /* renamed from: androidx.loader.content.a$a, reason: collision with other inner class name */
    final class RunnableC0030a extends c<D> implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        boolean f1359i;

        RunnableC0030a() {
        }

        @Override // androidx.loader.content.c
        protected D b() {
            return (D) a.this.onLoadInBackground();
        }

        @Override // androidx.loader.content.c
        protected void g(D d3) {
            a.this.dispatchOnCancelled(this, d3);
        }

        @Override // androidx.loader.content.c
        protected void h(D d3) {
            a.this.dispatchOnLoadComplete(this, d3);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1359i = false;
            a.this.executePendingTask();
        }
    }

    public a(Context context) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(a<D>.RunnableC0030a runnableC0030a, D d3) {
        onCanceled(d3);
        if (this.mCancellingTask == runnableC0030a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(a<D>.RunnableC0030a runnableC0030a, D d3) {
        if (this.mTask != runnableC0030a) {
            dispatchOnCancelled(runnableC0030a, d3);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d3);
            return;
        }
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(d3);
    }

    @Override // androidx.loader.content.b
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f1359i);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f1359i);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            printWriter.print(DateUtils.formatElapsedTime(timeUnit.toSeconds(this.mUpdateThrottle)));
            printWriter.print(" mLastLoadCompleteTime=");
            if (this.mLastLoadCompleteTime == -10000) {
                str2 = "--";
            } else {
                str2 = "-" + DateUtils.formatElapsedTime(timeUnit.toSeconds(SystemClock.uptimeMillis() - this.mLastLoadCompleteTime));
            }
            printWriter.print(str2);
            printWriter.println();
        }
    }

    void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        if (this.mTask.f1359i) {
            this.mTask.f1359i = false;
            this.mHandler.removeCallbacks(this.mTask);
        }
        if (this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.f1359i = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        } else {
            if (this.mExecutor == null) {
                this.mExecutor = getExecutor();
            }
            this.mTask.c(this.mExecutor);
        }
    }

    protected Executor getExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    @Override // androidx.loader.content.b
    protected boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!isStarted()) {
            onContentChanged();
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f1359i) {
                this.mTask.f1359i = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        }
        if (this.mTask.f1359i) {
            this.mTask.f1359i = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        }
        boolean a4 = this.mTask.a(false);
        if (a4) {
            this.mCancellingTask = this.mTask;
            cancelLoadInBackground();
        }
        this.mTask = null;
        return a4;
    }

    public void onCanceled(D d3) {
    }

    @Override // androidx.loader.content.b
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0030a();
        executePendingTask();
    }

    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j3) {
        this.mUpdateThrottle = j3;
        if (j3 != 0) {
            this.mHandler = new Handler();
        }
    }
}
