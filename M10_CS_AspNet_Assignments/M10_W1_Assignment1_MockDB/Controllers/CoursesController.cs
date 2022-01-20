using M10_W1_Assignment1_MockDB.Data;
using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.ModelsDto;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB.Controllers {
    public class CoursesController : Controller {
        private readonly ICourseRepo _repository;
        private readonly IStudentRepo _studentRepository; //read only field
        private readonly Mapper _mapper = new Mapper();

        public CoursesController(ICourseRepo repo, IStudentRepo stuRepo) {
            _repository = repo;
            _studentRepository = stuRepo;
        }
        // GET: CoursesController
        public ActionResult Index() {
            var courseDtos = _repository.GetAllCourses()
            .Select(p => _mapper.Map(p));
            return View(courseDtos);
        }

        // GET: CoursesController/Details/5
        public ActionResult Details(int id) {
            return View();
        }

        public ActionResult StudentHTML() {
            var students = _studentRepository.GetAllStudents();
            ViewBag.students = _studentRepository;

            //view

            return View();
        }

        // GET: CoursesController/Create
        public ActionResult Create() {
            return View();
        }

        // POST: CoursesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(CourseDto input) {
            try {
                //use mapper to save the input to db
                var courseToDb = _mapper.Map(input);
                _repository.CreateCourse(courseToDb);

                return RedirectToAction(nameof(Index));
            }
            catch {
                return View();
            }
        }

        // GET: CoursesController/Edit/5
        public ActionResult Edit(int id) {
            return View();
        }

        // POST: CoursesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection) {
            try {
                return RedirectToAction(nameof(Index));
            }
            catch {
                return View();
            }
        }

        // GET: CoursesController/Delete/5
        public ActionResult Delete(int id) {
            return View();
        }

        // POST: CoursesController/Delete/5
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
