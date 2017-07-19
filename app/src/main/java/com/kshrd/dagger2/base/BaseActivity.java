package com.kshrd.dagger2.base;

import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

/**
 * Created by pirang on 7/13/17.
 */

public class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
        }
    }

    protected void setUnbinder(Unbinder unbinder){
        this.unbinder = unbinder;
    }
}
