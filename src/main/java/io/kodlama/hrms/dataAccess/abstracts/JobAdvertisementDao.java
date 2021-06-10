package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.kodlama.hrms.entities.concretes.jobAdvertisement;
import io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto;

public interface JobAdvertisementDao extends JpaRepository<jobAdvertisement, Integer> {

    @Query("select new io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto(ja.id,e.companyName,e.web_Address,e.companyPhone,e.domainMail,jp.id,jp.position, c.id,c.name, ja.title,ja.definition,ja.positionQuantity,ja.minSalary,ja.maxSalary, ja.endDate,ja.isOpen) from jobAdvertisement ja Inner join ja.employer e Inner join ja.jobPosition jp Inner join ja.city c where ja.id=:jobAdvertisementId and ja.isOpen=true")
    List<JobAdvertisementGetDto> getJobAdvertisement(int jobAdvertisementId);

    @Query("select new io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto(ja.id,e.companyName,e.web_Address,e.companyPhone,e.domainMail,jp.id,jp.position, c.id,c.name, ja.title,ja.definition,ja.positionQuantity,ja.minSalary,ja.maxSalary, ja.endDate,ja.isOpen) from jobAdvertisement ja Inner join ja.employer e Inner join ja.jobPosition jp Inner join ja.city c where jp.id=:jobPositionId and ja.isOpen=true")
    List<JobAdvertisementGetDto> getJobAdvertisementByjobPositionId(int jobPositionId);

    @Query("select new io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto(ja.id,e.companyName,e.web_Address,e.companyPhone,e.domainMail,jp.id,jp.position, c.id,c.name, ja.title,ja.definition,ja.positionQuantity,ja.minSalary,ja.maxSalary, ja.endDate,ja.isOpen) from jobAdvertisement ja Inner join ja.employer e Inner join ja.jobPosition jp Inner join ja.city c where c.id=:cityId and ja.isOpen=true")
    List<JobAdvertisementGetDto> getJobAdvertisementByCityId(int cityId);

    @Query("select new io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto(ja.id,e.companyName,e.web_Address,e.companyPhone,e.domainMail,jp.id,jp.position, c.id,c.name, ja.title,ja.definition,ja.positionQuantity,ja.minSalary,ja.maxSalary, ja.endDate,ja.isOpen) from jobAdvertisement ja Inner join ja.employer e Inner join ja.jobPosition jp Inner join ja.city c where ja.isOpen=true")
    List<JobAdvertisementGetDto> getAllJobAdvertisement();

    // @Query("select new
    // io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto(ja.id,e.companyName,e.web_Address,e.companyPhone,e.domainMail,jp.id,jp.position,
    // c.id,c.name,
    // ja.title,ja.definition,ja.positionQuantity,ja.minSalary,ja.maxSalary,
    // ja.endDate,ja.isOpen) from jobAdvertisement ja Inner join ja.employer e Inner
    // join ja.jobPosition jp Inner join ja.city c where ja.isOpen=true and
    // ja.endDate between :startDate and :endDate order by ja.endDate")
    // List<JobAdvertisementGetDto> getAllJobAdvertisementByDateRange(Date
    // startDate, Date endDate);

    /*
     * int jobAdvertisementId, String companyName, String web_Address, String
     * companyPhone, String domainMail, int positionId, String position, int cityId,
     * String cityName, String title, String definition, int positionQuantity, int
     * minSalary, int maxSalary, LocalDate endDate, boolean isOpen
     */
}
