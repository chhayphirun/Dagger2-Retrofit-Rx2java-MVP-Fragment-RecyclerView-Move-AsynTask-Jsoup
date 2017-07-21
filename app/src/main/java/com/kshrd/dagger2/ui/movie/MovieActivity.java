package com.kshrd.dagger2.ui.movie;

import android.os.Bundle;
import android.widget.Toast;
import com.kshrd.dagger2.R;
import com.kshrd.dagger2.app.di.component.ActivityComponent;
import com.kshrd.dagger2.base.BaseActivity;
import com.kshrd.dagger2.entity.Movie;
import com.kshrd.dagger2.ui.movie.mvp.MovieContract;
import java.util.List;
import javax.inject.Inject;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity implements MovieContract.View {

    @Inject
    MovieContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setUnbinder(ButterKnife.bind(this));

        presenter.onAttach(this);
        presenter.findMovie();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void updateRecyclerView(List<Movie> movieList) {
        Toast.makeText(this, movieList.size() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
