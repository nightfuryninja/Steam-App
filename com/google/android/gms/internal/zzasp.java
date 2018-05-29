package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;

class zzasp {
    private final String zzVQ;
    private String zzaHB;
    private String zzabL;
    private String zzbpK;
    private String zzbpL;
    private String zzbpM;
    private long zzbpN;
    private long zzbpO;
    private long zzbpP;
    private long zzbpQ;
    private String zzbpR;
    private long zzbpS;
    private long zzbpT;
    private boolean zzbpU;
    private long zzbpV;
    private long zzbpW;
    private long zzbpX;
    private long zzbpY;
    private long zzbpZ;
    private final zzatp zzbpw;
    private long zzbqa;
    private String zzbqb;
    private boolean zzbqc;
    private long zzbqd;
    private long zzbqe;

    zzasp(zzatp com_google_android_gms_internal_zzatp, String str) {
        zzac.zzw(com_google_android_gms_internal_zzatp);
        zzac.zzdv(str);
        this.zzbpw = com_google_android_gms_internal_zzatp;
        this.zzVQ = str;
        this.zzbpw.zzmq();
    }

    public String getAppInstanceId() {
        this.zzbpw.zzmq();
        return this.zzaHB;
    }

    public String getGmpAppId() {
        this.zzbpw.zzmq();
        return this.zzbpK;
    }

    public void setAppVersion(String str) {
        this.zzbpw.zzmq();
        this.zzbqc = (!zzaue.zzab(this.zzabL, str) ? 1 : 0) | this.zzbqc;
        this.zzabL = str;
    }

    public void setMeasurementEnabled(boolean z) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpU != z ? 1 : 0) | this.zzbqc;
        this.zzbpU = z;
    }

    public long zzJA() {
        this.zzbpw.zzmq();
        return this.zzbpP;
    }

    public long zzJB() {
        this.zzbpw.zzmq();
        return this.zzbpQ;
    }

    public String zzJC() {
        this.zzbpw.zzmq();
        return this.zzbpR;
    }

    public long zzJD() {
        this.zzbpw.zzmq();
        return this.zzbpS;
    }

    public long zzJE() {
        this.zzbpw.zzmq();
        return this.zzbpT;
    }

    public boolean zzJF() {
        this.zzbpw.zzmq();
        return this.zzbpU;
    }

    public long zzJG() {
        this.zzbpw.zzmq();
        return this.zzbpN;
    }

    public long zzJH() {
        this.zzbpw.zzmq();
        return this.zzbqd;
    }

    public long zzJI() {
        this.zzbpw.zzmq();
        return this.zzbqe;
    }

    public void zzJJ() {
        this.zzbpw.zzmq();
        long j = this.zzbpN + 1;
        if (j > 2147483647L) {
            this.zzbpw.zzJt().zzLc().zzj("Bundle index overflow. appId", zzati.zzfI(this.zzVQ));
            j = 0;
        }
        this.zzbqc = true;
        this.zzbpN = j;
    }

    public long zzJK() {
        this.zzbpw.zzmq();
        return this.zzbpV;
    }

    public long zzJL() {
        this.zzbpw.zzmq();
        return this.zzbpW;
    }

    public long zzJM() {
        this.zzbpw.zzmq();
        return this.zzbpX;
    }

    public long zzJN() {
        this.zzbpw.zzmq();
        return this.zzbpY;
    }

    public long zzJO() {
        this.zzbpw.zzmq();
        return this.zzbqa;
    }

    public long zzJP() {
        this.zzbpw.zzmq();
        return this.zzbpZ;
    }

    public String zzJQ() {
        this.zzbpw.zzmq();
        return this.zzbqb;
    }

    public String zzJR() {
        this.zzbpw.zzmq();
        String str = this.zzbqb;
        zzfm(null);
        return str;
    }

    public void zzJw() {
        this.zzbpw.zzmq();
        this.zzbqc = false;
    }

    public String zzJx() {
        this.zzbpw.zzmq();
        return this.zzbpL;
    }

    public String zzJy() {
        this.zzbpw.zzmq();
        return this.zzbpM;
    }

    public long zzJz() {
        this.zzbpw.zzmq();
        return this.zzbpO;
    }

    public void zzX(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpO != j ? 1 : 0) | this.zzbqc;
        this.zzbpO = j;
    }

    public void zzY(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpP != j ? 1 : 0) | this.zzbqc;
        this.zzbpP = j;
    }

    public void zzZ(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpQ != j ? 1 : 0) | this.zzbqc;
        this.zzbpQ = j;
    }

    public void zzaa(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpS != j ? 1 : 0) | this.zzbqc;
        this.zzbpS = j;
    }

    public void zzab(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpT != j ? 1 : 0) | this.zzbqc;
        this.zzbpT = j;
    }

    public void zzac(long j) {
        int i = 1;
        zzac.zzas(j >= 0);
        this.zzbpw.zzmq();
        boolean z = this.zzbqc;
        if (this.zzbpN == j) {
            i = 0;
        }
        this.zzbqc = z | i;
        this.zzbpN = j;
    }

    public void zzad(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbqd != j ? 1 : 0) | this.zzbqc;
        this.zzbqd = j;
    }

    public void zzae(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbqe != j ? 1 : 0) | this.zzbqc;
        this.zzbqe = j;
    }

    public void zzaf(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpV != j ? 1 : 0) | this.zzbqc;
        this.zzbpV = j;
    }

    public void zzag(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpW != j ? 1 : 0) | this.zzbqc;
        this.zzbpW = j;
    }

    public void zzah(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpX != j ? 1 : 0) | this.zzbqc;
        this.zzbpX = j;
    }

    public void zzai(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpY != j ? 1 : 0) | this.zzbqc;
        this.zzbpY = j;
    }

    public void zzaj(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbqa != j ? 1 : 0) | this.zzbqc;
        this.zzbqa = j;
    }

    public void zzak(long j) {
        this.zzbpw.zzmq();
        this.zzbqc = (this.zzbpZ != j ? 1 : 0) | this.zzbqc;
        this.zzbpZ = j;
    }

    public void zzfh(String str) {
        this.zzbpw.zzmq();
        this.zzbqc = (!zzaue.zzab(this.zzaHB, str) ? 1 : 0) | this.zzbqc;
        this.zzaHB = str;
    }

    public void zzfi(String str) {
        this.zzbpw.zzmq();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzbqc = (!zzaue.zzab(this.zzbpK, str) ? 1 : 0) | this.zzbqc;
        this.zzbpK = str;
    }

    public void zzfj(String str) {
        this.zzbpw.zzmq();
        this.zzbqc = (!zzaue.zzab(this.zzbpL, str) ? 1 : 0) | this.zzbqc;
        this.zzbpL = str;
    }

    public void zzfk(String str) {
        this.zzbpw.zzmq();
        this.zzbqc = (!zzaue.zzab(this.zzbpM, str) ? 1 : 0) | this.zzbqc;
        this.zzbpM = str;
    }

    public void zzfl(String str) {
        this.zzbpw.zzmq();
        this.zzbqc = (!zzaue.zzab(this.zzbpR, str) ? 1 : 0) | this.zzbqc;
        this.zzbpR = str;
    }

    public void zzfm(String str) {
        this.zzbpw.zzmq();
        this.zzbqc = (!zzaue.zzab(this.zzbqb, str) ? 1 : 0) | this.zzbqc;
        this.zzbqb = str;
    }

    public String zzjI() {
        this.zzbpw.zzmq();
        return this.zzVQ;
    }

    public String zzmy() {
        this.zzbpw.zzmq();
        return this.zzabL;
    }
}
