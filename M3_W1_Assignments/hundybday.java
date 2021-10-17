/*******************************************************************************
* hundybday.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 1 Assignment #2 - One-hundredth Birthday
*
* This program calculates and prints the day the user turns 100 years old. 
*******************************************************************************/

import javax.swing.JOptionPane; //import class for dialog (input) box

public class hundybday {
    public static void main(String[] args) {
        String name; //name of user
        String month; 
        int day;
        int year;

        name = JOptionPane.showInputDialog("What is your name? :");
        month = JOptionPane.showInputDialog("Enter your birth month: ");
        day = Integer.parseInt(JOptionPane.showInputDialog("Enter the day you were born: "));
        year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year you were born: "));
        year = year + 100;

            JOptionPane.showMessageDialog(null, "Welcome " + name + ", you will be 100 years old on " + month + " " 
                    + day + ", " + year + ".");
    } //End Main
} // End Class
