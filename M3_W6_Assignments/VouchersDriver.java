/*******************************************************************************
* VowelDriver.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 6  Assignment #1.2 - Voucher Processing System  
*
* This program is used to create vouchers/invoices for a business. The program
* is able to prepare, process, and then print the invoices as needed. 
* Voucher searching is included. 
* 
* This Class file is meant to work with the Driver file named VouchersDriver.java
********************************************************************************/

import java.util.InputMismatchException;

public class VouchersDriver {

    public static void main(String[] args) {
        String compName = " \n---- ODINxGaming Voucher Manager ---- \n";
        System.out.println(compName);
        int selection;  // user inputted selection for activity to perform next
        Boolean timeToExit = false; // checks to see if the user is ready to end the program

        VoucherSystem voucherList = new VoucherSystem();

        voucherList.initializeDirectory();
        
        while (timeToExit ==  false){

            try { // try_catch for integer selection- quits the program if selection is not a number.
                
                selection = voucherList.setActivity();
                voucherList.processSelection(selection);
                timeToExit = voucherList.timeToExit();    
            } 
            
            catch (InputMismatchException e) {
                System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println("\n Please enter an Integer. Program shutting down...\n");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
                timeToExit = true;
            }
        }
    } // End Main   
} // End Class VoucherDriver
