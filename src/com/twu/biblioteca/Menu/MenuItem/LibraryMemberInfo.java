package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import java.io.IOException;

/**
 * Created by juhijariwala on 04/03/15.
 */
public class LibraryMemberInfo implements MenuItem {
    private MemberSession memberSession;
    public LibraryMemberInfo(MemberSession memberSession) {
        this.memberSession = memberSession;
    }

    @Override
    public void performAction(LibraryCollection library,IODevice ioDevice) throws IOException {
        ioDevice.writeln("******************Member Information*****************");
        ioDevice.writeln("Name : "+ memberSession.getUser().getName(),
                "Email : "+ memberSession.getUser().getEmailAddress(),
                "Phone No : "+ memberSession.getUser().getPhoneNumber());
    }

    @Override
    public String printMenu() {
        return "Member Information";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }
}
