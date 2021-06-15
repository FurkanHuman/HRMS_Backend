package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCvDto {

    private int id;
    private String language;
    private int level;
    private String levelName;
    private String description;

}
