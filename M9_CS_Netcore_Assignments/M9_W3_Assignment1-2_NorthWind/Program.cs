using System;
using System.Collections.Generic;
using System.Linq;
using M9_W3_Assignment1_2_NorthWind.data;
using static System.Console;
using static System.IO.Path;
using static System.Environment;
using System.IO;
using System.Xml.Serialization;


namespace M9_W3_Assignment1_2_NorthWind {
    class Program {
        static void Main(string[] args) {
            List<Category> categories = new List<Category>(); //The list is every db table  -- Category is table name
            List<Product> products = new List<Product>();
            var txtList = categories.ConvertAll(x => x.ToString());
            string line = "";


            var ctx = new NorthwindContext();

            //create list to write to
            string xmlPath = Combine(CurrentDirectory, "Cat_Prod_List.xml"); //System.Environment
            string jsonPath = Combine(CurrentDirectory, "Cat_Prod_List.json");
            string txtPath = Combine(CurrentDirectory, "Cat_Prod_List.txt");


            if (File.Exists(xmlPath)) {
                File.Delete(xmlPath);
            }
            if (File.Exists(jsonPath)) {
                File.Delete(jsonPath);
            }
            if (File.Exists(txtPath)) {
                File.Delete(txtPath);
            }

            //format to xml
            var xs = new XmlSerializer(typeof(List<Category>));
            var xt = new XmlSerializer(typeof(List<Product>));
            //var js = JsonConvert.SerializeObject(categories);
            //var jt = JsonConvert.SerializeObject(products);
            

            categories = ctx.Categories.ToList();
            products = ctx.Products.ToList();

            //Serialize XML
            using (FileStream stream = File.Create(xmlPath)) {
                xs.Serialize(stream, categories);
                xt.Serialize(stream, products);
            }

            //Searilize JSON
            string jsonCat = System.Text.Json.JsonSerializer.Serialize(categories);
            string jsonProd = System.Text.Json.JsonSerializer.Serialize(products);
            File.WriteAllText(jsonPath, jsonCat);
            File.WriteAllText(jsonPath, jsonProd);

            //Add text to TXT
            using (StreamWriter tw = new StreamWriter(txtPath)) {

                foreach (var item in categories) {
                    tw.WriteLine("Category => " + item.CategoryId);
                    tw.Write("Category Name => "+item.CategoryName + "\n");
                    tw.Write("Category Description: "+item.Description + "\n\n");
                }
            }

            //OUTPUT
            WriteLine("*************** OUTPUT ******************\n\n");

            Console.WriteLine(File.ReadAllText(xmlPath));

            WriteLine("\n\n*************** XML ******************\n");
            WriteLine("This XML file used: " + new FileInfo(xmlPath).Length + " bytes\n");
            long xmlSize = new FileInfo(xmlPath).Length;

            WriteLine("*************** OUTPUT ******************\n\n");

            WriteLine(jsonCat + "\n\n");
            WriteLine(jsonProd);

            WriteLine("\n\n*************** JSON ******************\n");
            WriteLine("This JSON file used: " + new FileInfo(jsonPath).Length + " bytes\n");
            long jsonSize = new FileInfo(jsonPath).Length;


            WriteLine("*************** OUTPUT ******************\n\n");

            using (StreamReader sr = new StreamReader(txtPath)) {
                while((line = sr.ReadLine()) != null) {
                    WriteLine(line);
                }
            }
            WriteLine("\n\n*************** TXT ******************\n");
            WriteLine("This TXT file used: " + new FileInfo(txtPath).Length + " bytes\n");
            long txtSize = new FileInfo(txtPath).Length;

            WriteLine("*************** RANKING ******************\n\n");

            var raw = new List<long> {xmlSize, jsonSize, txtSize};
            raw.Sort();
            WriteLine(string.Join(", ", raw));
        }
    }
}

