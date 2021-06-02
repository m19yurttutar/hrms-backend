package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class WorkExperienceDto implements Dto{
    private String companyName;
    private String positionName;
    private int startYear;
    private int quitYear;
}
