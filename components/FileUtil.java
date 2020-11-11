package coursera.demo.components;

import coursera.demo.entities.Course;
import coursera.demo.entities.Instructor;
import coursera.demo.entities.Student;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

@Component
public class FileUtil {
    private BufferedWriter bf;

    public FileUtil() {
    }


    public void setBufferedWriter(BufferedWriter bf) {
        this.bf = bf;
    }

    public void writeStudentsInfo(String title, List<Student> students) throws IOException {
        bf.write(title);
        bf.newLine();
        bf.newLine();
        String formated = "";
        for (Student s : students) {
            formated += String.format("Student %s %s with pin %d is %d-years old has joined on %s and has %d credits.\n" +
                            "The student who's learning type is %s will graduate in %s.\n",
                    s.getFirstName(), s.getLastName(), s.getPin(), s.getAge(), String.valueOf(s.getJoinedDate()),
                    s.getCredits(), s.getLearningType().name(), String.valueOf(s.getGraduationDate()));
            if (s.getCourses().size() != 0) {
                formated += "The student has joined in courses: \n";
                for (Course c : s.getCourses()) {
                    formated += formatCourse(c);
                }
            }
        }
        bf.write(formated);
        bf.newLine();
    }

    public void writeInstructorsInfo(String s, List<Instructor> all) throws IOException {
        bf.write(s);
        bf.newLine();
        bf.newLine();

        String formated = "";
        for (Instructor i : all) {
            formated += String.format("Instructor %s %s with id %d is %d-years old with %d years of internship takes $%.2f salary was hired on %s.\n",
                    i.getFirstName(), i.getLastName(), i.getId(), i.getAge(), i.getYearsInternship(), i.getSalary(), i.getDateHired());
            if (i.getCourses().size() != 0) {
                for (Course c : i.getCourses()) {
                    formated += formatCourse(c);
                }
            }
        }
        bf.write(formated);
        bf.newLine();
    }

    private String formatCourse(Course c) {
        return String.format("\tCourses: \n\t\t\t%s with end date %s\n\n",
                c.getTitle(), String.valueOf(c.getEndDate()));
    }

    public void closeBufferedWriter() {
        try {
            this.bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCoursesInfo(String title, List<Course> all) throws IOException {
        bf.write(title);
        bf.newLine();
        bf.newLine();

        String formated = "";
        for (Course c : all) {
            formated += String.format("Course %s with %d credits has %s education working type and it's duration is %d.\n" +
                            "Course's start date is %s and ends in %s.\n" +
                            "The course has %d enrolled students.\n" +
                            "The instructor of this course is %s %s.\n"
                    , c.getTitle(), c.getCredits(), c.getEducationWorkingType().name(), c.getDuration(),
                    c.getStartDate(), c.getEndDate(), c.getStudents().size(), c.getInstructor().getFirstName(), c.getInstructor().getLastName());
        }
        bf.write(formated);
        bf.newLine();
    }
}
