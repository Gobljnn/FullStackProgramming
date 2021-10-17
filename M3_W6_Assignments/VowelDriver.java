/*******************************************************************************
* VowelDriver.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 6  Assignment #1.1 - Vowel Counter  
*
* This program counts the number of occurrences of lowercase and uppercase 
* vowels in entered lines of text. Texts to be analyzed can be entered
* successionally. The total amount of vowels are also calculated.
* 
* This Driver file is meant to work with the Class file named VowelCounter.java
********************************************************************************/
public class VowelDriver {

    public static void main(String[] args) {
        // int vowCounter [] [];
        // String vowA, vowE, vowI, vowO, vowU;
        String userInput;
        Boolean timeToExit = false; 
       // String analyzeInput;


    //**************************************************************************** */

        VowelCounter charInput = new VowelCounter();

    //**************************************************************************** */

    while (timeToExit == false) {
        userInput = charInput.askUser();

        //charInput.setInput();
        // userInput = JOptionPane.showInputDialog(null, "Enter a line of characters to check (leave blank to analyze) : ");

        //**************************************************************************** */
        charInput.analyzeInput(userInput);

        //**************************************************************************** */
        timeToExit = charInput.timeToExit(userInput);
        // JOptionPane.showMessageDialog(null, "Main method  " + timeToExit);
    }
        

        charInput.printSummary();

    }
    
}
