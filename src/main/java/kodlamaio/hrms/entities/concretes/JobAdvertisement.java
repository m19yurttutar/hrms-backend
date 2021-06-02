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

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "vacant_position_count")
    private int vacantPositionCount;

    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "activity_status")
    private boolean activityStatus;

    public JobAdvertisement(Employer employer, JobPosition jobPosition, String jobDescription, City city, int minSalary, int maxSalary, int vacantPositionCount, LocalDate applicationDeadline, boolean activityStatus) {
        this.employer = employer;
        this.jobPosition = jobPosition;
        this.jobDescription = jobDescription;
        this.city = city;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.vacantPositionCount = vacantPositionCount;
        this.applicationDeadline = applicationDeadline;
        this.activityStatus = activityStatus;
    }
}
