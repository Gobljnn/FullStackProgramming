/*******************************************************************************
* circleparam.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 1 Assignment #1 - Circle Parameters
*
* This program calculates and prints the diameter, circumference, and area 
* based on the radius value inputted by the user.
*******************************************************************************/

import javax.swing.JOptionPane; //import class for dialog (input) box

public class circleparam {
    
   public static void main(String[] args) {
       double radius;
       double diameter; // radius * 2
       double circum; //Circumference = 2*PI*radius
       double area; //area = 2*PI*radius^2

            radius = Double.parseDouble(JOptionPane.showInputDialog("Enter a Radius: "));
            diameter = radius * 2;
            circum = (2 * Math.PI*radius);
            area = (2 * Math.PI * Math.pow(radius, 2));

                JOptionPane.showMessageDialog(null,"Based on the radius of " + radius + "\n" +
                    "The diameter is " + diameter + "\n" +
                    "The Circumference is " + circum + "\n" +
                    "The Area is " + area);       
   } // End Main
}// End Class Circleparam
