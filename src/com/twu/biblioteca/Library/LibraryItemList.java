package com.twu.biblioteca.Library;

import com.twu.biblioteca.Customer.Customer;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class LibraryItemList<T extends LibraryItem>  {
    private ArrayList<T> itemList = new ArrayList<T>();

    private Customer customer = new Customer();

    public void addItem(T t) {
        itemList.add(t);
    }

    public ArrayList<T> getItemList() {
        return itemList;
    }

    public ArrayList<T> search(String title) {

        ArrayList<T> searchedItems = new ArrayList<T>();
        for (T t : itemList) {
            if (t.getTitle().equals(title)) {
                searchedItems.add(t);
            }
        }
        return searchedItems;
    }

    public T checkout(String title) {
        if (search(title).size() != 0) {
            T t = (T) search(title).get(0);
            itemList.remove(t);
            customer.addItem(t);
            return t;
        }
        return null;
    }

    public ArrayList<T> returnBook(String title) {
        T t = (T) customer.returnItem(title);
        if (t != null) {
            itemList.add(t);
            return getItemList();
        }
        return null;
    }
}
