package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "programming_technology_name")
    private String programmingTechnologyName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
    private CurriculumVitae curriculumVitae;

    public Skill(CurriculumVitae curriculumVitae, String programmingTechnologyName){
        this.setCurriculumVitae(curriculumVitae);
        this.setProgrammingTechnologyName(programmingTechnologyName);
    }
}
