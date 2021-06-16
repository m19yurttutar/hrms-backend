package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.WorkingTime;
import kodlamaio.hrms.entities.concretes.WorkingType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobAdvertisementDto implements Dto {
    private Integer jobPositionId;
    private Integer cityId;
    private Integer workingTypeId;
    private Integer workingTimeId;
    private String jobSummary;
    private String jobDescription;
    private float minSalary;
    private float maxSalary;
    private Integer vacantPositionCount;
    private String applicationDeadline;
}
