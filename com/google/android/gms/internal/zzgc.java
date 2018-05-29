package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzmb
public abstract class zzgc {
    @zzmb
    public static final zzgc zzFk = new C05321();
    @zzmb
    public static final zzgc zzFl = new C05332();
    @zzmb
    public static final zzgc zzFm = new C05343();

    class C05321 extends zzgc {
        C05321() {
        }

        public String zzf(String str, String str2) {
            return str2;
        }
    }

    class C05332 extends zzgc {
        C05332() {
        }

        public String zzf(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    class C05343 extends zzgc {
        C05343() {
        }

        private String zzW(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzf(String str, String str2) {
            String zzW = zzW(str);
            String zzW2 = zzW(str2);
            return TextUtils.isEmpty(zzW) ? zzW2 : TextUtils.isEmpty(zzW2) ? zzW : new StringBuilder((String.valueOf(zzW).length() + 1) + String.valueOf(zzW2).length()).append(zzW).append(",").append(zzW2).toString();
        }
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzf((String) map.get(str), str2));
    }

    public abstract String zzf(String str, String str2);
}
