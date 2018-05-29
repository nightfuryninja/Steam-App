package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.Map;

@zzmb
public class zzja {
    private final Context mContext;
    private final String zzJd;
    private zzpn<zzix> zzJe;
    private zzpn<zzix> zzJf;
    private zzd zzJg;
    private int zzJh;
    private final Object zzrN;
    private final zzqa zztr;

    static class zza {
        static int zzJs = 60000;
        static int zzJt = 10000;
    }

    public static class zzb<T> implements zzpn<T> {
        public void zzd(T t) {
        }
    }

    public static class zzc extends zzqj<zzjb> {
        private final zzd zzJu;
        private boolean zzJv;
        private final Object zzrN = new Object();

        class C06021 implements com.google.android.gms.internal.zzqi.zzc<zzjb> {
            C06021(zzc com_google_android_gms_internal_zzja_zzc) {
            }

            public void zzb(zzjb com_google_android_gms_internal_zzjb) {
                zzpe.m11v("Ending javascript session.");
                ((zzjc) com_google_android_gms_internal_zzjb).zzgA();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        class C06032 implements com.google.android.gms.internal.zzqi.zzc<zzjb> {
            final /* synthetic */ zzc zzJw;

            C06032(zzc com_google_android_gms_internal_zzja_zzc) {
                this.zzJw = com_google_android_gms_internal_zzja_zzc;
            }

            public void zzb(zzjb com_google_android_gms_internal_zzjb) {
                zzpe.m11v("Releasing engine reference.");
                this.zzJw.zzJu.zzgx();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        class C06043 implements com.google.android.gms.internal.zzqi.zza {
            final /* synthetic */ zzc zzJw;

            C06043(zzc com_google_android_gms_internal_zzja_zzc) {
                this.zzJw = com_google_android_gms_internal_zzja_zzc;
            }

            public void run() {
                this.zzJw.zzJu.zzgx();
            }
        }

        public zzc(zzd com_google_android_gms_internal_zzja_zzd) {
            this.zzJu = com_google_android_gms_internal_zzja_zzd;
        }

        public void release() {
            synchronized (this.zzrN) {
                if (this.zzJv) {
                    return;
                }
                this.zzJv = true;
                zza(new C06021(this), new com.google.android.gms.internal.zzqi.zzb());
                zza(new C06032(this), new C06043(this));
            }
        }
    }

    public static class zzd extends zzqj<zzix> {
        private zzpn<zzix> zzJf;
        private boolean zzJx;
        private int zzJy;
        private final Object zzrN = new Object();

        class C06083 implements com.google.android.gms.internal.zzqi.zzc<zzix> {
            final /* synthetic */ zzd zzJA;

            C06083(zzd com_google_android_gms_internal_zzja_zzd) {
                this.zzJA = com_google_android_gms_internal_zzja_zzd;
            }

            public void zza(final zzix com_google_android_gms_internal_zzix) {
                zzv.zzcJ().runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C06083 zzJC;

                    public void run() {
                        this.zzJC.zzJA.zzJf.zzd(com_google_android_gms_internal_zzix);
                        com_google_android_gms_internal_zzix.destroy();
                    }
                });
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzix) obj);
            }
        }

        public zzd(zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix) {
            this.zzJf = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix;
            this.zzJx = false;
            this.zzJy = 0;
        }

        public zzc zzgw() {
            final zzc com_google_android_gms_internal_zzja_zzc = new zzc(this);
            synchronized (this.zzrN) {
                zza(new com.google.android.gms.internal.zzqi.zzc<zzix>(this) {
                    public void zza(zzix com_google_android_gms_internal_zzix) {
                        zzpe.m11v("Getting a new session for JS Engine.");
                        com_google_android_gms_internal_zzja_zzc.zzg(com_google_android_gms_internal_zzix.zzgt());
                    }

                    public /* synthetic */ void zzd(Object obj) {
                        zza((zzix) obj);
                    }
                }, new com.google.android.gms.internal.zzqi.zza(this) {
                    public void run() {
                        zzpe.m11v("Rejecting reference for JS Engine.");
                        com_google_android_gms_internal_zzja_zzc.reject();
                    }
                });
                zzac.zzar(this.zzJy >= 0);
                this.zzJy++;
            }
            return com_google_android_gms_internal_zzja_zzc;
        }

        protected void zzgx() {
            boolean z = true;
            synchronized (this.zzrN) {
                if (this.zzJy < 1) {
                    z = false;
                }
                zzac.zzar(z);
                zzpe.m11v("Releasing 1 reference for JS Engine");
                this.zzJy--;
                zzgz();
            }
        }

