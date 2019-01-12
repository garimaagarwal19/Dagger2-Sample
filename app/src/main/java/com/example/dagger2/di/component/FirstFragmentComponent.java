package com.example.dagger2.di.component;

import com.example.dagger2.di.module.FirstFragmentModule;
import com.example.dagger2.di.scope.FragmentScope;
import com.example.dagger2.fragment.FirstFragment;
import com.example.dagger2.model.User;

import dagger.Subcomponent;

/**
 * Created by Garima Chamaria on 12/01/19.
 */

@FragmentScope
@Subcomponent(modules = FirstFragmentModule.class)
public interface FirstFragmentComponent {

    void inject(FirstFragment firstFragment);

    User getUser();
}
