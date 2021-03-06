package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zze<TResult> implements zzf<TResult> {
    private final Executor zzbDK;
    private OnSuccessListener<? super TResult> zzbLB;
    private final Object zzrN = new Object();

    public zze(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzbDK = executor;
        this.zzbLB = onSuccessListener;
    }

    public void onComplete(final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzrN) {
                if (this.zzbLB == null) {
                    return;
                }
                this.zzbDK.execute(new Runnable(this) {
                    final /* synthetic */ zze zzbLC;

                    public void run() {
                        synchronized (this.zzbLC.zzrN) {
                            if (this.zzbLC.zzbLB != null) {
                                this.zzbLC.zzbLB.onSuccess(task.getResult());
                            }
                        }
                    }
                });
            }
        }
    }
}
