package InputOutput.FileHandling.ATM_ManagementSystem;

import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.ATMSystem.option;
import static InputOutput.FileHandling.ATM_ManagementSystem.Login.login;
import static InputOutput.FileHandling.ATM_ManagementSystem.LogoutAndEnquiry.quit;

public class PinMatch {

    public static void pinMatch(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter New Pin: ");
        float newPin = sc.nextFloat();
        System.out.print("Enter New Pin Again: ");
        float newPinAgain = sc.nextInt();
        if(newPin % 1 == 0 && newPinAgain % 1 == 0) {
            if ((int) newPin == (int) newPinAgain) {
                if (balance[2] != (int) newPin) {
                    balance[2] = (int) newPin;
                    System.out.println("\u001B[32mPassword reset successfully...\u001B[0m");
                    System.out.println("we redirected you to the 'Login Page'");
                    System.out.println("\u001B[33mNote: Login with New Password\u001B[0m");
                    System.out.print("\n");
                    login(balance, c);
                } else {
                    System.out.println("\u001B[33mThis password is already exists, please try with new strong password...!\u001B[0m");
                    pinMatch(balance, c);
                }
            } else {
                thirdCheck(balance, c);
            }
        }else {
            System.out.println("Try with number's only, you use Decimal value here...!");
            thirdCheck(balance, c);
        }
    }

    public static void thirdCheck(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
        if((int)balance[1] != 0) {
            balance[1] -= 1;
            System.out.println("\u001B[31mPasswords Cannot Match, try again\u001B[0m");
            System.out.println("\u001BWarning : You have only " + (int)balance[1]  + " Attempts left\u001B[0m");
            pinMatch(balance, c);
        }else {
            System.out.println("\u001B[33mToo many attempt's : please try again later or after sometime...\u001B[0m");
            System.out.println("For return press 1 or to Quit press 0");
            System.out.print("Enter your Option: ");
            int opt = sc.nextInt();
            balance[1] = 3;
            if(opt == 1) {
                option(balance, c);
            } else if (opt == 0) {
                quit(balance, c);
            }else {
                System.out.print("\n");
                System.out.println("\u001B[31mInvalid try, we redirected you to the 'Main Page'\u001B[0m");
                System.out.print("\n");
                option(balance, c);
            }
        }
    }
}
