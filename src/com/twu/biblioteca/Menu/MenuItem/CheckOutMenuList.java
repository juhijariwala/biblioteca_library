package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class CheckOutMenuList implements MenuItem<LibraryManager>{
    private Menu menu;

    public CheckOutMenuList(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void performAction(LibraryManager library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        Integer choice=-1;
        do{

            ioDevice.write(printingFormat.checkOutMenuStatements());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menu.executeCommand(choice);
            }catch (NumberFormatException e){
                ioDevice.write("Invalid Option!\n");
            }
        }while (choice!=0);
    }

}
