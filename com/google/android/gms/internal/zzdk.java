package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzda.zzb;

@zzmb
public class zzdk {
    private Context mContext;
    private final Object zzrN = new Object();
    private final Runnable zzys = new C05091(this);
    private zzdn zzyt;
    private zzdr zzyu;

    class C05091 implements Runnable {
        final /* synthetic */ zzdk zzyv;

        C05091(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void run() {
            this.zzyv.disconnect();
        }
    }

    class C05102 implements zzb {
        final /* synthetic */ zzdk zzyv;

        C05102(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void zzk(boolean z) {
            if (z) {
                this.zzyv.connect();
            } else {
                this.zzyv.disconnect();
            }
        }
    }

    class C05113 implements zzf.zzb {
        final /* synthetic */ zzdk zzyv;

        C05113(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void onConnected(Bundle bundle) {
            synchronized (this.zzyv.zzrN) {
                try {
                    this.zzyv.zzyu = this.zzyv.zzyt.zzew();
                } catch (Throwable e) {
                    zzpy.zzb("Unable to obtain a cache service instance.", e);
                    this.zzyv.disconnect();
                }
                this.zzyv.zzrN.notifyAll();
            }
        }

        public void onConnectionSuspended(int i) {
            synchronized (this.zzyv.zzrN) {
                this.zzyv.zzyt = null;
                this.zzyv.zzyu = null;
                this.zzyv.zzrN.notifyAll();
                zzv.zzcZ().zzkD();
            }
        }
    }

    class C05124 implements zzc {
        final /* synthetic */ zzdk zzyv;

        C05124(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            synchronized (this.zzyv.zzrN) {
                this.zzyv.zzyt = null;
                this.zzyv.zzyu = null;
                this.zzyv.zzrN.notifyAll();
                zzv.zzcZ().zzkD();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connect() {
        /*
        r3 = this;
        r1 = r3.zzrN;
        monitor-enter(r1);
        r0 = r3.mContext;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.zzyt;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = new com.google.android.gms.internal.zzdk$3;	 Catch:{ all -> 0x0024 }
        r0.<init>(r3);	 Catch:{ all -> 0x0024 }
        r2 = new com.google.android.gms.internal.zzdk$4;	 Catch:{ all -> 0x0024 }
        r2.<init>(r3);	 Catch:{ all -> 0x0024 }
        r0 = r3.zza(r0, r2);	 Catch:{ all -> 0x0024 }
        r3.zzyt = r0;	 Catch:{ all -> 0x0024 }
        r0 = r3.zzyt;	 Catch:{ all -> 0x0024 }
        r0.zzwT();	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        goto L_0x000c;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdk.connect():void");
    }

    private void disconnect() {
        synchronized (this.zzrN) {
            if (this.zzyt == null) {
                return;
            }
            if (this.zzyt.isConnected() || this.zzyt.isConnecting()) {
                this.zzyt.disconnect();
            }
            this.zzyt = null;
            this.zzyu = null;
            Binder.flushPendingCommands();
            zzv.zzcZ().zzkD();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialize(android.content.Context r3) {
        /*
        r2 = this;
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = r2.zzrN;
        monitor-enter(r1);
        r0 = r2.mContext;	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        goto L_0x0002;
    L_0x000c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        throw r0;
    L_0x000f:
        r0 = r3.getApplicationContext();	 Catch:{ all -> 0x000c }
        r2.mContext = r0;	 Catch:{ all -> 0x000c }
        r0 = com.google.android.gms.internal.zzfx.zzEL;	 Catch:{ all -> 0x000c }
        r0 = r0.get();	 Catch:{ all -> 0x000c }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x000c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x0028;
    L_0x0023:
        r2.connect();	 Catch:{ all -> 0x000c }
    L_0x0026:
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        goto L_0x0002;
    L_0x0028:
        r0 = com.google.android.gms.internal.zzfx.zzEK;	 Catch:{ all -> 0x000c }
        r0 = r0.get();	 Catch:{ all -> 0x000c }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x000c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x0026;
    L_0x0036:
        r0 = new com.google.android.gms.internal.zzdk$2;	 Catch:{ all -> 0x000c }
        r0.<init>(r2);	 Catch:{ all -> 0x000c }
        r2.zza(r0);	 Catch:{ all -> 0x000c }
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdk.initialize(android.content.Context):void");
    }

    protected zzdn zza(zzf.zzb com_google_android_gms_common_internal_zzf_zzb, zzc com_google_android_gms_common_internal_zzf_zzc) {
        return new zzdn(this.mContext, zzv.zzcZ().zzkC(), com_google_android_gms_common_internal_zzf_zzb, com_google_android_gms_common_internal_zzf_zzc);
    }

    protected void zza(zzb com_google_android_gms_internal_zzda_zzb) {
        zzv.zzcM().zza(com_google_android_gms_internal_zzda_zzb);
    }

    public void zzeq() {
        if (((Boolean) zzfx.zzEM.get()).booleanValue()) {
            synchronized (this.zzrN) {
                connect();
                zzv.zzcJ();
                zzpi.zzWR.removeCallbacks(this.zzys);
                zzv.zzcJ();
                zzpi.zzWR.postDelayed(this.zzys, ((Long) zzfx.zzEN.get()).longValue());
            }
        }
    }
}
