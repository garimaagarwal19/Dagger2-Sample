package com.example.dagger2;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dagger2.model.User;
import com.google.gson.Gson;

/**
 * Created by Garima Chamaria on 11/01/19.
 */
public class SharedPrefManagerImpl implements SharedPrefManager {
    private static final String PREF_NAME = "Dagger_sample";
    private static final String USER_DETAILS = "User_Details";
    private SharedPreferences mSharedPreferences;
    private Context mContext;
    private Gson mGson;

    public SharedPrefManagerImpl(Context context, Gson gson) {
        mContext = context;
        mGson = gson;
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setUserDetails(User user) {
        String json = mGson.toJson(user);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_DETAILS, json);
        editor.commit();
    }

    @Override
    public User getUserDetails() {
        String json = mSharedPreferences.getString(USER_DETAILS, null);
        return mGson.fromJson(json, User.class);
    }
}
