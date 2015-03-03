package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class MainMenuItem implements MenuItem{
    private MenuList menuList;

    public MainMenuItem(MenuList menuList) {
        this.menuList = menuList;
    }

    @Override
    public void performAction(Library library, IODevice ioDevice) throws IOException {

    }
}
