package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    public static void awaitTerminationUninterruptibly(ExecutorService executorService) {
        Verify.verify(awaitTerminationUninterruptibly(executorService, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    }

    public static boolean awaitTerminationUninterruptibly(ExecutorService executorService, long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z3 = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static boolean awaitUninterruptibly(Condition condition, long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return condition.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> future) {
        V v3;
        boolean z3 = false;
        while (true) {
            try {
                v3 = future.get();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return v3;
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> future, long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return future.get(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void joinUninterruptibly(Thread thread) {
        boolean z3 = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
    }

    public static void joinUninterruptibly(Thread thread, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            long nanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = nanoTime - System.nanoTime();
                }
            }
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e3) {
        boolean z3 = false;
        while (true) {
            try {
                blockingQueue.put(e3);
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepUninterruptibly(long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            long nanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.sleep(nanos);
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = nanoTime - System.nanoTime();
                }
            }
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E take;
        boolean z3 = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i3, long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return semaphore.tryAcquire(i3, nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j3, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j3, timeUnit);
    }

    public static boolean tryLockUninterruptibly(Lock lock, long j3, TimeUnit timeUnit) {
        boolean z3 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z3 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return lock.tryLock(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
