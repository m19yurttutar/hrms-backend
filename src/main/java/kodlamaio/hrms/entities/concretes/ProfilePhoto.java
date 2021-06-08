package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.core.entities.concretes.User;
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
    private String url = "https://res.cloudinary.com/dxahez1o6/image/upload/v1623099446/mqkyb7zxgnmnwwnlxhwf.jpg";

    @Column(name = "public_id")
    private String publicId = "mqkyb7zxgnmnwwnlxhwf";

    @JsonIgnore
    @OneToOne(mappedBy = "profilePhoto")
    private User user;

    public ProfilePhoto(int id, String name, String url, String publicId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.publicId = publicId;
    }
}
