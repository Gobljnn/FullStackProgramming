/*******************************************************************************
* VowelSystem.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 6  Assignment #1.2- Voucher Processing System  
*
* This program counts the number of occurrences of lowercase and uppercase 
* vowels in entered lines of text. Texts to be analyzed can be entered
* successionally. The total amount of vowels are also calculated.
* 
* This Class file is meant to work with the Driver file named VoucherDriver.java
********************************************************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class VoucherSystem {
    
    private int selection; // User selection 
    private String tempStorage1;
    private String tempStorage2;
    private int vnum = 1000; // Starting voucher number
    private Boolean validVoucher = false; // Checks to see if the searched voucher exists
    int vcreated = 0; // counts how many vouchers have been created

    private ArrayList<ArrayList<String>> voucherDirectory = new ArrayList<>(); // 2D ArrayList for all ArrayLists created

    private ArrayList<String> voucherNum = new ArrayList<>();  // ArrayList for vouchers
    private ArrayList<Integer> payVoucher = new ArrayList<>(); // ArrayList for all vouchers created

    private Double amount;       // userInputted cost of service/purchasing amount
    private ArrayList<String> purchAmount = new ArrayList<>(); // ArrayList for purchasing amount/cost of service

    private int chequeNum;      // Auto-Generated Cheque Number
    private ArrayList<String> checkNum = new ArrayList<>();     //ArrayList for Cheque Number

    private String pDate;       // Date of purchase/service provided
    private ArrayList<String> purchDate = new ArrayList<>();    // ArrayList for date of purchase/service provided

    private String pyDate;      // Date payment was made
    private ArrayList<String> payDate = new ArrayList<>();      //ArrayList for payment date

    private String acct;        // Account to debit
    private ArrayList<String> debitAcct = new ArrayList<>();    // ArrayList for all accounts debitted

    private String supplier;    // Vendor
    private ArrayList<String> vendor = new ArrayList<>();       //ArrayList for vendor

    Scanner userInput = new Scanner(System.in);

    //***************************************************************************************************//

    public void initializeDirectory(){
        voucherDirectory.add(voucherNum);   // index 0 
        voucherDirectory.add(purchAmount);  // index 1
        voucherDirectory.add(purchDate);    // index 2
        voucherDirectory.add(debitAcct);    // index 3
        voucherDirectory.add(vendor);       // index 4
        voucherDirectory.add(payDate);      // index 5
        voucherDirectory.add(checkNum);     // index 6
    }

    //***************************************************************************************************//

    public Boolean timeToExit(){
        if (selection == 0){
            return true;
        }

        else{
            return false;
        }
    }

    //***************************************************************************************************//

    public int setActivity(){
        System.out.println("What would you like to do ? \n");
        System.out.println("Activities available are : \n");
        System.out.println("1. Create Voucher \n" +
                           "2. Print Voucher Register \n" +
                           "3. Issue Checks \n");
        System.out.print("Enter number of choice (or zero to quit) : ");

        selection = userInput.nextInt();
        return selection;
    }

    //***************************************************************************************************//

    public void processSelection(int selection){
        
        if (selection == 1){
            System.out.println("\n" + " - - - - - - - - - - - - Creating Voucher - - - - - - - - - - - \n");

            vnum ++;
            payVoucher.add(vnum);
            tempStorage1 = Integer.toString(vnum);
            voucherNum.add(tempStorage1);
            System.out.println("Voucher No. : #" + vnum);

            System.out.print("Enter purchase date (dd/mm/yyyy) : ");
            pDate = userInput.nextLine();
            pDate = userInput.nextLine();
            purchDate.add(pDate);

            System.out.print("Enter amount: $ ");
            amount = userInput.nextDouble();
            tempStorage2 = Double.toString(amount);
            purchAmount.add(tempStorage2);

            System.out.print("Enter name of account to debit : ");
            acct = userInput.nextLine();
            acct = userInput.nextLine();
            debitAcct.add(acct);

            System.out.print("Enter name of vendor: ");
            supplier = userInput.nextLine();
            vendor.add(supplier);

            chequeNum = 0;
            tempStorage1 = Integer.toString(chequeNum);
            checkNum.add(tempStorage1);
            pyDate = null;
            payDate.add(pyDate);

            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
            
            vcreated++; //vouchers created
        }

        else if(selection == 2){
            System.out.println("\n" + " - - - - - - - - - - - - Voucher Register - - - - - - - - - - - \n");

            for (int i = 0; i < vcreated; i++){
                System.out.print("Voucher #:" + voucherDirectory.get(0).get(i)); // Retrievs info from main directory (row.col)
                System.out.print("\t\t\t" + "Purchase Date: " + voucherDirectory.get(2).get(i));
                System.out.println("\t\t" + "Purchase Amount: $" + voucherDirectory.get(1).get(i));
                System.out.print("Debit Account: " + voucherDirectory.get(3).get(i));
                System.out.println("\t\t" + "Vendor: " + voucherDirectory.get(4).get(i));
                System.out.print("Check #:CK-" + voucherDirectory.get(6).get(i));
                System.out.println("\t\t\t" + "Payment Date: " + voucherDirectory.get(5).get(i) + "\n");
                System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
            }

            System.out.println("Total number of vouchers created: " + vcreated);
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n \n ");
        }

        else if (selection == 3){
            System.out.println("\n" + " - - - - - - - - - - - - Payement Registry - - - - - - - - - - - \n");
            Collections.sort(payVoucher); // Sorts the main voucher list
            validVoucher = false;

            while (validVoucher == false){
                System.out.print("Enter number of voucher to pay: #");
                int voucherToPay = userInput.nextInt();
                int col = getCol(voucherToPay);
    
                if (col >= 0){
                    System.out.print("Enter payment date (dd/mm/yyyy) : ");
                    pyDate = userInput.nextLine();
                    pyDate = userInput.nextLine();
                    payDate.add(col, pyDate);
                    checkNum.add(col, voucherDirectory.get(0).get(col));
                    validVoucher = true;
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
                }
    
                else{
                    System.out.println("No vouchers have that number");
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
                }
            }
        }

        else if (selection == 0){
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
            System.out.println("\n Thank you come again... \n");
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
        }

        else {
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
            System.out.println("\n Invalid number choice. Please try again. \n");
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n ");
        }   
    }

    //***************************************************************************************************//

    public int getCol(int voucherToPay){
        int col = Collections.binarySearch(payVoucher, voucherToPay);
        return col;
    }

    //***************************************************************************************************//
} // End Class Voucher System
