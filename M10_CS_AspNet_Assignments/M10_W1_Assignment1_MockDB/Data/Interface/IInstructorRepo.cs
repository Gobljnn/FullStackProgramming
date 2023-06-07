using M10_W1_Assignment1_MockDB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Data.Interface {
    public interface IInstructorRepo {

        //CRUD - Create retrieve  update delete

        //To create
        void CreateInstructor(Instructor input); // object found in models

        //To retrieve data you can  use these two methods - can get all data or just from one source by id
        IEnumerable<Instructor> GetAllInstructors();//to get  all -prod model
        Instructor GetInstructorByID(int id); //return 1 prod 

        //to update
        void UpdateInstructor(Instructor input); // send new prod object---find vendor by id-- 

        //to delete
        void DeleteInstructor(int id);


    }
}
