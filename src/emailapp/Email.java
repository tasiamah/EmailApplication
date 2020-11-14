package emailapp;

import java.util.Scanner;

public class Email {
    private static int PASSWORD_LENGTH = 8;
    private static int MAIL_CAPICITY = 1000;
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String emailadress;
    private String alternateEmail;
    private String companySuffix = "dp.com";
    private int inbox;


    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        System.out.println("Deparment: " + this.department);

        this.password = randomPassword(PASSWORD_LENGTH);
        System.out.println("Your password is: " + this.password);

        this.emailadress = firstName.toLowerCase() +"."+ lastName.toLowerCase() + "@" + department + companySuffix;
        System.out.println("Your emailadress is: " + emailadress);
    }

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {
            return "sales";
        } else if (departmentChoice == 2) {
            return "dev";
        } else if (departmentChoice == 3) {
            return "acct";
        } else return "";
    }

    private String randomPassword (int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char[] password = new char[length];
        for (int i=0;i<length;i++){
           int random =  (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(random);
        }
        return new String(password);

    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public static int getMailCapicity() {
        return MAIL_CAPICITY;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo () {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + emailadress +
                "\nMAILBOX CAPACITY " + MAIL_CAPICITY + "MB";
    }
}


