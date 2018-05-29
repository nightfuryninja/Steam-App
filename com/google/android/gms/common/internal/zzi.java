package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.zzaax;

public abstract class zzi implements OnClickListener {

    class C02481 extends zzi {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;

        C02481(Intent intent, Activity activity, int i) {
            this.val$intent = intent;
            this.val$activity = activity;
            this.val$requestCode = i;
        }

        public void zzxm() {
            if (this.val$intent != null) {
                this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode);
            }
        }
    }

    class C02493 extends zzi {
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ zzaax zzaEh;

        C02493(Intent intent, zzaax com_google_android_gms_internal_zzaax, int i) {
            this.val$intent = intent;
            this.zzaEh = com_google_android_gms_internal_zzaax;
            this.val$requestCode = i;
        }

        @TargetApi(11)
        public void zzxm() {
            if (this.val$intent != null) {
                this.zzaEh.startActivityForResult(this.val$intent, this.val$requestCode);
            }
        }
    }

    public static zzi zza(Activity activity, Intent intent, int i) {
        return new C02481(intent, activity, i);
    }

    public static zzi zza(zzaax com_google_android_gms_internal_zzaax, Intent intent, int i) {
        return new C02493(intent, com_google_android_gms_internal_zzaax, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzxm();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }

    protected abstract void zzxm();
}
