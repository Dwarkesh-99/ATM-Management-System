package InputOutput.FileHandling.ATM_ManagementSystem;

import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.ATMSystem.option;

public class Login {

    public static int login(double[] balance, String c) {
        String atmNum = "12345";
        String pass = String.valueOf((int)balance[2]);
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ATM Banking System, to connect with us follow below steps...!");
        System.out.println("#Default ATM No. & Password is '12345'");

        System.out.print("1.Enter ATM no: ");
        String a = sc.next();
        System.out.print("2.Enter your number Digit PIN: ");
        String b = sc.next();
        System.out.print("3.Enter your Name: ");
        c = sc.next();
        System.out.println("\n");

        if(balance[2] == 543210) {
            System.out.println("\u001B[33mWarning: This Account is Blocked for next 3 days\u001B[0m");
            System.out.println("If above info is wrong, go to your near Branch or call us on: 0257-2255663 ");
            System.out.print("\n");
            System.exit(0);
        }
        if(balance[2] == 54321) {
            System.out.println("\u001B[33mWarning: This account service is stop for next 24 hours, try after 24 hours...\u001B[0m");
            System.out.println("If above info is wrong, go to your near Branch or call us on: 0257-2255663 ");
            System.out.println("\n");
            System.exit(0);
        }

        if(a.equals(atmNum) && b.equals(pass)) {
                System.out.println("\u001B[32mWelcome back " + "'" + c + "' !" + "\u001B[0m");
                option(balance, c);
        }else {
            System.out.println("Try with valid input's..!");
            check(balance, c);
        }
        return 0;
    }
    public static void check(double[] balance, String c) {
        if (balance[1] != 0) {

            System.out.println("\u001B[31mYour enter PIN/ATM no. is invalid, Please try with valid no.\u001B[0m");
            System.out.println("\u001B[33mWarning : You have only " + (int) balance[1] + " Attempts left\u001B[0m");
            balance[1] -= 1;
            login(balance, c);

        }
        if (balance[1] == 0) {
            balance[1] = 3;
            System.out.println("\u001B[33mToo many attempt's : we block your account for 3 working days.\u001B[0m");
            System.out.println("Blocking Process Start...!");
            System.out.println("Now, you are Blocked..");
            balance[2] = 543210;
            login(balance, c);
        }
    }
}
