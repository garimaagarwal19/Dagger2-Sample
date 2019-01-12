package com.example.dagger2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dagger2.ActivityCallback;
import com.example.dagger2.IView;
import com.example.dagger2.R;
import com.example.dagger2.di.component.SecondFragmentComponent;
import com.example.dagger2.di.module.SecondFragmentModule;
import com.example.dagger2.model.User;
import com.example.dagger2.presenter.SecondFragmentPresenter;

import javax.inject.Inject;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public class SecondFragment extends Fragment implements IView {

    private View mView;
    private TextView userName, userNumber;

    private ActivityCallback mActivityCallback;
    private SecondFragmentComponent mSecondFragmentComponent;
    @Inject
    SecondFragmentPresenter mSecondFragmentPresenter;

    public void setActivityCallback(ActivityCallback activityCallback) {
        mActivityCallback = activityCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSecondFragmentComponent = mActivityCallback.getActivityComponent().plusSecondFragmentComponent(new SecondFragmentModule());
        mSecondFragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.second_fragment, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSecondFragmentPresenter.onAttach(this);
        userName = mView.findViewById(R.id.txt_userName);
        userNumber = mView.findViewById(R.id.txt_userPhoneNumber);
        initializeData();
    }

    private void initializeData() {
        User user = mSecondFragmentPresenter.getUser();
        userName.setText(user.getName());
        userNumber.setText(user.getPhoneNumber());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mSecondFragmentPresenter.onDetach();
    }
}
