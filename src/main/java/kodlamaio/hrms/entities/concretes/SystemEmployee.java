package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "system_employees")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemEmployee extends User {

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "systemEmployee")
    private List<JobAdvertisementConfirmation> jobAdvertisementConfirmations;

    public SystemEmployee(ProfilePhoto profilePhoto, String email, String password, JobPosition jobPosition, String firstName, String lastName) {
        super(profilePhoto, email, password);
        this.jobPosition = jobPosition;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SystemEmployee(int userId){
        super(userId);
    }
}
