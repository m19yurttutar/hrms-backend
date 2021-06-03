package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "profile_photos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name = "default_profile_photo";

    @Column(name = "url")
    private String url = "https://res.cloudinary.com/dxahez1o6/image/upload/v1622738472/sbcfwui0lb3cbjamww9p.jpg";

    @Column(name = "public_id")
    private String publicId = "sbcfwui0lb3cbjamww9p";

    @JsonIgnore
    @OneToOne(mappedBy = "profilePhoto")
    private CurriculumVitae curriculumVitae;

    public ProfilePhoto(int id, String name, String url, String publicId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.publicId = publicId;
    }
}
