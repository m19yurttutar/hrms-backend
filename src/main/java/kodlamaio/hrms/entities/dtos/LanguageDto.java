package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class LanguageDto implements Dto {
    private String language;
    private int languageLevel;
}
