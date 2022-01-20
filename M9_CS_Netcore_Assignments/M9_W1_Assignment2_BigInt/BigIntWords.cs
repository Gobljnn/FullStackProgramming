using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;
using System.Numerics;

namespace M9_W1_Assignment2_BigInt {
    class BigIntWords {
        BigInteger number;
        string convNumber;
        string words = "";
        int length;
        int temp;
        string[] wordsArr = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten " };
        string[] decUnitsArr = {"Ten ", "Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninty " };
        string[] hexUnitArr = { "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen " };
        
        public void units(BigInteger number, string convNumber) {
            this.number = number;
            this.convNumber = convNumber;
            words = "";


            if (number < 0) { //negative function will be implemented later
                words += "Negative ";
            }

            if (number == 0) {
                words = "Zero";
            }

            if (number > 0 && number <= 10) {
                words += wordsArr[(int)(number - 1)];
            }

            else if (number >= 11 && number <= 19) {
                words += hexUnitArr[(int)(number - 1)];

            }

            else if (number >= 20 && convNumber.Length == 2) {
                length = convNumber.Length;
                temp = (int)(number / 10);
                words += decUnitsArr[temp - 1];
            }

            else if (convNumber.Length == 3) {
                int i = 1;
                length = convNumber.Length;
                temp = (int) (number / 100);
               
                if (number % 100 ==0) {
                    words += wordsArr[temp - 1] + "hundred ";
                }

                else {
                    words += wordsArr[temp - 1] + "hundred ";
                    decUnits(number, convNumber, length);
                }
            }

            else if (convNumber.Length == 4) {
                int i = 1;
                length = convNumber.Length;
                temp = (int)(number / 1000);

                if (number % 1_000 == 0) {
                    words += wordsArr[temp - 1] + "thousand ";
                }

                else {
                    words += wordsArr[temp - 1] + "thousand ";
                    hunUnits(number, convNumber, length);
                }
            }

            else if (convNumber.Length == 5) {
                length = convNumber.Length;
                temp = (int)(number / 10000);

                if (number % 10_000 == 0) {
                    words += decUnitsArr[temp - 1] + "thousand ";
                }

                else {

                    if (number >= 20_000) {
                        words += decUnitsArr[temp - 1];
                        temp = ToInt16(char.ToString(convNumber[1]));
                        if (temp == 0) {
                            words += "thousand ";
                            tetUnits(number, convNumber, length);
                        }

                        else {
                            words += wordsArr[temp - 1] + "thousand ";
                            tetUnits(number, convNumber, length);
                        }
                    }

                    else {
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += decUnitsArr[temp] + "thousand ";
                            tetUnits(number, convNumber, length);
                        }

                        else {
                            words += hexUnitArr[temp - 1] + "thousand ";
                            tetUnits(number, convNumber, length);
                            words += "hundred ";
                        }
                    }
                }
            }

            else if (convNumber.Length == 6) {
                length = convNumber.Length;
                temp = (int)(number / 100_000);

                if (number % 100_000 == 0) {
                    words += wordsArr[temp - 1] + "hundred thousand ";
                }

                else {
                    words += wordsArr[temp - 1] + "hundred and ";
                    decUnits(number, convNumber, length);
                    words += "thousand ";
                }
            }

            else if (convNumber.Length == 7) {
                length = convNumber.Length;
                temp = (int)(number / 1_000_000);

                if (number % 1_000_000 == 0) {
                    words += wordsArr[temp - 1] + "million ";
                }

                else {
                    words += wordsArr[temp - 1] + "million ";
                    hunUnits(number, convNumber, length);
                    words += "thousand ";
                }
            }

            else if (convNumber.Length == 8) {
                length = convNumber.Length;
                temp = (int)(number / 10_000_000);

                if (number % 10_000_000 == 0) {
                    words += decUnitsArr[temp - 1] + "million ";
                }

                else {

                    if (number >= 20_000_000) {
                        words += decUnitsArr[temp - 1];
                        temp = ToInt16(char.ToString(convNumber[1]));
                        if (temp == 0) {
                            words += "million ";
                            tetUnits(number, convNumber, length);
                            words += "thousand ";
                        }

                        else {
                            words += wordsArr[temp - 1] + "million ";
                            tetUnits(number, convNumber, length);
                            words += "thousand ";
                        }     
                    }

                    else {
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += decUnitsArr[temp] + "million ";
                            tetUnits(number, convNumber, length);
                        }

                        else {
                            words += hexUnitArr[temp - 1] + "million ";
                            tetUnits(number, convNumber, length);
                            words += "thousand ";
                        }
                    }
                }
            }

            else if (convNumber.Length == 9) {
                length = convNumber.Length;
                temp = (int)(number / 100_000_000);

                if (number % 100_000_000 == 0) {
                    words += wordsArr[temp - 1] + "hundred million ";
                }

                else {
                    words += wordsArr[temp - 1] + "hundred and ";
                    decUnits(number, convNumber, length);
                    words += "million ";
                }
            }

