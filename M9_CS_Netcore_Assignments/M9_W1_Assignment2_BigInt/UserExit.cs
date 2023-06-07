using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;

namespace M9_W1_Assignment2_BigInt {
    class UserExit {
        Boolean userDone = false;

        public Boolean isUserDone() {
            userDone = false;

            WriteLine("Press ESC TWICE to end or any key ONCE and then ENTER to try again");
            ConsoleKeyInfo key = ReadKey();

            if (ReadKey().Key == ConsoleKey.Escape) {
                WriteLine("TThank you ... come again"); 
                return true;
            }

            else {
                WriteLine("Welcome back...!");
                return false;
            }
        }


    }
}
