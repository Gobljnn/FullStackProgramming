using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.SqlRepos {
    public class SqlStudentRepo : IStudentRepo {
        private readonly EnrollmentDBContext _context;
        public SqlStudentRepo(EnrollmentDBContext context) {
            _context = context;
        }
        public void CreateStudent(Student input) { //to save info
            _context.Add(input);
            _context.SaveChanges();
            
        }

        public void DeleteStudent(int id) {
            throw new NotImplementedException();
        }

        public IEnumerable<Student> GetAllStudents() {
            return _context.Students.ToList(); //tolist to convert the db to list of products and has immediate execution

        }

        public Student GetStudentByID(int id) {
            throw new NotImplementedException();
        }

        public void UpdateStudent(Student input) { //to update info
            _context.Update(input);
            _context.SaveChanges();
        }
    }
}
