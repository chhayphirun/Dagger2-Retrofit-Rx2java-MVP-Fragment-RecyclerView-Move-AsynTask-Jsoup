package com.kshrd.dagger2.app.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pirang on 7/18/17.
 */

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    public Context provideApplicationContext() {
        return this.context;
    }
}
