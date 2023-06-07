using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.ModelsDto {
    public class StudentDto {

        [DisplayName ("Student ID")]
        public int stuID { get; set; }
        [DisplayName("First Name")]
        public string firstName { get; set; }
        [DisplayName("Last Name")]
        public string lastName { get; set; }
        [DisplayName("E-Mail")]
        public string email { get; set; }
        [DisplayName("Phone Number")]
        public long phoneNum { get; set; }
        [DisplayName("Course Enrolled In")]
        public int? courseID { get; set; }

    }
}
