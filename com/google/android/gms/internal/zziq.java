package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedList;
import java.util.List;

@zzmb
class zziq {
    private final List<zza> zztf = new LinkedList();

    interface zza {
        void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException;
    }

    class C05661 extends com.google.android.gms.internal.zzel.zza {
        final /* synthetic */ zziq zzIl;

        class C05611 implements zza {
            C05611(C05661 c05661) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdClosed();
                }
                zzv.zzcY().zzgj();
            }
        }

        class C05633 implements zza {
            C05633(C05661 c05661) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdLeftApplication();
                }
            }
        }

        class C05644 implements zza {
            C05644(C05661 c05661) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdLoaded();
                }
            }
        }

        class C05655 implements zza {
            C05655(C05661 c05661) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdOpened();
                }
            }
        }

        C05661(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onAdClosed() throws RemoteException {
            this.zzIl.zztf.add(new C05611(this));
        }

        public void onAdFailedToLoad(final int i) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                    if (com_google_android_gms_internal_zzir.zzti != null) {
                        com_google_android_gms_internal_zzir.zzti.onAdFailedToLoad(i);
                    }
                }
            });
            zzpe.m11v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzIl.zztf.add(new C05633(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzIl.zztf.add(new C05644(this));
            zzpe.m11v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzIl.zztf.add(new C05655(this));
        }
    }

    class C05682 extends com.google.android.gms.internal.zzer.zza {
        final /* synthetic */ zziq zzIl;

        C05682(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onAppEvent(final String str, final String str2) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                    if (com_google_android_gms_internal_zzir.zzIt != null) {
                        com_google_android_gms_internal_zzir.zzIt.onAppEvent(str, str2);
                    }
                }
            });
        }
    }

    class C05703 extends com.google.android.gms.internal.zzkz.zza {
        final /* synthetic */ zziq zzIl;

        C05703(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void zza(final zzky com_google_android_gms_internal_zzky) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                    if (com_google_android_gms_internal_zzir.zzIu != null) {
                        com_google_android_gms_internal_zzir.zzIu.zza(com_google_android_gms_internal_zzky);
                    }
                }
            });
        }
    }

    class C05724 extends com.google.android.gms.internal.zzgj.zza {
        final /* synthetic */ zziq zzIl;

        C05724(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void zza(final zzgi com_google_android_gms_internal_zzgi) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                    if (com_google_android_gms_internal_zzir.zzIv != null) {
                        com_google_android_gms_internal_zzir.zzIv.zza(com_google_android_gms_internal_zzgi);
                    }
                }
            });
        }
    }

    class C05745 extends com.google.android.gms.internal.zzek.zza {
        final /* synthetic */ zziq zzIl;

        class C05731 implements zza {
            C05731(C05745 c05745) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIw != null) {
                    com_google_android_gms_internal_zzir.zzIw.onAdClicked();
                }
            }
        }

        C05745(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onAdClicked() throws RemoteException {
            this.zzIl.zztf.add(new C05731(this));
        }
    }

    class C05826 extends com.google.android.gms.internal.zznt.zza {
        final /* synthetic */ zziq zzIl;

        class C05751 implements zza {
            C05751(C05826 c05826) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdLoaded();
                }
            }
        }

        class C05762 implements zza {
            C05762(C05826 c05826) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdOpened();
                }
            }
        }

        class C05773 implements zza {
            C05773(C05826 c05826) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoStarted();
                }
            }
        }

        class C05784 implements zza {
            C05784(C05826 c05826) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdClosed();
                }
            }
        }

        class C05806 implements zza {
            C05806(C05826 c05826) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdLeftApplication();
                }
            }
        }

        C05826(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            this.zzIl.zztf.add(new C05784(this));
        }

        public void onRewardedVideoAdFailedToLoad(final int i) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                    if (com_google_android_gms_internal_zzir.zzIx != null) {
                        com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdFailedToLoad(i);
                    }
                }
            });
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            this.zzIl.zztf.add(new C05806(this));
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            this.zzIl.zztf.add(new C05751(this));
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            this.zzIl.zztf.add(new C05762(this));
        }

        public void onRewardedVideoStarted() throws RemoteException {
            this.zzIl.zztf.add(new C05773(this));
        }

        public void zza(final zznq com_google_android_gms_internal_zznq) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                    if (com_google_android_gms_internal_zzir.zzIx != null) {
                        com_google_android_gms_internal_zzir.zzIx.zza(com_google_android_gms_internal_zznq);
                    }
                }
            });
        }
    }

    zziq() {
    }

    void zza(final zzir com_google_android_gms_internal_zzir) {
        Handler handler = zzpi.zzWR;
        for (final zza com_google_android_gms_internal_zziq_zza : this.zztf) {
            handler.post(new Runnable(this) {
                public void run() {
                    try {
                        com_google_android_gms_internal_zziq_zza.zzb(com_google_android_gms_internal_zzir);
                    } catch (Throwable e) {
                        zzpy.zzc("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
        this.zztf.clear();
    }

    void zzc(zzl com_google_android_gms_ads_internal_zzl) {
        com_google_android_gms_ads_internal_zzl.zza(new C05661(this));
        com_google_android_gms_ads_internal_zzl.zza(new C05682(this));
        com_google_android_gms_ads_internal_zzl.zza(new C05703(this));
        com_google_android_gms_ads_internal_zzl.zza(new C05724(this));
        com_google_android_gms_ads_internal_zzl.zza(new C05745(this));
        com_google_android_gms_ads_internal_zzl.zza(new C05826(this));
    }
}
