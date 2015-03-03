package com.twu.biblioteca.Library;

import org.junit.Assert;
import org.junit.Test;

public class MovieItemTest {

    @Test
    public void should_get_movie(){
        MovieItem movieItem =new MovieItem("movie1",2000, "director1", "10");
        Assert.assertEquals(true, equalMovie(new MovieItem("movie1", 2000, "director1", "10"), movieItem.getMovie()));

    }


    private boolean equalMovie(MovieItem expected,MovieItem actual){
        if (expected.getName()== actual.getName()&& expected.getDirector() == actual.getDirector()) {
            return true;
        }
        else {
            return false;
        }
    }



}