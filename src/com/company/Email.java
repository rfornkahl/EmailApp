package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 12;
    private String email;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //Constructor to recieve the first and last name
public Email(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    //System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

    //Call a method that asks for the depatment - return the department
    this.department = setDepartment();
    //System.out.println("Department: " + this.department);

//call a method that returns a random password

    this.password = randomPassword(defaultPasswordLength);
    System.out.println("Your password is: " + this.password);


//Combine elements to generate a email
    email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    //System.out.println("Your email address is: " + email);
}

//Ask for the department
    private String setDepartment(){
    System.out.println("New Worker: " + firstName + "\nDepartment Codes:\n1 for Sales \n2 for Development \n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice ==  1){
            return "sales";
        }else if (depChoice == 2){
            return "dev";
        }else if (depChoice == 3){
            return "acct";
        }else{
            return "";
        }

    }

    //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQURSTUVWYXZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }
    //set the mailbox capacity
public void setMailboxCapacity(int capacity){
    this.mailboxCapacity = capacity;

}
    //set the alternate email address
public void setAlternateEmail(String altEmail){
    this.alternateEmail = altEmail;
}
    //change the password
public void changePassword(String password){
    this.password = password;
}

public int getMailboxCapacity(){
    return mailboxCapacity;
    }
    public String getAlternateEmail(){
    return alternateEmail;
    }
    public String getPassword(){
    return password;
    }
    public String showInfo(){
    return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
            "COMPANY EMAIL: " + email + "\n" +
            "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
