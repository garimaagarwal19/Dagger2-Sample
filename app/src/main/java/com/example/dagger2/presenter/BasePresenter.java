package com.example.dagger2.presenter;

import com.example.dagger2.IView;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public class BasePresenter {
    private IView mIView;

    public void onAttach(IView view) {
        mIView = view;
    }

    public IView getView() {
        return mIView;
    }

    public void onDetach() {
        mIView = null;
    }
}
