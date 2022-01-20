/*******************************************************************************
* Program.cs
* Dammy 'Gobljnn' Adebayo
* Module 8_ Week 2  Assignment #1 - Prime Factor Calculator (driver) (Version 2.1)
*
* This program calculates and finds prime factors for user inputted integer
*
* This driver class receives user input and displays prime factor or determines
* if user input is a prime number
* 
* Version 2 patch: 
* --Quality of life changes
* 
********************************************************************************/

using System;
using static System.Console;
using static System.Convert;
using System.Collections;

namespace M8_W2_PrimeFactors{

    class Program{

        static void Main(string[] args){

            int initVal; //user input
            Boolean factorsCalculated = false; //boolean that changes if a prime factor has been obtained
            Boolean possibleFactors = true; //boolean that changes if user input will have prime factors or if it is a prime number

            ArrayList factorsArr = new ArrayList(); //dynamic array that stores prime factos

            PrimeCalc newPrime = new PrimeCalc ();

            while (factorsCalculated == false) {
                try {

                    Write("Please provide a positive integer greater than 2: "); 
                    initVal = ToInt32(ReadLine());
                    newPrime.setValue(initVal);

                    if (initVal >= 1) {
                        possibleFactors = newPrime.possibleFactors(); //first stage to determine if input will have prime factors or not

                        if (possibleFactors == false) {
                            Write(initVal + " does not have any prime factors but is a prime number\n"
                                    + "Therefore its factors are: "  + initVal + " X " + "1") ;

                            factorsCalculated = true;
                        }
                    }


                    if (initVal >= 1 && possibleFactors ==true ) { 
                        factorsArr = newPrime.getFactors();

                        Write("Prime factors for " + initVal + " are: ");

                        foreach (var fact in factorsArr) {
                            Write(fact + " X ");
                        }

                        Write("1");
                        factorsCalculated = true;
                    }

                    else {
                        WriteLine("Please input a positive integer greater than 1");
                    }
                }
                catch (Exception) {

                    WriteLine("ERROR: Please input an integer");
                }
            }
        }
    }
}
