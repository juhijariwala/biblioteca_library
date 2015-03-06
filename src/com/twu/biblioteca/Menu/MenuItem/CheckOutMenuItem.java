package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Menu.PrintFormat.IMessageTemplate;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

public class CheckOutMenuItem implements MenuItem<LibraryCollection> {
    MemberSession memberSession;
    IMessageTemplate messageTemplate;
    public CheckOutMenuItem(IMessageTemplate template, MemberSession memberSession) {
        this.messageTemplate = template;
        this.memberSession = memberSession;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        String outStatement;
        String title=ioDevice.readWithLabel(messageTemplate.printUserInputHeader());
        LibraryItem libraryItem = library.checkout(title, memberSession.getUser());
        if (libraryItem !=null){
            outStatement = messageTemplate.successMessage();
        }
        else {
            outStatement = messageTemplate.failureMessage();
        }
        ioDevice.writeln(outStatement);
    }

    @Override
    public String printMenu() {
        return "Check Out ";
    }

    @Override
    public boolean shouldShowMenu() {
        return false;
    }
}
