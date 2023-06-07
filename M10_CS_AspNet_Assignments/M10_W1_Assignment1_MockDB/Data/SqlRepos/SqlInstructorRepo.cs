using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.SqlRepos {
    public class SqlInstructorRepo : IInstructorRepo {
        private readonly EnrollmentDBContext _context;
        public SqlInstructorRepo(EnrollmentDBContext context) {
            _context = context;
        }
        public void CreateInstructor(Instructor input) {
            _context.Add(input);
            _context.SaveChanges();
        }

        public void DeleteInstructor(int id) {
            throw new NotImplementedException();
        }

        public IEnumerable<Instructor> GetAllInstructors() {
            return _context.Instructors.ToList(); //tolist to convert the db to list of products and has immediate execution

        }

        public Instructor GetInstructorByID(int id) {
            throw new NotImplementedException();
        }

        public void UpdateInstructor(Instructor input) {
            throw new NotImplementedException();
        }
    }
}
