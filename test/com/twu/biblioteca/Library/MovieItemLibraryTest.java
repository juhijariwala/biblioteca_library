package com.twu.biblioteca.Library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MovieItemLibraryTest {
    @Test
    public void should_return_list_of_movies(){
        Library library =new Library();
        MovieItem movieItem1 =new MovieItem("movie1", 2000, "director1", "10");
        MovieItem movieItem2 =new MovieItem("movie2", 2000, "director1", "10");
        ArrayList<MovieItem> movieList=new ArrayList<MovieItem>();
        movieList.add(movieItem1);
        movieList.add(movieItem2);
        library.getMovieLibrary().add(movieList);
        ArrayList<MovieItem> actualMovieItemList = library.getMovieLibrary().getItemList();
        ArrayList<MovieItem> expectedMovieItemList = new ArrayList<MovieItem>();
        expectedMovieItemList.add(new MovieItem("movie1",2000, "director1", "10"));
        expectedMovieItemList.add(new MovieItem("movie2",2000, "director1", "10"));
        Assert.assertEquals(true, checkEqualbookList(expectedMovieItemList, actualMovieItemList));
    }

    @Test
    public void should_checkOutMovie(){
        Library library =new Library();
        MovieItem movieItem1 =new MovieItem("movie1", 2000, "director1", "10");
        MovieItem movieItem2 =new MovieItem("movie2", 2000, "director1", "10");
        ArrayList<MovieItem> movieList=new ArrayList<MovieItem>();
        movieList.add(movieItem1);
        movieList.add(movieItem2);
        library.getMovieLibrary().add(movieList);
        MovieItem actualMovieItem = library.getMovieLibrary().checkout("movie2", library.getBookLibrary().getLoggedinMember());
        Assert.assertEquals(true,checkEqualMovie(movieItem2 ,actualMovieItem));

    }
    private boolean checkEqualbookList(ArrayList<MovieItem> expectedMovieItemList, ArrayList<MovieItem> actualMovieItemList){
        if(expectedMovieItemList.size()== actualMovieItemList.size()){
            for(int i=0;i< expectedMovieItemList.size();i++){
                if(!checkEqualMovie(expectedMovieItemList.get(i),actualMovieItemList.get(i))){
                    return false;
                }
            }
        }
        else {
            return false;
        }
                return true;
    }

    private boolean checkEqualMovie(MovieItem expectedMovieItem, MovieItem actualMovieItem){
        if (!actualMovieItem.getYear().equals(expectedMovieItem.getYear())) {
            return false;
        } else if (!actualMovieItem.getDirector().equals(expectedMovieItem.getDirector())) {
            return false;
        } else if (!actualMovieItem.getTitle().equals(expectedMovieItem.getTitle())) {
            return false;
        }
        return true;
    }
}
