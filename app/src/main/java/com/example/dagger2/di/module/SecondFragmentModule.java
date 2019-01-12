package com.example.dagger2.di.module;

import com.example.dagger2.SharedPrefManager;
import com.example.dagger2.di.scope.FragmentScope;
import com.example.dagger2.presenter.SecondFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Garima Chamaria on 12/01/19.
 */

@Module
public class SecondFragmentModule {

    @FragmentScope
    @Provides
    SecondFragmentPresenter provideSecondFragmentPresenter(SharedPrefManager sharedPrefManager) {
        return new SecondFragmentPresenter(sharedPrefManager);
    }
}
