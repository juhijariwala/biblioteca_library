package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 06/03/15.
 */
public class GenerateReportMenuItem implements MenuItem {

    private PrintingFormat printingFormat;

    public GenerateReportMenuItem(PrintingFormat printingFormat) {
        this.printingFormat = printingFormat;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {

            String libraryID=ioDevice.readWithLabel("Enter Member's LibraryID to view report :");

            if(library.checkoutItemsByMember(libraryID).size()!=0)
                ioDevice.writeln(printingFormat.printLibrayItems(library.checkoutItemsByMember(libraryID)));

            else
                ioDevice.writeln("Library member is not available or no items has been checked out by that member.");

    }

    @Override
    public String printMenu() {
        return "Report of Checked Out ";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }
}
