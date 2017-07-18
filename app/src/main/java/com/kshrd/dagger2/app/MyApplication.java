package com.kshrd.dagger2.app;

import android.app.Application;
import com.kshrd.dagger2.app.di.component.ApplicationComponent;
import com.kshrd.dagger2.app.di.component.DaggerApplicationComponent;
import com.kshrd.dagger2.app.di.module.ApplicationModule;
import com.kshrd.dagger2.app.di.module.ConstantModule;

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
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
