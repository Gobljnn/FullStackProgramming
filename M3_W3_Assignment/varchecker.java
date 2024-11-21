/************************************************************************
* varchecker.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 3 Assignment #3 - Variable Name Checker   
*
* This program checks the properness of a given variable name. More 
* specifically, this program specifies whether a user-entered variable 
* name is illegal, legal, but uses poor style, or good.
*************************************************************************/

import javax.swing.JOptionPane;
import java.util.Scanner;

public class varchecker{

    public static void main(String[] args) {  
        Scanner stdIn = new Scanner(System.in);
        String variable;                       // user entry
        boolean apt_0 = true, apt_1 = true;    // apt_0 & apt_1 are used to check for illegal variables and legal but poor style variables respectively
        boolean apt_2 = false;                 // apt_2 is to check if the first letter is capitalized  
        boolean apt_q = false;                 // checks to see if the user wants to quit        
        char ch;
        String setMode;                        // Users preferred mode - Terminal or Dialog

        setMode = JOptionPane.showInputDialog(null, "* Running Variable Checker Program *" + "\n \n" + 
                                        "Would you prefer to work in the Terminal (1) or Dialog Box (2)");

        if ((setMode.equals("1")) && apt_q == false ){

            JOptionPane.showMessageDialog(null, "Terminal chosen. Please go to your IDE's Terminal" );
            System.out.print("Enter a variable name (q to quit): ");
            variable = stdIn.nextLine();
            ch = variable.charAt(0);

            if (ch == 'q' || ch == 'Q' && apt_q == false){
                apt_0 = false;
                apt_q = true;
                System.out.println("Thank you and come again");
            }
            
            if ((!(Character.isLetter(ch)) && apt_0 == true && apt_q == false)) {
                apt_0 = false;
                apt_1 = false;
                System.out.println("Oh no! Variable name is Illegal - first character has to be a letter");
            }

            if ((Character.isUpperCase(ch)) && apt_2 == false && apt_q == false){
                apt_2 = true;
            }

            for (int i = 1; i < (variable.length()) && apt_0==true && apt_1 ==true && apt_q == false; i++ ){
                ch = variable.charAt(i);

                if (ch == ' '){
                    apt_0 = false;
                    apt_1 = false;
                    apt_2 = false;
                    System.out.println("Oh no! The variable is illegal, choose a different variable name ");
                }

                else if (!(Character.isLetterOrDigit(ch) && apt_1 == true)){
                    apt_0 =true;
                    apt_1 = false;
                }
                stdIn.close(); 
            }

            if (apt_0 == true && apt_1 == false && apt_q == false || apt_2 == true ){  // If the variable is capitalized or has a symbol
                System.out.println("The Variable is legal but has poor form");
            }

            else if (apt_0 == true && apt_1 == true && apt_2 == false && apt_q == false){ // If the variable passess all checks
                System.out.println("The variable is good. Congratulations!");
            }
        } // End setMode 1

        if ((setMode.equals("2")) && apt_q == false ){
            
            JOptionPane.showMessageDialog(null, "Dialog box chosen. Please continue." );
            
            variable = JOptionPane.showInputDialog(null, "Enter a variable name (q to quit): ");
            ch = variable.charAt(0);

            if (ch == 'q' || ch == 'Q' && apt_q == false){
                apt_0 = false;
                apt_q = true;
                JOptionPane.showMessageDialog(null,"Thank you and come again");
            }
            
            if ((!(Character.isLetter(ch)) && apt_0 == true && apt_q == false)) {
                apt_0 = false;
                apt_1 = false;
                JOptionPane.showMessageDialog(null,"Oh no! Variable name is Illegal - first character has to be a letter");
            }

            if ((Character.isUpperCase(ch)) && apt_2 == false && apt_q == false){
                apt_2 = true;
            }

            for (int i = 1; i < (variable.length()) && apt_0==true && apt_1 ==true && apt_q == false; i++ ){
                ch = variable.charAt(i);

                if (ch == ' '){
                    apt_0 = false;
                    apt_1 = false;
                    apt_2 = false;
                    JOptionPane.showMessageDialog(null,"Oh no! The variable is illegal, choose a different variable name ");
                }

                else if (!(Character.isLetterOrDigit(ch) && apt_1 == true)){
                    apt_0 =true;
                    apt_1 = false;
                }
            }

            if (apt_0 == true && apt_1 == false && apt_q == false || apt_2 == true ){
                JOptionPane.showMessageDialog(null, "The Variable is legal but has poor form");  //capital first let
            }

            else if (apt_0 == true && apt_1 == true && apt_2 == false && apt_q == false){ // all good 
                JOptionPane.showMessageDialog(null, "The variable is legal. Congratulations!");
            }
        } // End setMode 2
    }// End Main
} // End varchecker