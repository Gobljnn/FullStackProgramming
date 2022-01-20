using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
using static System.Console;
using static System.Convert;

namespace M9_W1_Assignment2_BigInt {
    class BigIntStart {

        long number;
        string convNumber;
        string temp;
        Boolean passed = false;
        BigInteger bigNum = new BigInteger();

        public void start() {
            passed = setFalse();

            while (passed == setFalse()) {
                
                number = 0;
                convNumber = "";
                bigNum = 0;

                try {
                    Write("Please supply a positive integer: ");
                    convNumber = ReadLine();
                    bigNum = BigInteger.Parse(convNumber);

                    if (bigNum >= 0) {
                        passed = setTrue();
                    }

                    else {
                        passed = setFalse();
                        WriteLine("ERROR: Number cannot be negative at this time, will be implemented soon.");
                    }
                    
                }
                catch (Exception) {
                    WriteLine("ERROR: Number in wrong format");
                }
            }
        }

        public BigInteger getNumber() {
            return bigNum;
        }

        public string getConvNumber() {
            return convNumber;
        }

        public void setBigInt() {
            bigNum =BigInteger.Parse(convNumber);
        }

        public Boolean setTrue() {
            return true;
        }

        public Boolean setFalse() {
            return false;
        }
        
    }
}
