package com.example.dagger2.di.component;

import com.example.dagger2.MainApplication;
import com.example.dagger2.di.module.ActivityModule;
import com.example.dagger2.di.module.AppModule;
import com.example.dagger2.di.module.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Garima Chamaria on 11/01/19.
 */

@Singleton
@Component (modules = {AppModule.class, SharedPrefModule.class})
/*
Dependencies provided by each declared module in this component is available for each other
*/

public interface ApplicationComponent {

    void inject(MainApplication mainApplication);

    ActivityComponent plusActivityComponent(ActivityModule activityModule);
}
