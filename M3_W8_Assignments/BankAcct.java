import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Scanner;
/*******************************************************************************
* BankAcct.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #2 - Bank Accounts  (Version 1)
*
* This program handles bank account balances for an several of bank accounts. 
* There are two types of bank accounts ─ checking and savings.
*
* This parent class contains all methods and variables needed for both bank
* account types.
********************************************************************************/

public class BankAcct {
    Scanner userInput = new Scanner(System.in);

    String title = "*Bank Accounts Program*";
    String title1 = "*Bank Accounts Program* --  Creating Account";
    String title2 = "*Bank Accounts Program* --  Modifying Account";
    String title3 = "*Bank Accounts Program* --  Account Statement";
    String titleexit = "Exiting";
    String titleerror = "*** ERROR ***";
    String diff1 = "Basic"; String diff2 = "Advanced";
    String m1 = "Terminal" ; String m2= "Dialog";
    boolean passed = false;
    String tempStorage;
    double balance;

    public ArrayList<ArrayList<String>> bankDB = new ArrayList<>();
    private ArrayList<String> balanceArr = new ArrayList<>(); //balance
    private ArrayList<String> checkingsArr = new ArrayList<>();
    private ArrayList<String> acctNumArr = new ArrayList<>();
    private ArrayList<String> intRateArr = new ArrayList<>();
    private ArrayList<String> acctTypeArr = new ArrayList<>(); //acct type
    private ArrayList<Integer> acctNumDBArr = new ArrayList<>();

    public void addAcctNumDBArr(int acctNum){
        acctNumDBArr.add(acctNum);
    }

    public void initializeDB(){
        bankDB.add(balanceArr); //index 0
        bankDB.add(checkingsArr); //index 1
        bankDB.add(acctNumArr); // index 2
        bankDB.add(intRateArr); //index 3
        bankDB.add(acctTypeArr); //index 4
    }

    public void setBalanceArr(double balance){ //sav
        tempStorage = Double.toString(balance);
        balanceArr.add(tempStorage); //sav
    }

    public void setCheckingsArr(double balance){
        tempStorage = Double.toString(balance);
        checkingsArr.add(tempStorage);
    }

    public void setIntArr(double intRate){
        tempStorage = Double.toString(intRate);
        intRateArr.add(tempStorage);
    }
    
    public void printArr(){
        JOptionPane.showMessageDialog(null, bankDB);
    }
  
    public BankAcct(double balance){
        this.balance = balance;
    }

    public double deposit(double amount){
        balance = checkBalance();
        balance = balance + amount;
        balance = checkBalance();
        return balance;
    }

    public double withdraw(double amount){  
        balance = checkBalance();  
        balance = balance - amount;
        balance = checkBalance();
        return balance;
    }

    public double checkBalance(){
        if (balance < 0){
            balance = 0;
        }
        return balance;
    }

    public void display(){
        System.out.println(balance);
    }

