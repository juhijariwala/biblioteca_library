package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.UserSession;
import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

public class CheckOutMenuItem implements MenuItem<LibraryManager> {
    UserSession userSession;
    public CheckOutMenuItem(UserSession userSession) {
        this.userSession = userSession;
    }
    @Override
    public void performAction(LibraryManager library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String outStatement;
        ioDevice.writeln(printingFormat.printUserInputHeader());
        String title = ioDevice.read();
        LibraryItem libraryItem = library.checkout(title,userSession.getUser());
        if (libraryItem !=null){
            outStatement=printingFormat.successMessage();
        }
        else {
            outStatement=printingFormat.failureMessage();
        }
        ioDevice.writeln(outStatement);
    }
}
