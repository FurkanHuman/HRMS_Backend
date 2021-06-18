package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolAddDto {
    private int schoolTypeId;
    private String name;
    private String webSite;
    private String avatar;
}
