package com.twu.biblioteca.Library;

public class Book implements LibraryItem {


    private String title;
    private String author;
    private String publishDate;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public String getPublishDate() {
        return publishDate;
    }


    public Book(String title, String author, String publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;

    }
}
