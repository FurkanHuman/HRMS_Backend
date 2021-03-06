package io.kodlama.hrms.entities.dtos;

import java.util.List;

import io.kodlama.hrms.entities.concretes.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvGetDto {

    private CandidateCvDto candidate;
    private Photo photos;
    private List<SchoolCvDto> schools;
    private List<LanguageCvDto> languages;
    private List<ProgramingLanguageCvDto> programingLanguage;
    private List<JobExperienceCvDto> jobExperiences;
}
