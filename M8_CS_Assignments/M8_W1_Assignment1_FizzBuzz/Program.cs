using System;

namespace M8_W1_Assignment1_FizzBuzz
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] values = new string[101];
            int i = 1;


            string start = string.Empty;

            for (i = 1; i < 101; i++){

                if (i % 5 == 0 && i % 3 == 0)
                {
                    values[i] = "FizzBuzz, ";
                }

                else if (i % 3 == 0){
                    int temp = i;
                    values[i] = "Fizz, ";
                }

                else if (i % 5 == 0){

                    if (i == 100){
                        values[i] = "Buzz.";
                    }

                    else{
                        values[i] = "Buzz, ";
                    }
                }

                else{
                    values[i] = Convert.ToString(i) + ", ";
                }

            }

            foreach (string value in values){

                Console.Write(value);
            }
        }
    }
}
