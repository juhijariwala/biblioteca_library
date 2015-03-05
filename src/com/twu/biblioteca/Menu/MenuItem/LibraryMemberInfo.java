package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.UserSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 04/03/15.
 */
public class LibraryMemberInfo implements MenuItem {
    private UserSession userSession;
    public LibraryMemberInfo(UserSession userSession) {
        this.userSession=userSession;
    }

    @Override
    public void performAction(LibraryCollection library, PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        String outStatement="Name : "+userSession.getUser().getName()+"\n";
        outStatement+="Email : "+userSession.getUser().getEmailAddress()+"\n";
        outStatement+="Phone No : "+userSession.getUser().getPhoneNumber()+"\n";
    ioDevice.writeln(outStatement);
    }
}
