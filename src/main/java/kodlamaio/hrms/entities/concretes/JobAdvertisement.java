package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import javax.lang.model.type.ArrayType;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "job_description")
    private String jobDescription;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "vacant_position_count")
    private Integer vacantPositionCount;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "activity_status")
    private boolean activityStatus;
}
