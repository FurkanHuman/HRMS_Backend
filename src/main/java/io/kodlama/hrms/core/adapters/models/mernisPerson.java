package io.kodlama.hrms.core.adapters.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class mernisPerson {
    private String name;
    private String lastName;
    private String identificationNumber;
    private Date birthYear;
}
