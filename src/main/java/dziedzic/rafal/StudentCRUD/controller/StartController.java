package dziedzic.rafal.StudentCRUD.controller;

import dziedzic.rafal.StudentCRUD.dao.StudentDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @Autowired
    StudentDaoJpa studentDaoJpa;

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public String ShowAllStudent(ModelMap modelMap) {
        modelMap.addAttribute("studentList", studentDaoJpa.findAll());
        return "student";
    }
}
