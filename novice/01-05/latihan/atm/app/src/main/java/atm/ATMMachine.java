/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package atm;
import java.util.Scanner;
import java.io.*;

public class ATMMachine {
    public static void checkBalance(){
        System.out.println("\tYour current balance is " + BalanceInquiry.getBalance());

    }
    public static void withdrawMoney(){
        if(BalanceInquiry.balance==0){
            System.out.println("\t Your current balance is zero");
            System.out.println("\tYou cannot withdraw");
            System.out.println("\tYou need to deposit money first");
        }
        else if(BalanceInquiry.balance<=500){
            System.out.println("\t You don't have sufficient money to withdraw");
            System.out.println("\t Checked your balance to see your money in the bank");
        }
        else{
            BalanceInquiry.balance = BalanceInquiry.balance-Withdraw.withdraw;
            System.out.println("\n\t You withdraw the amount of Php" + Withdraw.withdraw);
        }
        
        }
    public static void depositMoney(){
        System.out.println("\t You deposited the amount of" + Deposit.getDeposit());
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int select =0;
        int choice = 0;

        System.out.println("==========================================");
        System.out.println("\t Welcome to the simple ATM");
        System.out.println("==========================================");

        System.out.println();

        do
        {
            try{
                do{
                    System.out.println("\t Please select ATM Transaction");
                    System.out.println("\t Press [1] Deposit");
                    System.out.println("\t Press [2] Withdraw");
                    System.out.println("\t Press [3] Balance Inquiry");
                    System.out.println("\t Press [4] Exit");
                    System.out.println("\n\t What would you like to do?");
                    select=read.nextInt();

                    if(select>4){
                        System.out.println("Please select correct transaction");

                    }
                    else{
                        switch(select){
                            case 1:
                            System.out.println("\n\t Enter the amount of money to deposit");
                            Deposit.deposit= read.nextDouble();
                            BalanceInquiry.balance = Deposit.deposit + BalanceInquiry.balance;
                            depositMoney();
                            break;
                            case 2:
                            System.out.println("\n\t To withdraw , make sure that you have sufficient balance in your account");
                            System.out.println();
                            Withdraw.withdraw = read.nextDouble();
                            withdrawMoney();
                            break;
                            case 3:
                            checkBalance();
                            break;

                            default:
                            System.out.println("\n\t Transaction excited");
                            break;
                        }
                    }
                } while(select>4);
                    do{
                        try{
                            System.out.println("\n\t Would you like to try another transaction?");
                            System.out.println("\n\t Press[1] Yes \n\t Press [2] No");
                            System.out.println("Enter choice :");
                            choice= read.nextInt();
                           
                            if(choice>2){
                                System.out.println("\n\t Please select correct choice");
                            }
                        }
                        catch(Exception e){
                            System.out.println("Error input! please enter number only");
                            read = new Scanner(System.in);
                            System.out.println("\t enter your choice");
                            choice=read.nextInt();
                        } 
                    }while(choice>2);
                }
                    catch(Exception e){
                        System.out.println("\tError Input! Please enter a number only.");
                        read = new Scanner(System.in);
                        System.out.println("\tEnter yout choice:");
                        select = read.nextInt();
                    }
                }while(choice<=1);
            System.out.println("\t thank you for using the simple ATM Machine");
        }
    }

     
   