package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceAddDto {

    private int candidateId;

    private int employerId;

    private int jobPositionId;

    private LocalDate expStartDate;

    private LocalDate expEndDate;

    private boolean state;
}
