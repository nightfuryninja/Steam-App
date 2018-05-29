package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.common.internal.zzm.zza;
import java.util.Set;

public abstract class zzl<T extends IInterface> extends zzf<T> implements zze, zza {
    private final Account zzagg;
    private final Set<Scope> zzajm;
    private final zzg zzazs;

    class C02501 implements zzb {
        final /* synthetic */ ConnectionCallbacks zzaEu;

        C02501(ConnectionCallbacks connectionCallbacks) {
            this.zzaEu = connectionCallbacks;
        }

        public void onConnected(Bundle bundle) {
            this.zzaEu.onConnected(bundle);
        }

        public void onConnectionSuspended(int i) {
            this.zzaEu.onConnectionSuspended(i);
        }
    }

    class C02512 implements zzc {
        final /* synthetic */ OnConnectionFailedListener zzaEv;

        C02512(OnConnectionFailedListener onConnectionFailedListener) {
            this.zzaEv = onConnectionFailedListener;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.zzaEv.onConnectionFailed(connectionResult);
        }
    }

    protected zzl(Context context, Looper looper, int i, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzn.zzaC(context), GoogleApiAvailability.getInstance(), i, com_google_android_gms_common_internal_zzg, (ConnectionCallbacks) zzac.zzw(connectionCallbacks), (OnConnectionFailedListener) zzac.zzw(onConnectionFailedListener));
    }

    protected zzl(Context context, Looper looper, zzn com_google_android_gms_common_internal_zzn, GoogleApiAvailability googleApiAvailability, int i, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, com_google_android_gms_common_internal_zzn, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), com_google_android_gms_common_internal_zzg.zzxi());
        this.zzazs = com_google_android_gms_common_internal_zzg;
        this.zzagg = com_google_android_gms_common_internal_zzg.getAccount();
        this.zzajm = zzb(com_google_android_gms_common_internal_zzg.zzxf());
    }

    private static zzb zza(ConnectionCallbacks connectionCallbacks) {
        return connectionCallbacks == null ? null : new C02501(connectionCallbacks);
    }

    private static zzc zza(OnConnectionFailedListener onConnectionFailedListener) {
        return onConnectionFailedListener == null ? null : new C02512(onConnectionFailedListener);
    }

    private Set<Scope> zzb(Set<Scope> set) {
        Set<Scope> zzc = zzc(set);
        for (Scope contains : zzc) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzc;
    }

    public final Account getAccount() {
        return this.zzagg;
    }

    protected Set<Scope> zzc(Set<Scope> set) {
        return set;
    }

    protected final Set<Scope> zzwY() {
        return this.zzajm;
    }

    protected final zzg zzxp() {
        return this.zzazs;
    }
}
