/*******************************************************************************
* bank.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 2 Assignment #2 - Bank Balance  
*
* This program calculates the users for a starting balance and then prints the 
* number of years it takes to reach $100,000 and also the number of years it
* takes to reach $1,000,000.
*******************************************************************************/
import javax.swing.JOptionPane; //import class for dialog (input) box

public class bank {

    public static void main(String[] args) {
        float balance;              // users initial bank balance
        int count= 0;               // total number of years 
        int fyears = 0;             // first-stage - number of years to reach $100,000
        int syears = 0;             // second-stage - number of years to reach $1,000,000
        boolean fstage = false;     // checks to see if $100,000 has been reached
        boolean sstage = false;     // checks to see if $1,000,000 has been reached

        
        try 
        {
            balance = Float.parseFloat(JOptionPane.showInputDialog("Enter your starting balance ($ - with no commas or symbols) : "));
            if ((balance >= 1_000_000) && (fstage == false) && (sstage == false))
            {
            JOptionPane.showMessageDialog(null,"My guy you already got $" + balance + " you don't need any more money " + 
                        "share some with me I got bills to pay ...please and thank you. Additionally, I'd look both ways " +
                        " before crossing the street...just saying.");
            }
            else if (balance <= 0)
            {
                JOptionPane.showMessageDialog(null,"Bro... $" + balance + " you too broke, put some money in your account.");
            }
            while ((balance > 0) && (fstage == false) && (balance < 1_000_000))
            {
                balance *= 2;
                count++;

                    if (balance >= 100_000)
                    {   
                        fstage = true;
                        fyears = count;
                    }
            }

            while ((balance > 100_000) && (sstage == false))
            {
                balance *= 2;
                count++;

                    if (balance >= 1_000_000)
                    {
                        sstage = true;
                        syears = count;
                    }
            }

            if ((balance >= 1_000_000) && (fstage) && (sstage))
            {
                JOptionPane.showMessageDialog(null,"It will take you " + fyears + " year(s) to make atleast $100,000 " + 
                            "and " + syears + " year(s) to make atleast $1,000,000 ." + "\n \n" + "I'd suggest really paying attention to " +
                            "the road -you know looking both ways before crossing- in like " + (syears-1) + " years just saying bro.");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "User input was not a number.");
        }
    } // End Main         
} // End Bank Balance
 
