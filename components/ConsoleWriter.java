package coursera.demo.components;

public class ConsoleWriter {
    public void welcoming() {
        System.out.println("Welcome to Coursera project!");
        System.out.println("This project is about reading and writing database's information.");
    }

    public void methodsCounting() {
        System.out.println("For writing information about students, please press 1.");
        System.out.println("For writing information about courses, please press 2.");
        System.out.println("For writing information about instructors, please press 3.");
        System.out.println("For exiting the program, please press E.");
    }

    public void studentMethods() {
        System.out.println("\tPlease press: ");
        System.out.println("\t\t\t- 1 for writing down information about all students.");
        System.out.println("\t\t\t- 2 for writing down information about all students with required total minimum credits.");
        System.out.println("\t\t\t- 3 for writing down information about all students who are in required course.");
        System.out.println("\t\t\t- 4 for writing down information about all students who are graduating in required year.");
        System.out.println("\t\t\t- 5 for writing down information about all students who's learning type is.");
        System.out.println("\t\t\t- E for exiting.");
    }

    public void minimumCredits() {
        System.out.println("Please enter the minimum credits.(0-220)");
    }

    public void requiredCourse() {
        System.out.println("Please enter course name.");
        System.out.println("(Google IT Support, Applied Data Science, Indigenous Canada, Business Foundations)\n" +
                "(The Science of Well-Being, Google Cloud Networking, Digital Product Management, AI in Healthcare)\n" +
                "(Digital Marketing, Financial Markets)");
    }

    public void graduatingYear() {
        System.out.println("Please enter graduating year in format (dd-mm-yy)");
    }

    public void learningType() {
        System.out.println("Please enter learning type.");
        System.out.println("(Distance, Regular)");
    }

    public void courseMethods() {
        System.out.println("\tPlease press: ");
        System.out.println("\t\t\t- 1 for writing down information about all courses.");
        System.out.println("\t\t\t- 2 for writing down information about all courses with required duration.");
        System.out.println("\t\t\t- 3 for writing down information about all courses with minimum students.");
        System.out.println("\t\t\t- E for exiting.");
    }
    public void instructorMethods() {
        System.out.println("\tPlease press: ");
        System.out.println("\t\t\t- 1 for writing down information about all instructors.");
        System.out.println("\t\t\t- 2 for writing down information about all instructors with minimum salary.");
        System.out.println("\t\t\t- 3 for writing down information about instructor with name.");
        System.out.println("\t\t\t- E for exiting.");
    }
    public void requiredDuartion(){
        System.out.println("Please enter course's duration.");
    }
    public void minimumStudents(){
        System.out.println("Please enter course's minimum students.");
    }
    public void minimumSalary(){
        System.out.println("Please enter instructor's minimum salary.");
    }
    public void instructorName(){
        System.out.println("Please enter instructor's first name.");
        System.out.println("(Jack Nickolsone, Maria Bubalova, Simona Georgieva, Ivan Kovachev, Reneta Parashkevova)");
    }
    public void exiting(){
        System.out.println("Please check files instructors/courses/students.html in the project directory.");
        System.out.println("See you soon!");
    }
}
