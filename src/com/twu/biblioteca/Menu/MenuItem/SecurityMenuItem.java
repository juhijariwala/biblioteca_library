package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import com.twu.biblioteca.UserAccount.UserAccount;

import java.io.IOException;

/**
 * Created by juhijariwala on 04/03/15.
 */
public class SecurityMenuItem<T extends LibraryCollection> implements MenuItem<LibraryCollection> {

    Role authorisedRole;
    private MenuItem menuItem;
    private MemberSession memberSession;
    UserAccount userAccount = new UserAccount();

    public SecurityMenuItem(MenuItem menuItem, MemberSession memberSession, Role authorisedRole) {
        this.menuItem = menuItem;
        this.memberSession = memberSession;
        this.authorisedRole = authorisedRole;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        if (memberSession.getUser() == null) {

            String libraryID = ioDevice.readWithLabel("Enter LibraryID:");
            String pwd = ioDevice.readWithLabel("Enter Password:");

            LibraryMember libraryMember = userAccount.login(libraryID, pwd);

            memberSession.setUser(libraryMember);
            if (libraryMember != null) {
                ioDevice.writeln("Successfully logged in!!");
                menuItem.performAction(library, ioDevice);
            } else {
                ioDevice.writeln("Invalid Username or Password!!");
            }
        } else {
            menuItem.performAction(library, ioDevice);
        }
    }

    @Override
    public String printMenu() {
        return menuItem.printMenu();
    }

    @Override
    public boolean shouldShowMenu() {
        if ( authorisedRole.equals(Role.PUBLIC))
            return true;
        if (authorisedRole.equals(Role.LIBRARIAN)) {
            if (authorisedRole.equals(memberSession.getUser().getRole()))
                return true;
        }
        return false;
    }

}
