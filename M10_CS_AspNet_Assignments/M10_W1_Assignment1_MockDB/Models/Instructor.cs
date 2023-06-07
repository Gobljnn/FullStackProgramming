using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema; //foreign Key
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Models {
    public class Instructor {
        [Key]
        public int insID { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string email { get; set; }
        [ForeignKey("Course")]
        public int? courseID { get; set; }

        public Course Course { get; set; } //this is for foreign key create this so a foreign key relationship is made
                                            //when the db has been created.
        

    }
}
