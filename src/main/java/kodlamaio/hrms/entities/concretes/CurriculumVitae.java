package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curriculum_vitaes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @JsonIgnore
    @OneToOne(mappedBy = "curriculumVitae")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<School> schools;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> languages;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Skill> skills;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Connection> connections;

    public CurriculumVitae(int id){
        this.setId(id);
    }

    public CurriculumVitae(JobSeeker jobSeeker){
        this.setJobSeeker(jobSeeker);
    }
}
