/*******************************************************************************
* Program.cs
* Dammy 'Gobljnn' Adebayo
* Module 8_ Week 2  Assignment #2 - The Zoo (Driver) (Version 1.4)
*
* This program is used to indentify and locate animals in the zoo. Each animal 
* has special characteristics unique to them.
*
* This driver class runs the program.
********************************************************************************/

using System;
using static System.Console;
using static System.Convert;
using System.Collections;

namespace M8_W2_TheZoo {
    class Program {
        static void Main(string[] args) {

            string animalType;
            int animalAge;
            string[] animalTypeArr = new string[3];
            int[] animalAgeArr = new int[3];
            string[] animalCharArr = new string[3];
            int[] animalNumArr = new int[3];
            Boolean readyToPrint = false;
            int cageNum;

            Animal animal = new Animal();

            for (cageNum = 0; cageNum <= 2; cageNum++) {

                animal.setAnimalInfo();
                animalTypeArr = animal.getAnimalTypeArr();
                animalAgeArr = animal.getAnimalAgeArr();

                if (animalTypeArr[cageNum].Equals("Lion")) {
                    Lion lion = new Lion(animal);
                    lion.setColor();
                    animalCharArr[cageNum] = lion.getColor();
                }

                else if (animalTypeArr[cageNum].Equals("Wolf")) {
                    Wolf wolf = new Wolf(animal);
                    wolf.setSpeed();
                    animalCharArr[cageNum] = wolf.getSpeed();
                }

                else if (animalTypeArr[cageNum].Equals("Bear")) {
                    Bear bear = new Bear(animal) ;
                    bear.setGrizzly();
                    animalCharArr[cageNum] = bear.getGrizzly();
           
                }
                else { //if an unknown animal is inputted.
                    animalCharArr[cageNum] = " with unknown characteristics";
                }

                if (cageNum == 2) {
                    readyToPrint = true;
                }
            }

            if (readyToPrint == true) {

                WriteLine("- - - - - - -\n- - - - - - -");
                for (cageNum = 0; cageNum <= 2; cageNum++) {
                    WriteLine("Cage# " + (cageNum + 1) + " contains a " + animalAgeArr[cageNum] + "-year-old " + animalTypeArr[cageNum] + animalCharArr[cageNum]);
                }
            }
        }
    }
}
