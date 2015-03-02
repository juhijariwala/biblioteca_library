package com.twu.biblioteca.Library;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {

    @Test
    public void should_get_movie(){
        Movie movie=new Movie("movie1",2000, "director1", "10");
        Assert.assertEquals(true, equalMovie(new Movie("movie1", 2000, "director1", "10"), movie.getMovie()));

    }


    private boolean equalMovie(Movie expected,Movie actual){
        if (expected.getName()== actual.getName()&& expected.getDirector() == actual.getDirector()) {
            return true;
        }
        else {
            return false;
        }
    }



}