using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;
using System.Xml.Serialization;
using System.IO;
using static System.IO.Path;

namespace M9_W2_Assignment1_Serializing {
    
    public class ShapesStart {
        string value;
        Boolean startPassed;

        public void start() {
            startPassed = false;
            while (startPassed == false) {
                WriteLine("Press Y to start N to quit (case insensitive): ");
                value = ReadLine();

                if (value != "y" || value != "Y" || value != "n"|| value != "N") {
                    startPassed = true;
                }

                else {
                    WriteLine("Please input a valid value (Y/N - case insensitive) \n");
                }
            }
        }       
    }
}
