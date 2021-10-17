/*******************************************************************************
* SalaryEmp.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #1 - Employee Payroll  (Version 2.1)
*
* This program populates and displays the payroll for 3 types of employees.  
* Employees are Hourly, Salary, and Salary+Commission. Bonuses are applied to 
* respective employees if their birthday fall within the pay period.
*
* This child class contains methods and variables specific to the Salary Employees.
*
* This Child Class file is meant to work with the Driver file named PayrollDrv.java
*
* V1.5 Updates -- : 
*   -- Quality of life changes, and compacted/cleaned certain sections of code
*   -- Added Exception handling to all user inputs to better model real world situations
*
* V 2.1 Updates -- :
*   -- Enhanced NumberFormatException to be more accurate
*   -- Quality of life changes; cleaned certain areas of code
********************************************************************************/
import javax.swing.JOptionPane;

public class SalaryEmp extends Employee {
    public double weeklySalary;
    boolean passed = false;

    public double setSalary(String name, String mode){

        if (mode.equals(m1)){
            while (passed == false){
                try {
                    System.out.print("\nWhat is " + name + "\'s weekly salary ? : $");
                    this.weeklySalary = userInput.nextDouble();
    
                    if (this.weeklySalary > 0){
                        passed = true;
                        return this.weeklySalary;
                    }
    
                    else{
                        System.out.println("\n**ERROR** : Excuse me what?? That's practically slavery. Pay your worker... Try Again...");
                    }
        
                } catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input either a decimal/integer number value...Try Again");
                    userInput.next();
                }
            }

        }

        else if (mode.equals(m2)){
            while (passed == false){
                String str = JOptionPane.showInputDialog(null, "What is " + name + "\'s weekly salary? ($)", 
                            title1, JOptionPane.QUESTION_MESSAGE) ;
                try {
                    this.weeklySalary = Double.parseDouble( str );
    
                    if (this.weeklySalary > 0){
                        passed = true;
                        return this.weeklySalary;
                    }
    
                    else{
                        JOptionPane.showMessageDialog(null, "EXCUSE ME ?!? That's practically slavery. Pay your workers", 
                                                    title2, JOptionPane.ERROR_MESSAGE);
                    }
        
                } catch (Exception e) {
                    if (str == null){
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Please input either a decimal/integer number value", 
                    title2, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return this.weeklySalary;
    }

    // ****************************************************************************************************************
    
}
