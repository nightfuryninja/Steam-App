package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class zzazk {

    class C03681 implements Runnable {
        final /* synthetic */ Editor zzbGo;

        C03681(Editor editor) {
            this.zzbGo = editor;
        }

        public void run() {
            this.zzbGo.commit();
        }
    }

    public static void zza(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C03681(editor)).start();
        }
    }
}
