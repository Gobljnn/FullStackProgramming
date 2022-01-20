using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.Interface {
    public interface ICourseRepo {

        //CRUD - Create retrieve  update delete

        //To create
        void CreateCourse(Course input); // object found in models

        //To retrieve data you can  use these two methods - can get all data or just from one source by id
        IEnumerable<Course> GetAllCourses();//to get  all -prod model
        Course GetCourseByID(int id); //return 1 prod 

        //to update
        void UpdateCourse(Course input); // send new prod object---find vendor by id-- 

        //to delete
        void DeleteCourse(int id);
    }
}
