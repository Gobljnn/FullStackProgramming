import javax.swing.JOptionPane;

/*******************************************************************************
* HourlyEmp.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #1 - Employee Payroll  (Version 2.1)
*
* This program populates and displays the payroll for 3 types of employees.  
* Employees are Hourly, Salary, and Salary+Commission. Bonuses are applied to 
* respective employees if their birthday fall within the pay period.
*
* This child class contains methods and variables specific to the Hourly Employees.
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
//import javax.swing.JOptionPane;

public class HourlyEmp extends Employee {
    Double hourlyPay;
    Double hoursWorked;
    boolean passed = false;
    private String m1 = "Terminal" , m2 = "Dialog Box" ;

    public double setHourlyPay(String name, String mode){
        passed = false;


        while (passed == false){

            if (mode.equals(m1)){
                try {
                    System.out.print("\nWhat is " + name + "\'s hourly pay? : $");
                    this.hourlyPay = userInput.nextDouble();
    
                    if (this.hourlyPay > 0 ){
                        passed = true;
                        return this.hourlyPay;
                    }
    
                    else{
                        System.out.println("\n**ERROR** : Excuse me what?? That's practically slavery. Pay your worker... Try Again...");
                    }
    
                } catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input a number value, either decimal or integer...Try Again");
                    userInput.next();
                }
            }

            else if (mode.equals(m2)){
                String str = JOptionPane.showInputDialog(null, "What is " + name + "\'s hourly pay? ($)", 
                                    title2, JOptionPane.QUESTION_MESSAGE);
                try {
                    this.hourlyPay = Double.parseDouble( str);
    
                    if (this.hourlyPay > 0 ){
                        passed = true;
                        return this.hourlyPay;
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
                    JOptionPane.showMessageDialog(null, "Please input a number value, either decimal or integer", 
                                            title2, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return this.hourlyPay;
    }

    // ****************************************************************************************************************

    public double setHoursWorked(String name, String mode){
        passed = false;

        if (mode.equals(m1)){
            while (passed == false){
                try {
                    System.out.print("What is " + name + "\'s hours worked? (hours): ");
                    this.hoursWorked = userInput.nextDouble();
    
                    if (this.hoursWorked > 0){
                        passed = true;
                        return this.hoursWorked;
                    }
                    
                    else{
                        System.out.println("\n**ERROR** : Hours worked has to be greater than 0... Try Again...\n");
                    }
                    
                } catch (Exception e) {
                    
                    System.out.println("\n**ERROR** : Please input a number value, either decimal or integer...Try Again");
                    userInput.next();
                }
            }
        }

        else if (mode.equals(m2)){
            while (passed == false){
                String str =JOptionPane.showInputDialog(null, "What is " + name + "\'s hours worked? (hours)",
                                     title1, JOptionPane.QUESTION_MESSAGE) ;
                try {
                    this.hoursWorked = Double.parseDouble(str);
    
                    if (this.hoursWorked > 0){
                        passed = true;
                        return this.hoursWorked;
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "Hours worked has to be greater than 0", 
                                                    title2, JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (Exception e) {
                    if (str == null){
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Please input a number value, either decimal or integer", 
                                            title2, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return this.hoursWorked;
    }

    // ****************************************************************************************************************

    public double calcEarnings(String name) { // Calculates earnings for Hourly employees
        double OTH, OTR, tempStorage1;
        double OTP = 0 ;
        
        if (hoursWorked > 40){
            tempStorage1 = 40 * (this.hourlyPay);
            OTH = this.hoursWorked - 40 ;
            OTR = (this.hourlyPay) * 1.5 ;
            OTP = OTR * OTH ;
            this.paycheck = tempStorage1 + OTP;
        }

        else{
            this.paycheck = (this.hoursWorked) * (this.hourlyPay);
        }

        return this.paycheck;
    }

    // ****************************************************************************************************************
    
}
