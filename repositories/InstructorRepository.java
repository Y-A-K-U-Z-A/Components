package coursera.demo.repositories;

import coursera.demo.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<Instructor> findAllBySalaryGreaterThan(double salary);

    List<Instructor> findByFirstName(String fName);
}
