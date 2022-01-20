using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.ModelsDto {
    public class CourseDto {
        [DisplayName("Course ID")]
        public int courseID { get; set; }
        [DisplayName("Course Name")]
        public string courseName { get; set; }
        [DisplayName("Course Description")]
        public string courseDesc { get; set; }
    }
}
