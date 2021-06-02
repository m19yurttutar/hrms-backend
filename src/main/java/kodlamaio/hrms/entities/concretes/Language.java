package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "language_level")
    private int languageLevel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
    private CurriculumVitae curriculumVitae;

    public Language(CurriculumVitae curriculumVitae, String language, int languageLevel){
        this.setCurriculumVitae(curriculumVitae);
        this.setLanguage(language);
        this.setLanguageLevel(languageLevel);
    }
}
