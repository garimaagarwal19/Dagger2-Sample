package com.example.dagger2;

import com.example.dagger2.model.User;

/**
 * Created by Garima Chamaria on 11/01/19.
 */
public interface SharedPrefManager {
    void setUserDetails(User user);
    User getUserDetails();
}
