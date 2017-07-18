package com.kshrd.dagger2.app.di.module;

import com.kshrd.dagger2.data.AppPreferenceHelper;
import com.kshrd.dagger2.data.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pirang on 7/18/17.
 */

@Module
public class PreferenceModule {

    @Provides
    @Singleton
    public PreferenceHelper providePreferenceHelper(AppPreferenceHelper appPreferenceHelper){
        return appPreferenceHelper;
    }

}
