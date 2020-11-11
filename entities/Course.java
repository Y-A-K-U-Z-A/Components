package coursera.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Data
public class Course extends BaseEntity{
    @Column(name = "title", nullable = false, length = 100)@Getter
    @Setter
    private String title;

    @Column(name = "description", length = 270)@Getter @Setter
    private String description;

    @Positive
    @Column(name = "credits", nullable = false)@Getter @Setter
    private int credits;

    @Column(name = "type_training", nullable = false)@Getter @Setter
    @Enumerated(value = EnumType.STRING)
    private EducationWorkingType educationWorkingType;

    @Column(name = "duration", nullable = false)
    @Positive @Getter @Setter
    private int duration;

    @Column(name = "start_date", nullable = false)
    @Positive @Getter @Setter
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @Positive @Getter @Setter
    private LocalDate endDate;
    @Column(name = "salary_teacher", nullable = false)
    @Positive @Getter @Setter
    private double salaryForTeacher;

    @ManyToMany(fetch = EAGER, cascade = ALL)
    @Getter @Setter
    //    @JoinTable(
    //            joinColumns = @JoinColumn(name="shampoo_id", referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(name="ingredient_id", referencedColumnName = "id")
    //    )
    @JoinTable(
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_pin", referencedColumnName = "pin")
    )
    private Set<Student> students = new HashSet<>();


//    @ManyToOne(optional = true, cascade = {PERSIST, REFRESH}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "label", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "instructor", referencedColumnName = "id")
    private Instructor instructor;
}
