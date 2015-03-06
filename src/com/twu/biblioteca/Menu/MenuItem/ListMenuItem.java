package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class ListMenuItem implements MenuItem<LibraryCollection> {
    public ListMenuItem(PrintingFormat printingFormat) {
        this.printingFormat = printingFormat;
    }

    PrintingFormat printingFormat;
    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        String bookDetailPrintStatement = printingFormat.printLibrayItems(library.getItemList());
        ioDevice.writeln(bookDetailPrintStatement);
    }

    @Override
    public String printMenu() {
        return "List ";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }

}