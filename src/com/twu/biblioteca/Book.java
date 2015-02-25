package com.twu.biblioteca;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class Book {


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

    public String printBookDetail() {

        return "\t" + title + "\t" + author + "\t" + publishDate + "\n";
    }
}
