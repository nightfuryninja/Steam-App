package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public abstract class zzft<T> {
    private final int zzAG;
    private final String zzAH;
    private final T zzAI;

    class C05241 extends zzft<Boolean> {
        C05241(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzb(sharedPreferences);
        }

        public Boolean zzb(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzfm()).booleanValue()));
        }
    }

    class C05252 extends zzft<Integer> {
        C05252(int i, String str, Integer num) {
            super(i, str, num);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzc(sharedPreferences);
        }

        public Integer zzc(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzfm()).intValue()));
        }
    }

    class C05263 extends zzft<Long> {
        C05263(int i, String str, Long l) {
            super(i, str, l);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzd(sharedPreferences);
        }

        public Long zzd(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzfm()).longValue()));
        }
    }

    class C05274 extends zzft<Float> {
        C05274(int i, String str, Float f) {
            super(i, str, f);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zze(sharedPreferences);
        }

        public Float zze(SharedPreferences sharedPreferences) {
            return Float.valueOf(sharedPreferences.getFloat(getKey(), ((Float) zzfm()).floatValue()));
        }
    }

    class C05285 extends zzft<String> {
        C05285(int i, String str, String str2) {
            super(i, str, str2);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzf(sharedPreferences);
        }

        public String zzf(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(getKey(), (String) zzfm());
        }
    }

    private zzft(int i, String str, T t) {
        this.zzAG = i;
        this.zzAH = str;
        this.zzAI = t;
        zzv.zzcU().zza(this);
    }

    public static zzft<String> zza(int i, String str) {
        zzft<String> zza = zza(i, str, null);
        zzv.zzcU().zzb(zza);
        return zza;
    }

    public static zzft<Float> zza(int i, String str, float f) {
        return new C05274(i, str, Float.valueOf(f));
    }

    public static zzft<Integer> zza(int i, String str, int i2) {
        return new C05252(i, str, Integer.valueOf(i2));
    }

    public static zzft<Long> zza(int i, String str, long j) {
        return new C05263(i, str, Long.valueOf(j));
    }

    public static zzft<Boolean> zza(int i, String str, Boolean bool) {
        return new C05241(i, str, bool);
    }

    public static zzft<String> zza(int i, String str, String str2) {
        return new C05285(i, str, str2);
    }

    public static zzft<String> zzb(int i, String str) {
        zzft<String> zza = zza(i, str, null);
        zzv.zzcU().zzc(zza);
        return zza;
    }

    public T get() {
        return zzv.zzcV().zzd(this);
    }

    public String getKey() {
        return this.zzAH;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzfm() {
        return this.zzAI;
    }
}
