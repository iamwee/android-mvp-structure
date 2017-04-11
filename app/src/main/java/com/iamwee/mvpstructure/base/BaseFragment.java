package com.iamwee.mvpstructure.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.iamwee.mvpstructure.base.presenter.IBasePresenter;
import com.iamwee.mvpstructure.util.loading_dialog.LoadingDialogHelper;

public class BaseFragment<CP extends IBasePresenter> extends Fragment {

    private static final String KEY_DIALOG_SHOWING = "dialog_showing";
    private boolean isDialogShowing = false;

    private CP presenter;

    public CP getPresenter() {
        return presenter;
    }

    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isDialogShowing()) showLoadingDialog();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isLoadingDialogShowing()) {
            dismissLoadingDialog();
            setDialogShowing(true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_DIALOG_SHOWING, isDialogShowing);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            isDialogShowing = savedInstanceState.getBoolean(KEY_DIALOG_SHOWING, false);
        }
    }

    protected void initView(View rootView) {
    }

    protected void setupView(View rootView) {
    }

    protected boolean isLoadingDialogShowing() {
        return LoadingDialogHelper.getInstance().isDialogShowing(getChildFragmentManager());
    }

    protected void showLoadingDialog() {
        LoadingDialogHelper.getInstance().showLoadingDialog(getChildFragmentManager());
    }

    protected void dismissLoadingDialog() {
        if (LoadingDialogHelper.getInstance().isDialogShowing(getChildFragmentManager())) {
            LoadingDialogHelper.getInstance().dismissDialog();
            setDialogShowing(false);
        }
    }

    public boolean isDialogShowing() {
        return isDialogShowing;
    }

    public void setDialogShowing(boolean dialogShowing) {
        isDialogShowing = dialogShowing;
    }
}
