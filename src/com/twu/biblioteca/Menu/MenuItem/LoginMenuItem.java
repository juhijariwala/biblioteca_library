package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.UserAccount;

import java.io.IOException;

/**
 * Created by juhijariwala on 04/03/15.
 */
public class LoginMenuItem<T extends LibraryCollection> implements MenuItem<LibraryCollection> {

    private MenuItem menuItem;
    private MemberSession memberSession;
    UserAccount userAccount = new UserAccount();

    public LoginMenuItem(MenuItem menuItem, MemberSession memberSession) {
        this.menuItem = menuItem;
        this.memberSession = memberSession;
    }

    @Override
    public void performAction(LibraryCollection library, PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        if (memberSession.getUser() == null) {
            ioDevice.write("\nEnter LibraryID:");
            String libraryID = ioDevice.read();
            ioDevice.write("\nEnter Password:");
            String pwd = ioDevice.read();
            LibraryMember libraryMember = userAccount.login(libraryID, pwd);
            memberSession.setUser(libraryMember);
            if (libraryMember != null) {
                ioDevice.write("\nSuccessfully logged in!!\n\n");
                menuItem.performAction(library, printingFormat, ioDevice);
            } else {
                ioDevice.write("\nInvalid Username or Password!!\n\n");
            }
        } else {
            menuItem.performAction(library, printingFormat, ioDevice);
        }
    }
}
