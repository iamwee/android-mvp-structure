package com.iamwee.mvpstructure.util.loading_dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.iamwee.mvpstructure.R;


public class LoadingDialog extends DialogFragment {

    public LoadingDialog() {

    }

    public static LoadingDialog newInstance() {
        return new LoadingDialog();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        setCancelable(false);
        return inflater.inflate(R.layout.view_dialog_loading, container, false);
    }
}
