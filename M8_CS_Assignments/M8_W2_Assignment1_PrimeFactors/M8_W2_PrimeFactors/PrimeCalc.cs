/*******************************************************************************
* PrimeCalc.cs
* Dammy 'Gobljnn' Adebayo
* Module 8_ Week 2  Assignment #1 - Prime Factor Calculator  (Version 2.1)
*
* This program calculates and finds prime factors for user inputted integer
*
* This class contains all methods and variables needed to find prime factor values
* * Version 2 patch: 
* --Reworked how the calculations are performed, version 1 had some number that would
* return an error or were caught in an infinite loop
* --Quality of life changes
********************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Console;



namespace M8_W2_PrimeFactors{
    class PrimeCalc{

        int initVal; //user inputted value
        int finalVal; //final value at the end

        ArrayList factorsArr = new ArrayList(); //dynamic array that stores prime factors

        public void setValue (int initVal) {
            this.initVal = initVal;
        }

        //Will check user input to see if it has prime factors or is a prime number
        //Returns true if it has prime factors
        //Returns false if it has no prime factos and is therefore a prime number
        public Boolean possibleFactors() {

            finalVal = initVal;

            while (finalVal != 1) {

                for (int i = 2; i <= 10; i++) {

                    if (finalVal % i == 0) {
                        finalVal = finalVal / i;
                        i = 1;
                        return true;
                    }

                    else if (i == 10) { //if it has prime factors it should find atleast one of them before i = 10
                        return false;
                    }
                }
            }
            return false;
        }


        //This class is meant to actual find the prime factors and/or prime number
        //Will populate the dynamic array
        public ArrayList getFactors() {

            finalVal = initVal;

            while (finalVal != 1) {

                for (int i = 2; i <= finalVal; i++) {

                    if (finalVal % i == 0) {
                        factorsArr.Add(i);
                        finalVal = finalVal / i;
                        i = 1;
                    }

                    else if (finalVal == 1) { // once the final value reaches 1, the smallest prime factor has been reached.
                        return factorsArr;
                    }
                }
            }
            return factorsArr;
        }
    }
}
