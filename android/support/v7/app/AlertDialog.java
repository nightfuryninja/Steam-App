package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.appcompat.C0098R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    final AlertController mAlert = new AlertController(getContext(), this, getWindow());

    public static class Builder {
        private final AlertParams f6P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(Context context, int themeResId) {
            this.f6P = new AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, themeResId)));
            this.mTheme = themeResId;
        }

        public Context getContext() {
            return this.f6P.mContext;
        }

        public Builder setTitle(CharSequence title) {
            this.f6P.mTitle = title;
            return this;
        }

        public Builder setCustomTitle(View customTitleView) {
            this.f6P.mCustomTitleView = customTitleView;
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.f6P.mIcon = icon;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.f6P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setAdapter(ListAdapter adapter, OnClickListener listener) {
            this.f6P.mAdapter = adapter;
            this.f6P.mOnClickListener = listener;
            return this;
        }

        public AlertDialog create() {
            AlertDialog dialog = new AlertDialog(this.f6P.mContext, this.mTheme);
            this.f6P.apply(dialog.mAlert);
            dialog.setCancelable(this.f6P.mCancelable);
            if (this.f6P.mCancelable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(this.f6P.mOnCancelListener);
            dialog.setOnDismissListener(this.f6P.mOnDismissListener);
            if (this.f6P.mOnKeyListener != null) {
                dialog.setOnKeyListener(this.f6P.mOnKeyListener);
            }
            return dialog;
        }
    }

    protected AlertDialog(Context context, int themeResId) {
        super(context, resolveDialogTheme(context, themeResId));
    }

    static int resolveDialogTheme(Context context, int resid) {
        if (resid >= 16777216) {
            return resid;
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(C0098R.attr.alertDialogTheme, outValue, true);
        return outValue.resourceId;
    }

    public void setTitle(CharSequence title) {
        super.setTitle(title);
        this.mAlert.setTitle(title);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mAlert.onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.mAlert.onKeyUp(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
