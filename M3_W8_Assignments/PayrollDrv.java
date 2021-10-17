/*******************************************************************************
* PayrollDrv.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #1 - Employee Payroll  (Version 2.1)
*
* This program populates and displays the payroll for 3 types of employees.  
* Employees are Hourly, Salary, and Salary+Commission. Bonuses are applied to 
* respective employees if their birthday fall within the pay period.
*
* This Driver class contains all methods and variables needed to execute the program.
*
* This Driver Class file is meant to work with the class files (4) - Employee.java,
* HourlyEmp.java, SalaryEmp.java, SalPlusCommEmp.java
*
* V 1.5 Updates -- : 
*   -- Added file header description
*
* V 2.1 Updates -- : 
*   -- Added hourly employee's hours to the final summary
*   -- Added the option to ask if user wants to add more employees
********************************************************************************/

public class PayrollDrv {
    public static void main(String[] args) {
        int profileNum, profileType;
        String name;           // Employee name
        String mode;           // Terminal or Dialog
        double hourlyPay, weeklySalary, paycheck, hours;

        Employee mainUser = new Employee();
        HourlyEmp hourlyUser = new HourlyEmp();
        SalaryEmp salUser = new SalaryEmp();
        SalPlusCommEmp comUser = new SalPlusCommEmp();
        boolean tryAgain = true ;   // boolean if the user wants to add more employees

        mainUser.initializeDB();

        while (tryAgain == true){

            mode = mainUser.setMode();

            profileNum = mainUser.setFormNum(mode);
            
    
            for (int i = 0 ; i < profileNum ; i++){
                name = mainUser.setName(mode);
                mainUser.setEmpNameArr();
                
    
                profileType = mainUser.setProfileType(mode);
                mainUser.setEmpNumArr();
                mainUser.setTypeArr();
                
    
                if (profileType == 1){ //hourly
                    mainUser.setSocial(mode);
                    mainUser.setSocialNumArr();
    
                    //JOptionPane.showMessageDialog(null, , "Test", JOptionPane.INFORMATION_MESSAGE);
                    
    
                    mainUser.setBirthday(mode);
                    mainUser.setB_MonthArr();
                    mainUser.setB_WeekArr();
    
                    hourlyPay = hourlyUser.setHourlyPay(name, mode);
                    mainUser.setHourRateArr(hourlyPay);
                    hours = hourlyUser.setHoursWorked(name, mode);
                    mainUser.setHoursArr(hours, profileType);


    
                    paycheck = hourlyUser.calcEarnings(name);
                    paycheck = mainUser.checkPayCheck(paycheck, name, mode);
                    paycheck = mainUser.getBonus(paycheck, mode);
                    mainUser.setWeeklyPayArr(paycheck);    
                }
    
                else if (profileType == 2){ //Salary
                    mainUser.setSocial(mode);
                    mainUser.setSocialNumArr();
                    
    
                    mainUser.setBirthday(mode);
                    mainUser.setB_MonthArr();
                    mainUser.setB_WeekArr();
    
                    weeklySalary = salUser.setSalary(name, mode); 
                    mainUser.setWeekSalaryArr(weeklySalary, profileType);
                    hours = 0;
                    mainUser.setHoursArr(hours, profileType);
                    
    
                    weeklySalary = mainUser.checkPayCheck(weeklySalary, name, mode);
                    weeklySalary = mainUser.getBonus(weeklySalary, mode);
                    mainUser.setWeeklyPayArr(weeklySalary);
    
                }
    
                else if (profileType == 3 ){ //sal+com
                    Double commission;
                    mainUser.setSocial(mode);
                    mainUser.setSocialNumArr();
                    
    
                    mainUser.setBirthday(mode);
                    mainUser.setB_MonthArr();
                    mainUser.setB_WeekArr();
    
                    weeklySalary = salUser.setSalary(name, mode);
                    mainUser.setWeekSalaryArr(weeklySalary, profileType);
                    hours = 0;
                    mainUser.setHoursArr(hours, profileType);
                    weeklySalary = mainUser.checkPayCheck(weeklySalary, name, mode);
    
                    
                    comUser.setSales(name, mode);
                    comUser.setComRate(name, mode);
                    weeklySalary = comUser.calcEarnings(weeklySalary, name, mode);
                    commission = comUser.getCommSales();
                    mainUser.setCommissionArr(commission);
                    weeklySalary = mainUser.getBonus(weeklySalary, mode);
                    
                    mainUser.setWeeklyPayArr(weeklySalary);
                } 
            }
            mainUser.printReport(mode);
            tryAgain = mainUser.tryAgain(mode);
        }


    }
}