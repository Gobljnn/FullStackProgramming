/*******************************************************************************
* BankAcct.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #2 - Bank Accounts  (Version 1)
*
* This program handles bank account balances for an several of bank accounts. 
* There are two types of bank accounts ─ checking and savings.
*
* This Child Class file is meant to work with the Driver file named BankAcct.java
********************************************************************************/
import javax.swing.JOptionPane;

public class CheckingAcct extends BankAcct {

    public CheckingAcct (double balance){
        super(balance);
    }

    public double writeCheck(double amount){
        balance = checkBalance();
        double fee = 1.00;
        balance = balance - (amount) - fee; 
        balance = checkBalance();
        return balance;
    }

    public void display(){
        System.out.printf("Checking Account Balance =  $%.2f\n", balance);
    }

    public double advCheckingsAcct(String mode, int acctNum){
        passed = false;
        if (mode.equals(m1)){
            System.out.println("Creating account #" + acctNum + " (Checkings Account)");

            while (passed == false){
                try {
                    System.out.print("What is your starting balance: $");
                    balance = userInput.nextDouble(); 
                } catch (Exception e) {
                    System.out.println("**ERROR** : Please input a number");
                }
            }
        }

        else if (mode.equals(m2)){
            String str;
            JOptionPane.showMessageDialog(null, "Creating account #" + acctNum + " (Checkings Account)", 
                                        title + " -- Checkings Account", JOptionPane.INFORMATION_MESSAGE);
            str =  JOptionPane.showInputDialog(null, "What is your starting balance ($) ?",
                                         title1, JOptionPane.QUESTION_MESSAGE);
            try {
                balance = Double.parseDouble(str);                
            } catch (Exception e) {
                if (str == null){
                    JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                else{
                    JOptionPane.showMessageDialog(null, "Please input a number", titleexit, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return balance;
    }
} // End Checking Acct class
