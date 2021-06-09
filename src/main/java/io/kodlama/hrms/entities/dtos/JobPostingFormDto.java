package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingFormDto {
    private String companyName;
    private String title;
    private String definition;
    private int openJobPositionQuantity;
    private LocalDate createdDate;
    private LocalDate endDate;
    private boolean isOpen;

}
