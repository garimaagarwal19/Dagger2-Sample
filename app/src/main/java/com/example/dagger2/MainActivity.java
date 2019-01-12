package com.example.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dagger2.di.component.ActivityComponent;
import com.example.dagger2.di.module.ActivityModule;
import com.example.dagger2.fragment.FirstFragment;
import com.example.dagger2.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    private ActivityCallback mActivityCallback = new ActivityCallback() {
        @Override
        public void addSecondFragment() {
            MainActivity.this.addSecondFragment();
        }

        @Override
        public ActivityComponent getActivityComponent() {
            return MainActivity.this.getActivityComponent();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityComponent = MainApplication.getApplicationComponent().
                plusActivityComponent(new ActivityModule(this));
        mActivityComponent.inject(this);

        addFirstFragment();
    }

    private void addFirstFragment() {
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setActivityCallback(mActivityCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, firstFragment).commit();
    }

    private void addSecondFragment() {
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setActivityCallback(mActivityCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, secondFragment).commit();
    }

    private ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}
