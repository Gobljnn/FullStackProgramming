/*******************************************************************************
* Lion.cs
* Dammy 'Gobljnn' Adebayo
* Module 8_ Week 2  Assignment #2 - The Zoo (Version 1.4)
*
* This program is used to indentify and locate animals in the zoo. Each animal 
* has special characteristics unique to them.
*
* This child class receives and sets the characteristics of the Lion 
********************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using static System.Console;
using static System.Convert;

namespace M8_W2_TheZoo {
    public class Lion {

        public Animal animal;
        public string maneColor;


        public Lion(Animal ani) { 
        }

        public void setColor() {
            Write("What color is its mane? : ");
            this.maneColor = ReadLine();
        }

        public string getColor() {
            return " with a " + this.maneColor + " mane.";
        }
    }
}
