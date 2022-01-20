using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.MockRepos {
    public class MockCourseRepo : ICourseRepo {

        //public int courseID { get; set; }
        //public string courseName { get; set; }
        //public string courseDesc { get; set; }

        //container for static mockdata
        private static List<Course> _courses = new List<Course> {
            new Course { courseID = 001, courseName = "HTML", courseDesc = "HTML Desc" },
            new Course { courseID = 002, courseName = "CSS", courseDesc = "CSS Desc" },
            new Course { courseID = 003, courseName = "JAVA", courseDesc = "Java Desc" },
            new Course { courseID = 004, courseName = "SQL", courseDesc = "SQL Desc" },
        };


        public void CreateCourse(Course input) {
            throw new NotImplementedException();
        }

        public void DeleteCourse(int id) {
            throw new NotImplementedException();
        }

        public IEnumerable<Course> GetAllCourses() {
            return _courses;
        }

        public Course GetCourseByID(int id) {
            throw new NotImplementedException();
        }

        public void UpdateCourse(Course input) {
            throw new NotImplementedException();
        }
    }
}
