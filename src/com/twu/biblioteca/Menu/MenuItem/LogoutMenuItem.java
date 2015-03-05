package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 05/03/15.
 */
public class LogoutMenuItem  implements MenuItem{
    private MemberSession memberSession;
    public LogoutMenuItem(MemberSession memberSession) {
        this.memberSession = memberSession;
    }

    @Override
    public void performAction(LibraryCollection library, PrintingFormat printingFormat, IODevice ioDevice) throws IOException {

        if(memberSession.getUser()==null){
            ioDevice.writeln("You are not Logged in!!\n");
        }
        else {
            memberSession.eraseUser();
            ioDevice.writeln("Successfully logged out!!");
        }

    }
}
