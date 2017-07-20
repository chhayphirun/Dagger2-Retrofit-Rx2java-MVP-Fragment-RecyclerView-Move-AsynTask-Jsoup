package com.kshrd.dagger2.app.di.component;

import com.kshrd.dagger2.app.di.module.ActivityModule;
import com.kshrd.dagger2.app.di.scope.PerActivity;
import com.kshrd.dagger2.ui.detail.DetailActivity;
import com.kshrd.dagger2.ui.detail.fragment.BlankFragment;
import com.kshrd.dagger2.ui.main.MainActivity;

import dagger.Component;
import dagger.Module;

/**
 * Created by pirang on 7/20/17.
 */

@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);
    void inject(BlankFragment blankFragment);
}
