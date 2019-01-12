package com.example.dagger2.di.module;

import android.content.Context;

import com.example.dagger2.SharedPrefManager;
import com.example.dagger2.SharedPrefManagerImpl;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Garima Chamaria on 11/01/19.
 */

@Module
public class SharedPrefModule {

    @Singleton
    @Provides
    SharedPrefManager provideSharedPrefManager(@Named("application_context") Context context, Gson gson) {
        return new SharedPrefManagerImpl(context, gson);
    }
}
