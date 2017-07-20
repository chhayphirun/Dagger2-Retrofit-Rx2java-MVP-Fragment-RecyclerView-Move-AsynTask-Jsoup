package com.kshrd.dagger2.app.di.component;

import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.app.di.qualifier.ApiKey;
import com.kshrd.dagger2.data.PreferenceHelper;
import com.kshrd.dagger2.ui.detail.DetailActivity;
import com.kshrd.dagger2.ui.detail.fragment.BlankFragment;
import com.kshrd.dagger2.ui.main.MainActivity;
import com.kshrd.dagger2.app.di.module.ApplicationModule;
import com.kshrd.dagger2.app.di.module.ConstantModule;
import com.kshrd.dagger2.app.di.module.PreferenceModule;
import com.kshrd.dagger2.app.di.module.RestfulModule;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by pirang on 7/17/17.
 */

@Singleton
@Component(modules = {ConstantModule.class, ApplicationModule.class, PreferenceModule.class, RestfulModule.class})
public interface ApplicationComponent {

    /**
     *
     * In case you want to use Field Injection , you need to add code below
     */

    PreferenceHelper preferenceHelper();

    String apiUrl();

    @ApiKey
    String apiKey();

    ArticleApi articleApi();

    CompositeDisposable compositeDisposable();


}
