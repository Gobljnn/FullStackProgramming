using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.ModelsDto {
    public class InstructorDto {
        [DisplayName("Instructor ID")]
        public int insID { get; set; }
        [DisplayName("First Name")]
        public string firstName { get; set; }
        [DisplayName("Last Name")]
        public string lastName { get; set; }
        [DisplayName("E-Mail")]
        public string email { get; set; }
        [DisplayName("Course No. Being Taught")]
        public int? courseID { get; set; }
    }
}
