package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.kodlama.hrms.entities.concretes.CandidateProgramingLanguage;
import io.kodlama.hrms.entities.dtos.CandidateProgramingGetDto;

public interface CandidateProgramingLanguageDao extends JpaRepository<CandidateProgramingLanguage, Integer> {

    List<CandidateProgramingLanguage> findByCandidateId(int candidateId);

    List<CandidateProgramingLanguage> getByCandidateId(int candidateId);

    @Query("select new io.kodlama.hrms.entities.dtos.CandidateProgramingGetDto"
            + " (cpl.id,cpl.comment, pl.id,pl.name) from CandidateProgramingLanguage cpl"
            + " inner join cpl.candidate c inner join cpl.programingLanguage pl where c.id=:candidateId")
    List<CandidateProgramingGetDto> getByCandidate(int candidateId);

}
