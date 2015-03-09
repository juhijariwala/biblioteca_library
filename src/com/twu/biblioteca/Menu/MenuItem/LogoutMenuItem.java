package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;


public class LogoutMenuItem implements MenuItem {
    private MemberSession memberSession;

    public LogoutMenuItem(MemberSession memberSession) {
        this.memberSession = memberSession;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {

        if (memberSession.getUser() == null) {
            ioDevice.writeln("You are not Logged in!!\n");
        } else {
            memberSession.eraseUser();
            ioDevice.writeln("Successfully logged out!!");
        }

    }

    @Override
    public String printMenu() {
        return "Logout";
    }

    @Override
    public boolean shouldShowMenu() {
        if (memberSession.getUser() == null)
            return false;
        return true;

    }
}
