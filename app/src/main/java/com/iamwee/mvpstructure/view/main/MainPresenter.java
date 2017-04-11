package com.iamwee.mvpstructure.view.main;

import com.iamwee.mvpstructure.base.presenter.BasePresenter;


public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    public static MainPresenter newInstance(IMainView view) {
        return new MainPresenter(view);
    }

    private MainPresenter(IMainView view) {
        super(view);
    }
}
