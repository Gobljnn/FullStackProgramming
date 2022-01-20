using System;
using System.Collections.Generic;
using M9_W3_Assignment2_NorthWindPt2.data;
using Microsoft.Data.SqlClient;
using static System.Console;


namespace M9_W3_Assignment2_NorthWindPt2 {
    class Program { 
        static void Main(string[] args) {
            int i = 0;
            int count;
            string cityCount;
            int counter=0;
            int j = 0;
            string city;
            List<Customer> customers = new List<Customer>();

            string connectionString = "data source=localhost\\SQLEXPRESS;initial catalog = Northwind; persist security info = True;Integrated Security = SSPI;"; //integrated security for windows authentication in MS SQL server
            
            
            using (SqlConnection con = new SqlConnection(connectionString)) {
                
                con.Open();

                using (SqlCommand commQuery = con.CreateCommand())
                using (SqlCommand command = new SqlCommand("SELECT DISTINCT City from Customers", con)) {
                    using (SqlCommand counterReader = new SqlCommand("SELECT Count (DISTINCT City) from Customers", con)) {
                        using (SqlDataReader reader = counterReader.ExecuteReader()) {
                            if (reader.Read()) {
                                cityCount = reader[0].ToString();
                                counter = Int32.Parse(cityCount);                                
                            }
                        }
                    }
                        i = 0;
                    using (SqlDataReader reader = command.ExecuteReader()) {
                        

                        while(i < counter) {
                            while (reader.Read()) {

                                if (i >= 0 && i < (counter-1)) {
                                    Write(reader.GetString(0));
                                    Write(", ");
                                }

                                else if (i == (counter-1)) {
                                    Write(reader.GetString(0));
                                }

                                i++;
                            }
                        }
                    }
                  
                    ChooseCity chosenCity = new ChooseCity();

                    city = chosenCity.userCity();
                }

                using (SqlCommand command = new SqlCommand("Select CompanyName from Customers where city = @city", con)) {
                    command.Parameters.AddWithValue("@city", city);

                    using (SqlDataReader reader = command.ExecuteReader()) {
                        j = 0;
                        while (reader.Read()) {
                            j++;
                            count = j;
                        }

                        WriteLine("\nThere are " + j + " customers in " + city + ": ");
                    }


                    using (SqlDataReader reader = command.ExecuteReader()) {
                        i = 0;

                        while (reader.Read()) {

                            //Write(reader.GetString(0));
                            if (i == 0) {
                                Write(reader.GetString(0));
                                Write(", ");
                                i++;

                            }

                            else if (i > 0) {
                                Write(reader.GetString(0));
                                if (!reader.Read()) {
                                }

                                else {
                                    Write(", ");
                                    i++;
                                }

                            } 
                        }
                    }

                    Write("\n\n");

                }
            }
        }
    }
}
