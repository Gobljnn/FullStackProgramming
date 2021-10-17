/*******************************************************************************
* SalPlusCommEmp.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #1 - Employee Payroll  (Version 2.1)
*
* This program populates and displays the payroll for 3 types of employees.  
* Employees are Hourly, Salary, and Salary+Commission. Bonuses are applied to 
* respective employees if their birthday fall within the pay period.
*
* This child class contains methods and variables specific to the Salary +
* commission Employees.
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
public class SalPlusCommEmp extends Employee {

    public Double sales;
    public double comRate;
    public double comSales;
    boolean passed = false;

    public void setSalary(String name, String mode){
        passed = false;

        if (mode.equals(m1)){
            while (passed == false){

                try {
                    System.out.print("\nWhat is " + name + "\'s weekly salary ? : $");
                    this.weeklySalary = userInput.nextDouble();
        
                    if (this.weeklySalary > 0){
                        passed = true;
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
                String str =JOptionPane.showInputDialog(null, "What is " + name + "\'s weekly salary? ($)", 
                            title1, JOptionPane.QUESTION_MESSAGE)  ;

                try {
                    this.weeklySalary = Double.parseDouble( str );
                    if (this.weeklySalary > 0){
                        passed = true;
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


    }

    // ****************************************************************************************************************

    public Double setSales(String name, String mode){
        passed = false;

        if (mode.equals(m1)){
            while (passed == false){
                try {
                    System.out.print("How much in sales did " + name + " make this week? : $");
                    this.sales = userInput.nextDouble();
    
                    if (this.sales >= 0){
                        passed = true;
                        return this.sales;
                    }
    
                    else{
                        System.out.println("\n**ERROR** :  Wow negative sales, that's new but yeah... sales has to be a positive integer or decimal.. Try Again...\n");
                    }
                   
                } catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input either a decimal/integer number value...Try Again");
                    userInput.next();            
                }
        }
    }


        else if (mode.equals(m2)){
            while (passed == false){
                String str =JOptionPane.showInputDialog(null, "How much in sales did " + name + " make this week? ($)", 
                            title1, JOptionPane.QUESTION_MESSAGE) ;
                try {
                    this.sales = Double.parseDouble(str);
    
                    if (this.sales >= 0){
                        passed = true;
                        return this.sales;
                    }
    
                    else{
                        JOptionPane.showMessageDialog(null, "Wow negative sales, that's new but yeah... sales has to be a positive integer or decimal", 
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
        return this.sales;
    }

    // ****************************************************************************************************************

    public double setComRate(String name, String mode){
        passed = false;

        if (mode.equals(m1)){
            while (passed == false){
                try {
                    System.out.print("What is " + name + "\'s commission rate (%) ? : ");
                    this.comRate = userInput.nextDouble();
                    if (this.comRate > 0){
                        passed = true;
                        return this.comRate;
                    }
    
                    else if (this.comRate == 0){
                        passed = true;
                        System.out.println("That's some COVID sales right there, it's hard out there");
                        return this.comRate;
                    }
    
                    else{
                        System.out.println("\n**ERROR** : Commission rate cannot be negative... Try Again...");
                    }
    
                } catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input either a decimal/integer number value...Try Again");
                    userInput.next();            
                }
            }

        }

        else if (mode.equals(m2)){
            while (passed == false){
                String str = JOptionPane.showInputDialog(null, "What is " + name + "\'s commission rate (%) ?",
                            title1, JOptionPane.QUESTION_MESSAGE) ;
                try {
                    this.comRate = Double.parseDouble(str);

                    if (this.comRate > 0){
                        passed = true;
                        return this.comRate;
                    }
    
                    else if (this.comRate == 0){
                        passed = true;
                        JOptionPane.showMessageDialog(null, "That's some COVID sales right there, it's hard out there", title1, 
                                            JOptionPane.INFORMATION_MESSAGE); ;
                        return this.comRate;
                    }
    
                    else{
                        JOptionPane.showMessageDialog(null, "Commission rate cannot be negative", title2, JOptionPane.ERROR_MESSAGE);
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
        return this.comRate;
    }

    // ****************************************************************************************************************

    public double calcEarnings(Double weeklySalary, String name, String mode){
        this.comSales = (this.sales * ((this.comRate)/100));
        this.paycheck = (weeklySalary) + this.comSales;

        if (mode.equals(m1)){
            System.out.println("\n\n"+ name + " made $" + this.sales + " in sales this week, with a commission rate of " + this.comRate +
            "% ("  +(this.comRate/100) +") " + name + "\'s commission for this week is $" + this.comSales );
        }

        else {
            JOptionPane.showMessageDialog(null, name + " made $" + this.sales + " in sales this week, with a commission rate of " + this.comRate +
                                         "% ("  +(this.comRate/100) +") " + name + "\'s commission for this week is $" + this.comSales, title1, 
                                        JOptionPane.INFORMATION_MESSAGE);
        }

        return this.paycheck;
    }

    // ****************************************************************************************************************

    public double getCommSales(){ //retrieves sales commission
        return this.comSales;
    }

    // ****************************************************************************************************************
    
}
