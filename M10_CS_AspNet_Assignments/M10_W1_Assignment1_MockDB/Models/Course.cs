using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations; //[key]
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Models {
    public class Course {

        [Key] 
        public int courseID { get; set; }
        public string courseName { get; set; }
        public string courseDesc { get; set; }
    }
}
