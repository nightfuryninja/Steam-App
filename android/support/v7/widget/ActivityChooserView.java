package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0098R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    private final LinearLayoutCompat mActivityChooserContent;
    final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    OnDismissListener mOnDismissListener;
    private final OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    private class ActivityChooserViewAdapter extends BaseAdapter {
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;
        final /* synthetic */ ActivityChooserView this$0;

        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel = this.this$0.mAdapter.getDataModel();
            if (oldDataModel != null && this.this$0.isShown()) {
                oldDataModel.unregisterObserver(this.this$0.mModelDataSetObserver);
            }
            this.mDataModel = dataModel;
            if (dataModel != null && this.this$0.isShown()) {
                dataModel.registerObserver(this.this$0.mModelDataSetObserver);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int position) {
            if (this.mShowFooterView && position == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int activityCount = this.mDataModel.getActivityCount();
            if (!(this.mShowDefaultActivity || this.mDataModel.getDefaultActivity() == null)) {
                activityCount--;
            }
            int count = Math.min(activityCount, this.mMaxActivityCount);
            if (this.mShowFooterView) {
                return count + 1;
            }
            return count;
        }

        public Object getItem(int position) {
            switch (getItemViewType(position)) {
                case 0:
                    if (!(this.mShowDefaultActivity || this.mDataModel.getDefaultActivity() == null)) {
                        position++;
                    }
                    return this.mDataModel.getActivity(position);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            switch (getItemViewType(position)) {
                case 0:
                    if (convertView == null || convertView.getId() != C0098R.id.list_item) {
                        convertView = LayoutInflater.from(this.this$0.getContext()).inflate(C0098R.layout.abc_activity_chooser_view_list_item, parent, false);
                    }
                    PackageManager packageManager = this.this$0.getContext().getPackageManager();
                    ResolveInfo activity = (ResolveInfo) getItem(position);
                    ((ImageView) convertView.findViewById(C0098R.id.icon)).setImageDrawable(activity.loadIcon(packageManager));
                    ((TextView) convertView.findViewById(C0098R.id.title)).setText(activity.loadLabel(packageManager));
                    if (this.mShowDefaultActivity && position == 0 && this.mHighlightDefaultActivity) {
                        ViewCompat.setActivated(convertView, true);
                    } else {
                        ViewCompat.setActivated(convertView, false);
                    }
                    return convertView;
                case 1:
                    if (convertView == null || convertView.getId() != 1) {
                        convertView = LayoutInflater.from(this.this$0.getContext()).inflate(C0098R.layout.abc_activity_chooser_view_list_item, parent, false);
                        convertView.setId(1);
                        ((TextView) convertView.findViewById(C0098R.id.title)).setText(this.this$0.getContext().getString(C0098R.string.abc_activity_chooser_view_see_all));
                    }
                    return convertView;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int measureContentWidth() {
            int oldMaxActivityCount = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int contentWidth = 0;
            View itemView = null;
            int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            for (int i = 0; i < count; i++) {
                itemView = getView(i, itemView, null);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
            }
            this.mMaxActivityCount = oldMaxActivityCount;
            return contentWidth;
        }

        public void setMaxActivityCount(int maxActivityCount) {
            if (this.mMaxActivityCount != maxActivityCount) {
                this.mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public void setShowFooterView(boolean showFooterView) {
            if (this.mShowFooterView != showFooterView) {
                this.mShowFooterView = showFooterView;
                notifyDataSetChanged();
            }
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public void setShowDefaultActivity(boolean showDefaultActivity, boolean highlightDefaultActivity) {
            if (this.mShowDefaultActivity != showDefaultActivity || this.mHighlightDefaultActivity != highlightDefaultActivity) {
                this.mShowDefaultActivity = showDefaultActivity;
                this.mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            }
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }
    }

    private class Callbacks implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView this$0;

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (((ActivityChooserViewAdapter) parent.getAdapter()).getItemViewType(position)) {
                case 0:
                    this.this$0.dismissPopup();
                    if (!this.this$0.mIsSelectingDefaultActivity) {
                        if (!this.this$0.mAdapter.getShowDefaultActivity()) {
                            position++;
                        }
                        Intent launchIntent = this.this$0.mAdapter.getDataModel().chooseActivity(position);
                        if (launchIntent != null) {
                            launchIntent.addFlags(524288);
                            this.this$0.getContext().startActivity(launchIntent);
                            return;
                        }
                        return;
                    } else if (position > 0) {
                        this.this$0.mAdapter.getDataModel().setDefaultActivity(position);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.this$0.mDefaultActivityButton) {
                this.this$0.dismissPopup();
                Intent launchIntent = this.this$0.mAdapter.getDataModel().chooseActivity(this.this$0.mAdapter.getDataModel().getActivityIndex(this.this$0.mAdapter.getDefaultActivity()));
                if (launchIntent != null) {
                    launchIntent.addFlags(524288);
                    this.this$0.getContext().startActivity(launchIntent);
                }
            } else if (view == this.this$0.mExpandActivityOverflowButton) {
                this.this$0.mIsSelectingDefaultActivity = false;
                this.this$0.showPopupUnchecked(this.this$0.mInitialActivityCount);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.this$0.mDefaultActivityButton) {
                if (this.this$0.mAdapter.getCount() > 0) {
                    this.this$0.mIsSelectingDefaultActivity = true;
                    this.this$0.showPopupUnchecked(this.this$0.mInitialActivityCount);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            notifyOnDismissListener();
            if (this.this$0.mProvider != null) {
                this.this$0.mProvider.subUiVisibilityChanged(false);
            }
        }

        private void notifyOnDismissListener() {
            if (this.this$0.mOnDismissListener != null) {
                this.this$0.mOnDismissListener.onDismiss();
            }
        }
    }

    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] TINT_ATTRS = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, TINT_ATTRS);
            setBackgroundDrawable(a.getDrawable(0));
            a.recycle();
        }
    }

    public void setActivityChooserModel(ActivityChooserModel dataModel) {
        this.mAdapter.setDataModel(dataModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(resourceId));
    }

    public void setProvider(ActionProvider provider) {
        this.mProvider = provider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    void showPopupUnchecked(int maxActivityCount) {
        if (this.mAdapter.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        boolean defaultActivityButtonShown;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            defaultActivityButtonShown = true;
        } else {
            defaultActivityButtonShown = false;
        }
        int activityCount = this.mAdapter.getActivityCount();
        int maxActivityCountOffset;
        if (defaultActivityButtonShown) {
            maxActivityCountOffset = 1;
        } else {
            maxActivityCountOffset = 0;
        }
        if (maxActivityCount == Integer.MAX_VALUE || activityCount <= maxActivityCount + maxActivityCountOffset) {
            this.mAdapter.setShowFooterView(false);
            this.mAdapter.setMaxActivityCount(maxActivityCount);
        } else {
            this.mAdapter.setShowFooterView(true);
            this.mAdapter.setMaxActivityCount(maxActivityCount - 1);
        }
        ListPopupWindow popupWindow = getListPopupWindow();
        if (!popupWindow.isShowing()) {
            if (this.mIsSelectingDefaultActivity || !defaultActivityButtonShown) {
                this.mAdapter.setShowDefaultActivity(true, defaultActivityButtonShown);
            } else {
                this.mAdapter.setShowDefaultActivity(false, false);
            }
            popupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
            popupWindow.show();
            if (this.mProvider != null) {
                this.mProvider.subUiVisibilityChanged(true);
            }
            popupWindow.getListView().setContentDescription(getContext().getString(C0098R.string.abc_activitychooserview_choose_application));
        }
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            }
        }
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.mModelDataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.mModelDataSetObserver);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), 1073741824);
        }
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.mOnDismissListener = listener;
    }

    public void setInitialActivityCount(int itemCount) {
        this.mInitialActivityCount = itemCount;
    }

    public void setDefaultActionButtonContentDescription(int resourceId) {
        this.mDefaultActionButtonContentDescription = resourceId;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            this.mListPopupWindow = new ListPopupWindow(getContext());
            this.mListPopupWindow.setAdapter(this.mAdapter);
            this.mListPopupWindow.setAnchorView(this);
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
        }
        return this.mListPopupWindow;
    }
}
