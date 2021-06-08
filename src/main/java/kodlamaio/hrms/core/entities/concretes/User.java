package kodlamaio.hrms.core.entities.concretes;

import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_photo_id", referencedColumnName = "id")
    private ProfilePhoto profilePhoto;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User(ProfilePhoto profilePhoto, String email, String password) {
        this.profilePhoto = profilePhoto;
        this.email = email;
        this.password = password;
    }
}