    public String setDifficulty(String mode){
        String[] options = {"Basic", "Advanced"};
        String str = (String) JOptionPane.showInputDialog(null, "Would you like to observe the basic or advance criteria?", title, 
                                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        try {
            if (str.equals(diff1) && mode.equals(m2)){
                JOptionPane.showMessageDialog(null, "Running basic criteria \n\nCheck your IDE's terminal ", title, JOptionPane.INFORMATION_MESSAGE);
            }
    
            else if (str.equals(diff1) && mode.equals(m1)){
                System.out.println("Running basic criteria");
            }
    
            else if (str.equals(diff2) && mode.equals(m1)){
                System.out.println("Running advanced criteria");
            }
    
            else if (str.equals(diff2) && mode.equals(m2)){
                JOptionPane.showMessageDialog(null, "Running advanced criteria", title, JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            if (str == null){
                JOptionPane.showMessageDialog(null, "Exiting", title, JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    
        return str;
    }

    public String setMode(){
        String[] selMode = {"Terminal" , "Dialog"};
        String str;
        str = (String) JOptionPane.showInputDialog(null, "Terminal or Dialog", title, JOptionPane.QUESTION_MESSAGE, null, selMode, selMode[0]);
        try {
            if (str.equals("Terminal")){
                JOptionPane.showMessageDialog(null, "Please proceed to your IDE's terminal to continue",
                                         title, JOptionPane.INFORMATION_MESSAGE);
            }
    
            else if(str.equals(m2)){
                JOptionPane.showMessageDialog(null, "Welcome! You may continue", title, JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            if (str == null){
                JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        return str;
    }

    public int chooseOption(String mode){
        passed = false;
        int bankOption = 00;

        if (mode.equals(m1)){
            
            while (passed == false){
                try {
                    System.out.print("What would you like to do? - Create Account (1),"
                                    + "Modify Account (2), Print Accounts (3), Quit (00)");

                    bankOption = userInput.nextInt();

                    if (bankOption == 1){
                        System.out.println("Creating Account...");
                        passed = true;
                    }
                    
                    else if (bankOption == 2){
                        System.out.println("Modifying Account...");
                        passed = true;
                    }

                    else if (bankOption == 3){
                        System.out.println("Printing Account Statements");
                        passed = true;
                    }

                    else if (bankOption == 00){
                        System.out.println("Thank you come again");
                        passed = true;
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("Please input one of the options - 1, 2, 3, or 00");
                }
            }
        }

        else if (mode.equals(m2)){
            String[] option = {"Create Account", "Modify Account", "Print Accounts"};
            
            while (passed == false){
                String str = (String) JOptionPane.showInputDialog(null, "What would you like to do?", title, 
                        JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

                if (str.equals("Create Account")){
                    bankOption = 1;
                    JOptionPane.showMessageDialog(null, "Creating Account", 
                                                title1, JOptionPane.INFORMATION_MESSAGE);
                    passed = true;
                }

                else if (str.equals("Modify Account")) {
                    bankOption = 2;
                    JOptionPane.showMessageDialog(null, "Modifying Account", title2, JOptionPane.INFORMATION_MESSAGE);
                    passed = true;
                }

                else if (str.equals("Print Accounts")){
                    JOptionPane.showMessageDialog(null, "Printing Accounts", title3, JOptionPane.INFORMATION_MESSAGE);
                    passed = true;
                }
            }
        }
        return bankOption;
    }

    public int setAcct(String mode){
        int acct = 0;
        passed = false;
        char ch;
        if (mode.equals(m1)){
            while (passed == false){
                try {
                    System.out.println("Which account would you like to create? - Savings (1), Checkings (2), Quit(00): ");
                    acct = userInput.nextInt();
        
                    if (acct == 00){
                        System.out.println("Thank you, come again");
                        passed = true;
                        System.exit(0);
                    }
        
                    else if (acct == 1){
                        System.out.println("Creating Savings Account...");
                        passed = true;
                    }
        
                    else if (acct == 2){
                        System.out.print("Creating Checkings Account...");
                        passed = true;
                    }
    
                    else{
                        System.out.println("Please input one of the options - 1, 2, or 00");
                    }
                } catch (Exception e) {
                    System.out.println("Please in put a number");
                }
            }
        }

        else if (mode.equals(m2)){
            String[] options = {"Savings", "Checkings"};
            String str;

            while (passed == false){
                str = (String) JOptionPane.showInputDialog(null, "Which account would you like to create?", title,
                             JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                try {

                    if (str.equals("Savings")){
                        acct = 1;
                        acctTypeArr.add("Savings");
                        JOptionPane.showMessageDialog(null, "Creating Savings Account", title1, JOptionPane.INFORMATION_MESSAGE);
                        passed = true;
                    }

                    else if (str.equals("Checkings")){
                        acct = 2;
                        acctTypeArr.add("Checkings");
                        JOptionPane.showMessageDialog(null, "Creating Checkings Account", title1, JOptionPane.INFORMATION_MESSAGE);
                        passed = true;        
                    }

                    passed = true;
                    return acct;
                    
                } catch (Exception e) {
                    if (str == null){
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        passed = true;
                        System.exit(0);
                    }
                }
            }
        }
        return acct;
    }

    public void advModifyAcct(String mode){
        passed = false;

        while (passed == false){
            for (int i = 0 ; i <= acctNumDBArr.size() ; i++){
                System.out.println(bankDB);
                // JOptionPane.showMessageDialog(null, "running adv");
                if (acctTypeArr.get(i).equals("Savings")){
                    System.out.println("Account Number: " + acctNumDBArr.get(i) + "\t\tAccount Type: " + bankDB.get(4).get(i) +
                                     "\t\tBalance : $" + bankDB.get(0).get(i));
                    // if (i == acctNumDBArr.size()){
                    //     passed = true;
                    // }
                }

                else if (acctTypeArr.get(i).equals("Checkings")){
                    System.out.println("Account Number: " + acctNumDBArr.get(i) + "\t\tAccount Type: " + bankDB.get(4).get(i) +
                    "\t\tBalance : $" + bankDB.get(1).get(i));
                }
            }

            JOptionPane.showInputDialog(null, "Which account would you like to modify? (Check Terminal for list of accounts)", title, JOptionPane.QUESTION_MESSAGE);

        }



    }

    public boolean advCheckAcctSize(String mode){

        System.out.println("bankDB size: " + bankDB.size());
        System.out.println("db size: " + acctNumDBArr.size());
        if (acctNumDBArr.size() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid option! No Account has been created yet!", 
                                        titleerror, JOptionPane.ERROR_MESSAGE);
            
            return false;
        }

        else {
            return true;
        }
    }
} // End Bank Acct class