            else if (convNumber.Length == 10) {
                length = convNumber.Length;
                temp = (int)(number / 1_000_000_000);

                if (number % 1_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "billion ";
                }

                else {
                    words += wordsArr[temp - 1] + "billion ";
                    hunUnits(number, convNumber, length);
                    words += "million ";
                }
            }

            else if (convNumber.Length == 11) {
                length = convNumber.Length;
                temp = (int)(number / 10_000_000_000);

                if (number % 10_000_000_000 == 0) {
                    words += decUnitsArr[temp - 1] + "billion ";
                }

                else {

                    if (number >= 20_000_000_000) {
                        words += decUnitsArr[temp - 1];
                        temp = ToInt16(char.ToString(convNumber[1]));
                        if (temp == 0) {
                            words += "billion ";
                            tetUnits(number, convNumber, length);
                            words += "million ";
                        }

                        else {
                            words += wordsArr[temp - 1] + "billion ";
                            tetUnits(number, convNumber, length);
                            words += "million ";
                        }
                    }

                    else {
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += decUnitsArr[temp] + "billion ";
                            tetUnits(number, convNumber, length);
                            words += "million ";
                        }

                        else {
                            words += hexUnitArr[temp - 1] + "billion ";
                            tetUnits(number, convNumber, length);
                            words += "million ";
                        }
                    }
                }
            }

            else if (convNumber.Length == 12) {
                length = convNumber.Length;
                temp = (int)(number / 100_000_000_000);

                if (number % 100_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "hundred billion ";
                }

                else {
                    words += wordsArr[temp - 1] + "hundred and ";
                    decUnits(number, convNumber, length);
                    words += "billion ";
                }
            }

            else if (convNumber.Length == 13) {
                length = convNumber.Length;
                temp = (int)(number / 1_000_000_000_000);

                if (number % 1_000_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "trillion ";
                }

                else {
                    words += wordsArr[temp - 1] + "trillion ";
                    hunUnits(number, convNumber, length);
                    words += "billion ";
                }
            }

            else if (convNumber.Length == 14) {
                length = convNumber.Length;
                temp = (int)(number / 10_000_000_000_000);

                if (number % 10_000_000_000_000 == 0) {
                    words += decUnitsArr[temp - 1] + "trillion ";
                }

                else {
                    if (number >= 20_000_000_000_000) {
                        words += decUnitsArr[temp - 1];
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += "trillion ";
                            tetUnits(number, convNumber, length);                            
                        }

                        else {
                            words += wordsArr[temp - 1] + "trillion ";
                            tetUnits(number, convNumber, length);
                            if (ToInt16(char.ToString(convNumber[2])) != 0 && ToInt16(char.ToString(convNumber[3])) != 0
                                && ToInt16(char.ToString(convNumber[4])) != 0) {
                                words += "billion ";
                            }
                        }
                    }

                    else {
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += decUnitsArr[temp] + "trillion ";
                            tetUnits(number, convNumber, length);
                            words += "billion ";
                        }

                        else {
                            words += hexUnitArr[temp - 1] + "trillion ";
                            tetUnits(number, convNumber, length);
                            words += "billion ";
                        }
                    }
                }
            }

            else if (convNumber.Length == 15) {
                length = convNumber.Length;
                temp = (int)(number / 100_000_000_000_000);

                if (number % 100_000_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "hundred trillion ";
                }

                else {
                    words += wordsArr[temp - 1] + "hundred and ";
                    decUnits(number, convNumber, length);
                    words += "trillion ";
                }
            }

            else if (convNumber.Length == 16) {
                length = convNumber.Length;
                temp = (int)(number / 1_000_000_000_000_000);

                if (number % 1_000_000_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "quadrillion ";
                }

                else {
                    words += wordsArr[temp - 1] + "quadrillion ";
                    hunUnits(number, convNumber, length);
                    words += "trillion ";
                }
            }

            else if (convNumber.Length == 17) {
                length = convNumber.Length;
                temp = (int)(number / 10_000_000_000_000_000);

                if (number % 10_000_000_000_000_000 == 0) {
                    words += decUnitsArr[temp - 1] + "quadrillion ";
                }

                else {
                    if (number >= 20_000_000_000_000_000) {
                        words += decUnitsArr[temp - 1];
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += "quadrillion ";
                            tetUnits(number, convNumber, length);
                            words += "trillion ";
                        }

                        else {
                            words += wordsArr[temp - 1] + "quadrillion ";
                            tetUnits(number, convNumber, length);
                            words += "trillion ";
                        }
                    }

                    else {
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += decUnitsArr[temp] + "quadrillion ";
                            tetUnits(number, convNumber, length);
                            words += "trillion ";
                        }

                        else {
                            words += hexUnitArr[temp - 1] + "quadrillion ";
                            tetUnits(number, convNumber, length);
                            words += "trillion ";
                        }
                    }
                }
            }

            else if (convNumber.Length == 18) {
                length = convNumber.Length;
                temp = (int)(number / 100_000_000_000_000_0000);

                if (number % 100_000_000_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "hundred quadrillion ";
                }

                else {
                    words += wordsArr[temp - 1] + "hundred and ";
                    decUnits(number, convNumber, length);
                    words += "quadrillion ";
                }
            }

            else if (convNumber.Length == 19) {
                length = convNumber.Length;
                temp = (int)(number / 1_000_000_000_000_000_000);

                if (number % 1_000_000_000_000_000_000 == 0) {
                    words += wordsArr[temp - 1] + "quintillion ";
                }

                else {
                    words += wordsArr[temp - 1] + "quintillion ";
                    hunUnits(number, convNumber, length);
                    words += "quadrillion ";
                }
            }

            else if (convNumber.Length == 20) {
                length = convNumber.Length;
                temp = (int)(number / 10_000_000_000_000_000_000);

                if (number % 10_000_000_000_000_000_000 == 0) {
                    words += decUnitsArr[temp - 1] + "quintillion ";
                }

                else {
                    if (number >= 18_400_000_000_000_000_000) {
                        words += decUnitsArr[temp - 1];
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += "quintillion ";
                            tetUnits(number, convNumber, length);
                            words += "quadrilion ";
                        }

                        else {
                            words += wordsArr[temp - 1] + "quintillion ";
                            tetUnits(number, convNumber, length);
                            words += "quadrillion ";
                        }
                    }

                    else {
                        temp = ToInt16(char.ToString(convNumber[1]));

                        if (temp == 0) {
                            words += decUnitsArr[temp] + "quintillion ";
                            tetUnits(number, convNumber, length);
                            words += "quadrillion ";
                        }

                        else {
                            words += hexUnitArr[temp - 1] + "quintillion ";
                            tetUnits(number, convNumber, length);
                            words += "quadrillion ";
                        }
                    }
                }
            }
            WriteLine($"{number} converted to words is {words}");
        }

    /*****************************************************************************************************************/

        public void decUnits(BigInteger number, string convNumber, int length) { //2 iterations
            int i = 1;
            int temp;
            for (i = 1; i <= 2; i++) {
                temp = ToInt16(char.ToString(convNumber[i]));
                if (ToInt16(char.ToString(convNumber[1])) != 0 && i == 1) { 
                    words += decUnitsArr[(temp - 1)];
                }

                else if (ToInt16(char.ToString(convNumber[2])) != 0 && i == 2) {
                    words += wordsArr[(temp - 1)];
                }
            }
        }

    /*****************************************************************************************************************/

        public void hunUnits(BigInteger number, string convNumber, int length) { //3 iterations 
            int i = 1;
            int temp;

            for (i = 1; i <= 3; i++) {
                temp = ToInt16(char.ToString(convNumber[i]));

                if (ToInt16(char.ToString(convNumber[1])) != 0 && i == 1) {
                    words += wordsArr[(temp - 1)] + "hundred ";

                    if (ToInt16(char.ToString(convNumber[3])) != 0 && ToInt16(char.ToString(convNumber[3])) != 0) {
                        words += "and ";
                    }
                }

                else if (ToInt16(char.ToString(convNumber[1])) == 0 && i == 1 && length == 4) {
                    words += "and ";
                }

                else if (ToInt16(char.ToString(convNumber[i])) != 0 && i == 2) {
                    words += decUnitsArr[(temp - 1)];
                }

                else if (ToInt16(char.ToString(convNumber[3])) != 0 && i == 3) {
                    words += wordsArr[(temp - 1)];
                }
            }
        }

    /*****************************************************************************************************************/


        public void tetUnits(BigInteger number, string convNumber, int length) { // 4 iterations
            int i = 2;
            int temp;

            for (i = 2; i <= 4; i++) { //
                temp = ToInt16(char.ToString(convNumber[i]));

                if (ToInt16(char.ToString(convNumber[i])) != 0 && i == 2) {
                
                    words += wordsArr[temp - 1] + "hundred ";
                    if (ToInt16(char.ToString(convNumber[i + 1])) != 0) {
                        words += "and ";
                    }
                }

                else if (ToInt16(char.ToString(convNumber[3])) == 1 && i == 3) {
                    temp = ToInt16(char.ToString(convNumber[4]));
                    words += hexUnitArr[temp - 1];
                    i = 4;
                }

                else if (ToInt16(char.ToString(convNumber[i])) != 0 && i == 3) {

                   if (ToInt16(char.ToString(convNumber[3])) == 1) {
                        temp = ToInt16(char.ToString(convNumber[4]));
                        words += hexUnitArr[temp - 1];
                        i = 4;
                   }
                    

                    if (ToInt16(char.ToString(convNumber[i+1])) != 0) {
                        words += decUnitsArr[temp - 1];
                    }

                    else {
                        words += decUnitsArr[temp - 1];
                    }
                }

                else if (ToInt16(char.ToString(convNumber[i])) != 0 && i == 4) {
                    words += wordsArr[temp - 1];
                }
            }
        }
    }
}
