package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSchoolAddDto {
    private int schoolId;
    private int candidateId;
    private String description;
    private LocalDate graduation;

}
