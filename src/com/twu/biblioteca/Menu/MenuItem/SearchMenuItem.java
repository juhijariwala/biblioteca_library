package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class SearchMenuItem implements MenuItem<LibraryCollection> {
    @Override
    public void performAction(LibraryCollection library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String msg = printingFormat.printUserInputHeader();
        ioDevice.writeln(msg);
        String title = ioDevice.read();
        ArrayList<LibraryItem> searchedBookItemList = library.search(title);
        if(searchedBookItemList.size()!=0)
            ioDevice.writeln(printingFormat.printLibrayItems(searchedBookItemList));
        else
            ioDevice.writeln(printingFormat.failureMessage());
        }


}
