/************************************************************************
* triangle.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 2 Assignment #2 - Triangle   
*
* This program generates an isosceles triangle made of asterisks 
* (or other symbols). The program should prompt the user to specify 
* the size of the triangle.
*************************************************************************/

import javax.swing.JOptionPane;
import java.util.Scanner;

public class triangle {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in); 
        
        int size, row, col; // size, column and row of the triangle
        String triChar = "*"; // symbol(s) that will be used to make the triangle image
        String triangle ; // String that will contain the displayed triangle
        Boolean tryAgain = true; // checks to see if user wants to try again
        String setMode = ""; // checks to see if user wants to use terminal or dialog box
        String goAgain = "y"; // user input to try again

        while (tryAgain == true && goAgain.equalsIgnoreCase("y")) 
        {
            setMode = JOptionPane.showInputDialog("Do you want to work in the Terminal (1) or Dialog Box (2)");

            if (setMode.equals("1")) 
            {
                JOptionPane.showMessageDialog(null, "Terminal chosen. Please go to your IDE's Terminal" );
                System.out.print("Enter what character(s) to use for the Triangle: ");
                triChar = stdIn.nextLine();
                
                try { // try and catch used to check if an integer is put as the size of the triangle
                    System.out.print("Enter the size of the Triangle (Integer): ");
                    size = stdIn.nextInt();
                    for (row =1, triangle = ""; row <= size ; row++)
                    {
                        for (col=1 ; col <= row; col++)
                        {
                            System.out.print(triChar);
                        }
                        System.out.println();
                    } //End Nested For Loop
                    System.out.print("Do you want to try again (y/n) : ");
                    goAgain = stdIn.nextLine();
                    goAgain = stdIn.nextLine();

                    if (goAgain.equalsIgnoreCase("y"))
                    {
                        System.out.print("Welcome back, a dialog box should open up" + "\n");
                    }
                } 
                
                catch (Exception e) 
                {
                    System.out.println("Your input was not a number. You have been returned to the dialog box");
                    System.out.print("A dialog box should open up" + "\n");
                }
                stdIn.close();
            } //End if setMode 1

            else if (setMode.equals("2"))
            {
                JOptionPane.showMessageDialog(null, "Dialog Box Chosen. Please Proceed." );
                triChar = JOptionPane.showInputDialog(null, "Enter what character(s) to use for the Triangle: " );
                
                try 
                {
                    size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the Triangle (Integer) : "));
                    for (row =1, triangle = "" ; row <= size ; row++)
                    {
                        for (col=1 ; col <= row; col++)
                        { }
                        triangle += triChar.repeat(col-1);
                        triangle += "\n";
                    } //End Nested For Loop
                    JOptionPane.showMessageDialog(null, triangle );
                    goAgain = JOptionPane.showInputDialog("Do you want to try again (y/n) : ");
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "Your input was not a number.");
                }
            } // End if setMode 2

            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Mode, choose one of the two options please" );
            }
        } //End tryAgain While Loop

        if (goAgain.equalsIgnoreCase("n") && setMode.equals("1"))
        {
            System.out.print("Thank you, come again");
            tryAgain = false;
        }

        else if (goAgain.equalsIgnoreCase("n") && setMode.equals("2"))
        {
            JOptionPane.showMessageDialog(null, "Thank you, come again" );
            tryAgain = false;
        }

        else
        {
            JOptionPane.showMessageDialog(null, "Invalid input, choose one of the two options please" );
        }   
    }// End Main
} // End Triangles
