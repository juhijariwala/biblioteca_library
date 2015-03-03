package com.twu.biblioteca.Library;

public class MovieItem implements LibraryItem{
    private String name;
    private Integer year;
    private String director;
    private String rating;

    public MovieItem(String name, Integer year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }


    public MovieItem getMovie() {
        return this;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String getTitle() {
        return name;
    }
}
