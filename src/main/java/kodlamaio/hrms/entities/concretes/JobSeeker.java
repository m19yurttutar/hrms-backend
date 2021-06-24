package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_seekers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
    private CurriculumVitae curriculumVitae;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity_number")
    private String nationalIdentityNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public JobSeeker(ProfilePhoto profilePhoto, String email, String password, CurriculumVitae curriculumVitae, Gender gender, String firstName, String lastName, String nationalIdentityNumber, LocalDate birthDate) {
        super(profilePhoto, email, password);
        this.curriculumVitae = curriculumVitae;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentityNumber = nationalIdentityNumber;
        this.birthDate = birthDate;
    }
}
