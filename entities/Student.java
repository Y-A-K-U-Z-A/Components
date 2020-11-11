package coursera.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long pin;

    @Column(name = "first_name", nullable = false)@Getter @Setter
    private String firstName;
    @Column(name = "last_name", nullable = false)@Getter @Setter
    private String lastName;

    @Positive
    @Column(name = "age", nullable = false, length = 120)@Getter @Setter
    private int age;

    @Positive
    @Column(name = "total_credits", nullable = false)@Getter @Setter
    private int credits;

    @Column(name = "joined_date")@Getter @Setter
    private LocalDate joinedDate;

    @Column(name = "graduation_date", nullable = false)@Getter @Setter
    private LocalDate graduationDate;
    //    @ToString.Exclude
    //    @ManyToMany(mappedBy = "ingredients", cascade = ALL)
    //    private Set<Shampoo> shampoos = new HashSet<>();
    @ToString.Exclude
    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)     @Getter @Setter
    private Set<Course> courses = new HashSet<>();

    @Enumerated(value = EnumType.STRING) @Getter @Setter
    private LearningType learningType;

}
