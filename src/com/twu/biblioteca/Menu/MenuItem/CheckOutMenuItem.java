package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

public class CheckOutMenuItem implements MenuItem<LibraryCollection> {
    MemberSession memberSession;
    public CheckOutMenuItem(MemberSession memberSession) {
        this.memberSession = memberSession;
    }
    @Override
    public void performAction(LibraryCollection library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String outStatement;
        ioDevice.writeln(printingFormat.printUserInputHeader());
        String title = ioDevice.read();
        LibraryItem libraryItem = library.checkout(title, memberSession.getUser());
        if (libraryItem !=null){
            outStatement=printingFormat.successMessage();
        }
        else {
            outStatement=printingFormat.failureMessage();
        }
        ioDevice.writeln(outStatement);
    }
}
