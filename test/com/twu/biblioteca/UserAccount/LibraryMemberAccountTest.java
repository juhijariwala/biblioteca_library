package com.twu.biblioteca.UserAccount;

import org.junit.Assert;
import org.junit.Test;

public class LibraryMemberAccountTest {

    @Test
    public void should_login_given_library_id_and_password(){
        UserAccount userAccount=new UserAccount();
        LibraryMember actualLibraryMember =userAccount.login("123-4567","password1");
        Assert.assertEquals("Juhi Jariwala", actualLibraryMember.getName());

    }


}