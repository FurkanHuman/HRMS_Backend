package io.kodlama.hrms.entities.dtos;

import java.time.LocalDate;

public class JobAdvertisementGetDto {

    private int jobAdvertisementId;
    private String companyName;
    private String web_Address;
    private String companyPhone;
    private String domainMail;
    private int positionId;
    private String position;
    private int cityId;
    private String cityName;
    private String title;
    private String definition;
    private int positionQuantity;
    private int minSalary;
    private int maxSalary;
    private LocalDate endDate;
    private boolean isOpen;

    public JobAdvertisementGetDto() {
    }

    public JobAdvertisementGetDto(int jobAdvertisementId, String companyName, String web_Address, String companyPhone,
            String domainMail, int positionId, String position, int cityId, String cityName, String title,
            String definition, int positionQuantity, int minSalary, int maxSalary, LocalDate endDate, boolean isOpen) {
        this.jobAdvertisementId = jobAdvertisementId;
        this.companyName = companyName;
        this.web_Address = web_Address;
        this.companyPhone = companyPhone;
        this.domainMail = domainMail;
        this.positionId = positionId;
        this.position = position;
        this.cityId = cityId;
        this.cityName = cityName;
        this.title = title;
        this.definition = definition;
        this.positionQuantity = positionQuantity;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.endDate = endDate;
        this.isOpen = isOpen;
    }

    public int getJobAdvertisementId() {
        return jobAdvertisementId;
    }

    public void setJobAdvertisementId(int jobAdvertisementId) {
        this.jobAdvertisementId = jobAdvertisementId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWeb_Address() {
        return web_Address;
    }

    public void setWeb_Address(String web_Address) {
        this.web_Address = web_Address;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getDomainMail() {
        return domainMail;
    }

    public void setDomainMail(String domainMail) {
        this.domainMail = domainMail;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getPositionQuantity() {
        return positionQuantity;
    }

    public void setPositionQuantity(int positionQuantity) {
        this.positionQuantity = positionQuantity;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

}
