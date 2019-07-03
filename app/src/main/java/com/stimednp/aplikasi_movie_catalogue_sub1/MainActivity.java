package com.stimednp.aplikasi_movie_catalogue_sub1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataMovieName;
    private String[] dataMovieDesc;
    private String[] dataMovieRelease;
    private String[] dataMovieGenre;
    private String[] dataMovieRating;
    private TypedArray dataMoviePhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie_catalogue);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //explicit with data
//                Movie parceableMovie = new Movie();
//                parceableMovie.setMovieTitle(movies.get(position).getMovieTitle());
//                parceableMovie.setMovieDescription(movies.get(position).getMovieDescription());
//                parceableMovie.setMovieRelease(movies.get(position).getMovieRelease());
//                parceableMovie.setMovieGenre(movies.get(position).getMovieGenre());
//                parceableMovie.setMovieRating(movies.get(position).getMovieRating());
//                parceableMovie.setMoviePhoto(movies.get(position).getMoviePhoto());
//                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailMovieActivity.class);
//                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, parceableMovie);

                //perbaikan dari dicoding (simple explicit with data parceable)
                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailMovieActivity.class);
                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.get(position));
                startActivity(moveWithObjectIntent);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataMovieName.length; i++) {
            Movie movie = new Movie();
            movie.setMovieTitle(dataMovieName[i]);
            movie.setMovieDescription(dataMovieDesc[i]);
            movie.setMovieRelease(dataMovieRelease[i]);
            movie.setMovieGenre(dataMovieGenre[i]);
            movie.setMovieRating(dataMovieRating[i]);
            movie.setMoviePhoto(dataMoviePhoto.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataMovieName = getResources().getStringArray(R.array.data_movie_title);
        dataMovieDesc = getResources().getStringArray(R.array.data_movie_description);
        dataMovieRelease = getResources().getStringArray(R.array.data_movie_release);
        dataMovieGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataMovieRating = getResources().getStringArray(R.array.data_movie_rating);
        dataMoviePhoto = getResources().obtainTypedArray(R.array.data_movie_photo);
    }
}
