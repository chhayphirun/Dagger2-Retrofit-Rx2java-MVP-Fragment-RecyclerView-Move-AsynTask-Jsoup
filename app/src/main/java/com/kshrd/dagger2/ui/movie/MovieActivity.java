package com.kshrd.dagger2.ui.movie;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kshrd.dagger2.R;
import com.kshrd.dagger2.adapter.MovieAdapter;
import com.kshrd.dagger2.app.di.component.ActivityComponent;
import com.kshrd.dagger2.base.BaseActivity;
import com.kshrd.dagger2.entity.Movie;
import com.kshrd.dagger2.listener.MyclickListener;
import com.kshrd.dagger2.ui.movie.mvp.MovieContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity implements MovieContract.View,MyclickListener {
    private ProgressDialog progressDialog;
    AlertDialog.Builder showInternetConnectionDialog;
    @Inject
    MovieContract.Presenter presenter;
    @BindView(R.id.rvmovies)
    RecyclerView recyclerViewMovie;

    MovieAdapter adapter;
    private List<Movie> movieList;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        getSupportActionBar().setTitle("Home");
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading ...");
        setUnbinder(ButterKnife.bind(this));
        setUnbinder(ButterKnife.bind(this));
        showInternetConnectionDialog=new AlertDialog.Builder(this);

        setupListView();
        presenter.onAttach(this);

        if (isNetworkConnected()) {
            presenter.findMovie();

        }else {

            showInternetConnectionDialog = new AlertDialog.Builder(this);
            showInternetConnectionDialog
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("No Internet Connection!")
                    .setMessage("Please enable Mobile Data or Wi-Fi")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                   /* .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })*/
            ;
//                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
//                            }
//                        });
            AlertDialog dialog = showInternetConnectionDialog.create();
            dialog.show();
            Log.e("ooooo","no internet connection");
        }
    }

    private void setupListView() {
        movieList = new ArrayList<>();
        recyclerViewMovie= (RecyclerView) findViewById(R.id.rvmovies);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter=new MovieAdapter(this,movieList);
        recyclerViewMovie.setAdapter(adapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void updateRecyclerView(List<Movie> movieList) {
        this.movieList.addAll(movieList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onClicked(int position, View v) {
        final Movie movie=movieList.get(position);
        Log.e("ooo1",movie.getLinktrailer());
        TextView trailer= (TextView) v.findViewById(R.id.trailer);
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getLinktrailer()));
        startActivity(intent);
    }

    @Override
    public void onDetailclick(int position, View v) {
        final Movie movie=movieList.get(position);
        ImageView imageView= (ImageView) v.findViewById(R.id.ivThumbnail);
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getLink()));
        startActivity(intent);
    }
}
