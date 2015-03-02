package com.twu.biblioteca.Library;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class MovieLibrary {
    private ArrayList<Movie> movieList=new ArrayList<Movie>();

    public void addMovie(Movie movie) {
        movieList.add(movie);

    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
