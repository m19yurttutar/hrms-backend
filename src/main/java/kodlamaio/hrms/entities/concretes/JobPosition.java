package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="job_positions")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_position_name")
    private String jobPositionName;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvertisement> jobAdvertisements;
}
