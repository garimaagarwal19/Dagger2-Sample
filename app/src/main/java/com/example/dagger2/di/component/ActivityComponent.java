package com.example.dagger2.di.component;

import com.example.dagger2.MainActivity;
import com.example.dagger2.di.module.ActivityModule;
import com.example.dagger2.di.module.FirstFragmentModule;
import com.example.dagger2.di.module.SecondFragmentModule;
import com.example.dagger2.di.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Garima Chamaria on 11/01/19.
 */

@ActivityScope
@Subcomponent (modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    FirstFragmentComponent plusFirstFragmentComponent(FirstFragmentModule firstFragmentModule);

    SecondFragmentComponent plusSecondFragmentComponent(SecondFragmentModule secondFragmentModule);
}
