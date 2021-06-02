package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobAdvertisementDto implements Dto {
    private JobPosition jobPosition;
    private String jobDescription;
    private City city;
    private int minSalary;
    private int maxSalary;
    private int vacantPositionCount;
    private LocalDate applicationDeadline;
}
