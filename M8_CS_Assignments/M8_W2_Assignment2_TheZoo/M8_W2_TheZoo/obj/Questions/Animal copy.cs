using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;
using System.Collections;

namespace M8_W2_TheZoo {

    public class Animal {
        public string animalType { get; set; }
        public int animalAge { get; set; }
        int cageNum;

        string[] animalTypeArr = new string[3];
        int[] animalAgeArr = new int[3];
        string[] animalCharArr = new string[3];
        int[] animalNumArr = new int[3];
        Boolean infoSet = false;
        Boolean ageVer = false;

        public void setAnimalInfo() {
            infoSet = setFalse();
            ageVer = setFalse();

            while (infoSet == false) {

                Console.Write("Cage# " + (cageNum + 1) + ": " + "Please input an animal (Lion, Bear, Wolf): ");
                this.animalType = ReadLine();
                animalTypeArr[cageNum] = animalType;

                while (ageVer == false) {
                    try {
                        Write("How old is it? : ");
                        this.animalAge = ToInt32(ReadLine());
                        animalAgeArr[cageNum] = this.animalAge;
                        ageVer = setTrue();
                    }

                    catch (Exception) {
                        WriteLine("ERROR: Please input an integer");
                    }
                }
                cageNum++;
                infoSet = setTrue();
            }

            //for (cageNum = 0; cageNum < (cageNum-1); cageNum++) {

            //    //this.cageNum = (cageNum+1);
            //}
        }

        public string[] getAnimalTypeArr() {
            return this.animalTypeArr;
        }

        public int[] getAnimalAgeArr() {
            return this.animalAgeArr;
        }

        public int[] getAnimalNum() {
            return animalNumArr;
        }

        public Boolean setTrue() {
            return true;
        }

        public Boolean setFalse() {
            return false;
        }
      
    }
}
