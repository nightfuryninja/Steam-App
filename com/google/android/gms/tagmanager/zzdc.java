package com.google.android.gms.tagmanager;

class zzdc extends zzdb {
    private static final Object zzbFZ = new Object();
    private static zzdc zzbGl;
    private boolean connected = true;
    private zzaw zzbGb;
    private volatile zzau zzbGc;
    private int zzbGd = 1800000;
    private boolean zzbGe = true;
    private boolean zzbGf = false;
    private boolean zzbGg = true;
    private zzax zzbGh = new C07841(this);
    private boolean zzbGk = false;

    class C07841 implements zzax {
        final /* synthetic */ zzdc zzbGm;

        C07841(zzdc com_google_android_gms_tagmanager_zzdc) {
            this.zzbGm = com_google_android_gms_tagmanager_zzdc;
        }
    }

    class C07852 implements Runnable {
        final /* synthetic */ zzdc zzbGm;

        C07852(zzdc com_google_android_gms_tagmanager_zzdc) {
            this.zzbGm = com_google_android_gms_tagmanager_zzdc;
        }

        public void run() {
            this.zzbGm.zzbGb;
        }
    }

    private zzdc() {
    }

    public static zzdc zzPT() {
        if (zzbGl == null) {
            zzbGl = new zzdc();
        }
        return zzbGl;
    }

    public synchronized void dispatch() {
        if (this.zzbGf) {
            zzau com_google_android_gms_tagmanager_zzau = this.zzbGc;
            C07852 c07852 = new C07852(this);
        } else {
            zzbo.m13v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbGe = true;
        }
    }
}
