package android.support.v7.app;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.mediarouter.C0113R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class MediaRouteExpandCollapseButton extends ImageButton {
    private final AnimationDrawable mCollapseAnimationDrawable;
    private final String mCollapseGroupDescription;
    private final AnimationDrawable mExpandAnimationDrawable;
    private final String mExpandGroupDescription;
    private boolean mIsGroupExpanded;
    private OnClickListener mListener;

    class C00921 implements OnClickListener {
        C00921() {
        }

        public void onClick(View view) {
            MediaRouteExpandCollapseButton.this.mIsGroupExpanded = !MediaRouteExpandCollapseButton.this.mIsGroupExpanded;
            if (MediaRouteExpandCollapseButton.this.mIsGroupExpanded) {
                MediaRouteExpandCollapseButton.this.setImageDrawable(MediaRouteExpandCollapseButton.this.mExpandAnimationDrawable);
                MediaRouteExpandCollapseButton.this.mExpandAnimationDrawable.start();
                MediaRouteExpandCollapseButton.this.setContentDescription(MediaRouteExpandCollapseButton.this.mCollapseGroupDescription);
            } else {
                MediaRouteExpandCollapseButton.this.setImageDrawable(MediaRouteExpandCollapseButton.this.mCollapseAnimationDrawable);
                MediaRouteExpandCollapseButton.this.mCollapseAnimationDrawable.start();
                MediaRouteExpandCollapseButton.this.setContentDescription(MediaRouteExpandCollapseButton.this.mExpandGroupDescription);
            }
            if (MediaRouteExpandCollapseButton.this.mListener != null) {
                MediaRouteExpandCollapseButton.this.mListener.onClick(view);
            }
        }
    }

    public MediaRouteExpandCollapseButton(Context context) {
        this(context, null);
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mExpandAnimationDrawable = (AnimationDrawable) ContextCompat.getDrawable(context, C0113R.drawable.ic_expand);
        this.mCollapseAnimationDrawable = (AnimationDrawable) ContextCompat.getDrawable(context, C0113R.drawable.ic_collapse);
        ColorFilter filter = new PorterDuffColorFilter(MediaRouterThemeHelper.getControllerColor(context, defStyleAttr), Mode.SRC_IN);
        this.mExpandAnimationDrawable.setColorFilter(filter);
        this.mCollapseAnimationDrawable.setColorFilter(filter);
        this.mExpandGroupDescription = context.getString(C0113R.string.mr_controller_expand_group);
        this.mCollapseGroupDescription = context.getString(C0113R.string.mr_controller_collapse_group);
        setImageDrawable(this.mExpandAnimationDrawable.getFrame(0));
        setContentDescription(this.mExpandGroupDescription);
        super.setOnClickListener(new C00921());
    }

    public void setOnClickListener(OnClickListener listener) {
        this.mListener = listener;
    }
}
