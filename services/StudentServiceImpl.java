package coursera.demo.services;

import coursera.demo.components.FileUtil;
import coursera.demo.entities.LearningType;
import coursera.demo.entities.Student;
import coursera.demo.repositories.StudentRepository;
import coursera.demo.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private File file = new File("students.html");
    private BufferedWriter bf;
    private final FileUtil fileUtil = new FileUtil();

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
            try {
                bf = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.fileUtil.setBufferedWriter(bf);
    }

    @Override
    public void getAllStudents() throws IOException {
        List<Student> all = this.studentRepository.findAll();
        fileUtil.writeStudentsInfo("All Students -----------", all);
    }

    @Override
    public void getStudentsByMinimumCredits(int minimumCredits) throws IOException {
        List<Student> all = this.studentRepository.findAllByCreditsGreaterThan(minimumCredits);
        fileUtil.writeStudentsInfo("Students with minimum credits(" + minimumCredits + ") -----------", all);
    }

    @Override
    public void getStudentsByCourseName(String courseName) throws IOException {
        List<Student> all = this.studentRepository.findAllByCourse(courseName);
        fileUtil.writeStudentsInfo("Students enrolled in a course " + courseName + " -----------", all);
    }

    @Override
    public void getStudentsByGraduatingYear(String graduatingYear) throws IOException {
        int[] tokens = Arrays.stream(graduatingYear.split("-")).mapToInt(Integer::parseInt).toArray();
        List<Student> all = this.studentRepository.findAllByGraduationDate(LocalDate.of(tokens[2], tokens[1], tokens[0]));
        fileUtil.writeStudentsInfo("Students graduating in " + graduatingYear +" -----------", all);
    }

    @Override
    public void getStudentByLearningType(String learningType) throws IOException {
        List<Student> all = this.studentRepository.findAllByLearningType(LearningType.valueOf(learningType.toUpperCase()));
        fileUtil.writeStudentsInfo("Students with learning type " + learningType +" -----------", all);
    }

    @Override
    public void closeBufferedWriter() {
        this.fileUtil.closeBufferedWriter();
    }
}
