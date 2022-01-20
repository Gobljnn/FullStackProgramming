using System;
using static System.Console;
using static System.Convert;

namespace M9_W1_Assignment1_RegEx {
    class M911_RegExProgram {
        static void Main(string[] args) {

            int i;
            Boolean userDone = false;

            StartRegex start = new StartRegex();
            RunRegex runRegex = new RunRegex();
            UserExit userExit = new UserExit();
            i = start.startProg();

            while (userDone == false) {
                if (i == 1) {
                    runRegex.setExpression();
                    userDone = userExit.isUserDone();
                }

                else {
                    WriteLine("Thank you come again!");
                    userDone = true;
                }
            }
        }
    }
}
