/*******************************************************************************
* Bear.cs
* Dammy 'Gobljnn' Adebayo
* Module 8_ Week 2  Assignment #2 - The Zoo (Version 1.4)
*
* This program is used to indentify and locate animals in the zoo. Each animal 
* has special characteristics unique to them.
*
* This child class receives and sets the characteristics of the Bear 
********************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;


namespace M8_W2_TheZoo {

    
    class Bear : Animal {
        public static char grizzlyOrNot;

        // public Animal animal;
        public int runSpeed;
        Boolean isGrizzly = false;
        Boolean validValue = false;


        // public Bear(Animal ani) {
        //     this.animal = ani;
        // }

        public void setGrizzly() {

            while (validValue == false) {
                Console.Write("Is the bear a grizzly (T for true, F for false)? : ");
                //grizzlyOrNot = Convert.ToChar(ReadLine());
                string temp = ReadLine();

                if (grizzlyOrNot.Equals('T') || grizzlyOrNot.Equals('t')) {
                    isGrizzly = setTrue();
                    validValue = setTrue();
                }

                else if (grizzlyOrNot.Equals('F') || grizzlyOrNot.Equals('f')) {
                    isGrizzly = setFalse();
                    validValue = setTrue();
                }

                else {
                    WriteLine("Please input a valid input (T or F)");
                }
            }
        }

        public String getGrizzly() {

            if (isGrizzly == false) {
                return " non-grizzly bear.";
            }

            else {
                return " grizzly bear.";
            }
        }

        // public Boolean setTrue() {
        //     return true;
        // }

        // public Boolean setFalse() {
        //     return false;
        // }
    }
}
