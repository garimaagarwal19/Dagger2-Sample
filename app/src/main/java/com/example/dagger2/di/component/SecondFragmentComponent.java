package com.example.dagger2.di.component;

import com.example.dagger2.di.module.SecondFragmentModule;
import com.example.dagger2.di.scope.FragmentScope;
import com.example.dagger2.fragment.SecondFragment;

import dagger.Subcomponent;

/**
 * Created by Garima Chamaria on 12/01/19.
 */

@FragmentScope
@Subcomponent (modules = SecondFragmentModule.class)
public interface SecondFragmentComponent {

    void inject(SecondFragment secondFragment);

}
