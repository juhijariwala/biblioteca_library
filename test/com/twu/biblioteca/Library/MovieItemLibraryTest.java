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
        library.getMovieLibrary().addItem(movieItem1);
        library.getMovieLibrary().addItem(movieItem2);
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
        library.getMovieLibrary().addItem(movieItem1);
        library.getMovieLibrary().addItem(movieItem2);
        MovieItem actualMovieItem = library.getMovieLibrary().checkout("movie2");
//        Assert.assertEquals(true, checkEqualbookList(expectedMovieItemList, actualMovieItemList));

    }
    private boolean checkEqualbookList(ArrayList<MovieItem> expectedMovieItemList, ArrayList<MovieItem> actualMovieItemList){
        if(expectedMovieItemList.size()== actualMovieItemList.size()){
            for(int i=0;i< expectedMovieItemList.size();i++){
                if (!actualMovieItemList.get(i).getYear().equals(expectedMovieItemList.get(i).getYear())) {
                    return false;
                } else if (!actualMovieItemList.get(i).getDirector().equals(expectedMovieItemList.get(i).getDirector())) {
                    return false;
                } else if (!actualMovieItemList.get(i).getName().equals(expectedMovieItemList.get(i).getName())) {
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