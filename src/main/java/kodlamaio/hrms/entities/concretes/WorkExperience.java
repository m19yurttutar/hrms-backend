package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "work_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "quit_year")
    private Integer quitYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
    private CurriculumVitae curriculumVitae;

    public WorkExperience(CurriculumVitae curriculumVitae, String companyName, String positionName, Integer startYear, Integer quitYear){
        this.setCurriculumVitae(curriculumVitae);
        this.setCompanyName(companyName);
        this.setPositionName(positionName);
        this.setStartYear(startYear);
        this.setQuitYear(quitYear);
    }
}
