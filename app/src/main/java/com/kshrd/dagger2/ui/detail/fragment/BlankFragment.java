package com.kshrd.dagger2.ui.detail.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kshrd.dagger2.R;
import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.app.MyApplication;
import com.kshrd.dagger2.base.BaseActivity;
import com.kshrd.dagger2.base.BaseFragment;
import com.kshrd.dagger2.data.PreferenceHelper;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {

    @Inject
    PreferenceHelper preferenceHelper;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onInject(BaseActivity activity) {
        activity.getActivityComponent().inject(this);
    }

    @Override
    public void setUp(View view, Bundle savedInstanceState) {
        Toast.makeText(getBaseActivity(), preferenceHelper.getUserId() + "", Toast.LENGTH_SHORT).show();
    }
}
