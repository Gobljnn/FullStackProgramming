using M10_W1_Assignment1_MockDB.Models;
using M10_W1_Assignment1_MockDB.ModelsDto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data {
    public class Mapper { //mapper is used to covert DTO to buisness logic model (application layer)
        //Course
        public Course Map(CourseDto input) {
            return new Course {
                courseID = input.courseID,
                courseDesc = input.courseDesc,
                courseName = input.courseName

            };
        }

        public CourseDto Map(Course input) {
            return new CourseDto {
                courseID = input.courseID,
                courseDesc = input.courseDesc,
                courseName = input.courseName

            };
        }

        //Instructor
        public Instructor Map(InstructorDto input) {
            return new Instructor {
                courseID = input.courseID,
                insID = input.insID,
                firstName = input.firstName,
                lastName = input.lastName,
                email = input.email

            };
        }

        public InstructorDto Map(Instructor input) {
            return new InstructorDto {
                courseID = input.courseID,
                insID = input.insID,
                firstName = input.firstName,
                lastName = input.lastName,
                email = input.email
            };
        }

        //Students
        public Student Map(StudentDto input) {
            return new Student {
                stuID = input.stuID,
                firstName = input.firstName,
                lastName = input.lastName,
                email = input.email,
                phoneNum = input.phoneNum,
                courseID = input.courseID
            };
        }

        public StudentDto Map(Student input) {
            return new StudentDto {
                stuID = input.stuID,
                firstName = input.firstName,
                lastName = input.lastName,
                email = input.email,
                phoneNum = input.phoneNum,
                courseID = input.courseID
            };
        }
    }
}
