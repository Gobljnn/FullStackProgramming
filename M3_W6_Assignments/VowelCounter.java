import javax.swing.JOptionPane;

public class VowelCounter {

    private int vowCounter [] [] = new int [5][3]; //rows column
    private int vowNumA = 0, vowNumE = 0, vowNumI = 0, vowNumO = 0, vowNumU = 0 ;
    private int vowLNumA = 0, vowLNumE = 0, vowLNumI = 0, vowLNumO = 0, vowLNumU = 0;
    private int vowUNumA = 0, vowUNumE = 0, vowUNumI = 0, vowUNumO = 0, vowUNumU = 0;
    private String userInput;
    private char ch;
    private Boolean stringEmpty = false;

    //**************************************************************************** */
  

    public String askUser(){

        userInput = JOptionPane.showInputDialog(null, "Enter a line of characters to check (leave blank to analyze) : ");
        return userInput;

    } // end askUser

    //**************************************************************************** */

    public int [] [] analyzeInput(String userInput){
        
        for (int i = 0; i < (userInput.length()) ; i++ ){
            ch = userInput.charAt(i);

            if (ch == 'a') {
                vowLNumA++;
            }
            else if (ch == 'A'){
                vowUNumA++;
            }


            else if (ch == 'e') {
                vowLNumE++;
            }
            else if (ch == 'E'){
                vowUNumE++;
            }


            else if (ch == 'i') {
                vowLNumI++;
            }
            else if (ch == 'I'){
                vowUNumI++;
            }


            else if (ch == 'o') {
                vowLNumO++;
            }
            else if (ch == 'O'){
                vowUNumO++;
            }


            else if (ch == 'u') {
                vowLNumU++; 
            }
            else if (ch == 'U'){
                vowUNumU++;
            }

        }

        vowCounter[0][0] = vowLNumA;
        vowCounter[0][1] = vowUNumA;
        vowCounter[0][2] = vowLNumA + vowUNumA;

        vowCounter[1][0] = vowLNumE;
        vowCounter[1][1] = vowUNumE;
        vowCounter[1][2] = vowLNumE + vowUNumE;

        vowCounter[2][0] = vowLNumI;
        vowCounter[2][1] = vowUNumI;
        vowCounter[2][2] = vowLNumI + vowUNumI;

        vowCounter[3][0] = vowLNumO;
        vowCounter[3][1] = vowUNumO;
        vowCounter[3][2] = vowLNumO + vowUNumO;

        vowCounter[4][0] = vowLNumU;
        vowCounter[4][1] = vowUNumU;
        vowCounter[4][2] = vowLNumU + vowUNumU;

        vowNumA = vowLNumA + vowUNumA;
        vowNumE = vowLNumE + vowUNumE;
        vowNumI = vowLNumI + vowUNumI;
        vowNumO = vowLNumO + vowUNumO;
        vowNumU = vowLNumU + vowUNumU;

        return vowCounter;

    } // end analyzeinput

    //**************************************************************************** */

    public Boolean timeToExit(String userInput){
        if (userInput.isEmpty()){
            stringEmpty = true;
        }

        return stringEmpty;
    } //end timeToExit

    public void printSummary() {

        JOptionPane.showMessageDialog(null, "Your summary of vowels are as follows: \n \n" +
                    "A: " + vowLNumA + " lowercase, " + vowUNumA + " uppercase, " + vowNumA + " total \n" + 
                    "E: " + vowLNumE + " lowercase, " + vowUNumE + " uppercase, " + vowNumE + " total \n" + 
                    "I: " + vowLNumI + " lowercase, " + vowUNumI + " uppercase, " + vowNumI + " total \n" + 
                    "O: " + vowLNumO + " lowercase, " + vowUNumO + " uppercase, " + vowNumO + " total \n" + 
                    "U: " + vowLNumU + " lowercase, " + vowUNumU + " uppercase, " + vowNumU + " total \n" );
        
    } //end printSummary

    
} // end vowelCounter class
