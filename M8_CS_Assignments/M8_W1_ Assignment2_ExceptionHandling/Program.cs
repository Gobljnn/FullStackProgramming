using System;

namespace M8_W1__Assignment2_ExceptionHandling
{
    class Program
    {
        static void Main(string[] args)
        {
            int a;
            int b;
            int c;

            Boolean exited = false;
            try{

                while (exited == false){
                    Console.Write("1) Please input your first number (0-255): ");
                    a = Convert.ToInt32(Console.ReadLine());

                    Console.Write("2) Please input your second number (0-255): ");
                    b = Convert.ToInt32(Console.ReadLine());

                    if (a <= 255 && b <= 255 && a >= 0 && b >= 1){
                        c = a / b;
                        Console.WriteLine($"{a} divided by {b} is {c}");
                        exited = true;
                    }

                    else if (b == 0){
                        Console.WriteLine("Error: The second number cannot be zero");
                    }

                    else{
                        Console.WriteLine("Error: Numbers are not in range");
                    }
                }
            }
            catch (Exception){
                Console.WriteLine("Error: Input string was not in a correct format, please only include integers.");
            }
        }
    }
}
