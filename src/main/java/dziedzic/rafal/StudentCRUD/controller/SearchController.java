package dziedzic.rafal.StudentCRUD.controller;

import dziedzic.rafal.StudentCRUD.model.Student;
import dziedzic.rafal.StudentCRUD.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

    @Autowired
    StudentServices studentServices;


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchEngine(ModelMap modelMap) {
        modelMap.addAttribute("student",new Student());
        return "search";
    }

    @RequestMapping(value = "/searchEngine", method = RequestMethod.POST)
    public String wynikWyszukiwania(ModelMap modelMap, Student student) {
        modelMap.addAttribute("student",student);
        modelMap.addAttribute("studentList",studentServices.findByNameAndSurname(student.getName(),student.getSurname()));
        return "studentSearchResult";
    }

}
