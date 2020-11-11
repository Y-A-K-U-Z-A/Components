package coursera.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructors")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Instructor extends BaseEntity{
    @Column(name = "first_name", length = 50) @Getter @Setter
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50) @Getter @Setter
    private String lastName;
    @Column(name = "age", nullable = false) @Getter @Setter
    @Positive
    private int age;
    @Column(name = "salary", nullable = false) @Getter @Setter
    @Positive
    private double salary;
    @Column(name = "years_internship", nullable = false) @Getter @Setter
    @Positive
    private int yearsInternship;
    @Column(name = "date_hired") @Getter @Setter
    private LocalDate dateHired;
    @Column(name = "is_retired", nullable = false, columnDefinition = "boolean default false")
    @Getter @Setter
    private boolean isRetired = false;
    @Column(name = "date_retirement") @Getter @Setter
    private LocalDate dateRetirement;
//ToString.Exclude
//    @OneToMany(mappedBy = "label")
//    private Set<Shampoo> shampoos = new HashSet<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    @Getter @Setter
    private Set<Course> courses = new HashSet<>();
}
