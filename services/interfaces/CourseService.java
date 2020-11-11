package coursera.demo.services.interfaces;

import java.io.IOException;

public interface CourseService {
    void getAllCourses() throws IOException;

    void getCoursesByDuration(int duration) throws IOException;

    void getCourseByMinimumStudents(int minStudents) throws IOException;

    void closeBufferedWriter();

}
