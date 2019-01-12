package com.example.dagger2.di.module;

import com.example.dagger2.SharedPrefManager;
import com.example.dagger2.di.scope.FragmentScope;
import com.example.dagger2.model.User;
import com.example.dagger2.presenter.FirstFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Garima Chamaria on 12/01/19.
 */

@Module
public class FirstFragmentModule {

    @FragmentScope
    @Provides
    FirstFragmentPresenter provideFirstFragmentPresenter(SharedPrefManager sharedPrefManager) {
        return new FirstFragmentPresenter(sharedPrefManager);
    }

    /*
       We have not defined scope for USER provider method, So each time a new User Object is returned
    */
    @Provides
    public User provideUser() {
        return new User();
    }
}
