package coursera.demo.repositories;

import coursera.demo.entities.LearningType;
import coursera.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByCreditsGreaterThan(int minCredits);

    @Query("select s from Student s join s.courses c where c.title = ?1")
    List<Student> findAllByCourse(String courseName);

    List<Student> findAllByGraduationDate(LocalDate graduationDate);

    List<Student> findAllByLearningType(LearningType learningType);
}
