package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.UserSession;
import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ReturnMenuItem implements MenuItem<LibraryCollection> {
    UserSession userSession;
    public ReturnMenuItem(UserSession userSession) {
        this.userSession = userSession;
    }
    @Override
    public void performAction(LibraryCollection library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String title;
        ioDevice.writeln(printingFormat.printUserInputHeader());
        title = ioDevice.read();
        ArrayList<LibraryItem> itemList = library.returnItem(title, userSession.getUser());
        if (itemList != null) {
            ioDevice.writeln(printingFormat.printLibrayItems(itemList));
        }
        else
        ioDevice.writeln(printingFormat.failureMessage());

    }
}