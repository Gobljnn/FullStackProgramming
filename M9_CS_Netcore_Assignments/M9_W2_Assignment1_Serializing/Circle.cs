using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Convert;
using System.Xml.Serialization;
using System.IO;
using static System.IO.Path;
using DocumentFormat.OpenXml.Drawing.ChartDrawing;

namespace M9_W2_Assignment1_Serializing {
    public class Circle : Shape {
        public const double PI = 3.141592;

        public double Radius { get; set; } //automatically called when 'value' is set
        
        public override double Area {
            get {
                return (Radius * Radius * PI);
            }

            set {
            }
        }
    }
}
