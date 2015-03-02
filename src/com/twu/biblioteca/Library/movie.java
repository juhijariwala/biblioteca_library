package com.twu.biblioteca.Library;

public class Movie {
    private String name;
    private Integer year;
    private String director;
    private String rating;

    public Movie(String name, Integer year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }


    public Movie getMovie() {
        return this;
    }


    public String getName() {
        return name;
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
}
