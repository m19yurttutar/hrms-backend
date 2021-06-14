package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "working_time")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "working_time_name")
    private String workingTimeName;

    @JsonIgnore
    @OneToMany(mappedBy = "workingTime")
    private List<JobAdvertisement> jobAdvertisements;
}
