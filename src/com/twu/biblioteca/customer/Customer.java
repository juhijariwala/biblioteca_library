package com.twu.biblioteca.Customer;

import com.twu.biblioteca.Library.LibraryItem;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class Customer<T extends LibraryItem> {

    private ArrayList<T> itemList = new ArrayList<T>();

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
