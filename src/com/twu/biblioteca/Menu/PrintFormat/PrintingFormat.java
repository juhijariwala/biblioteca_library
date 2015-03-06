package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.LibraryItem;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 03/03/15.
 */
public interface PrintingFormat<T extends LibraryItem> {

    public String printItem(T t);

    public String printLibrayItems(ArrayList<T> t);

}

