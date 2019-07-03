package com.stimednp.aplikasi_movie_catalogue_sub1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by rivaldy on 6/24/2019.
 */

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView tvMovieTitle, tvMovieDesc, tvMovieRelease;
        private ImageView imgMoviePhoto;

        public ViewHolder(View view) {
            tvMovieTitle = view.findViewById(R.id.tv_movie_title);
            tvMovieDesc = view.findViewById(R.id.tv_movie_desc);
            tvMovieRelease = view.findViewById(R.id.tv_movie_release);
            imgMoviePhoto = view.findViewById(R.id.img_movie_photo);
        }

        public void bind(Movie movie) {
            tvMovieTitle.setText(movie.getMovieTitle());
            tvMovieDesc.setText(movie.getMovieDescription());
            tvMovieRelease.setText(movie.getMovieRelease());
            Glide.with(context)
                    .load(movie.getMoviePhoto())
                    .centerCrop()
                    .into(imgMoviePhoto);
        }
    }
}
