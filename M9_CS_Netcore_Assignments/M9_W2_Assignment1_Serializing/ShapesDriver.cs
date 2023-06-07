using System;
using static System.Console;
using static System.Convert;
using System.Collections.Generic;
using System.Xml.Serialization;
using System.IO;
using static System.IO.Path;
using static System.Environment;

namespace M9_W2_Assignment1_Serializing {
    class ShapesDriver {
        static void Main(string[] args) {
            

            List<Shape> shapelist = new List<Shape>();
            shapelist.AddRange(new Shape[] {
                new Circle { Colour = "Red", Radius = 2.5},
                new Rectangle {Colour = "Blue", Height = 20.0, Width = 10.0},
                new Circle { Colour = "Green", Radius = 8},
                new Circle { Colour = "Purple", Radius = 12.3},
                new Rectangle {Colour = "Blue", Height = 45.0, Width = 18.0}

            });

            //Create file to write to
            string path = Combine(CurrentDirectory, "Shapes_List.xml");

            TextWriter myStreamWrite = new StreamWriter(path);
            Type[] extraTypes = new Type[3];
            extraTypes[0] = typeof(List<Shape>);
            extraTypes[1] = typeof(Circle);
            extraTypes[2] = typeof(Rectangle);
            myStreamWrite.Close();

            //format shape list into XML
            var xs = new XmlSerializer(typeof(List<Shape>), extraTypes);

            

            //seralize the info from List of Shapes <List> object to file
            using (FileStream stream = File.Create(path)) {
                xs.Serialize(stream, shapelist);
                stream.Close();
            }

            //Console.WriteLine(File.ReadAllText(path));


            using (FileStream xmlLoad = File.Open(path, FileMode.Open)) {
                List<Shape> loadedShapesXml = (List<Shape>)xs.Deserialize(xmlLoad);

                WriteLine("Loading shapes from XML... ");

                foreach (Shape item in loadedShapesXml) {
                    int i = 0;
                    WriteLine($"{item.GetType().Name} is {item.Colour} and has an area of : {item.Area} units");
                }

            }

        }
    }
}
