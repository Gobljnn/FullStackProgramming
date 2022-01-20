using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace M9_W2_Assignment1_Serializing {
    public class Rectangle : Shape {
        public override double Area {
            get {
                return (Height * Width);
            }

            set {
                
            }
        }

        public double Height { get; set; }
        public double Width { get; set; }

    }
}
