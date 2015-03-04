package com.twu.biblioteca.UserAccount;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by juhijariwala on 04/03/15.
 */
public class UserAccount {

    private ArrayList<LibraryMember> libraryMemberList = new ArrayList<LibraryMember>(Arrays.asList(
            new LibraryMember("123-4567", "Juhi Jariwala", "juhi.jari@gmail.com", "123456789", "password1"),
            new LibraryMember("123-4568", "Diana Devasia", "dianadev@gmail.com", "123456789", "password2"),
            new LibraryMember("123-4569", "Sana Singh", "sanasingh@gmail.com", "123456789", "password3")
    ));


    public LibraryMember login(String libraryID, String password) {

        for(LibraryMember libraryMember : libraryMemberList){
            if(libraryMember.getLibraryID()==libraryID && libraryMember.getPassword()==password){
                return libraryMember;
            }
        }
        return null;
    }
}
