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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "connection_id", referencedColumnName = "id")
    private Connection connection;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<School> schools;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> languages;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Skill> skills;

    @JsonIgnore
    @OneToOne(mappedBy = "curriculumVitae")
    private JobSeeker jobSeeker;

    public CurriculumVitae(int id){
        this.id = id;
    }

    public CurriculumVitae(Connection connection){
        this.connection = connection;
    }
}
