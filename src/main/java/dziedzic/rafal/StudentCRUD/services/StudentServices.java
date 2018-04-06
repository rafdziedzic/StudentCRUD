package dziedzic.rafal.StudentCRUD.services;

import dziedzic.rafal.StudentCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServices {
    List<Student> findByNameAndSurname(String name, String surname);
}
