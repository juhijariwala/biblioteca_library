package com.twu.biblioteca.Customer;

import com.twu.biblioteca.Library.LibraryItem;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class User<T extends LibraryItem> {
    private String name;
    private String emailAddress;
    private String phoneNumber;


    private ArrayList<T> itemList = new ArrayList<T>();

    public User(String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<T> getItemList() {
        return itemList;
    }

    public void addItem(T t) {
        itemList.add(t);
    }

    public T returnItem(String title) {
        for (T t : itemList) {
            if (t.getTitle().equals(title))
                return t;
        }
        return null;
    }
}
