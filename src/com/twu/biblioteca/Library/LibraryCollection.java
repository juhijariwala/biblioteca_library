package com.twu.biblioteca.Library;

import com.twu.biblioteca.UserAccount.LibraryMember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class LibraryCollection<T extends LibraryItem> {

    private ArrayList<T> itemList = new ArrayList<T>();

    private HashMap<LibraryMember, ArrayList<LibraryItem>> checkedOutItems = new HashMap<LibraryMember, ArrayList<LibraryItem>>();


    public HashMap<LibraryMember, ArrayList<LibraryItem>> getCheckedOutItems() {
        return checkedOutItems;
    }


    public void add(ArrayList<T> t) {
        itemList = t;
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

    public T checkout(String title, LibraryMember libraryMember) {
        if (search(title).size() != 0) {
            T t = (T) search(title).get(0);

            itemList.remove(t);

            if (checkedOutItems.get(libraryMember) != null) {
                checkedOutItems.get(libraryMember).add(t);
            } else {
                checkedOutItems.put(libraryMember, new ArrayList<LibraryItem>(Arrays.asList(t)));
            }

            return t;
        }
        return null;
    }

    public ArrayList<T> returnItem(String title, LibraryMember libraryMember) {
        if (checkedOutItems.get(libraryMember) != null) {
            for (T t : (ArrayList<T>)checkedOutItems.get(libraryMember)) {
                if (t.getTitle().equals(title)) {
                    checkedOutItems.get(libraryMember).remove(t);
                    itemList.add(t);
                    return getItemList();
                }
            }
            return null;
        }
        return null;
    }

}


