package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
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
public class ReturnMenuItem implements MenuItem<LibraryCollection> {
    MemberSession memberSession;
    PrintingFormat printingFormat;
    IMessageTemplate messageTemplate;
    public ReturnMenuItem(IMessageTemplate messageTemplate,MemberSession memberSession,PrintingFormat printingFormat) {
        this.memberSession = memberSession;
        this.printingFormat=printingFormat;
        this.messageTemplate=messageTemplate;
    }
    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        String title;
        title =ioDevice.readWithLabel(messageTemplate.printUserInputHeader());
        ArrayList<LibraryItem> itemList = library.returnItem(title, memberSession.getUser());
        if (itemList != null) {
            ioDevice.writeln(printingFormat.printLibrayItems(itemList));
        }
        else
        ioDevice.writeln(messageTemplate.failureMessage());

    }

    @Override
    public String printMenu() {
        return "Return";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }
}
