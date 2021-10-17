import javax.swing.JOptionPane;

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

public class SavingAcct extends BankAcct {
    double intRate;
    String str;

    // basic criteria

    public SavingAcct (double balance, double intRate){
        super(balance);
        this.intRate = intRate;
    }

    public double addInt(){
        double interest = balance * (intRate);
        balance = balance + interest;
        balance = checkBalance();
        return balance;
    }

    public void display(){
        System.out.printf("Saving Account Balance =  $%.2f\n", balance);
    }


    // advanced

    public double advSavingAcct(String mode, int acctNum){
        passed = false;
        if (mode.equals(m1)){
            System.out.println("Creating account #" + acctNum + " (Savings Account)");

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
            JOptionPane.showMessageDialog(null, "Creating account #" + acctNum + " (Savings Account)", 
                                        title + " -- Savings Account", JOptionPane.INFORMATION_MESSAGE);
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

    public double advIntRate(String mode){
        if (mode.equals(m1)){
            System.out.print("What is your interest rate (%)? : ");
        }
        
        else if (mode.equals(m2)){
            str = JOptionPane.showInputDialog(null, "What is your interest rate (%)?", 
                                        title + " -- Savings Account", JOptionPane.QUESTION_MESSAGE);

            try {
                intRate = Double.parseDouble(str);                
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
        return intRate;
    }

} // End Saving Acct class
