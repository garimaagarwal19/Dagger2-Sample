package com.example.dagger2;

import com.example.dagger2.di.component.ActivityComponent;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public interface ActivityCallback {
    void addSecondFragment();

    ActivityComponent getActivityComponent();
}
