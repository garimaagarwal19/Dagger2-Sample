package com.example.dagger2.di.module;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Garima Chamaria on 11/01/19.
 */

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Singleton
    @Provides
    @Named("application_context")
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}
