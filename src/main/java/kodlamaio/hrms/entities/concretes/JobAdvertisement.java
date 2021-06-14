package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "job_description")
    private String jobDescription;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "working_type_id", referencedColumnName = "id")
    private WorkingType workingType;

    @ManyToOne
    @JoinColumn(name = "working_time_id", referencedColumnName = "id")
    private WorkingTime workingTime;

    @Column(name = "min_salary")
    private float minSalary;

    @Column(name = "max_salary")
    private float maxSalary;

    @Column(name = "vacant_position_count")
    private int vacantPositionCount;

    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "activity_status")
    private boolean activityStatus = true;

    @Column(name = "confirmation_status")
    private boolean confirmationStatus = false;

    public JobAdvertisement(Employer employer, JobPosition jobPosition, City city, WorkingType workingType, WorkingTime workingTime, String jobDescription, Float minSalary, Float maxSalary, int vacantPositionCount, LocalDate applicationDeadline) {
        this.employer = employer;
        this.jobPosition = jobPosition;
        this.city = city;
        this.workingType = workingType;
        this.workingTime = workingTime;
        this.jobDescription = jobDescription;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.vacantPositionCount = vacantPositionCount;
        this.applicationDeadline = applicationDeadline;
    }
}
