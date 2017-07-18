package com.kshrd.dagger2.app.di.component;

import com.kshrd.dagger2.DetailActivity;
import com.kshrd.dagger2.MainActivity;
import com.kshrd.dagger2.app.di.module.ApplicationModule;
import com.kshrd.dagger2.app.di.module.ConstantModule;
import com.kshrd.dagger2.app.di.module.PreferenceModule;
import com.kshrd.dagger2.app.di.module.RestfulModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pirang on 7/17/17.
 */

@Singleton
@Component(modules = {ConstantModule.class, ApplicationModule.class, PreferenceModule.class, RestfulModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);

}
