package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CandidateProgramingGetDto {
    private int id;
    private String comment;
    private int programingLanguageId;
    private String name;

}
