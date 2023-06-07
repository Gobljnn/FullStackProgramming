using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;

namespace M8_W2_TheZoo {

    
    class Bear {
        public static char grizzlyOrNot;

        public Animal animal;
        public int runSpeed;
        //char grizzlyOrNot;
        Boolean isGrizzly = false;
        Boolean validValue = false;


        public Bear(Animal ani) {
            this.animal = ani;
        }

        public void setGrizzly() {

            while (validValue == false) {
                Write("Is the bear a grizzly (T for true, F for false)? : ");
                grizzlyOrNot = Convert.ToChar(ReadLine());

                //if (grizzlyOrNot.Equals('T', StringComparison.OrdinalIgnoreCase)) {

                //}

                if (grizzlyOrNot.Equals('T') || grizzlyOrNot.Equals('t')) {
                    isGrizzly = setTrue();
                    validValue = setTrue();
                }

                else if (grizzlyOrNot.Equals('F') || grizzlyOrNot.Equals('f')) {
                    isGrizzly = setFalse();
                    validValue = setTrue();
                }

                else {
                    WriteLine("Please input a valid input (t/ f)");
                }
            }
        }

        public String getGrizzly() {

            if (isGrizzly == false) {
                return " non-grizzly bear.";
            }

            else {
                return " grizzle bear.";
            }
            return " bear";
        }

        public Boolean setTrue() {
            return true;
        }

        public Boolean setFalse() {
            return false;
        }
    }
}
