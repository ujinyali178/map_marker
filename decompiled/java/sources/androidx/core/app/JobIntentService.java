package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: /root/release/classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: k, reason: collision with root package name */
    static final Object f457k = new Object();

    /* renamed from: l, reason: collision with root package name */
    static final HashMap<ComponentName, h> f458l = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    b f459c;

    /* renamed from: d, reason: collision with root package name */
    h f460d;

    /* renamed from: f, reason: collision with root package name */
    a f461f;

    /* renamed from: g, reason: collision with root package name */
    boolean f462g = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f463h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f464i = false;

    /* renamed from: j, reason: collision with root package name */
    final ArrayList<d> f465j;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a4 = JobIntentService.this.a();
                if (a4 == null) {
                    return null;
                }
                JobIntentService.this.e(a4.getIntent());
                a4.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.g();
        }
    }

    interface b {
        IBinder a();

        e b();
    }

    static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        private final Context f467d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f468e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f469f;

        /* renamed from: g, reason: collision with root package name */
        boolean f470g;

        /* renamed from: h, reason: collision with root package name */
        boolean f471h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f467d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f468e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f469f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                if (this.f471h) {
                    if (this.f470g) {
                        this.f468e.acquire(60000L);
                    }
                    this.f471h = false;
                    this.f469f.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                if (!this.f471h) {
                    this.f471h = true;
                    this.f469f.acquire(600000L);
                    this.f468e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f470g = false;
            }
        }
    }

    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f472a;

        /* renamed from: b, reason: collision with root package name */
        final int f473b;

        d(Intent intent, int i3) {
            this.f472a = intent;
            this.f473b = i3;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f473b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f472a;
        }
    }

    interface e {
        void a();

        Intent getIntent();
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f475a;

        /* renamed from: b, reason: collision with root package name */
        final Object f476b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f477c;

        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f478a;

            a(JobWorkItem jobWorkItem) {
                this.f478a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f476b) {
                    JobParameters jobParameters = f.this.f477c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f478a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f478a.getIntent();
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f476b = new Object();
            this.f475a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            JobWorkItem dequeueWork;
            synchronized (this.f476b) {
                JobParameters jobParameters = this.f477c;
                if (jobParameters == null) {
                    return null;
                }
                dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                dequeueWork.getIntent().setExtrasClassLoader(this.f475a.getClassLoader());
                return new a(dequeueWork);
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f477c = jobParameters;
            this.f475a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b4 = this.f475a.b();
            synchronized (this.f476b) {
                this.f477c = null;
            }
            return b4;
        }
    }

    static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f480d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f481e;

        g(Context context, ComponentName componentName, int i3) {
            super(componentName);
            a(i3);
            this.f480d = new JobInfo.Builder(i3, this.f482a).setOverrideDeadline(0L).build();
            this.f481e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f482a;

        /* renamed from: b, reason: collision with root package name */
        boolean f483b;

        /* renamed from: c, reason: collision with root package name */
        int f484c;

        h(ComponentName componentName) {
            this.f482a = componentName;
        }

        void a(int i3) {
            if (!this.f483b) {
                this.f483b = true;
                this.f484c = i3;
            } else {
                if (this.f484c == i3) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i3 + " is different than previous " + this.f484c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        this.f465j = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList<>();
    }

    static h d(Context context, ComponentName componentName, boolean z3, int i3) {
        h cVar;
        HashMap<ComponentName, h> hashMap = f458l;
        h hVar = hashMap.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z3) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i3);
        }
        h hVar2 = cVar;
        hashMap.put(componentName, hVar2);
        return hVar2;
    }

    e a() {
        b bVar = this.f459c;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f465j) {
            if (this.f465j.size() <= 0) {
                return null;
            }
            return this.f465j.remove(0);
        }
    }

    boolean b() {
        a aVar = this.f461f;
        if (aVar != null) {
            aVar.cancel(this.f462g);
        }
        this.f463h = true;
        return f();
    }

    void c(boolean z3) {
        if (this.f461f == null) {
            this.f461f = new a();
            h hVar = this.f460d;
            if (hVar != null && z3) {
                hVar.c();
            }
            this.f461f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(Intent intent);

    public boolean f() {
        return true;
    }

    void g() {
        ArrayList<d> arrayList = this.f465j;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f461f = null;
                ArrayList<d> arrayList2 = this.f465j;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    c(false);
                } else if (!this.f464i) {
                    this.f460d.b();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f459c;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f459c = new f(this);
            this.f460d = null;
        } else {
            this.f459c = null;
            this.f460d = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f465j;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f464i = true;
                this.f460d.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        if (this.f465j == null) {
            return 2;
        }
        this.f460d.d();
        synchronized (this.f465j) {
            ArrayList<d> arrayList = this.f465j;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i4));
            c(true);
        }
        return 3;
    }
}
