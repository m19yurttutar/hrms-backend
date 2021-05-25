package kodlamaio.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "job_seekers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_year")
    private int birthYear;
}
