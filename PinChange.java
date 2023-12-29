package InputOutput.FileHandling.ATM_ManagementSystem;

import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.Login.login;
import static InputOutput.FileHandling.ATM_ManagementSystem.PinMatch.pinMatch;

public class PinChange {

    public static void pinChange(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("To change your Old PIN and set New PIN, please follow below steps");
        System.out.println("\u001B[33mWarning: Enter your Name as same as you write before...!\u001B[0m");
        System.out.print("1.Enter ATM no: ");
        float a = sc.nextFloat();
        System.out.print("2.Enter your Old PIN: ");
        float b = sc.nextFloat();
        System.out.print("3.Enter your Name: ");
        String check = sc.next();
        if(a % 1 == 0 && b % 1 == 0) {
            if(check.equals(c) && (int)a == 12345 && (int)b == balance[2]) {
                System.out.println("Detail Verifying, it will takes few seconds. please Wait...!");
                System.out.println("\u001B[33mDetails verified successfully.\u001B[0m");
                balance[1] = 3;
                pinMatch(balance, c);
            } else {
                reCheck(balance, c);
            }
        }else {
            System.out.println("Try with number's only, you use Decimal value here...!");
            reCheck(balance, c);
        }
    }
    public static void reCheck(double[] balance, String c) {
        if(balance[1] != 0) {
            System.out.println("\u001B[31mSomething went wrong or MisMatch, please try again with valid input..");
            System.out.println("Warning : You have only " + (int)balance[1]  + " Attempts left\u001B[0m");
            System.out.print("\n");
            balance[1] -= 1;
            pinChange(balance, c);
        }
        if(balance[1] == 0) {
            balance[1] = 3;
            System.out.println("\u001B[33mToo many attempt's : we stop service to your account for next 24 hours\u001B[0m");
            System.out.println("Service Stop Process Started...!");
            balance[2] = 54321;
            login(balance, c);
        }
    }
}
