package InputOutput.FileHandling.ATM_ManagementSystem;

import java.text.DecimalFormat;
import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.ATMSystem.option;

public class Deposit {
    public static void deposit(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amount to Deposit: ");
        double amt = sc.nextDouble();
        double[] totBal = balance;
        System.out.print("\n");
        if(amt < 1000) {
            System.out.println("\u001B[33mAmount is less than minimum amount, deposit minimum 1000rs.\u001B[0m");
            deposit(balance, c);
        }else if(amt > 25000) {
            System.out.println("\u001B[33mEnter Amount Exceeds Maximum Range, deposit maximum 25,000rs.\u001B[0m");
            System.out.println("Deposit only 25,000rs at a same time...!");
            deposit(balance, c);
        }else {
            totBal[0] += amt;
            balance[0] = totBal[0];
            DecimalFormat dF = new DecimalFormat("#.##");
            balance[0] = Double.valueOf(dF.format(balance[0]));
            System.out.println("\u001B[32mAmount deposit successfully, your total balance is: \u001B[0m" +"\033[4;2m" + balance[0] + "\u001B[0m"+ "\u001B[32m CR-MahaBank_ATM\u001B[0m");
        }
        System.out.print("\n");
        System.out.println("For return press 1 or to Deposit again press 0");
        System.out.print("Enter your Option: ");
        amt = sc.nextFloat();
        if((int)amt == 1) {
            option(balance, c);
        }else if((int)amt == 0) {
            deposit(balance, c);
        }else {
            System.out.println("\u001B[31mInvalid try, we redirected you to the 'Option Page'\u001B[0m");
            option(balance, c);
        }
    }
}
