package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.UserSession;
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
    private LibraryMember libraryMember;
    private UserSession userSession;
    UserAccount userAccount = new UserAccount();

    public LoginMenuItem(MenuItem menuItem, UserSession userSession) {
        this.menuItem = menuItem;
        this.userSession = userSession;
    }

    @Override
    public void performAction(LibraryCollection library, PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        if (userSession.getUser() == null) {
            ioDevice.write("\nEnter LibraryID:");
            String libraryID = ioDevice.read();
            ioDevice.write("\nEnter Password:");
            String pwd = ioDevice.read();
            libraryMember = userAccount.login(libraryID, pwd);
            userSession.setUser(libraryMember);
            if (libraryMember != null) {
                ioDevice.write("\nSuccessfully logged in!!\n");
                menuItem.performAction(library, printingFormat, ioDevice);
            } else {
                ioDevice.write("\nInvalid Username or Password!!");
                return;
            }
        }
        else    menuItem.performAction(library, printingFormat, ioDevice);
    }
}
