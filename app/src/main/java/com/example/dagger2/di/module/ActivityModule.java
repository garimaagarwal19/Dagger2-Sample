package com.example.dagger2.di.module;

import android.content.Context;

import com.example.dagger2.di.scope.ActivityScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Garima Chamaria on 11/01/19.
 */

@Module
public class ActivityModule {
    private Context mContext;

    public ActivityModule(Context context) {
        mContext = context;
    }

    @Named("activity_context")
    @ActivityScope
    @Provides
    public Context provideContext() {
        return mContext;
    }
}
