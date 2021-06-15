package io.kodlama.hrms.entities.dtos;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidateCvDto {

    private int id;
    private String name;
    private String surName;
    private Date birthDate;
    private String eMail;
    private List<String> photo;

}
