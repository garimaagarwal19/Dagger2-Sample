package com.example.dagger2.presenter;

import com.example.dagger2.SharedPrefManager;
import com.example.dagger2.model.User;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public class SecondFragmentPresenter extends BasePresenter {
    private SharedPrefManager mSharedPrefManager;

    public SecondFragmentPresenter(SharedPrefManager sharedPrefManager) {
        mSharedPrefManager = sharedPrefManager;
    }

    public User getUser() {
        return mSharedPrefManager.getUserDetails();
    }
}
