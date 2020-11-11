package coursera.demo.services;

import coursera.demo.components.FileUtil;
import coursera.demo.entities.Course;
import coursera.demo.repositories.CourseRepository;
import coursera.demo.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private File file = new File("courses.html");
    private BufferedWriter bf;
    private final FileUtil fileUtil = new FileUtil();

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        try {
            bf = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileUtil.setBufferedWriter(bf);
    }

    @Override
    public void getAllCourses() throws IOException {
        List<Course> all = this.courseRepository.findAll();
        this.fileUtil.writeCoursesInfo("All courses -----------", all);
    }

    @Override
    public void getCoursesByDuration(int duration) throws IOException {
        List<Course> all = this.courseRepository.findAllByDuration(duration);
        this.fileUtil.writeCoursesInfo("Courses with duration " + duration + " -----------", all);
    }

    @Override
    public void getCourseByMinimumStudents(int minStudents) throws IOException {
        List<Course> all = this.courseRepository.findAllByStudents(minStudents);
        this.fileUtil.writeCoursesInfo("Courses with minimum students " + minStudents + " -----------", all);
    }

    @Override
    public void closeBufferedWriter() {
        this.fileUtil.closeBufferedWriter();
    }
}
