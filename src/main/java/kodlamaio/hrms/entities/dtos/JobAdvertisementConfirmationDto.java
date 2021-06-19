package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class JobAdvertisementConfirmationDto {
    private int jobAdvertisementId;
    private boolean confirmationStatus;
}
