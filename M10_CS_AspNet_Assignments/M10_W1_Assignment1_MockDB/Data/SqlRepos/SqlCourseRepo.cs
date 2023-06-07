using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.SqlRepos {
    public class SqlCourseRepo : ICourseRepo { //inherit the interface for the repoo
        private readonly EnrollmentDBContext _context;

        public SqlCourseRepo(EnrollmentDBContext context) {
            _context = context;
        }
        public void CreateCourse(Course input) {
            _context.Add(input);
            _context.SaveChanges();
        }

        public void DeleteCourse(int id) {
            throw new NotImplementedException();
        }

        public IEnumerable<Course> GetAllCourses() {
            return _context.Courses.ToList(); //tolist to convert the db to list of products and has immediate execution
        }

        public Course GetCourseByID(int id) {
            throw new NotImplementedException();
        }

        public void UpdateCourse(Course input) {
            throw new NotImplementedException();
        }
    }
}
