using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.MockRepos {

    //public int stuID { get; set; }
    //public string firstName { get; set; }
    //public string lastName { get; set; }
    //public string email { get; set; }
    //public int phoneNum { get; set; }

   


    public class MockStudentRepo : IStudentRepo {
        //container for static mockdata
        private static List<Student> _students = new List<Student> {
            new Student { stuID = 1, firstName = "Gijsbert", lastName = "Marini", email = "GM@email.com", phoneNum = 7801234567  },
            new Student { stuID = 2, firstName = "Jep", lastName = "Khachaturian", email = "JK@email.com", phoneNum = 7801234567 },
            new Student { stuID = 3, firstName = "Paulina", lastName = "Biancardi", email = "PB@email.com", phoneNum = 7802345678},
            new Student { stuID = 4 , firstName = "Line", lastName = "Krüger", email = "LK@email.com", phoneNum = 7806456789 },
        };
        public void CreateStudent(Student input) {
            throw new NotImplementedException();
        }

        public void DeleteStudent(int id) {
            throw new NotImplementedException();
        }

        public IEnumerable<Student> GetAllStudents() {
            return _students;
        }

        public Student GetStudentByID(int id) {
            throw new NotImplementedException();
        }

        public void UpdateStudent(Student input) {
            throw new NotImplementedException();
        }
    }
}
