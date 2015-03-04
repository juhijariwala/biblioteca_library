package com.twu.biblioteca.UserAccount;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class LibraryMember {
    private String libraryID;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String password;



    public LibraryMember(String libraryID, String name, String emailAddress, String phoneNumber, String password) {
        this.libraryID = libraryID;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public String getLibraryID() {
        return libraryID;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
