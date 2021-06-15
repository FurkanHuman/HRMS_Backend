package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobExperienceCvDto {

    private int id;
    private String companyName;
    private String companyPhone;
    private String domainMail;
    private String web_Address;
    private int positionId;
    private String position;
    private LocalDate expStartDate;
    private LocalDate expEndDate;
    private boolean state;

}
