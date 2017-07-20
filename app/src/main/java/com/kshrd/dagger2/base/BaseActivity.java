package com.kshrd.dagger2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kshrd.dagger2.app.MyApplication;
import com.kshrd.dagger2.app.di.component.ActivityComponent;
import com.kshrd.dagger2.app.di.component.DaggerActivityComponent;
import com.kshrd.dagger2.app.di.module.ActivityModule;

import butterknife.Unbinder;

/**
 * Created by pirang on 7/13/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule())
                .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
                .build();
        onInject(activityComponent);

    }

    public abstract void onInject(ActivityComponent activityComponent);

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

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
