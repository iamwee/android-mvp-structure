package com.iamwee.mvpstructure.base.presenter;

import android.content.Context;

import com.iamwee.mvpstructure.util.Contextor;


public class BasePresenter<CV extends IBaseView> implements IBasePresenter {

    private CV view;

    public BasePresenter(CV view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    protected CV getView() {
        return view;
    }

    protected Context getContext() {
        return Contextor.getInstance().getContext();
    }
}
