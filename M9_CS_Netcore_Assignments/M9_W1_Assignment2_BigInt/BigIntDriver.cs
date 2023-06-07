using System;
using static System.Console;
using System.Numerics;

namespace M9_W1_Assignment2_BigInt {
    class BigIntDriver {
        static void Main(string[] args) {

            BigIntStart startProg = new BigIntStart();
            BigIntWords wordsProg = new BigIntWords();
            UserExit userExit = new UserExit();

            BigInteger number;
            string convNumber;
            string words;
            Boolean userDone = false;

            while (userDone == false) {
                userDone = false;
                number = 0;
                convNumber = "";
                words = "";
                startProg.start();
                number = startProg.getNumber();
                convNumber = startProg.getConvNumber();
                startProg.setBigInt();

                wordsProg.units(number, convNumber);
                userDone = userExit.isUserDone();
            }


        }
    }
}
