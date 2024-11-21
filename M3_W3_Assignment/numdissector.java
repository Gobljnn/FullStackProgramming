/************************************************************************
* numdissector.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 3 Assignment #3 - Number Dissector   
*
* This program reads phone numbers and it displays the phone number's 
* three (3) components - country code (cc), area code (area), and
* local phone number. Format should be cc-area-local
* 
* Phone number should be between 11 to 17 numbers long, while still 
* following the above mentioned format
*************************************************************************/

import javax.swing.JOptionPane;
import java.util.Scanner;

public class numdissector {

    public static void main(String[] args) {
        String phoneNum=" ", cc=" ", area=" ", loc=" "; // initializing the strings for phone number, country 
                                                        //code, area code, and local number,respectively.

        boolean secClose_cc = true, secClose_area = false, secClose_loc = false; // secClose = Section close, returns false once 
                                                                                //the cc, area and local numbers have been determined
        Scanner stdIn = new Scanner(System.in);
        char num; // variable for characters in phone number
        int num1=0, num2=0; // substring values; num1 = beginning index; num2 = endindex
        String setMode; // user preference mode
        String goAgain = "y"; // if user user wants to try again
        boolean tryAgain = true; // returns false if user decides to exit the program
        boolean repeat = true; // returns false once the noticication for user preference has been shown

        setMode = JOptionPane.showInputDialog(null, "* Running Number Dissector Program *" + "\n \n" + 
                                            "Would you prefer to work in the Terminal (1) or Dialog Box (2)");

        while (setMode.equals("1") && goAgain.equalsIgnoreCase("y") && tryAgain == true){  // If the user prefers to use the terminal
            if (repeat == true) {
                JOptionPane.showMessageDialog(null, "Terminal chosen. Please go to your IDE's Terminal" );
                repeat = false;
            }
            
            System.out.println("Enter a phone mumber of the format (cc-area-local), \nWhere cc = Country Code Digits " + 
                    ", area = Area Code Digits, and local = Local Phone Digits. \n \n (q to quit)");
            phoneNum = stdIn.nextLine();
            
            if (phoneNum.length() >= 13 && phoneNum.length() <= 19 && tryAgain == true){  

                for (int i=1; phoneNum.length() >= 13 && i < phoneNum.length() ; i++ ){
                    num = phoneNum.charAt(i);
    
                    if (!(Character.isDigit(num)) && secClose_cc == true){
                        num1 = i;
                        cc = phoneNum.substring(0, num1);
                        secClose_cc = false;
                        secClose_area = true;
                        System.out.println("Based on the phone number: " + phoneNum + " that you supplied..." + "\n");
                        System.out.println("The country code is: " + cc + "\n");
                    }
    
                    else if (!(Character.isDigit(num)) && secClose_area == true){
                        num2 = i;
                        area = phoneNum.substring(num1+1, num2);
                        secClose_area = false;
                        secClose_loc = true;
                        num1 = num2; //switches num1 and num2 to be used in the next if statement
                        System.out.println("The area code is: " + area + "\n");
                    }
    
                    else if (i == phoneNum.length()-1 && (secClose_loc == true)){
                        num2 = i;
                        loc = phoneNum.substring(num1+1, phoneNum.length());
                        secClose_loc = false;
                        System.out.println("The local number is: " + loc);
                        goAgain = "n";
                        System.out.println("Do you want to try a different number? (y/n)");
                        goAgain = stdIn.nextLine();

                        if (goAgain.equalsIgnoreCase("y")) {
                            System.out.println("Welcome back \n \n");
                            secClose_cc = true;  //section closes are reverted back to allow the above if statements to be executed
                            secClose_area = false;
                            secClose_loc = false;
                        }

                        else if (goAgain.equalsIgnoreCase("n")){
                            System.out.println("Thank you and come again.");
                            tryAgain = false;
                        }

                        else{
                            System.out.println("Invalid input, program is exiting. " );
                        }
                    }
                }
            }

            else if (phoneNum.equalsIgnoreCase("q")){
                System.out.println("Thank you and come again.");
                tryAgain = false;
            }
            
            else {
                System.out.println("Invalid phone number, check its length.");
            }
        } // End Terminal Mode
        
        while (setMode.equals("2") && goAgain.equalsIgnoreCase("y") && tryAgain == true) { // user prefers using the dialog box
            
            if (repeat == true) {
                JOptionPane.showMessageDialog(null, "Dialog box chosen. Please continue." );
                repeat = false;
            }

            phoneNum = JOptionPane.showInputDialog(null, "Enter a phone mumber of the format (cc-area-local), \nWhere cc = Country Code Digits " + 
            ", area = Area Code Digits, and local = Local Phone Digits. \n \n (q to quit)");

            
            if (phoneNum.length() >= 13 && phoneNum.length() <= 19){

                for (int i=1; phoneNum.length() >= 13 && i < phoneNum.length() ; i++ ){
                    num = phoneNum.charAt(i);
    
                    if (!(Character.isDigit(num)) && secClose_cc == true){
                        num1 = i;
                        cc = phoneNum.substring(0, num1);
                        secClose_cc = false;
                        secClose_area = true;
                    }
    
                    else if (!(Character.isDigit(num)) && secClose_area == true){
                        num2 = i;
                        area = phoneNum.substring(num1+1, num2);
                        secClose_area = false;
                        secClose_loc = true;
                        num1 = num2;
                    }
    
                    else if (i == phoneNum.length()-1 && (secClose_loc == true)){
                        num2 = i;
                        loc = phoneNum.substring(num1+1, phoneNum.length());
                        secClose_loc = false;
                        JOptionPane.showMessageDialog(null, "Based on the phone number: " + phoneNum + " that you supplied..." + "\n" + 
                                                    "The country code is: " + cc + "\n" +"The area code is: " + area + "\n" + 
                                                    "The local number is: " + loc + "\n" );

                        goAgain = "n";
                        goAgain = JOptionPane.showInputDialog(null, "Do you want to try a different number? (y/n)");

                        if (goAgain.equalsIgnoreCase("y")) {
                            JOptionPane.showMessageDialog(null, "Welcome back");
                            secClose_cc = true;
                            secClose_area = false;
                            secClose_loc = false;
                        }

                        else if (goAgain.equalsIgnoreCase("n")){
                            JOptionPane.showMessageDialog(null, "Thank you and come again.");
                            tryAgain = false;
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Invalid input, click ok to leave exit the program. " );
                        }
                    }
                }
            }

            else if (phoneNum.equalsIgnoreCase("q")){
                JOptionPane.showMessageDialog(null,"Thank you and come again.");
                tryAgain = false;
            }
            
            else {
                JOptionPane.showMessageDialog(null,"Invalid phone number, check its length.");
            }

        } // End Dialog box mode
        stdIn.close();
    } // End main
    
} // End numdissector
