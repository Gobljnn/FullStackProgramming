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
    public class InstructorsController : Controller {
        private readonly IInstructorRepo _repository;
        private readonly Mapper _mapper = new Mapper();

        public InstructorsController(IInstructorRepo repo) {
            _repository = repo; 
        }
        // GET: InstructorController
        public ActionResult Index() {
            var instructorDtos = _repository.GetAllInstructors()
            .Select(p => _mapper.Map(p));
            return View(instructorDtos);
            
        }

        // GET: InstructorController/Details/5
        public ActionResult Details(int id) {
            return View();
        }

        // GET: InstructorController/Create
        public ActionResult Create() {
            return View();
        }

        // POST: InstructorController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(InstructorDto input) {
            try {
                //use mapper to save the input to db
                var instructorToDb = _mapper.Map(input);
                _repository.CreateInstructor(instructorToDb);

                return RedirectToAction(nameof(Index));
            }
            catch {
                return View();
            }
        }

        // GET: InstructorController/Edit/5
        public ActionResult Edit(int id) {
            return View();
        }

        // POST: InstructorController/Edit/5
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

        // GET: InstructorController/Delete/5
        public ActionResult Delete(int id) {
            return View();
        }

        // POST: InstructorController/Delete/5
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
