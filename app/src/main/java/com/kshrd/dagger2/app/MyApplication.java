package com.kshrd.dagger2.app;

import android.app.Application;
import com.kshrd.dagger2.app.di.ApplicationComponent;
import com.kshrd.dagger2.app.di.ConstantModule;
import com.kshrd.dagger2.app.di.DaggerApplicationComponent;

/**
 * Created by pirang on 7/17/17.
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .constantModule(new ConstantModule())
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
