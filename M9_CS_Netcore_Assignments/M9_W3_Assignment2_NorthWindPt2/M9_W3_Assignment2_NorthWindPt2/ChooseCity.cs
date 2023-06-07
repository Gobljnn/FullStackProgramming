using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace M9_W3_Assignment2_NorthWindPt2 {
    class ChooseCity {
        Boolean passed = false;
        string city;

        public string userCity() {
            while (passed == false) {
                passed = false;
                Write("\n\nChoose a city from the list to search for: ");
                city = ReadLine();
                
                if (city != "" || city != " ") {
                    passed = true;
                    return city;
                }
                else {
                    WriteLine("Please input a value..."); 
                }

            }
            return city;
        }

    }
}
