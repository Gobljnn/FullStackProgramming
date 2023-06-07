/*******************************************************************************
* Wolf.cs
* Dammy 'Gobljnn' Adebayo
* Module 8_ Week 2  Assignment #2 - The Zoo (Version 1.4)
*
* This program is used to indentify and locate animals in the zoo. Each animal 
* has special characteristics unique to them.
*
* This child class receives and sets the characteristics of the Wolf 
********************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;

namespace M8_W2_TheZoo {
    class Wolf {

        public Animal animal;
        public int runSpeed;
        Boolean validNum = false;

        public Wolf(Animal ani) {
            this.animal = ani;
        }

        public void setSpeed() {

            while (validNum == false) {
                validNum = false;
                try {
                    Write("How fast can it run in (km/hr)? : ");
                    this.runSpeed = ToInt32(ReadLine());

                    if (runSpeed > 0) {
                        validNum = true;
                    }

                    else {
                        WriteLine("Please input a number greater than 0");
                    }

                }
                catch (Exception) {
                    WriteLine("ERROR: Please input a number");
                }
            }
        }

        public string getSpeed() {
            return " that runs " + this.runSpeed + " km/hr.";
        }
    }
}
