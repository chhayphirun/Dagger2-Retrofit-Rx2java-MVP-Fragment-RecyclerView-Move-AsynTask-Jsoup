package com.kshrd.dagger2.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.Unbinder;

/**
 * Created by pirang on 7/20/17.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    private BaseActivity baseActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity){
            BaseActivity baseActivity = (BaseActivity) context;
            this.baseActivity = baseActivity;
            onInject(baseActivity);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view, savedInstanceState);
    }

    public abstract void setUp(View view, Bundle savedInstanceState);

    public abstract void onInject(BaseActivity baseActivity);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }
}
