package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0154R;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
public class zzki extends zzko {
    private final Context mContext;
    private final Map<String, String> zzFs;
    private String zzLk;
    private long zzLl;
    private long zzLm;
    private String zzLn;
    private String zzLo;

    class C06201 implements OnClickListener {
        final /* synthetic */ zzki zzLp;

        C06201(zzki com_google_android_gms_internal_zzki) {
            this.zzLp = com_google_android_gms_internal_zzki;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            zzv.zzcJ().zzb(this.zzLp.mContext, this.zzLp.createIntent());
        }
    }

    class C06212 implements OnClickListener {
        final /* synthetic */ zzki zzLp;

        C06212(zzki com_google_android_gms_internal_zzki) {
            this.zzLp = com_google_android_gms_internal_zzki;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzLp.zzay("Operation denied by user.");
        }
    }

    public zzki(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
        super(com_google_android_gms_internal_zzqp, "createCalendarEvent");
        this.zzFs = map;
        this.mContext = com_google_android_gms_internal_zzqp.zzkR();
        zzgO();
    }

    private String zzav(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzFs.get(str)) ? "" : (String) this.zzFs.get(str);
    }

    private long zzaw(String str) {
        String str2 = (String) this.zzFs.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzgO() {
        this.zzLk = zzav("description");
        this.zzLn = zzav("summary");
        this.zzLl = zzaw("start_ticks");
        this.zzLm = zzaw("end_ticks");
        this.zzLo = zzav("location");
    }

    @TargetApi(14)
    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.zzLk);
        data.putExtra("eventLocation", this.zzLo);
        data.putExtra("description", this.zzLn);
        if (this.zzLl > -1) {
            data.putExtra("beginTime", this.zzLl);
        }
        if (this.zzLm > -1) {
            data.putExtra("endTime", this.zzLm);
        }
        data.setFlags(268435456);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzay("Activity context is not available.");
        } else if (zzv.zzcJ().zzC(this.mContext).zzfk()) {
            Builder zzB = zzv.zzcJ().zzB(this.mContext);
            Resources resources = zzv.zzcN().getResources();
            zzB.setTitle(resources != null ? resources.getString(C0154R.string.create_calendar_title) : "Create calendar event");
            zzB.setMessage(resources != null ? resources.getString(C0154R.string.create_calendar_message) : "Allow Ad to create a calendar event?");
            zzB.setPositiveButton(resources != null ? resources.getString(C0154R.string.accept) : "Accept", new C06201(this));
            zzB.setNegativeButton(resources != null ? resources.getString(C0154R.string.decline) : "Decline", new C06212(this));
            zzB.create().show();
        } else {
            zzay("This feature is not available on the device.");
        }
    }
}
