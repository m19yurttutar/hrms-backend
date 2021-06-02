package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "connections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "github_account_link")
    private String githubAccountLink;

    @Column(name = "linkedin_account_link")
    private String linkedinAccountLink;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
    private CurriculumVitae curriculumVitae;

    public Connection(CurriculumVitae curriculumVitae, String githubAccountLink, String linkedinAccountLink){
        this.setCurriculumVitae(curriculumVitae);
        this.setGithubAccountLink(githubAccountLink);
        this.setLinkedinAccountLink(linkedinAccountLink);
    }
}
