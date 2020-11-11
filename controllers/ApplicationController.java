package coursera.demo.controllers;

import coursera.demo.components.ConsoleWriter;
import coursera.demo.services.interfaces.CourseService;
import coursera.demo.services.interfaces.InstructorService;
import coursera.demo.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Scanner;

@Controller
public class ApplicationController implements CommandLineRunner {
    private final CourseService courseService;
    private final InstructorService instructorService;
    private final StudentService studentService;
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final Scanner sc = new Scanner(System.in);

    @Autowired
    public ApplicationController(CourseService courseService, InstructorService instructorService, StudentService studentService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        consoleWriter.welcoming();
        consoleWriter.methodsCounting();
        String line = sc.nextLine();
        while (!"E".equals(line)) {
            try {
                switch (line) {
                    case "1":
                        goToStudentMethod();
                        break;
                    case "2":
                        goToCourseMethod();
                        break;
                    case "3":
                        goToInstructorMethod();
                        break;
                }
            }catch (IOException e){
                System.out.println("Something went wrong. Please check FileUtil.");
            }

            System.out.println("Please press number (1-3) to continue.");
            line = sc.nextLine();
        }
    }

    private void goToInstructorMethod() throws IOException {
        consoleWriter.instructorMethods();
        String line = sc.nextLine();
        while (!"E".equals(line)) {

            switch (line) {
                case "1":
                    this.instructorService.getAllInstructors();
                    break;
                case "2":
                    consoleWriter.minimumSalary();
                    double salary = Double.parseDouble(sc.nextLine());
                    this.instructorService.getInstructorsBySalaryHigherThan(salary);
                    break;
                case "3":
                    consoleWriter.instructorName();
                    String firstName = sc.nextLine();
                    this.instructorService.getInstructorByFirstName(firstName);
                    break;
            }
            System.out.println("Please press number (1-3) to continue.");
            line = sc.nextLine();
        }
        this.instructorService.closeBufferedWriter();
    }

    private void goToCourseMethod() throws IOException {
        consoleWriter.courseMethods();
        String line = sc.nextLine();
        while (!"E".equals(line)) {
            switch (line) {
                case "1":
                    this.courseService.getAllCourses();
                    break;
                case "2":
                    consoleWriter.requiredDuartion();
                    int duration = Integer.parseInt(sc.nextLine());
                    this.courseService.getCoursesByDuration(duration);
                    break;
                case "3":
                    consoleWriter.minimumStudents();
                    int minStudents = Integer.parseInt(sc.nextLine());
                    this.courseService.getCourseByMinimumStudents(minStudents);
                    break;
            }
            System.out.println("Please press number (1-3) to continue.");
            line = sc.nextLine();
        }
        this.courseService.closeBufferedWriter();
    }

    private void goToStudentMethod() throws IOException {
        consoleWriter.studentMethods();
        String line = sc.nextLine();
        while (!"E".equals(line)) {
            switch (line) {
                case "1":
                    try {
                        this.studentService.getAllStudents();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    consoleWriter.minimumCredits();
                    int minimumCredits = Integer.parseInt(sc.nextLine());
                    this.studentService.getStudentsByMinimumCredits(minimumCredits);
                    break;
                case "3":
                    consoleWriter.requiredCourse();
                    String courseName = sc.nextLine();
                    this.studentService.getStudentsByCourseName(courseName);
                    break;
                case "4":
                    consoleWriter.graduatingYear();
                    String graduatingYear = sc.nextLine();
                    this.studentService.getStudentsByGraduatingYear(graduatingYear);
                    break;
                case "5":
                    consoleWriter.learningType();
                    String learningType = sc.nextLine();
                    this.studentService.getStudentByLearningType(learningType);
                    break;
            }
            System.out.println("Please press number (1-5) to continue.");
            line = sc.nextLine();
        }
        this.studentService.closeBufferedWriter();
    }
}
