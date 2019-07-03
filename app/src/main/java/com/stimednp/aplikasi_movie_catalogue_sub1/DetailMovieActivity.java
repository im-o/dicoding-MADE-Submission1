package com.stimednp.aplikasi_movie_catalogue_sub1;

import android.app.Person;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.blurry.Blurry;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvMovieTitle, tvMovieDesc, tvMovieRelease, tvMovieGenre, tvMovieRating;
    ImageView imgMoviePhoto, imgMovieBg;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvMovieTitle = findViewById(R.id.tv_movie_detail_title);
        tvMovieDesc = findViewById(R.id.tv_movie_detail_desc);
        tvMovieRelease = findViewById(R.id.tv_movie_detail_release);
        tvMovieGenre = findViewById(R.id.tv_movie_detail_genres);
        tvMovieRating = findViewById(R.id.tv_movie_detail_rating);
        imgMoviePhoto = findViewById(R.id.img_movie_detail_photo);
        imgMovieBg = findViewById(R.id.img_movie_background);
        mToolbar = findViewById(R.id.tb_movie_detail);
        setSupportActionBar(mToolbar);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String titile = movie.getMovieTitle();
        String desc = movie.getMovieDescription();
        String release = movie.getMovieRelease();
        String genre = movie.getMovieGenre();
        String rating = movie.getMovieRating();
        int imgId = movie.getMoviePhoto();

        //get year exp : (2018)
        String releaseYear = "";
        if (release.length() >= 4){
            releaseYear = release.substring(release.length() - 4);
        }
        tvMovieTitle.setText(String.format(titile+" (%s)", releaseYear));
        tvMovieDesc.setText(desc);
        tvMovieRelease.setText(release);
        tvMovieGenre.setText(genre);
        tvMovieRating.setText(rating);
        Glide.with(getApplicationContext())
                .load(imgId)
                .centerCrop()
                .into(imgMoviePhoto);
        Glide.with(getApplicationContext())
                .load(imgId)
                .override(150,230)
                .centerCrop()
                .into(imgMovieBg);

        //call method
        setActionBarToolbar();
    }

    private void setActionBarToolbar() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
