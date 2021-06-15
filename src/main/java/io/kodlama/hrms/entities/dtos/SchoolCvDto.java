package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SchoolCvDto {
    private int id;
    private String schoolType;
    private String schoolName;
    private String webSite;
    private String avatar;
    private String description;
    private LocalDate graduation;

}
