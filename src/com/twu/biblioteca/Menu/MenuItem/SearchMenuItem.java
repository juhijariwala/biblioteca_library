package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IMessageTemplate;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class SearchMenuItem implements MenuItem<LibraryCollection> {

    IMessageTemplate messageTemplate;
    PrintingFormat printingFormat;

    public SearchMenuItem(IMessageTemplate messageTemplate,PrintingFormat printingFormat) {
        this.messageTemplate = messageTemplate;
        this.printingFormat=printingFormat;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        String title = ioDevice.readWithLabel(messageTemplate.printUserInputHeader());
        ArrayList<LibraryItem> searchedBookItemList = library.search(title);
        if (searchedBookItemList.size() != 0)
            ioDevice.writeln(printingFormat.printLibrayItems(searchedBookItemList));
        else
            ioDevice.writeln(messageTemplate.failureMessage());
    }

    @Override
    public String printMenu() {
        return "Search";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }


}
