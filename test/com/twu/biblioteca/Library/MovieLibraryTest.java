package com.twu.biblioteca.Library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MovieLibraryTest  {
    @Test
    public void should_return_list_of_movie(){
        MovieLibrary movieLibrary=new MovieLibrary();
        Movie movie1=new Movie("movie1", 2000, "director1", "10");
        Movie movie2=new  Movie("movie2", 2000, "director1", "10");
        movieLibrary.addMovie(movie1);
        movieLibrary.addMovie(movie2);
        ArrayList<Movie> actualMovieList= movieLibrary.getMovieList();
        ArrayList<Movie> expectedMovieList = new ArrayList<Movie>();
        expectedMovieList.add(new Movie("movie1",2000, "director1", "10"));
        expectedMovieList.add(new Movie("movie2",2000, "director1", "10"));
        Assert.assertEquals(true, checkEqualbookList(expectedMovieList, actualMovieList));
    }

    private boolean checkEqualbookList(ArrayList<Movie> expectedMovieList, ArrayList<Movie> actualMovieList){
        if(expectedMovieList.size()==actualMovieList.size()){
            for(int i=0;i<expectedMovieList.size();i++){
                if (!actualMovieList.get(i).getYear().equals(expectedMovieList.get(i).getYear())) {
                    return false;
                } else if (!actualMovieList.get(i).getDirector().equals(expectedMovieList.get(i).getDirector())) {
                    return false;
                } else if (!actualMovieList.get(i).getName().equals(expectedMovieList.get(i).getName())) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
                return true;
    }
}