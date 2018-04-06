package dziedzic.rafal.StudentCRUD.dao;

import dziedzic.rafal.StudentCRUD.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDaoJpa extends JpaRepository<Student,Long> {
}
