package com.twu.biblioteca;

import com.twu.biblioteca.App.UserSession;
import com.twu.biblioteca.UserAccount.LibraryMember;

/**
 * Created by juhijariwala on 04/03/15.
 */
public class MockUserSessionHolder implements UserSession{
    private LibraryMember sessionLibraryMember;
    @Override
    public void setUser(LibraryMember libraryMember) {
        this.sessionLibraryMember=libraryMember;
    }

    @Override
    public LibraryMember getUser() {
        return sessionLibraryMember;
    }

    @Override
    public void eraseUser() {
        this.sessionLibraryMember=null;
    }
}
