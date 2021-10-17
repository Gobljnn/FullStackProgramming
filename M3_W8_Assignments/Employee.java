/*******************************************************************************
* Employee.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #1 - Employee Payroll  (Version 2.1)
*
* This program populates and displays the payroll for 3 types of employees.  
* Employees are Hourly, Salary, and Salary+Commission. Bonuses are applied to 
* respective employees if their birthday fall within the pay period.
*
* This parent class contains all methods and variables needed for all three 
* employee types.
*
* This Super/Parent Class file is meant to work with the Driver file named PayrollDrv.java
*
* V 1.5 Updates -- : 
*   -- Quality of life changes, and compacted/cleaned certain sections of code
*   -- Added Exception handling to all user inputs to better model real world situations
*   -- Disabled duplicate Social security numbers to better model real world situations
*
* V 2.1 Updates -- :
*   -- Enhanced NumberFormatException to be more accurate
*   -- Modified the program to request for user to choose either terminal or Dialog box 
*   -- Added hourly employee hours to the employeeDB array
*   -- Added the option to ask if user wants to add more employees
*   -- Quality of life changes; cleaned certain areas of code
********************************************************************************/

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.*;

public class Employee {
    public String name, print;                      // Employee's name and summary print variables, respectively
    public int socialSecurity;
    public String ssformatted;                      // Social Security number formated for summary printing           
    public double paycheck, weeklySalary;           // Emploee's paycheck and/or salary
    public int birthWeek, birthMonth, profileNum;   // Profile number holds how many profiles the user wants to create
    private int j = 1;                              // Counter for iteration
    public int profileType;                         // Holds variable for what kind of employee is being populated
    private String tempStorage1;
    private String mode;
    public String title = "*Weekly Payroll Program*";       // General title for JOptionpane
    public String title1 = "*Weekly Payroll Program* : Creating Employee Payroll Information"; //Creating employee title for JOptionpane
    public String title2 = "*** ERROR ***" ;    // Error title for JOptionpane
    public String title3 = "Exiting";       // Exiiting title for JOptionpane
    private String[] selMode ={"Terminal","Dialog Box"};
    public String m1 = "Terminal" , m2 = "Dialog Box" ; //shorten selMode to compact code

    private boolean passed = false;
    private boolean validSocial = false;

    Scanner userInput = new Scanner(System.in);
    Calendar birth = Calendar.getInstance();

    public ArrayList<ArrayList<String>> employeeDB = new ArrayList<>(); //2D ArrayList for all ArrayLists created
    private ArrayList<String> empNumArr = new ArrayList<>();
    private ArrayList<String> typeArr = new ArrayList<>();
    private ArrayList<String> empNameArr = new ArrayList<>();
    private ArrayList<String> socialArr = new ArrayList<>();
    private ArrayList<String> b_MonthArr = new ArrayList<>();
    private ArrayList<String> b_WeekArr = new ArrayList<>();
    private ArrayList<String> hourRateArr = new ArrayList<>();
    private ArrayList<String> salaryArr = new ArrayList<>();
    private ArrayList<String> commissionArr = new ArrayList<>();
    private ArrayList<String> weeklyPayArr = new ArrayList<>();
    private ArrayList<Integer> validSocialArr = new ArrayList<>();
    private ArrayList<String> hoursArr = new ArrayList<>();

    // ****************************************************************************************************************

    public void initializeDB(){
        employeeDB.add(empNumArr);     //index 0
        employeeDB.add(typeArr);       //index 1
        employeeDB.add(empNameArr);    //index 2
        employeeDB.add(socialArr);     //index 3
        employeeDB.add(b_MonthArr);    //index 4
        employeeDB.add(b_WeekArr);     //index 5
        employeeDB.add(hourRateArr);   //index 6
        employeeDB.add(salaryArr);     //index 7
        employeeDB.add(commissionArr); //index 8
        employeeDB.add(weeklyPayArr);  //index 9
        employeeDB.add(hoursArr);      //index 10
    }

    // ****************************************************************************************************************

    public void setEmpNumArr(){ // Holds profileNum
        tempStorage1 = Integer.toString((this.j)-1);
        empNumArr.add(tempStorage1);
    }

