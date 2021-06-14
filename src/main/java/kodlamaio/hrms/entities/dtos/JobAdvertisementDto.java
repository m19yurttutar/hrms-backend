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
    private JobPosition jobPosition;
    private City city;
    private WorkingType workingType;
    private WorkingTime workingTime;
    private String jobDescription;
    private float minSalary;
    private float maxSalary;
    private int vacantPositionCount;
    private String applicationDeadline;
}
