package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class CheckOutMainMenuItem implements MenuItem<LibraryCollection>{
    private Menu menu;

    public CheckOutMainMenuItem(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void performAction(LibraryCollection library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        Integer choice=-1;
        do{

            ioDevice.writeln(printingFormat.checkOutMenuStatements());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menu.executeCommand(choice);
            }catch (NumberFormatException e){
                ioDevice.writeln("Invalid Option!\n");
            }
        }while (choice!=0);
    }

}
