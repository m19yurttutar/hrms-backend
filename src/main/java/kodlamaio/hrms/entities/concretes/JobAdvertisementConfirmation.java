package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_advertisement_confirmations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SystemEmployee systemEmployee;

    @Column(name = "confirmation_status")
    private boolean confirmationStatus = false;

    @Column(name = "edit_date")
    private LocalDate editDate;

    @JsonIgnore
    @OneToOne(mappedBy = "jobAdvertisementConfirmation")
    private JobAdvertisement jobAdvertisement;

    public JobAdvertisementConfirmation(int id, SystemEmployee systemEmployee, boolean confirmationStatus, LocalDate editDate) {
        this.id = id;
        this.systemEmployee = systemEmployee;
        this.confirmationStatus = confirmationStatus;
        this.editDate = editDate;
    }
}
