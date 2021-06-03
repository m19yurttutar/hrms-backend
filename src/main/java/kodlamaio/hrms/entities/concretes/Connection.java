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
    @OneToOne(mappedBy = "connection")
    private CurriculumVitae curriculumVitae;

    public Connection(int id, String githubAccountLink, String linkedinAccountLink){
        this.id = id;
        this.githubAccountLink = githubAccountLink;
        this.linkedinAccountLink = linkedinAccountLink;
    }
}
