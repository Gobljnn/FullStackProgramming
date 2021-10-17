/*******************************************************************************
* economy.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 2 Assignment #2 - Economy Policy 
*
* This program calculates and prints economic policy practices. More 
* specifically, it reads in annual growth Rate and inflation values from the 
* the user and outputs the recommended economic policy for each given 
* economic situation. 
*******************************************************************************/

import javax.swing.JOptionPane; //import class for dialog (input) box

public class economy {
    
    public static void main(String[] args) {
        double inflationrate;
        double annualrate;

            annualrate = Double.parseDouble(JOptionPane.showInputDialog("Enter the annual growth rate (%) : "));
            inflationrate = Double.parseDouble(JOptionPane.showInputDialog("Enter the inflation rate (%) : "));
 
        if ((annualrate < 1) && (inflationrate < 3)) // The rates are already in percentages (%) format, which should be more user friendly
        {
            JOptionPane.showMessageDialog(null,"The economic policy recommended is: Increase welfare spending, " +  
                "reduce personal taxes, and decrease discount rate. ");
        }

        else if ((annualrate < 1) && (inflationrate >= 3))
        {
            JOptionPane.showMessageDialog(null,"The economic policy recommended is: Reduce business taxes");
        }
    
        else if ((annualrate > 4) && (inflationrate < 1))
        {
            JOptionPane.showMessageDialog(null,"The economic policy recommended is: Increase personal and " + 
                "business taxes and also decrease discount rate.");                  
        }

        else if ((annualrate > 4) && (inflationrate > 3))
        {
            JOptionPane.showMessageDialog(null,"The economic policy recommended is: Increase discount rate.");  
        }

        else
        {
            JOptionPane.showMessageDialog(null,"No change in economic policy.");  // If the economic situation is not accounted for this 
                                                                                  // text will be displayed
        }

    } // End Main
} // End Class Economy 
