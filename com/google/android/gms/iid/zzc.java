package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzc {
    static String zzbhq = null;
    static int zzbhr = 0;
    static int zzbhs = 0;
    static int zzbht = 0;
    PendingIntent zzbga;
    Messenger zzbge;
    int zzbhA;
    long zzbhB;
    Map<String, Object> zzbhu = new HashMap();
    Messenger zzbhv;
    MessengerCompat zzbhw;
    long zzbhx;
    long zzbhy;
    int zzbhz;
    Context zzqr;

    public zzc(Context context) {
        this.zzqr = context;
    }

    private void zzG(Object obj) {
        synchronized (getClass()) {
            for (String str : this.zzbhu.keySet()) {
                Object obj2 = this.zzbhu.get(str);
                this.zzbhu.put(str, obj);
                zzh(obj2, obj);
            }
        }
    }

    public static synchronized String zzGz() {
        String num;
        synchronized (zzc.class) {
            int i = zzbht;
            zzbht = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    static String zza(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = InstanceID.zzv(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private Intent zzb(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzGz = zzGz();
        synchronized (getClass()) {
            this.zzbhu.put(zzGz, conditionVariable);
        }
        zza(bundle, keyPair, zzGz);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.zzbhu.remove(zzGz);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static String zzbi(Context context) {
        ApplicationInfo applicationInfo;
        if (zzbhq != null) {
            return zzbhq;
        }
        zzbhr = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo2.uid);
                    zzbhs = applicationInfo2.uid;
                    zzbhq = resolveInfo.serviceInfo.packageName;
                    return zzbhq;
                } catch (NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(resolveInfo.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
            zzbhq = applicationInfo.packageName;
            zzbhs = applicationInfo.uid;
            return zzbhq;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                zzbhq = applicationInfo.packageName;
                zzbhs = applicationInfo.uid;
                return zzbhq;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    private static int zzbj(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzbi(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private void zzeJ(String str) {
        if ("com.google.android.gsf".equals(zzbhq)) {
            this.zzbhz++;
            if (this.zzbhz >= 3) {
                if (this.zzbhz == 3) {
                    this.zzbhA = new Random().nextInt(1000) + 1000;
                }
                this.zzbhA *= 2;
                this.zzbhB = SystemClock.elapsedRealtime() + ((long) this.zzbhA);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.zzbhA).toString());
            }
        }
    }

    private void zzh(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void zzi(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzbhu.get(str);
            this.zzbhu.put(str, obj);
            zzh(obj2, obj);
        }
    }

    void zzGy() {
        if (this.zzbge == null) {
            zzbi(this.zzqr);
            this.zzbge = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ zzc zzbhC;

                public void handleMessage(Message message) {
                    this.zzbhC.zze(message);
                }
            });
        }
    }

    Intent zza(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent zzb = zzb(bundle, keyPair);
        return (zzb == null || !zzb.hasExtra("google.messenger")) ? zzb : zzb(bundle, keyPair);
    }

    void zza(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzbhB == 0 || elapsedRealtime > this.zzbhB) {
            zzGy();
            if (zzbhq == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.zzbhx = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzbhq);
            bundle.putString("gmsv", Integer.toString(zzbj(this.zzqr)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(InstanceID.zzbf(this.zzqr)));
            bundle.putString("app_ver_name", InstanceID.zzbg(this.zzqr));
            bundle.putString("cliv", "iid-10084000");
            bundle.putString("appid", InstanceID.zza(keyPair));
            bundle.putString("pub2", InstanceID.zzv(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", zza(keyPair, this.zzqr.getPackageName(), r1));
            intent.putExtras(bundle);
            zzs(intent);
            zzb(intent, str);
            return;
        }
        elapsedRealtime = this.zzbhB - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.zzbhA);
        throw new IOException("RETRY_LATER");
    }

    protected void zzb(Intent intent, String str) {
        this.zzbhx = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(zzbhq);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            stringExtra = String.valueOf(intent.getExtras());
            new StringBuilder(String.valueOf(stringExtra).length() + 8).append("Sending ").append(stringExtra).toString();
        }
        if (this.zzbhv != null) {
            intent.putExtra("google.messenger", this.zzbge);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.zzbhv.send(obtain);
                return;
            } catch (RemoteException e) {
                Log.isLoggable("InstanceID/Rpc", 3);
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.zzqr.getPackageName());
            intent2.putExtra("GSF", intent);
            this.zzqr.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.zzbge);
        intent.putExtra("messenger2", "1");
        if (this.zzbhw != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.zzbhw.send(obtain2);
                return;
            } catch (RemoteException e2) {
                Log.isLoggable("InstanceID/Rpc", 3);
            }
        }
        this.zzqr.startService(intent);
    }

    public void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzbhw = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzbhv = (Messenger) parcelableExtra;
                    }
                }
                zzv((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    synchronized void zzs(Intent intent) {
        if (this.zzbga == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzbga = PendingIntent.getBroadcast(this.zzqr, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzbga);
    }

    String zzt(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void zzu(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                valueOf2 = new String(valueOf);
            }
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str = "InstanceID/Rpc";
                String str2 = "Unexpected structured response ";
                stringExtra = String.valueOf(stringExtra);
                Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
            }
            if (split.length > 2) {
                stringExtra = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                stringExtra = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf = stringExtra;
            stringExtra = null;
        }
        if (stringExtra == null) {
            zzG(valueOf);
        } else {
            zzi(stringExtra, valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.zzbhy = SystemClock.elapsedRealtime();
            this.zzbhA = ((int) longExtra) * 1000;
            this.zzbhB = SystemClock.elapsedRealtime() + ((long) this.zzbhA);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.zzbhA);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            zzeJ(valueOf);
        }
    }

    public void zzv(Intent intent) {
        if (intent == null) {
            Log.isLoggable("InstanceID/Rpc", 3);
            return;
        }
        String action = intent.getAction();
        String stringExtra;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            action = intent.getStringExtra("registration_id");
            stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
            if (stringExtra == null) {
                zzu(intent);
                return;
            }
            this.zzbhx = SystemClock.elapsedRealtime();
            this.zzbhB = 0;
            this.zzbhz = 0;
            this.zzbhA = 0;
            action = null;
            if (stringExtra.startsWith("|")) {
                String[] split = stringExtra.split("\\|");
                if (!"ID".equals(split[1])) {
                    String str = "InstanceID/Rpc";
                    String str2 = "Unexpected structured response ";
                    action = String.valueOf(stringExtra);
                    Log.w(str, action.length() != 0 ? str2.concat(action) : new String(str2));
                }
                stringExtra = split[2];
                if (split.length > 4) {
                    if ("SYNC".equals(split[3])) {
                        InstanceIDListenerService.zzbh(this.zzqr);
                    } else if ("RST".equals(split[3])) {
                        InstanceIDListenerService.zza(this.zzqr, InstanceID.getInstance(this.zzqr).zzGv());
                        intent.removeExtra("registration_id");
                        zzi(stringExtra, intent);
                        return;
                    }
                }
                action = split[split.length - 1];
                if (action.startsWith(":")) {
                    action = action.substring(1);
                }
                intent.putExtra("registration_id", action);
                action = stringExtra;
            }
            if (action == null) {
                zzG(intent);
            } else {
                zzi(action, intent);
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            action = "Unexpected response ";
            stringExtra = String.valueOf(intent.getAction());
            if (stringExtra.length() != 0) {
                action.concat(stringExtra);
            } else {
                stringExtra = new String(action);
            }
        }
    }
}
