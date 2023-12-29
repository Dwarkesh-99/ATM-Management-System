package InputOutput.FileHandling.ATM_ManagementSystem;

import java.text.DecimalFormat;
import java.util.Scanner;

import static InputOutput.FileHandling.ATM_ManagementSystem.ATMSystem.option;
import static InputOutput.FileHandling.ATM_ManagementSystem.Deposit.deposit;

public class Withdraws {

    public static void withdraws(double[] balance, String c) {
        Scanner sc = new Scanner(System.in);
        double[] totBal = balance;
        float minBal = 1000.00f;
        if(totBal[0] <= minBal) {
            System.out.println("\u001B[33mInsufficient Balance, please Deposit money first and then Withdraws it...!\u001B[0m");
            System.out.println("\n");
            System.out.println("For return press 1 or to Deposit money press 0");
            System.out.print("Enter your Option: ");
            float opt = sc.nextFloat();
            if((int)opt == 1) {
                option(balance, c);
            } else if ((int)opt == 0) {
                deposit(balance, c);
            }else {
                System.out.println("\u001B[31mInvalid try, we redirected you to the 'Option Page'\u001B[0m");
                option(balance, c);
            }
            deposit(balance, c);   //go to deposit function..
        } else if (totBal[0] >= minBal) {
            System.out.print("Enter withdraw amount: ");
            float amt = sc.nextFloat();
            double updatedVal = totBal[0] - amt;
            if(amt >= totBal[0]) {
                System.out.println("\u001B[33mEnter amount is equal/more than total amount, your total amount is: \u001B[0m" +"\033[4;2m" + balance[0] + "\u001B[0m"+ " CR-MahaBank_ATM");
                System.out.println("please try with less amount, should be less than total amount");
                withdraws(balance, c);
            }else if(updatedVal < minBal){
                System.out.println("please try with less amount, should be less than minimum amount");
                withdraws(balance, c);
            }else {
                System.out.println("Transaction Processing is start... please wait");
                totBal[0] -= amt;
                balance[0] = totBal[0];
                DecimalFormat dF = new DecimalFormat("#.##");
                balance[0] = Double.valueOf(dF.format(balance[0]));
                System.out.println("\u001B[32mMoney Withdraw Successfully, and your available balance is: \u001B[0m" +"\033[4;2m" + balance[0] + "\u001B[0m"+ " \u001B[32mCR-MahaBank_ATM \u001B[0m");
                System.out.print("\n");
                System.out.println("For return press 1 or to Withdraw again press 0");
                System.out.print("Enter your Option: ");
                float opt = sc.nextFloat();
                if((int)opt == 1) {
                    option(balance, c);
                } else if ((int)opt == 0) {
                    withdraws(balance, c);
                }else {
                    System.out.println("\u001B[31mInvalid try, we redirected you to the 'Option Page'\u001B[0m");
                    option(balance, c);
                }
            }
        }
    }
}
