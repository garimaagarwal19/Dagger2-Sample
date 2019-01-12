package com.example.dagger2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dagger2.ActivityCallback;
import com.example.dagger2.IView;
import com.example.dagger2.R;
import com.example.dagger2.di.component.FirstFragmentComponent;
import com.example.dagger2.di.module.FirstFragmentModule;
import com.example.dagger2.model.User;
import com.example.dagger2.presenter.FirstFragmentPresenter;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Garima Chamaria on 12/01/19.
 */
public class FirstFragment extends Fragment implements IView {
    private View mView;
    private TextInputLayout mNameLayout, mNumberLayout;
    private EditText mNameEdt, mNumberEdt;
    private Button mBtnSave;

    private ActivityCallback mActivityCallback;
    private FirstFragmentComponent mFirstFragmentComponent;

    @Named("application_context")
    @Inject
    Context mAppContext;
    @Inject
    FirstFragmentPresenter mFirstFragmentPresenter;

    public void setActivityCallback(ActivityCallback activityCallback) {
        mActivityCallback = activityCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirstFragmentComponent = mActivityCallback.getActivityComponent().plusFirstFragmentComponent(new FirstFragmentModule());
        mFirstFragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.first_fragment, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFirstFragmentPresenter.onAttach(this);

        mNameLayout = mView.findViewById(R.id.name);
        mNumberLayout = mView.findViewById(R.id.phoneNum);
        mNameEdt = mView.findViewById(R.id.edt_name);
        mNumberEdt = mView.findViewById(R.id.edt_phoneNum);
        mBtnSave = mView.findViewById(R.id.btn_save);
        setListeners();
    }

    private boolean validateDetails() {
        boolean isValidated = true;
        if(mNameEdt.getText().toString().length() == 0) {
            mNameLayout.setError("Please Enter Name");
            isValidated = false;
        }
        if(mNumberEdt.getText().toString().length() == 0) {
            mNumberLayout.setError("Please Enter Number");
            isValidated = false;
        }
        return isValidated;
    }

    private void saveDataToDataBase() {
        User user = mFirstFragmentComponent.getUser();
        user.setName(mNameEdt.getText().toString());
        user.setPhoneNumber(mNumberEdt.getText().toString());
        mFirstFragmentPresenter.setDataToDatabase(user);
    }

    private void setListeners() {
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateDetails()) {
                    saveDataToDataBase();
                    mActivityCallback.addSecondFragment();
                }
                else
                    Toast.makeText(mAppContext, "Enter Details", Toast.LENGTH_SHORT).show();
            }
        });

        mNameEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNameLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mNumberEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNumberLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFirstFragmentPresenter.onDetach();
    }
}
