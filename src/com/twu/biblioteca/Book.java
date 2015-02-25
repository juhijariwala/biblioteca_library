package com.twu.biblioteca;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class Book {
    private String title;
    private String author;
    private String publishDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (publishDate != null ? !publishDate.equals(book.publishDate) : book.publishDate != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;

        return true;
    }


    public Book(String title, String author, String publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;

    }

    public String printBookDetail() {

        return "\t"+title+"\t"+author+"\t"+publishDate+"\n";
    }
}
