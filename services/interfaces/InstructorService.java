package coursera.demo.services.interfaces;

import java.io.IOException;

public interface InstructorService {
    void getAllInstructors() throws IOException;

    void getInstructorsBySalaryHigherThan(double salary) throws IOException;

    void getInstructorByFirstName(String firstName) throws IOException;

    void closeBufferedWriter();

}
