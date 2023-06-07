using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.MockRepos {
    public class MockInstructorRepo : IInstructorRepo {

        //public int insID { get; set; }
        //public string firstName { get; set; }
        //public string lastName { get; set; }
        //public string email { get; set; }
        //public string course { get; set; }

        //container for static mockdata
        private static List<Instructor> _instructors = new List<Instructor> {
            new Instructor { insID = 1, firstName = "Ediz", lastName = "Seeger", email = "ES@email.com", courseID=001  },
            new Instructor { insID = 2, firstName = "Yemima", lastName = "Morce", email = "YM@email.com", courseID=004  },
            new Instructor { insID = 3, firstName = "Vilhelmo", lastName = "Joiner", email = "VJ@email.com", courseID=002  },
            new Instructor { insID = 4, firstName = "Hildingr", lastName = "Reis", email = "HR@email.com", courseID=003  },

        };

        public void CreateInstructor(Instructor input) {
            throw new NotImplementedException();
        }

        public void DeleteInstructor(int id) {
            throw new NotImplementedException();
        }

        public IEnumerable<Instructor> GetAllInstructors() {
            return _instructors;
        }

        public Instructor GetInstructorByID(int id) {
            throw new NotImplementedException();
        }

        public void UpdateInstructor(Instructor input) {
            throw new NotImplementedException();
        }
    }
}
