package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ReturnItemMenuItem implements MenuItem<LibraryManager> {

    @Override
    public void performAction(LibraryManager library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String title;
        ioDevice.write(printingFormat.printUserInputHeader());
        title = ioDevice.read();
        ArrayList<LibraryItem> itemList = library.returnItem(title,library.getLoggedinMember() );
        if (itemList != null) {
            ioDevice.write(printingFormat.printLibrayItems(itemList));
        }
        else
        ioDevice.write(printingFormat.failureMessage());

    }
}
