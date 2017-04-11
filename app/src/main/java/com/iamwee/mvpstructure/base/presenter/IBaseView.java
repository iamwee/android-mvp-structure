package com.iamwee.mvpstructure.base.presenter;



public interface IBaseView<CP extends IBasePresenter> {

    void setPresenter(CP presenter);

}
