package com.kshrd.dagger2.ui.movie.mvp;

import com.kshrd.dagger2.entity.Movie;
import com.kshrd.dagger2.listener.CallbackWithList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pirang on 7/21/17.
 */

public class MovieInteractor implements MovieContract.Interactor {

    @Inject
    public MovieInteractor(){

    }

    @Override
    public void findMovie(final CallbackWithList<Movie> callback) {
        Observable.create(new ObservableOnSubscribe<List<Movie>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Movie>> subscriber) throws Exception {

                List<Movie> movieList = new ArrayList<>();
                String baseUrl = "https://www.legend.com.kh";
                String url = baseUrl + "/Browsing/Movies/ComingSoon";
                Document document = null;
                try {
                    document = Jsoup.connect(url).get();
                    Elements movies = document.select("article#movies-list div.list-item.movie");
                    for (Element movie : movies) {
                        String posterUrl = movie.select("div.image-outer img").first().attr("src");
                        posterUrl=posterUrl.substring(posterUrl.indexOf('w'));
                        String title = movie.select("div.item-details h3.item-title").first().text();
                        String link = baseUrl + movie.select("div.image-outer a").first().attr("href");
                        String linktrailer = movie.select("div.movie-actions div.alt-action a.play").attr("href");
                        String date = movie.select("div.item-details div.item-details-inner p.movie-opening-date ").first().text();

                        Movie item;
                        if(linktrailer!=null){
                            item = new Movie(title, posterUrl.substring(posterUrl.indexOf('w')), link,linktrailer,date);

                        }else {
                            item = new Movie(title, posterUrl.substring(posterUrl.indexOf('w')), link,"",date);
                        }
                        movieList.add(item);
                    }
                    subscriber.onNext(movieList);

                } catch (IOException e) {
                    subscriber.onError(e);
                }

            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                callback.onSuccess(movieList);
            }
        });
    }
}
