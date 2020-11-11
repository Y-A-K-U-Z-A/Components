package coursera.demo.repositories;

import coursera.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByDuration (int duration);

    @Query("select c from Course c where c.students.size > ?1")
    List<Course> findAllByStudents (int size);

}
