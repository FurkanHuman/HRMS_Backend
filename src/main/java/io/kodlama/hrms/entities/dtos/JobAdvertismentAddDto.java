package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertismentAddDto {

    private int companyId;
    private String title;
    private String definition;
    private int jobPositionId;
    private int city;
    private int openJobPositionQuantity;
    private int minSalaries;
    private int maxSalaries;
    private LocalDate endDate;
    private boolean isOpen;
}