    // ****************************************************************************************************************

    public void setTypeArr(){ // Holds Profile type
        tempStorage1 = Integer.toString(this.profileType);
        if (tempStorage1.equalsIgnoreCase("1")){
            tempStorage1 = "Hourly";
            typeArr.add(tempStorage1);
        }

        else if (tempStorage1.equalsIgnoreCase("2")){
            tempStorage1 = "Salary";
            typeArr.add(tempStorage1);
        }

        else if (tempStorage1.equalsIgnoreCase("3")){
            tempStorage1 = "Salary+Commission";
            typeArr.add(tempStorage1);
        }
    }

    // ****************************************************************************************************************

    public void setEmpNameArr(){ //holds Employee name
        empNameArr.add(this.name);
    }

    // ****************************************************************************************************************

    public void setSocialNumArr(){ // holds employee social security number
        socialArr.add(this.ssformatted);
    }

    // ****************************************************************************************************************

    public void setB_MonthArr(){ //holds employee birthday month
        tempStorage1 = Integer.toString(this.birthMonth);
        b_MonthArr.add(tempStorage1);
    }

    // ****************************************************************************************************************

    public void setB_WeekArr(){ //holds employee birthday week
        tempStorage1 = Integer.toString(this.birthWeek);
        b_WeekArr.add(tempStorage1);
    }

    // ****************************************************************************************************************

    public void setHourRateArr(double hourlyPay){ //holds the hourly rate for hourly employees
        tempStorage1 = Double.toString(hourlyPay);
        hourRateArr.add(tempStorage1);
        salaryArr.add("N/A");
        commissionArr.add("N/A");
    }

    // ****************************************************************************************************************

    public void setWeekSalaryArr(double weeklySalary, int profileType){ //holds weekly salary for salary and Salary+commission employees
        tempStorage1 = Double.toString(weeklySalary);
        salaryArr.add(tempStorage1);
        hourRateArr.add("N/A");

        if (profileType == 2){
            commissionArr.add("N/A");
        }
    }

    // ****************************************************************************************************************

    public void setCommissionArr(double weeklyCommission){ //holds commission for Salary+Commission employees
        tempStorage1 = Double.toString(weeklyCommission);
        commissionArr.add(tempStorage1);
    }

    // ****************************************************************************************************************

    public void setWeeklyPayArr(double paycheck){ // holds weekly paycheck values for all employees
        tempStorage1 = Double.toString(paycheck);
        weeklyPayArr.add(tempStorage1);
    }

    // ****************************************************************************************************************

    public void setHoursArr(double hours, int profileType){
        if (profileType == 2 || profileType ==3){
            hoursArr.add("N/A");
        }
        else{
            tempStorage1 = Double.toString(hours);
            hoursArr.add(tempStorage1);
        }
    }

