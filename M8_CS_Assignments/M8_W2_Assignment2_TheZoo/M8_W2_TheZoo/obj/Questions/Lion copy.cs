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


        public Lion(Animal ani) { //explain
            this.animal = ani;

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
