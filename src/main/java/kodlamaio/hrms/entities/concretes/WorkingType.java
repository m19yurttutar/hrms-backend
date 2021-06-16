package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "working_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "working_type_name")
    private String workingTypeName;

    @JsonIgnore
    @OneToMany(mappedBy = "workingType")
    private List<JobAdvertisement> jobAdvertisements;

    public WorkingType(int id) {
        this.id = id;
    }
}
