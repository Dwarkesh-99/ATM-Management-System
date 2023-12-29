package InputOutput.FileHandling.ATM_ManagementSystem;

import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.Deposit.deposit;
import static InputOutput.FileHandling.ATM_ManagementSystem.Login.login;
import static InputOutput.FileHandling.ATM_ManagementSystem.LogoutAndEnquiry.enquiry;
import static InputOutput.FileHandling.ATM_ManagementSystem.LogoutAndEnquiry.quit;
import static InputOutput.FileHandling.ATM_ManagementSystem.PinChange.pinChange;
import static InputOutput.FileHandling.ATM_ManagementSystem.Withdraws.withdraws;


public class ATMSystem {

    public static void main(String[] args) {

//         1] arr[0] reserve for transactions.    2] arr[1] is reserved for Login Attempts which is 3.  3] arr[2] is reserved for ATM pin.

        double[] balance = {1000, 3, 12345};
        String c = "String's are immutable in java";

        login(balance, c);
    }

    public static void option(double[] balance, String c) {

        balance[1] = 3;
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Withdraw Cash                   -Press 1");
        System.out.println("2. Deposit Cash                    -Press 2");
        System.out.println("3. Balance Enquiry                 -Press 3");
        System.out.println("4. To change your Current PIN      -Press 4");
        System.out.println("5. Logout                          -Press 5");
        System.out.println("\n");
        System.out.print("your Option is: ");
        float c1 = sc.nextFloat();
        System.out.println("\n");
        switch ((int) c1) {
            case 1:
                withdraws(balance, c); break;
            case 2:
                deposit(balance, c); break;
            case 3:
                enquiry(balance, c); break;
            case 4:
                pinChange(balance, c); break;
            case 5:
                quit(balance, c); break;
            default: {
                System.out.println("\u001B[31mInvalid input, try again\u001B[0m");
                option(balance, c);
            }
        }
    }
}