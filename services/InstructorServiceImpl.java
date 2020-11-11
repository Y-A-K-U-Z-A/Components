package coursera.demo.services;

import coursera.demo.components.FileUtil;
import coursera.demo.entities.Instructor;
import coursera.demo.repositories.InstructorRepository;
import coursera.demo.services.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private File file = new File("instructors.html");
    private BufferedWriter bf;
    private final FileUtil fileUtil = new FileUtil();

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
        try {
            bf = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileUtil.setBufferedWriter(bf);
    }

    @Override
    public void getAllInstructors() throws IOException {
        List<Instructor> all = this.instructorRepository.findAll();
        fileUtil.writeInstructorsInfo("All instructors -----------", all);
    }

    @Override
    public void getInstructorsBySalaryHigherThan(double salary) throws IOException {
        List<Instructor> all = this.instructorRepository.findAllBySalaryGreaterThan(salary);
        fileUtil.writeInstructorsInfo("Instructors with salary higher than $" + salary + " -----------", all);
    }

    @Override
    public void getInstructorByFirstName(String firstName) throws IOException {
        List<Instructor> all = this.instructorRepository.findByFirstName(firstName);
        fileUtil.writeInstructorsInfo("Instructor with first name " + firstName+ " -----------", all);
    }

    @Override
    public void closeBufferedWriter() {
        this.fileUtil.closeBufferedWriter();
    }
}
