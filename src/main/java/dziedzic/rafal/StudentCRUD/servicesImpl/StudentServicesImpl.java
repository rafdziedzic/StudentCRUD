package dziedzic.rafal.StudentCRUD.servicesImpl;

import dziedzic.rafal.StudentCRUD.dao.StudentDaoJpa;
import dziedzic.rafal.StudentCRUD.model.Student;
import dziedzic.rafal.StudentCRUD.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices {


    @Autowired
    StudentDaoJpa studentDaoJpa;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Student> findByNameAndSurname(String name, String surname) {
        javax.persistence.Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name='" + name + "' AND s.surname='" + surname + "'");
        return query.getResultList();
    }

    @Override
    public void removeStudent(Long id) {
        //Student student = new Student();
        // student.getId();
        studentDaoJpa.deleteById(id);
    }
}