        public void zzgy() {
            boolean z = true;
            synchronized (this.zzrN) {
                if (this.zzJy < 0) {
                    z = false;
                }
                zzac.zzar(z);
                zzpe.m11v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzJx = true;
                zzgz();
            }
        }

        protected void zzgz() {
            synchronized (this.zzrN) {
                zzac.zzar(this.zzJy >= 0);
                if (this.zzJx && this.zzJy == 0) {
                    zzpe.m11v("No reference is left (including root). Cleaning up engine.");
                    zza(new C06083(this), new com.google.android.gms.internal.zzqi.zzb());
                } else {
                    zzpe.m11v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public static class zze extends zzqj<zzjb> {
        private zzc zzJD;

        public zze(zzc com_google_android_gms_internal_zzja_zzc) {
            this.zzJD = com_google_android_gms_internal_zzja_zzc;
        }

        public void finalize() {
            this.zzJD.release();
            this.zzJD = null;
        }

        public int getStatus() {
            return this.zzJD.getStatus();
        }

        public void reject() {
            this.zzJD.reject();
        }

        public void zza(com.google.android.gms.internal.zzqi.zzc<zzjb> com_google_android_gms_internal_zzqi_zzc_com_google_android_gms_internal_zzjb, com.google.android.gms.internal.zzqi.zza com_google_android_gms_internal_zzqi_zza) {
            this.zzJD.zza(com_google_android_gms_internal_zzqi_zzc_com_google_android_gms_internal_zzjb, com_google_android_gms_internal_zzqi_zza);
        }

        public void zzf(zzjb com_google_android_gms_internal_zzjb) {
            this.zzJD.zzg(com_google_android_gms_internal_zzjb);
        }

        public /* synthetic */ void zzg(Object obj) {
            zzf((zzjb) obj);
        }
    }

    public zzja(Context context, zzqa com_google_android_gms_internal_zzqa, String str) {
        this.zzrN = new Object();
        this.zzJh = 1;
        this.zzJd = str;
        this.mContext = context.getApplicationContext();
        this.zztr = com_google_android_gms_internal_zzqa;
        this.zzJe = new zzb();
        this.zzJf = new zzb();
    }

    public zzja(Context context, zzqa com_google_android_gms_internal_zzqa, String str, zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix, zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix2) {
        this(context, com_google_android_gms_internal_zzqa, str);
        this.zzJe = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix;
        this.zzJf = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix2;
    }

    private zzd zza(final zzav com_google_android_gms_internal_zzav) {
        final zzd com_google_android_gms_internal_zzja_zzd = new zzd(this.zzJf);
        zzv.zzcJ().runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzja zzJk;

            public void run() {
                final zzix zza = this.zzJk.zza(this.zzJk.mContext, this.zzJk.zztr, com_google_android_gms_internal_zzav);
                zza.zza(new com.google.android.gms.internal.zzix.zza(this) {
                    final /* synthetic */ C05991 zzJm;

                    class C05931 implements Runnable {
                        final /* synthetic */ C05941 zzJn;

                        class C05921 implements Runnable {
                            final /* synthetic */ C05931 zzJo;

                            C05921(C05931 c05931) {
                                this.zzJo = c05931;
                            }

                            public void run() {
                                zza.destroy();
                            }
                        }

                        C05931(C05941 c05941) {
                            this.zzJn = c05941;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.zzJn;
                            r0 = r0.zzJm;
                            r0 = r0.zzJk;
                            r1 = r0.zzrN;
                            monitor-enter(r1);
                            r0 = r3.zzJn;	 Catch:{ all -> 0x0043 }
                            r0 = r0.zzJm;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x0043 }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.zzJn;	 Catch:{ all -> 0x0043 }
                            r0 = r0.zzJm;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x0043 }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.zzJn;	 Catch:{ all -> 0x0043 }
                            r0 = r0.zzJm;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0.reject();	 Catch:{ all -> 0x0043 }
                            r0 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x0043 }
                            r2 = new com.google.android.gms.internal.zzja$1$1$1$1;	 Catch:{ all -> 0x0043 }
                            r2.<init>(r3);	 Catch:{ all -> 0x0043 }
                            r0.runOnUiThread(r2);	 Catch:{ all -> 0x0043 }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.internal.zzpe.m11v(r0);	 Catch:{ all -> 0x0043 }
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            goto L_0x0026;
                        L_0x0043:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.1.1.1.run():void");
                        }
                    }

                    public void zzgu() {
                        zzpi.zzWR.postDelayed(new C05931(this), (long) zza.zzJt);
                    }
                });
                zza.zza("/jsLoaded", new zzhx(this) {
                    final /* synthetic */ C05991 zzJm;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zza(com.google.android.gms.internal.zzqp r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.zzJm;
                        r0 = r0.zzJk;
                        r1 = r0.zzrN;
                        monitor-enter(r1);
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJk;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.zzJh = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJk;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJe;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzd(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzg(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJk;	 Catch:{ all -> 0x0051 }
                        r2 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzJg = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.internal.zzpe.m11v(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.1.2.zza(com.google.android.gms.internal.zzqp, java.util.Map):void");
                    }
                });
                final zzpu com_google_android_gms_internal_zzpu = new zzpu();
                zzhx c05963 = new zzhx(this) {
                    final /* synthetic */ C05991 zzJm;

                    public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                        synchronized (this.zzJm.zzJk.zzrN) {
                            zzpy.zzbd("JS Engine is requesting an update");
                            if (this.zzJm.zzJk.zzJh == 0) {
                                zzpy.zzbd("Starting reload.");
                                this.zzJm.zzJk.zzJh = 2;
                                this.zzJm.zzJk.zzb(com_google_android_gms_internal_zzav);
                            }
                            zza.zzb("/requestReload", (zzhx) com_google_android_gms_internal_zzpu.get());
                        }
                    }
                };
                com_google_android_gms_internal_zzpu.set(c05963);
                zza.zza("/requestReload", c05963);
                if (this.zzJk.zzJd.endsWith(".js")) {
                    zza.zzal(this.zzJk.zzJd);
                } else if (this.zzJk.zzJd.startsWith("<html>")) {
                    zza.zzan(this.zzJk.zzJd);
                } else {
                    zza.zzam(this.zzJk.zzJd);
                }
                zzpi.zzWR.postDelayed(new Runnable(this) {
                    final /* synthetic */ C05991 zzJm;

                    class C05971 implements Runnable {
                        final /* synthetic */ C05984 zzJq;

                        C05971(C05984 c05984) {
                            this.zzJq = c05984;
                        }

                        public void run() {
                            zza.destroy();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.zzJm;
                        r0 = r0.zzJk;
                        r1 = r0.zzrN;
                        monitor-enter(r1);
                        r0 = r3.zzJm;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x003b }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x003b }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0.reject();	 Catch:{ all -> 0x003b }
                        r0 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x003b }
                        r2 = new com.google.android.gms.internal.zzja$1$4$1;	 Catch:{ all -> 0x003b }
                        r2.<init>(r3);	 Catch:{ all -> 0x003b }
                        r0.runOnUiThread(r2);	 Catch:{ all -> 0x003b }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.internal.zzpe.m11v(r0);	 Catch:{ all -> 0x003b }
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        goto L_0x0020;
                    L_0x003b:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.1.4.run():void");
                    }
                }, (long) zza.zzJs);
            }
        });
        return com_google_android_gms_internal_zzja_zzd;
    }

    protected zzix zza(Context context, zzqa com_google_android_gms_internal_zzqa, zzav com_google_android_gms_internal_zzav) {
        return new zziz(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzav, null);
    }

    protected zzd zzb(zzav com_google_android_gms_internal_zzav) {
        final zzd zza = zza(com_google_android_gms_internal_zzav);
        zza.zza(new com.google.android.gms.internal.zzqi.zzc<zzix>(this) {
            final /* synthetic */ zzja zzJk;

            public void zza(zzix com_google_android_gms_internal_zzix) {
                synchronized (this.zzJk.zzrN) {
                    this.zzJk.zzJh = 0;
                    if (!(this.zzJk.zzJg == null || zza == this.zzJk.zzJg)) {
                        zzpe.m11v("New JS engine is loaded, marking previous one as destroyable.");
                        this.zzJk.zzJg.zzgy();
                    }
                    this.zzJk.zzJg = zza;
                }
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzix) obj);
            }
        }, new com.google.android.gms.internal.zzqi.zza(this) {
            final /* synthetic */ zzja zzJk;

            public void run() {
                synchronized (this.zzJk.zzrN) {
                    this.zzJk.zzJh = 1;
                    zzpe.m11v("Failed loading new engine. Marking new engine destroyable.");
                    zza.zzgy();
                }
            }
        });
        return zza;
    }

    public zzc zzc(zzav com_google_android_gms_internal_zzav) {
        zzc zzgw;
        synchronized (this.zzrN) {
            if (this.zzJg == null || this.zzJg.getStatus() == -1) {
                this.zzJh = 2;
                this.zzJg = zzb(com_google_android_gms_internal_zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 0) {
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 1) {
                this.zzJh = 2;
                zzb(com_google_android_gms_internal_zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 2) {
                zzgw = this.zzJg.zzgw();
            } else {
                zzgw = this.zzJg.zzgw();
            }
        }
        return zzgw;
    }

    public zzc zzgv() {
        return zzc(null);
    }
}
