package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class ConnectionDto implements Dto {
    private String githubAccountLink;
    private String linkedinAccountLink;
}
