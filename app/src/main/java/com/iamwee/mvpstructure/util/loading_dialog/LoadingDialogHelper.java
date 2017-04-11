package com.iamwee.mvpstructure.util.loading_dialog;


import android.support.v4.app.FragmentManager;

public class LoadingDialogHelper {

    private static final String TAG_DIALOG = "dialog";
    private static LoadingDialogHelper instance;

    public static LoadingDialogHelper getInstance() {
        if (instance == null) instance = new LoadingDialogHelper();
        return instance;
    }

    private LoadingDialog dialog;

    public void showLoadingDialog(FragmentManager fragmentManager){
        dismissDialog();
        dialog = LoadingDialog.newInstance();
        dialog.show(fragmentManager, TAG_DIALOG);
    }

    public boolean isDialogShowing(FragmentManager fragmentManager){
        return dialog != null && fragmentManager.findFragmentByTag(TAG_DIALOG) != null;
    }

    public void dismissDialog(){
        if (dialog != null && dialog.isAdded()){
            dialog.dismiss();
            dialog = null;
        }
    }
}
