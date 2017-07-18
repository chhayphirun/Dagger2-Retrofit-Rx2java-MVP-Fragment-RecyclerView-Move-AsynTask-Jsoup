package com.kshrd.dagger2.app.di.module;

import com.kshrd.dagger2.app.di.qualifier.ApiKey;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pirang on 7/17/17.
 */

@Module
public class ConstantModule {

    @Provides
    @ApiKey
    public String provideApiKey(){
        return "Key:absdf123123hsldfk";
    }

    @Provides
    public String provideApiUrl(){
        return "http://111.222.333:8080";
    }

}
