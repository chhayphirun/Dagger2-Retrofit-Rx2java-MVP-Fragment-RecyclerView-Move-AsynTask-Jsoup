package com.kshrd.dagger2.app.di;

import com.kshrd.dagger2.MainActivity;
import dagger.Component;

/**
 * Created by pirang on 7/17/17.
 */

@Component(modules = ConstantModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

}
