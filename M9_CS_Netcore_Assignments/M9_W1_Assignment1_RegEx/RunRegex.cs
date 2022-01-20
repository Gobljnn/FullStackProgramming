using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;


namespace M9_W1_Assignment1_RegEx {
    class RunRegex {
        string expression;
        string regEx;
        Regex defaultRegEx = new Regex(@"^[a-z]+$");
        
        int i = 0;
        

        public void setExpression() {
            if (i == 0) {
                WriteLine("The default regular expression checks for at least one digit.");
                i++;
            }

            if (i >= 0) {
               
                Write("Enter a regular expresssion (or press ENTER to use the default (^[a-z]+$)): ");
                regEx = ReadLine();

                if (regEx.Equals("")) {
                    Write("Enter some input: ");
                    expression = ReadLine();
                    analyzeExpression(expression);
                }

                else {
                    WriteLine("The regular expression you want to use is " + regEx);
                    Write("Enter some input: ");
                    expression = ReadLine();
                    analyzeCustRegex(regEx, expression);
                }
            }    
        }

        public void analyzeCustRegex(string custRegEx, string expression) {
            string custPattern = custRegEx; 
            this.expression = expression;
            var customRegEx = new Regex(custPattern); // use var to have the type conversions work out

            if (customRegEx.IsMatch(this.expression)) {
                WriteLine(this.expression + " matches " + custPattern + " ? True");
            }

            else {
                WriteLine(this.expression + " matches " + custPattern + " ? False");
            }
        }

        public void analyzeExpression(string expression) {
            this.expression = expression;

            if (defaultRegEx.IsMatch(this.expression)) {
                WriteLine(this.expression + " matches " + "@\"^[a-z]+$\"" + " ? True");
            }

            else {
                WriteLine(this.expression + " matches " + "@\"^[a-z]+$\"" + " ? False");
            }
        }

        public string getExpression() {
            return expression;
        }

        public Boolean setTrue() {
            return true;
        }

        public Boolean setFalse() {
            return false;
        }
    }
}
