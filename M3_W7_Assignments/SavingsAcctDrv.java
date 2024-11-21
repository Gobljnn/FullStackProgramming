/*******************************************************************************
* SavingsAcctDrv.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 7  Assignment #1 - Savings Acoount  (Version 2)
*
* This program calculates and displays the balance for two saving accounts  
* based on their individual starting balances, general annual interest rate, and
* months the balances have been in their respectie accounts. Additionally, both 
* accounts are summed together to obtained their total vlaue.
*
* This Driver file is meant to work with the Class file named SavingsAcctDrv.java
********************************************************************************/

import java.util.Scanner;

import javax.swing.JOptionPane;
public class SavingsAcctDrv {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String preferred ;
        
        SavingsAcct user1 = new SavingsAcct();
        SavingsAcct user2 = new SavingsAcct();
        SavingsAcct mainUser = new SavingsAcct();

        int months,acctNum;
        double annualRate;
        double balance, balance1, balance2;
        preferred = mainUser.setMode();

        if (preferred.equals("1")){
            System.out.println("\n\nWelcome to the Savings Calculator\n");
            System.out.print("How many months do you want to calculate?: ");
            months = mainUser.setMonths(preferred);
            annualRate = mainUser.setAnnualRate(preferred);
            mainUser.lockAnnualRate(annualRate);
    
            System.out.println("\nWhat is the account number and starting balance, respectively, for User 1? : ");
            System.out.print("Account number: ");
            acctNum = userInput.nextInt();
            System.out.print("Starting Balance: $");
            balance = userInput.nextDouble();
            user1.setUserInfo1(acctNum, balance);
    
    
            System.out.println("\nWhat is the account number and starting balance, respectively, for User 2? : ");
            System.out.print("Account number: ");
            acctNum = userInput.nextInt();
            System.out.print("Starting Balance: $");
            balance = userInput.nextDouble();
            user2.setUserInfo2(acctNum, balance);

            for (int i = 0; i < months+1; i++){
                user1.displayBalance1(months, i, preferred, annualRate);
                user2.displayBalance2(months, i, annualRate);
            }
    
            balance1 = user1.getBalance1();
            balance2 = user2.getBalance2();
    
            mainUser.calcBalance(balance1, balance2, preferred);
        }

        else if (preferred.equals("2")){
            JOptionPane.showMessageDialog(null, "Welcome to the Savings Calculator" );
            months = mainUser.setMonths(preferred);
            annualRate = mainUser.setAnnualRate(preferred);
            mainUser.lockAnnualRate(annualRate);
    
            JOptionPane.showMessageDialog(null, "What is the account number and starting balance, respectively, for User 1? : ");
            acctNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Account number: ")) ;
            balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Starting Balance: $"));
            user1.setUserInfo1(acctNum, balance);
    
            JOptionPane.showMessageDialog(null, "What is the account number and starting balance, respectively, for User 2? : ");
            acctNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Account number: ")) ;
            balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Starting Balance: $"));
            user2.setUserInfo2(acctNum, balance);

            for (int i = 0; i < months+1; i++){
                user1.displayBalance1(months, i, preferred, annualRate);
                user2.displayBalance2(months, i,annualRate);
            }
    
            balance1 = user1.getBalance1();
            balance2 = user2.getBalance2();
    
            mainUser.calcBalance(balance1, balance2, preferred);

        }

        userInput.close();
    }
}
