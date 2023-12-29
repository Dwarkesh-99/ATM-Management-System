package InputOutput.FileHandling.ATM_ManagementSystem;

import java.text.DecimalFormat;
import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.ATMSystem.option;
import static InputOutput.FileHandling.ATM_ManagementSystem.Deposit.deposit;
import static InputOutput.FileHandling.ATM_ManagementSystem.Login.login;

public class LogoutAndEnquiry {
    public static void quit(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
//        if(c1 == 5) {
        System.out.println("\u001B[33mare you sure to quit ? if YES press 1 and Otherwise press 0\u001B[0m");
        System.out.print("Your option is: ");
        float yes = sc.nextFloat();
        if((int)yes == 1) {
            System.out.println("\u001B[32mLogout Successfully, " + c + "!\u001B[0m");
            System.out.println("\u001B[32mThanks for using our service, visit again...!\u001B[0m");
            System.out.print("\n");
            login(balance, c);
        }else if((int)yes == 0){
            option(balance, c);
        }else {
            System.out.println("\u001B[31mInvalid try, we redirected you to the 'Main Page'\u001B[0m");
            option(balance, c);
        }
    }

    public static void enquiry(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
        float croreRs = 10000000;
        double[] totBal = balance;
        DecimalFormat dF = new DecimalFormat("#.##");
        balance[0] = Double.valueOf(dF.format(balance[0]));
        System.out.println("Your Available Balance is INR " +"\033[4;2m" + balance[0] + "\u001B[0m"+ " CR-MahaBank_ATM");
        if(totBal[0] >= croreRs) {
            System.out.println("Now, you are on RADAR of ED...lol😂😂😂");
        }
        if(totBal[0] <= 1000) {
            System.out.println("\u001B[31myour balance is low, please deposit money in it...!\u001B[0m");
        }
        System.out.println();
        System.out.println("For return press 1 or to Deposit Money press 0");
        System.out.print("Enter your Option: ");
        float opt = sc.nextFloat();
        if((int)opt == 1) {
            option(balance, c);
        } else if ((int)opt == 0) {
//            quit(balance, c);
            deposit(balance, c);
        }else {
            System.out.print("\n");
            System.out.println("\u001B[31mInvalid try, we redirected you to the 'Main Page'\u001B[0m");
            System.out.print("\n");
            option(balance, c);
        }
    }
}
