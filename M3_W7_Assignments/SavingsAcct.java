/*******************************************************************************
* SavingsAcct.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 7  Assignment #1 - Savings Acoount  (Version 2)
*
* This program calculates and displays the balance for two saving accounts  
* based on their individual starting balances, general annual interest rate, and
* months the balances have been in their respectie accounts. Additionally, both 
* accounts are summed together to obtained their total vlaue.
*
* This Class file is meant to work with the Driver file named SavingsAcctDrv.java
********************************************************************************/


import java.util.Scanner;
import javax.swing.JOptionPane;

public class SavingsAcct {
    Scanner userInput = new Scanner(System.in);

    private double annualRate; // annual interest in percentage (%) 
    public int acctNum1 ; // saver1 account number
    public int acctNum2 ; //saver2 account number
    private double balance1, balance2 ; //saver1 starting acct balance 
    private double finalBalance, fbalance1, fbalance2; 
    private int months; //months to calculate
    private String Heading = "%-9s%13s%16s%15s%16s\n";
    private String Data = "%-9d%11d%10s%(,.2f" ; 
    private String Data2 = "%13d%10s%(,.2f\n" ;

    //********************************************************************************

    public void setUserInfo1(int acctNum, double balance){
        this.acctNum1 = acctNum;
        this.balance1 = balance;
    }

    //********************************************************************************

    public void setUserInfo2(int acctNum, double balance){
        this.acctNum2 = acctNum;
        this.balance2 = balance;
    }

    //********************************************************************************

    public double setAnnualRate(String preferred){
        if (preferred.equals("1")){
            System.out.print("What is your preferred annual rate (%): ");
            this.annualRate = userInput.nextDouble();
            return this.annualRate;  
        }

        else if (preferred.equals("2")){
            this.annualRate = Double.parseDouble(JOptionPane.showInputDialog(null, "What is your preferred annual rate (%): " )) ;
            return this.annualRate;
        }
        return this.annualRate;
    }

    public void lockAnnualRate(double annualRate){
        this.annualRate = annualRate;
    }

    //********************************************************************************

    public int setMonths(String preferred){

        if (preferred.equals("1")){
            months = userInput.nextInt();
        }

        else if (preferred.equals("2")){
            months = Integer.parseInt(JOptionPane.showInputDialog(null, "How many months do you want to calculate?: "));
        }
        return months;
    }

    //********************************************************************************

    public void calcBalance(double balance1, double balance2, String preferred){
        if (preferred.equals("1")){
            finalBalance = balance1 + balance2;
            System.out.printf("\n\nThe combined balance for both accounts is : $ %(,.2f\n\n" , finalBalance);
        }
    
        else if (preferred.equals("2")){
            finalBalance = balance1 + balance2;
            String message = String.format("\nThe combined balance for both accounts is : $ %(,.2f\n" , finalBalance);
            System.out.printf("\n\nThe combined balance for both accounts is : $ %(,.2f\n\n" , finalBalance);
            JOptionPane.showMessageDialog(null, message);
        }

    }

    //********************************************************************************

    public void displayBalance1(int months, int i, String preferred, Double annualRate){

        if (preferred.equals("1")){
            if (i == 0){
                System.out.println("\n\nMonthly balances for " + months + " months // with an annual rate of " + annualRate + "% (" + annualRate/100 + ")\n");
                System.out.printf(Heading, "Months", "Account #", "Balance", "Account #", "Balance" );
                System.out.printf(Heading, "-------", "---------", "-----------", "---------", "-----------") ;
            }
    
            System.out.printf(Data, i, acctNum1, "$ ", balance1);
    
            if (i == months){
                fbalance1 = balance1;
            }
            balance1 = balance1 + (balance1 * ((annualRate/100) / 12));

        }
    
        else if (preferred.equals("2")){

            if (i == 0){
                JOptionPane.showMessageDialog(null, "Results are in your IDE's Terminal");
                System.out.println("\n\nMonthly balances for " + months + " months // with an annual rate of " + annualRate + "% (" + annualRate/100 + ")\n");
                System.out.printf(Heading, "Months", "Account #", "Balance", "Account #", "Balance" );
                System.out.printf(Heading, "-------", "---------", "-----------", "---------", "-----------") ;
            }
    
            System.out.printf(Data, i, acctNum1, "$ ", balance1);
    
            if (i == months){
                fbalance1 = balance1;
            }
            balance1 = balance1 + (balance1 * ((annualRate/100) / 12));
        }
    }

    //********************************************************************************

    public void displayBalance2(int months, int i, Double annualRate){
        System.out.printf(Data2, acctNum2, "$ ", balance2);
        if (i == months){
            fbalance2 = balance2;
        }
        balance2 = balance2 + (balance2 * ((annualRate/100) / 12));
    }

    //********************************************************************************

    public double getBalance1(){
        return fbalance1;
    }

    //********************************************************************************

    public double getBalance2(){
        return fbalance2;
    }

    //********************************************************************************

    // **** new stuff ****
    private String preferred;

    public String setMode(){
        this.preferred = JOptionPane.showInputDialog(null, "* Monthly balances Program *" + "\n \n" + 
                                            "Would you prefer to work in the Terminal (1) or Dialog Box (2)");

            if (this.preferred.equals("1")){
                JOptionPane.showMessageDialog(null, "Please proceed in your IDE's terminal");
            }

            if (this.preferred.equals("2")){
                JOptionPane.showMessageDialog(null, "You may continue...");
            }
        return this.preferred;
    }

    // if (preferred.equals("1")){

    // }

    // else if (preferred.equals("2")){
        
    // }
}

