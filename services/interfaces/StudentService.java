package coursera.demo.services.interfaces;

import java.io.IOException;

public interface StudentService {
    void getAllStudents() throws IOException;

    void getStudentsByMinimumCredits(int minimumCredits) throws IOException;

    void getStudentsByCourseName(String courseName) throws IOException;

    void getStudentsByGraduatingYear(String graduatingYear) throws IOException;

    void getStudentByLearningType(String learningType) throws IOException;

    void closeBufferedWriter();
}
