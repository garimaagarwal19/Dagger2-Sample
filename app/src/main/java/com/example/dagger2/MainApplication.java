package com.example.dagger2;

import android.app.Application;

import com.example.dagger2.di.component.ApplicationComponent;
import com.example.dagger2.di.component.DaggerApplicationComponent;
import com.example.dagger2.di.module.AppModule;
import com.example.dagger2.di.module.SharedPrefModule;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public class MainApplication extends Application {
    private static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().
                appModule(new AppModule(this)).
                sharedPrefModule(new SharedPrefModule()).build();
        mApplicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
