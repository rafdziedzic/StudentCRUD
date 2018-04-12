package dziedzic.rafal.StudentCRUD.controller;

import dziedzic.rafal.StudentCRUD.dao.StudentDaoJpa;
import dziedzic.rafal.StudentCRUD.model.Student;
import dziedzic.rafal.StudentCRUD.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StartController {

    @Autowired
    StudentDaoJpa studentDaoJpa;

    @Autowired
    StudentServices studentServices;

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public String ShowAllStudent(ModelMap modelMap) {
        modelMap.addAttribute("studentList", studentDaoJpa.findAll());
        return "student";
    }

    @GetMapping(value = "/addNewStudent")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("student", new Student());
        return "addNewStudent";
    }

    @PostMapping(value = "/addNewStudent")
    public String addStudent(@ModelAttribute Student student, ModelMap modelMap) {
        modelMap.addAttribute("student", student);
        studentDaoJpa.save(student);
        return "redirect:/addNewStudent";
    }


    @RequestMapping(value = "/removeStudent")
    public String removeStudent(@RequestParam("id") Long id) {
        studentServices.removeStudent(id);
        return "redirect:/studentList";
    }

}
