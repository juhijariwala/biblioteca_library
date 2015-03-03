package com.twu.biblioteca.Library;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 02/03/15.
 */

interface Item{
  public String getTitle();
}

class BookI implements Item{
    String title;

    public BookI(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
class MovieI implements Item{
    String title;

    public MovieI(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
class Lib<T extends Item> {
    ArrayList<T> itemList=new ArrayList<T>();
    public void addItem(T t){
        itemList.add(t);
    }
    public String returme(String name){
        for(T t:itemList){
            if(name == t.getTitle()){
                return t.getTitle();
            }
        }
        return null;
    }


}
public class TestLibrary {
    public static void main(String[] args) {
        Lib<BookI> booklib=new Lib<BookI>();
        booklib.addItem(new BookI("book1"));
        booklib.addItem(new BookI("book2"));
        System.out.println(booklib.returme("book1"));
    }
}
