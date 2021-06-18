package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgramingLanguageCvDto {
    private int id;
    private String programingLanguage;
    private String comment;
}
