using M10_W1_Assignment1_MockDB.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data {
    public class EnrollmentDBContext : DbContext {

        public EnrollmentDBContext(DbContextOptions<EnrollmentDBContext> op) : base(op) { }

        //collection should be property type of dbset
        public DbSet<Student> Students { get;set; }
        public DbSet<Instructor> Instructors { get; set; }
        public DbSet<Course> Courses { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            base.OnModelCreating(modelBuilder);

            //entity you want to insert goes below here
            //Courses
            modelBuilder.Entity<Course>().HasData(
                new Course { courseID = 002, courseName = "CSS", courseDesc = "CSS Desc" },
                new Course { courseID = 003, courseName = "JAVA", courseDesc = "Java Desc" },
                new Course { courseID = 001, courseName = "HTML", courseDesc = "HTML Desc" },
                new Course { courseID = 004, courseName = "SQL", courseDesc = "SQL Desc" }
            );
            
            //Instructors
            modelBuilder.Entity<Instructor>().HasData(
                new Instructor { insID = 1, firstName = "Ediz", lastName = "Seeger", email = "ES@email.com", courseID = 001  },
                new Instructor { insID = 2, firstName = "Yemima", lastName = "Morce", email = "YM@email.com", courseID = 004  }, 
                new Instructor { insID = 3, firstName = "Vilhelmo", lastName = "Joiner", email = "VJ@email.com", courseID = 002 },
                new Instructor { insID = 4, firstName = "Hildingr", lastName = "Reis", email = "HR@email.com", courseID = 003  }
            );

            //Students
            modelBuilder.Entity<Student>().HasData(
                new Student { stuID = 1, firstName = "Gijsbert", lastName = "Marini", email = "GM@email.com", phoneNum = 7801234567, courseID = 4 },
                new Student { stuID = 2, firstName = "Jep", lastName = "Khachaturian", email = "JK@email.com", phoneNum = 780123456, courseID = 3 },
                new Student { stuID = 3, firstName = "Paulina", lastName = "Biancardi", email = "PB@email.com", phoneNum = 78023456, courseID = 1 },
                new Student { stuID = 4, firstName = "Line", lastName = "Krüger", email = "LK@email.com", phoneNum = 7806456789, courseID = 2 }
            );
        }
    }
}
