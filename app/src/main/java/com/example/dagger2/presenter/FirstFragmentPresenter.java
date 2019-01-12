package com.example.dagger2.presenter;

import com.example.dagger2.SharedPrefManager;
import com.example.dagger2.model.User;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public class FirstFragmentPresenter extends BasePresenter {
    private SharedPrefManager mSharedPrefManager;

    public FirstFragmentPresenter(SharedPrefManager sharedPrefManager) {
        mSharedPrefManager = sharedPrefManager;
    }

    public void setDataToDatabase(User user) {
        mSharedPrefManager.setUserDetails(user);
    }
}
