package com.kshrd.dagger2.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by pirang on 7/18/17.
 */

public class AppPreferenceHelper implements PreferenceHelper {

    private static final String USER_PREFERENCE = "user_preference";
    private static final String USER_ID = "user_id";
    private static final String USER_NAME = "user_name";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Inject
    public AppPreferenceHelper(Context context){
        this.sharedPreferences = context.getSharedPreferences(USER_PREFERENCE, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    @Override
    public void setUserId(int userId) {
        editor.putInt(USER_ID, userId);
        editor.apply();
    }

    @Override
    public int getUserId() {
        return sharedPreferences.getInt(USER_ID, 0);
    }

    @Override
    public void setUserName(String userName) {
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    @Override
    public String getUserName() {
        return sharedPreferences.getString(USER_NAME, "n/a");
    }
}
