using M10_W1_Assignment1_MockDB.Data;
using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.ModelsDto;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Controllers {
    public class StudentsController : Controller {

        private readonly IStudentRepo _repository;
        private readonly ICourseRepo _courseRepo;
        private readonly Mapper _mapper = new Mapper();
        StudentDto studentDto = new StudentDto();

        //StudentsController obj = (new JavascriptSerializer()).Deserialize<StudentsController>(objJson);

        public StudentsController(IStudentRepo repo, ICourseRepo courseRepo) {
            _repository = repo;
            _courseRepo = courseRepo;

        }

        public List<string> GetStudentsByCourseId(int id) {
            var counter = 1;
            var res = _repository.GetAllStudents()                
                        .Where(p => p.courseID == id)
                        .Select(p => counter++ + ") " +  p.lastName + ", " + p.firstName  + " (Student ID: " + p.stuID + ")" + "<br> --------------- <br>")
                        .ToList();
            if (res == null || res.Count() == 0) {
                return new List<string> { "No Students in this class" };
            }

            return res;
        }

        // GET: InstructorController
        public ActionResult Index() {
            var studentDtos = _repository.GetAllStudents()
            .Select(p => _mapper.Map(p));
            return View(studentDtos);
        }

        // GET: StudentsController/Details/5
        public ActionResult Details(int id) {
            return View();
        }

        // GET: StudentsController/Create
        public ActionResult Create() {
            var courses = _courseRepo.GetAllCourses();
            ViewBag.Courses = new SelectList(courses, "courseID", "courseName");

            return View();
        }

        // POST: StudentsController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(StudentDto input) {
            try {
                //use mapper to save the input to db
                var studentToDb = _mapper.Map(input);
                _repository.CreateStudent(studentToDb);

                return RedirectToAction(nameof(Index));
            }
            catch {
                return View();
            }
        }

        // GET: StudentsController/Edit/5
        public ActionResult Edit(int id) {
            var courses = _courseRepo.GetAllCourses();
            ViewBag.Courses = new SelectList(courses, "courseID", "courseName");

            return View();
        }

        // POST: StudentsController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, StudentDto input) {
            try {
                //use mapper to save the input to db
                var studentToDb = _mapper.Map(input);
                _repository.UpdateStudent(studentToDb);

                return RedirectToAction(nameof(Index));
                //return View();
            }
            catch {
                return View();
            }
        }

        // GET: StudentsController/Delete/5
        public ActionResult Delete(int id) {
            return View();
        }

        // POST: StudentsController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection) {
            try {
                return RedirectToAction(nameof(Index));
            }
            catch {
                return View();
            }
        }
    }
}


