package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzaps;
import java.util.concurrent.Callable;

public abstract class zza<T> {

    public static class zza extends zza<Boolean> {

        class C02631 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences zzaWM;
            final /* synthetic */ String zzaWN;
            final /* synthetic */ Boolean zzaWO;

            C02631(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.zzaWM = sharedPreferences;
                this.zzaWN = str;
                this.zzaWO = bool;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzkt();
            }

            public Boolean zzkt() {
                return Boolean.valueOf(this.zzaWM.getBoolean(this.zzaWN, this.zzaWO.booleanValue()));
            }
        }

        public static Boolean zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) zzaps.zzb(new C02631(sharedPreferences, str, bool));
        }
    }

    public static class zzb extends zza<Integer> {

        class C02641 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences zzaWM;
            final /* synthetic */ String zzaWN;
            final /* synthetic */ Integer zzaWP;

            C02641(SharedPreferences sharedPreferences, String str, Integer num) {
                this.zzaWM = sharedPreferences;
                this.zzaWN = str;
                this.zzaWP = num;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzCS();
            }

            public Integer zzCS() {
                return Integer.valueOf(this.zzaWM.getInt(this.zzaWN, this.zzaWP.intValue()));
            }
        }

        public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) zzaps.zzb(new C02641(sharedPreferences, str, num));
        }
    }

    public static class zzc extends zza<Long> {

        class C02651 implements Callable<Long> {
            final /* synthetic */ SharedPreferences zzaWM;
            final /* synthetic */ String zzaWN;
            final /* synthetic */ Long zzaWQ;

            C02651(SharedPreferences sharedPreferences, String str, Long l) {
                this.zzaWM = sharedPreferences;
                this.zzaWN = str;
                this.zzaWQ = l;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzCT();
            }

            public Long zzCT() {
                return Long.valueOf(this.zzaWM.getLong(this.zzaWN, this.zzaWQ.longValue()));
            }
        }

        public static Long zza(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) zzaps.zzb(new C02651(sharedPreferences, str, l));
        }
    }

    public static class zzd extends zza<String> {

        class C02661 implements Callable<String> {
            final /* synthetic */ SharedPreferences zzaWM;
            final /* synthetic */ String zzaWN;
            final /* synthetic */ String zzaWR;

            C02661(SharedPreferences sharedPreferences, String str, String str2) {
                this.zzaWM = sharedPreferences;
                this.zzaWN = str;
                this.zzaWR = str2;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzou();
            }

            public String zzou() {
                return this.zzaWM.getString(this.zzaWN, this.zzaWR);
            }
        }

        public static String zza(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) zzaps.zzb(new C02661(sharedPreferences, str, str2));
        }
    }
}
