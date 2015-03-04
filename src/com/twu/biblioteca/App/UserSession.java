package com.twu.biblioteca.App;

import com.twu.biblioteca.UserAccount.LibraryMember;

public interface UserSession{
    public void setUser(LibraryMember libraryMember);
    public LibraryMember getUser();
    public void eraseUser();

}
