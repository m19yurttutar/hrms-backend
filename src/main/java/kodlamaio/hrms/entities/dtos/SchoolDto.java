package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class SchoolDto implements Dto {
    private String schoolName;
    private String departmentName;
    private int startYear;
    private int graduationYear;
}
