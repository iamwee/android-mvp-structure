package com.iamwee.mvpstructure.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;

import com.iamwee.mvpstructure.base.state.BundleSavedState;


public class BaseCustomView extends FrameLayout {

    private static final String KEY_CHILDREN_STATES = "children_states";

    public BaseCustomView(@NonNull Context context) {
        super(context);
    }

    public BaseCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCustomView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseCustomView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        Bundle childrenStates = new Bundle();
        for (int i = 0; i < getChildCount(); i++) {
            int id = getChildAt(i).getId();
            if (id != 0) {
                SparseArray<Parcelable> childrenState = new SparseArray<>();
                getChildAt(i).saveHierarchyState(childrenState);
                childrenStates.putSparseParcelableArray(String.valueOf(id), childrenState);
            }
        }

        BundleSavedState ss = new BundleSavedState(superState);
        ss.getBundle().putBundle(KEY_CHILDREN_STATES, childrenStates);
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle childrenStates = ss.getBundle().getBundle(KEY_CHILDREN_STATES);
        for (int i = 0; i < getChildCount(); i++) {
            int id = getChildAt(i).getId();
            if (id != 0) {
                if (childrenStates.containsKey(String.valueOf(id))) {
                    SparseArray<Parcelable> childrenState =
                            childrenStates.getSparseParcelableArray(String.valueOf(id));
                    getChildAt(i).restoreHierarchyState(childrenState);
                }
            }
        }
    }


    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    protected void init() {
    }

    protected void initWithStyleable(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    }
}
