package com.iamwee.mvpstructure.base.presenter;


public class BasePresenter<CV extends IBaseView> implements IBasePresenter {

    private CV view;

    public BasePresenter(CV view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    protected CV getView() {
        return view;
    }
}