    public String setMode(){
        mode = (String) JOptionPane.showInputDialog(null, "Terminal or Dialog", title, JOptionPane.QUESTION_MESSAGE, null, selMode, selMode[0]);
        try {
            if (mode.equals("Terminal")){
                JOptionPane.showMessageDialog(null, "Please proceed to your IDE's terminal to continue",
                                         title, JOptionPane.INFORMATION_MESSAGE);
            }
    
            else if(mode.equals(m2)){
                JOptionPane.showMessageDialog(null, "Welcome! You may continue", title, JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            if (mode == null){
                JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        return this.mode;
    }

    // ****************************************************************************************************************
    
    public int setFormNum(String mode){
        passed = false;

        if (mode.equals("Terminal")){
            while (passed == false){
                try {
                    System.out.println("\n\nWelcome!");
                    System.out.print("How many employee profiles are you going to create? : ");
                    this.profileNum = userInput.nextInt();
        
                    System.out.print("\n\n");
                    passed = true;
                    return this.profileNum;
                } 
                
                catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input a number...Try again...\n");
                    userInput.next();
                    passed = false;
                }
            }
            return this.profileNum;
        }

        else if (mode.equals("Dialog Box")){
            String str;
            while (passed == false){
                str = (String) JOptionPane.showInputDialog(null, "How many employee profiles are you going to create?",
                title, JOptionPane.QUESTION_MESSAGE);
                try {

                    this.profileNum = Integer.parseInt(str) ;

                    passed = true;
                    return this.profileNum;
                } 
                
                catch (Exception e) {
                    if (str == null){
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Please input a number", 
                                                title2, JOptionPane.ERROR_MESSAGE); 
                    passed = false;
                }
            }
            return this.profileNum;
        }
        return this.profileNum;
    }

    // ****************************************************************************************************************

    public int setProfileType(String mode){
        passed = false;
        while (passed == false){

            if (mode.equalsIgnoreCase(m1)){
                try {
                    System.out.println("\nCreating Profile for Employee #" + j + " (" + this.name.toUpperCase() + ")\n");
                    System.out.println("What type of employee is " + this.name + "?");
                    System.out.print("Hourly (1), Salaried (2), Salaried + Commission (3) : ");
            
                    profileType = userInput.nextInt();
        
                    if (profileType > 0 && profileType <= 3){
                        passed = true;
                        j++;
                        return profileType;
                    }
        
                    else {
                        System.out.println("\n**ERROR** : Please input a number from one of the options (1, 2, or 3) ... Try Again");
                    }
                } 
                
                catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input a number... Try Again...");
                    userInput.next();
                }  

            }

            else if (mode.equalsIgnoreCase(m2)){
                String strProfileType;
                String[] options = {"Hourly" , "Salaried", "Salaried + Commission"} ;
                
                strProfileType = (String) JOptionPane.showInputDialog(null, 
                                "Creating Profile for Employee #" + j + " (" + this.name.toUpperCase() + ")\n\n" 
                                + "What type of employee is " + this.name + "?" , 
                                title1, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) ;

                try {
                    if (strProfileType.equals("Hourly")){
                        profileType = 1;
                        j++;
                        passed = true;
                        return profileType;
                    }
    
                    else if (strProfileType.equals("Salaried")){
                        profileType = 2;
                        passed = true;
                        j++;
                        return profileType;
                    }
    
                    else if (strProfileType.equals("Salaried + Commission")){
                        profileType = 3;
                        passed = true;
                        j++;
                        return profileType;
                    }
                    
                } catch (Exception e) {
                    if (strProfileType == null) {
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }
        }
        return profileType;
    }

    // ****************************************************************************************************************

    public String setName(String mode){
        passed = false;

        if (mode.equalsIgnoreCase(m1)){
            if (j == 1 ){
                System.out.println("* * ".repeat(7) + "Creating Employee Payroll Information " + "* * ".repeat(7) );
            }
    
            while (passed == false){
    
                System.out.print("\nWhat is Employee #" +j+ "\'s name? : ");
                this.name = userInput.nextLine();
                this.name = userInput.nextLine();
    
                if (this.name.isEmpty()){
                    System.out.println("\n**ERROR** : Name cannot be empty, I'm sure this isn't Elon Musk\'s child... Try Again..");
                }
    
                else{
                    passed = true;
                    return this.name;
                }
            }

        }

        else if (mode.equalsIgnoreCase(m2)){
 
            while (passed == false){

                try {
                    this.name = JOptionPane.showInputDialog(null, "What is Employee #" +j+ "\'s name? : ", 
                    title1, JOptionPane.QUESTION_MESSAGE);

                    if (this.name.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Name cannot be empty, I'm sure this isn't Elon Musk\'s child", title2, JOptionPane.ERROR_MESSAGE);
                    }

                    else{
                        passed = true;
                        return this.name;
                    }
                    
                } catch (Exception e) {
                    if (this.name == null){
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }
        }
        return this.name;
    }

    // ****************************************************************************************************************

    public void setSocial(String mode){
        passed = false;

        if (mode.equals(m1)){

            while (passed == false){
                validSocial = false;
                while (validSocial == false){
                    try {
                        System.out.print("\nWhat is " + this.name + "\'s Social Security? (9 digits) : ");
                        this.socialSecurity = userInput.nextInt();
    
                        if (this.socialSecurity > 0){
                            if (String.valueOf(this.socialSecurity).length() == 9){
                                validSocial = searchSocial(this.socialSecurity);
        
                                if (validSocial == true){
                                    validSocialArr.add(this.socialSecurity);
                                    ssformatted = Integer.toString(this.socialSecurity);
                                    ssformatted = ssformatted.replaceFirst("(\\d{3})(\\d{2})(\\d+)", "$1-$2-$3");
                                    passed = true;
                                }
                                
                                else{
                                    System.out.println("\n**ERROR** : ANOTHER EMPLOYEE ALREADY HAS THIS SOCIAL SECURITY NUMBER...PLEASE VERIFY YOUR INPUT");
                                }
                            }
        
                            else{
                                System.out.print("\n**ERROR** : Please ensure " + this.name +  "\'s social security number is 9 digits \n");
                            } 
                        }
    
                        else{
                            System.out.println("\n**ERROR** : Social Security numbers cannot be negative");
                        }
        
                    } catch (Exception e) {
                        System.out.println("\n**ERROR** : Please ensure all characters are numbers... Try Again...");
                        userInput.next();
                    }
                }
            }

        }

        else if (mode.equals(m2)){
            String str;
            while (passed == false){

                validSocial = false;

                while (validSocial == false){
                    str = JOptionPane.showInputDialog(null, "What is " + this.name + "\'s Social Security number? (9 digits) : ",
                        title1, JOptionPane.QUESTION_MESSAGE);
                    try {
                        this.socialSecurity = Integer.parseInt(str);
    
                        if (this.socialSecurity > 0){
                            if (String.valueOf(this.socialSecurity).length() == 9){
                                validSocial = searchSocial(this.socialSecurity);
        
                                if (validSocial == true){
                                    validSocialArr.add(this.socialSecurity);
                                    ssformatted = Integer.toString(this.socialSecurity);
                                    ssformatted = ssformatted.replaceFirst("(\\d{3})(\\d{2})(\\d+)", "$1-$2-$3");
                                    passed = true;
                                }
                                
                                else{
                                    JOptionPane.showMessageDialog(null, "ANOTHER EMPLOYEE ALREADY HAS THIS SOCIAL SECURITY NUMBER...PLEASE VERIFY YOUR INPUT", 
                                                                title2, JOptionPane.ERROR_MESSAGE);
                                }
                            }
        
                            else{
                                JOptionPane.showMessageDialog(null, "Please ensure " + this.name +  "\'s social security number is 9 digits", 
                                title2, JOptionPane.ERROR_MESSAGE);
                            } 
                        }
    
                        else{
                            JOptionPane.showMessageDialog(null, "Social Security numbers cannot be negative", 
                            title2, JOptionPane.ERROR_MESSAGE);
                        }
        
                    } catch (Exception e) {
                        if (str == null){
                            JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                        JOptionPane.showMessageDialog(null, "Please ensure all characters are numbers", 
                        title2, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        

    }

    // ****************************************************************************************************************

    public boolean searchSocial(int socialSecurity){
        Collections.sort(validSocialArr);
        int position = Collections.binarySearch(validSocialArr, socialSecurity);

        if (position < 0){
            return true;
        }

        else{
            return false;
        }
    }

    // ****************************************************************************************************************

    public void setBirthday(String mode){
        passed = false;
        boolean innerpass = false;

        if (mode.equals(m1)){
            while (passed == false){
    
                try {
                    System.out.print("\nWhat is " + this.name + "\'s birth month (1 - 12) : ");
                    birthMonth = userInput.nextInt();
    
                    if (birthMonth > 0 && birthMonth <= 12){
                        while (innerpass == false){
                            try {
                                System.out.print("What is " + this.name + "\'s birth week (1 - 4) : ");
                                birthWeek = userInput.nextInt();
        
                                if (birthWeek > 0 &&  birthWeek <= 4) {
                                    passed = true;
                                    innerpass = true;
                                }
        
                                else {
                                    System.out.println("\n**ERROR** : Please input a number from 1 - 4.. Try Again...");
                                }
                            } 
                            
                            catch (Exception e) {
                                System.out.println("\n**ERROR** : Please input a number... Try Again...");
                                userInput.next();
                            }  
                        }
                    }
    
                    else {
                        System.out.println("\n**ERROR** : Please input a number from 1 - 12.. Try Again...");
                    }
                } 
                
                catch (Exception e) {
                    System.out.println("\n**ERROR** : Please input a number... Try Again...");
                    userInput.next();
                }
            }

        }

        else if (mode.equals(m2)){
            String strMonth;
            String[] options = {"Jan" , "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            while (passed == false){
    
                
                strMonth =(String) JOptionPane.showInputDialog(null, "What month was " + this.name + "\'s born?", title1, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                try {
                    if (strMonth.equals("Jan")){
                        birthMonth = 1;
                        passed = true;
                    }
                    else if (strMonth.equals("Feb")){
                        birthMonth = 2;
                        passed = true;
                    }
                    else if (strMonth.equals("Mar")){
                        birthMonth = 3;
                        passed = true;
                    }
                    else if (strMonth.equals("Apr")){
                        birthMonth = 4;
                        passed = true;
                    }

                    else if (strMonth.equals("May")){
                        birthMonth = 5;
                        passed = true;
                    }

                    else if (strMonth.equals("Jun")){
                        birthMonth = 6;
                        passed = true;
                    }

                    else if (strMonth.equals("Jul")){
                        birthMonth = 7;
                        passed = true;
                    }

                    else if (strMonth.equals("Aug")){
                        birthMonth = 8;
                        passed = true;
                    }

                    else if (strMonth.equals("Sep")){
                        birthMonth = 9;
                        passed = true;
                    }

                    else if (strMonth.equals("Oct")){
                        birthMonth = 10;
                        passed = true;
                    }

                    else if (strMonth.equals("Nov")){
                        birthMonth = 11;
                        passed = true;
                    }

                    else if (strMonth.equals("Dec")){
                        birthMonth = 12;
                        passed = true;
                    }
                } catch (Exception e) {
                    if (strMonth == null){
                        JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }

                while (innerpass == false){
                    String str = JOptionPane.showInputDialog(null, "What is " + this.name + "\'s birth week (1 - 4)", 
                            title1, JOptionPane.QUESTION_MESSAGE);
                    try {
                        birthWeek = Integer.parseInt(str);

                        if (birthWeek > 0 &&  birthWeek <= 4) {
                            passed = true;
                            innerpass = true;
                        }

                        else {
                            JOptionPane.showMessageDialog(null, "Please input a number from 1 - 4", title2, JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                    
                    catch (Exception e) {
                        if (str == null){
                            JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                        JOptionPane.showMessageDialog(null, "Please input a number", title2, JOptionPane.ERROR_MESSAGE);
                    }  
                }
            }
        }
    }

    // ****************************************************************************************************************

    public double getBonus(double paycheck, String mode){
        if (birth.get(Calendar.MONTH) == (birthMonth - 1) && birth.get(Calendar.WEEK_OF_MONTH) == (birthWeek)){

            if (mode.equals(m1)){
                System.out.println("\n\nWOOP!! It\'s " + this.name + "\'s birthday this week. They get a $100 Birthday bonus on this week\'s paycheck ");
            
                this.paycheck = paycheck + 100 ;
                System.out.println("\n *** New paycheck is $" + this.paycheck + " *** \n");
                return this.paycheck;

            }

            else if (mode.equals(m2)){
                this.paycheck = paycheck + 100 ;

                JOptionPane.showMessageDialog(null,
                                 "WOOP!! It\'s " + this.name + "\'s birthday this week. They get a $100 Birthday bonus on this week\'s paycheck \n\n" +
                                 "*** New paycheck is $" + this.paycheck + " *** ", 
                                 title1, JOptionPane.INFORMATION_MESSAGE);
                return this.paycheck;
            }
        }
        return paycheck;
    }

    // ****************************************************************************************************************

    public double checkPayCheck(double paycheck, String name, String mode){ // Checks paycheck to ensure base weekly salary does not exceed $1,000 for all employees
        if (paycheck > 1000){

            if (mode.equals(m1)){
                System.out.println("\n" + name + "\'s base paycheck is $" + paycheck + " but will be paid $1,000.00" );
            }

            else if (mode.equals(m2)){
                JOptionPane.showMessageDialog(null,  name + "\'s base paycheck is $" + paycheck + " but will be paid $1,000.00", 
                                        title1, JOptionPane.INFORMATION_MESSAGE);
            }
            this.paycheck = 1000;
        }

        else{
            if (mode.equals(m1)){
                System.out.println("*** "+name + "\'s base paycheck is $" + (paycheck) + "***");
            }
            else if (mode.equals(m2)){
                JOptionPane.showMessageDialog(null, name + "\'s base paycheck is $" + (paycheck), 
                                    title1, JOptionPane.INFORMATION_MESSAGE);
            }
            return paycheck;
        }
        return this.paycheck;
    }

    // ****************************************************************************************************************

    public void printReport(String mode){
        passed = false;
        char ch;
        int k = 0;

        while (passed == false){

            if (k==0){

                if (mode.equals(m1)){
                    System.out.print("\n\nWould you like to print out the report? (y/n): ");
                    print = userInput.nextLine();
                    print = userInput.nextLine();

                }

                else if (mode.equals(m2)) {
                    print = (String) JOptionPane.showInputDialog(null, "Would you like to print out the report? (y/n)",
                         "*Weekly Payroll Program* : Summary printout", JOptionPane.QUESTION_MESSAGE);
                }

                ch = print.charAt(0);
        
                if (ch == 'y' || ch == 'Y'){
                    if (mode.equals(m2)){
                       JOptionPane.showMessageDialog(null, "Your report(s) will be in your IDE's terminal", "*Weekly Payroll Program* : Summary printout", JOptionPane.INFORMATION_MESSAGE);
                    }
                    for (int i = 0; i < j-1 ; i++){
        
                        if (i == 0){
                            System.out.println("\n\n" +"* * ".repeat(7) + "Employee Payroll Summary " + "* * ".repeat(7) );
                            System.out.println("Summary of Pay Period (week/month): " + birth.get(Calendar.WEEK_OF_MONTH) + "/" + ((birth.get(Calendar.MONTH))+1) + "\n");
                        }

                        System.out.print("Employee name: " + employeeDB.get(2).get(i) );
                        System.out.println("\t\tSocial Security #: " + employeeDB.get(3).get(i));
                        System.out.print("Type: " + employeeDB.get(1).get(i));
                        System.out.println("\t\t\tHourly Rate ($/hr): " + employeeDB.get(6).get(i)); 
                        System.out.print("Salary ($/week): " + employeeDB.get(7).get(i));
                        System.out.println("\t\t\tCommission: $" + employeeDB.get(8).get(i));
                        System.out.print("Bonus week (week/month): " + employeeDB.get(5).get(i) + "/" + employeeDB.get(4).get(i));
                        System.out.println("\t\tHours worked (hours): " + employeeDB.get(10).get(i));
                        System.out.print("- - - - - - - - - - - - - - - - - - - - - \n" + "Paycheck: $" + 
                                        employeeDB.get(9).get(i) + "\n- - - - - - - - - - - - - - - - - - - - -\n\n" );
                    }
                    passed = true;
                }
        
                else if (ch == 'n' || ch == 'N'){
                    if (mode.equals(m1)){
                        System.out.println("\n\n" +"* * ".repeat(7) + "THANK YOU COME AGAIN... " + "* * ".repeat(7) );
                        passed = true;
                    }
                    
                    else if (mode.equals(m2)){
                        JOptionPane.showMessageDialog(null, "THANK YOU COME AGAIN", title3, JOptionPane.INFORMATION_MESSAGE);
                        passed = true;
                    }

                }
    
                else {
                    if (mode.equals(m1)){
                        System.out.println("\n**ERROR** : Please input one of the two option (y/n)... Try Again...");
                    }
                    else if (mode.equals(m2)){
                        JOptionPane.showMessageDialog(null, "Please input one of the two option (y/n)", title2, 
                                                    JOptionPane.ERROR_MESSAGE);
                    }
                }
                k++; 
            }

            else {

                if (mode.equals(m1)){
                    System.out.print("\n\nWould you like to print out the report? (y/n): ");
                    print = userInput.nextLine();
                }

                else if (mode.equals(m2)) {
                    print = JOptionPane.showInputDialog(null, "Would you like to print out the report? (y/n)",
                         "*Weekly Payroll Program* : Summary printout", JOptionPane.QUESTION_MESSAGE);
                }

        
                ch = print.charAt(0);
        
                if (ch == 'y' || ch == 'Y'){
                    for (int i = 0; i < j-1 ; i++){
        
                        if (i == 0){
                            System.out.println("\n\n" +"* * ".repeat(7) + "Employee Payroll Summary " + "* * ".repeat(7) );
                            System.out.println("Summary of Pay Period (week/month): " + birth.get(Calendar.WEEK_OF_MONTH) + "/" + ((birth.get(Calendar.MONTH))+1) + "\n");
                        }
        
                        System.out.print("Employee name: " + employeeDB.get(2).get(i) );
                        System.out.println("\t\tSocial Security #: " + employeeDB.get(3).get(i));
                        System.out.print("Type: " + employeeDB.get(1).get(i));
                        System.out.println("\t\t\tHourly Rate ($/hr): " + employeeDB.get(6).get(i)); 
                        System.out.print("Salary ($/week): " + employeeDB.get(7).get(i));
                        System.out.println("\t\t\tCommission: $" + employeeDB.get(8).get(i));
                        System.out.print("Bonus week (week/month): " + employeeDB.get(5).get(i) + "/" + employeeDB.get(4).get(i));
                        System.out.println("\t\tHours worked (hours): " + employeeDB.get(10).get(i));
                        System.out.print("- - - - - - - - - - - - - - - - - - - - - \n" + "Paycheck: $" + 
                                        employeeDB.get(9).get(i) + "\n- - - - - - - - - - - - - - - - - - - - -\n\n" );
                    }
                    passed = true;
                }
        
                else if (ch == 'n' || ch == 'N'){
                    if (mode.equals(m1)){
                        System.out.println("\n\n" +"* * ".repeat(7) + "THANK YOU COME AGAIN... " + "* * ".repeat(7) );
                        passed = true;
                        System.exit(0);
                    }
                    
                    else if (mode.equals(m2)){
                        JOptionPane.showMessageDialog(null, "THANK YOU COME AGAIN", title3, JOptionPane.INFORMATION_MESSAGE);
                        passed = true;
                        System.exit(0);
                    }

                }
    
                else {
                    if (mode.equals(m1)){
                        System.out.println("\n**ERROR** : Please input one of the two option (y/n)... Try Again...");
                    }
                    else if (mode.equals(m2)){
                        JOptionPane.showMessageDialog(null, "Please input one of the two option (y/n)", title2, 
                                                    JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    // ****************************************************************************************************************

    public boolean tryAgain(String mode){
        String tryAgain;
        passed = false;
        char ch;

        String[] options = {"Yes" , "No"};

        while (passed == false){
            tryAgain = "";

            if (mode.equals(m1)){
                System.out.print("\n\nDo you want to add any additional employees? (y/n) : ");
                tryAgain = userInput.nextLine();
            }

            else if (mode.equals(m2)){
                tryAgain = (String) JOptionPane.showInputDialog(null, "Do you want to add any additional employees?", 
                        title, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
            }

            ch = tryAgain.charAt(0);

            if (ch == 'y' || ch == 'Y'){
                if (mode.equals(m1)){
                    System.out.print("\n\nWelcome Back...");
                    passed = true;
                    return true;
                }

                else if(mode.equals(m2)){
                    JOptionPane.showMessageDialog(null, "Welcome Back!", title, JOptionPane.INFORMATION_MESSAGE);
                    passed = true;
                    return true;
                }
            }

            else if (ch == 'n' || ch == 'N'){
                if (mode.equals(m1)){
                    System.out.print("\n\nThank you, Goodbye");
                    passed = true;
                    return false;
                }

                else if(mode.equals(m2)){
                    JOptionPane.showMessageDialog(null, "Thank you, Goodbye!", title, JOptionPane.INFORMATION_MESSAGE);
                    passed = true;
                    System.exit(0);
                    return false;
                }
            }

            else if (tryAgain.equals(null)){
                if (mode.equals(m2)){
                    JOptionPane.showMessageDialog(null, "Exiting Program", "Exiting", JOptionPane.INFORMATION_MESSAGE);
                }
                System.exit(0);
            }

        }
        return false;
    }

    // ****************************************************************************************************************

} // End Employee Class