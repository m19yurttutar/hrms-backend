package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "graduation_year")
    private int graduationYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
    private CurriculumVitae curriculumVitae;

    public School(CurriculumVitae curriculumVitae, String schoolName, String departmentName, int startYear, int graduationYear){
        this.setCurriculumVitae(curriculumVitae);
        this.setSchoolName(schoolName);
        this.setDepartmentName(departmentName);
        this.setStartYear(startYear);
        this.setGraduationYear(graduationYear);
    }
}
