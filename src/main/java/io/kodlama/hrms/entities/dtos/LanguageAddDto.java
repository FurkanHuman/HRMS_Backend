package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageAddDto {
    private int candidateId;
    private int languageLevelId;
    private String languageName;
    private String description;
}
