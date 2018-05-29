package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

class zzazo {

    private static class zza {
        private static final ExecutorService zzbJl = Executors.newSingleThreadExecutor(new C03851());

        class C03851 implements ThreadFactory {
            C03851() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "google-tag-manager-background-thread");
            }
        }
    }

    private static class zzb {
        private static final ScheduledExecutorService zzbJm = Executors.newSingleThreadScheduledExecutor(new C03861());

        class C03861 implements ThreadFactory {
            C03861() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "google-tag-manager-scheduler-thread");
            }
        }
    }

    static ExecutorService zzQR() {
        return zza.zzbJl;
    }

    static ScheduledExecutorService zzQS() {
        return zzb.zzbJm;
    }
}
