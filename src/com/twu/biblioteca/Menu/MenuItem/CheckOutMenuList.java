package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import java.io.IOException;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class CheckOutMenuList implements MenuItem {
    private MenuList menuList;

    public CheckOutMenuList(MenuList menuList) {
        this.menuList = menuList;
    }

    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        Integer choice=-1;
        do{
            ioDevice.write("*****Checkout Menu*****\n");
            ioDevice.write("Search Book : Press 4\n");
            ioDevice.write("Check out Book : Press 5\n");
            ioDevice.write("Quit from the Checkout Menu : Press 6\n");
            try {
                choice = Integer.parseInt(ioDevice.read());
                menuList.executeCommand(choice);
            }catch (NumberFormatException e){
                ioDevice.write("Invalid Option!\n");
            }
        }while (choice!=0);
    }
}
