package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes2.dex */
public class ObservableInputStream extends ProxyInputStream {
    private final List<Observer> observers;

    public static abstract class Observer {
        void closed() {
        }

        void data(int i3) {
        }

        void data(byte[] bArr, int i3, int i4) {
        }

        void error(IOException iOException) {
            throw iOException;
        }

        void finished() {
        }
    }

    public ObservableInputStream(InputStream inputStream) {
        super(inputStream);
        this.observers = new ArrayList();
    }

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
            e = null;
        } catch (IOException e3) {
            e = e3;
        }
        if (e == null) {
            noteClosed();
        } else {
            noteError(e);
        }
    }

    public void consume() {
        while (read(new byte[8192]) != -1) {
        }
    }

    protected List<Observer> getObservers() {
        return this.observers;
    }

    protected void noteClosed() {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().closed();
        }
    }

    protected void noteDataByte(int i3) {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().data(i3);
        }
    }

    protected void noteDataBytes(byte[] bArr, int i3, int i4) {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().data(bArr, i3, i4);
        }
    }

    protected void noteError(IOException iOException) {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().error(iOException);
        }
    }

    protected void noteFinished() {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().finished();
        }
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i3;
        try {
            i3 = super.read();
            e = null;
        } catch (IOException e3) {
            e = e3;
            i3 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i3 == -1) {
            noteFinished();
        } else {
            noteDataByte(i3);
        }
        return i3;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int i3;
        try {
            i3 = super.read(bArr);
            e = null;
        } catch (IOException e3) {
            e = e3;
            i3 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i3 == -1) {
            noteFinished();
        } else if (i3 > 0) {
            noteDataBytes(bArr, 0, i3);
        }
        return i3;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        int i5;
        try {
            i5 = super.read(bArr, i3, i4);
            e = null;
        } catch (IOException e3) {
            e = e3;
            i5 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i5 == -1) {
            noteFinished();
        } else if (i5 > 0) {
            noteDataBytes(bArr, i3, i5);
        }
        return i5;
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void removeAllObservers() {
        this.observers.clear();
    }
}
