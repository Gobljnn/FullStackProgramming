using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;

namespace M9_W1_Assignment1_RegEx {
    class StartRegex {

        int i;
        Boolean passed = false;

        public int startProg() {

            while (passed == setFalse()) {
                passed = setFalse();
                try {
                    Write("Press 1 to start OR 0 to exit: ");
                    i = ToInt32(ReadLine());

                    if (i == 1 || i == 0) {
                        passed = setTrue();
                        return i;
                    }

                    else {
                        WriteLine("ERROR: Please enter either 1 or 0");
                        passed = setFalse();
                    }
                }
                catch (Exception) {
                    WriteLine("ERROR: Please enter either 1 or 0");
                }
            }
            return i;
        }

        public Boolean setTrue() {
            return true;
        }

        public Boolean setFalse() {
            return false;
        }
    }
}
