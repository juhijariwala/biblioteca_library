package com.twu.biblioteca.Library;

import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MovieLibraryTest {
    @Test
    public void should_return_list_of_movies(){
        Library library =new Library();
        Movie movie1 =new Movie("movie1", 2000, "director1", "10");
        Movie movie2 =new Movie("movie2", 2000, "director1", "10");
        ArrayList<Movie> movieList=new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);
        library.getMovieLibrary().add(movieList);
        ArrayList<Movie> actualMovieList = library.getMovieLibrary().getItemList();
        ArrayList<Movie> expectedMovieList = new ArrayList<Movie>();
        expectedMovieList.add(new Movie("movie1",2000, "director1", "10"));
        expectedMovieList.add(new Movie("movie2",2000, "director1", "10"));
        Assert.assertEquals(true, checkEqualbookList(expectedMovieList, actualMovieList));
    }

    @Test
    public void should_checkOutMovie(){
        Library library =new Library();
        Movie movie1 =new Movie("movie1", 2000, "director1", "10");
        Movie movie2 =new Movie("movie2", 2000, "director1", "10");
        ArrayList<Movie> movieList=new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);
        library.getMovieLibrary().add(movieList);
        Movie actualMovie = library.getMovieLibrary().checkout("movie2",  new LibraryMember("123-4567","Juhi","juhi.jari@gmail.com","12345678","password1", Role.USER));
        Assert.assertEquals(true,checkEqualMovie(movie2, actualMovie));

    }
    private boolean checkEqualbookList(ArrayList<Movie> expectedMovieList, ArrayList<Movie> actualMovieList){
        if(expectedMovieList.size()== actualMovieList.size()){
            for(int i=0;i< expectedMovieList.size();i++){
                if(!checkEqualMovie(expectedMovieList.get(i), actualMovieList.get(i))){
                    return false;
                }
            }
        }
        else {
            return false;
        }
                return true;
    }

    private boolean checkEqualMovie(Movie expectedMovie, Movie actualMovie){
        if (!actualMovie.getYear().equals(expectedMovie.getYear())) {
            return false;
        } else if (!actualMovie.getDirector().equals(expectedMovie.getDirector())) {
            return false;
        } else if (!actualMovie.getTitle().equals(expectedMovie.getTitle())) {
            return false;
        }
        return true;
    }
}
