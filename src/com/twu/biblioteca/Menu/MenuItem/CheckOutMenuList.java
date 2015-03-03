package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.Library;
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
    public void performAction(Library library, IODevice ioDevice) throws IOException {
        Integer choice=-1;
        do{
            String menuStatement="****************Checkout Menu****************\n";
            menuStatement+="|\tSearch Book : Press 1\n";
            menuStatement+="|\tCheck out Book : Press 2\n";
            menuStatement+="|\tQuit from the Checkout Menu : Press 0\n";
            ioDevice.write(menuStatement);
            try {
                choice = Integer.parseInt(ioDevice.read());
                menuList.executeCommand(choice);
            }catch (NumberFormatException e){
                ioDevice.write("Invalid Option!\n");
            }
        }while (choice!=0);
    }
}
