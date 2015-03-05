package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

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
    public void performAction(LibraryCollection library, PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String outStatement="Name : "+ memberSession.getUser().getName()+"\n";
        outStatement+="Email : "+ memberSession.getUser().getEmailAddress()+"\n";
        outStatement+="Phone No : "+ memberSession.getUser().getPhoneNumber()+"\n";

        ioDevice.writeln(outStatement);
    }
}
