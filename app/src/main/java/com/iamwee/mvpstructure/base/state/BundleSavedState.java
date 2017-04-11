package com.iamwee.mvpstructure.base.state;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View.BaseSavedState;


public class BundleSavedState extends BaseSavedState {
    private Bundle bundle = new Bundle();

    public BundleSavedState(Parcel source) {
        super(source);
        bundle = source.readBundle(getClass().getClassLoader());
    }

    public BundleSavedState(Parcelable superState) {
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeBundle(bundle);
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public static final Parcelable.Creator<BundleSavedState> CREATOR = new Creator<BundleSavedState>() {
        @Override
        public BundleSavedState createFromParcel(Parcel source) {
            return new BundleSavedState(source);
        }

        @Override
        public BundleSavedState[] newArray(int size) {
            return new BundleSavedState[size];
        }
    };
}
