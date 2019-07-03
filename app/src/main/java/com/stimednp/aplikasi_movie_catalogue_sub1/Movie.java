package com.stimednp.aplikasi_movie_catalogue_sub1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rivaldy on 6/24/2019.
 */

public class Movie implements Parcelable {
    private int moviePhoto;
    private String movieTitle, movieDescription, movieRelease, movieGenre, movieRating;

    public int getMoviePhoto() {
        return moviePhoto;
    }

    public void setMoviePhoto(int moviePhoto) {
        this.moviePhoto = moviePhoto;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(String movieRelease) {
        this.movieRelease = movieRelease;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.moviePhoto);
        dest.writeString(this.movieTitle);
        dest.writeString(this.movieDescription);
        dest.writeString(this.movieRelease);
        dest.writeString(this.movieGenre);
        dest.writeString(this.movieRating);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.moviePhoto = in.readInt();
        this.movieTitle = in.readString();
        this.movieDescription = in.readString();
        this.movieRelease = in.readString();
        this.movieGenre = in.readString();
        this.movieRating = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
