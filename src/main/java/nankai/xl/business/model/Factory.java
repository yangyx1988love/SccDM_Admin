package nankai.xl.business.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Factory {

    private Integer factoryId;

    private String factoryNo;

    private String legalperson;

    private String factoryName;

    private String factoryUsedname;

    private String factorySize;

    private String countyId;

    private String industryBigid;

    private String industryId;

    private String address;

    private Double powerAmount;

    private String addressRegister;

    private String countyidRegister;

    private Double factoryLongitude;

    private Double factoryLatitude;

    private String sourceType;

    private String year;

    private Date lastChangedTime;

    private Date auditTime;

    private Date fillingTime;

    private Integer yearDays;

    private Integer daysHours;

    private Double totalOutput;

    private Integer status;

    private String principalName;

    private String principalPhone;

    private String principalMobile;

    private String principalEmail;

    private Double lat1;

    private Double lon1;

    private Double lat2;

    private Double lon2;

    private Double lat3;

    private Double lon3;

    private Double lat4;

    private Double lon4;

    private Double lat5;

    private Double lon5;

    private Double lat6;

    private Double lon6;

    private Double lat7;

    private Double lon7;

    private Integer exhaustCount;

    private Integer boilerCount;

    private Integer kilnCount;

    private Integer deviceCount;

    private Integer deviceProductCount;

    private Integer deviceRawCount;

    private Integer rongjiProductCount;

    private Integer rongjiRawCount;

    private Integer feiqiCount;

    private Integer soilDustCount;

    private Integer conDustCount;

    private Integer roadDustCount;

    private Integer yardDustCount;

    private Integer noOrgWorkCount;

    private Boolean flag;

    private Integer important;

    private String note;

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson == null ? null : legalperson.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryUsedname() {
        return factoryUsedname;
    }

    public void setFactoryUsedname(String factoryUsedname) {
        this.factoryUsedname = factoryUsedname == null ? null : factoryUsedname.trim();
    }

    public String getFactorySize() {
        return factorySize;
    }

    public void setFactorySize(String factorySize) {
        this.factorySize = factorySize == null ? null : factorySize.trim();
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
    }

    public String getIndustryBigid() {
        return industryBigid;
    }

    public void setIndustryBigid(String industryBigid) {
        this.industryBigid = industryBigid == null ? null : industryBigid.trim();
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getPowerAmount() {
        return powerAmount;
    }

    public void setPowerAmount(Double powerAmount) {
        this.powerAmount = powerAmount;
    }

    public String getAddressRegister() {
        return addressRegister;
    }

    public void setAddressRegister(String addressRegister) {
        this.addressRegister = addressRegister == null ? null : addressRegister.trim();
    }

    public String getCountyidRegister() {
        return countyidRegister;
    }

    public void setCountyidRegister(String countyidRegister) {
        this.countyidRegister = countyidRegister == null ? null : countyidRegister.trim();
    }

    public Double getFactoryLongitude() {
        return factoryLongitude;
    }

    public void setFactoryLongitude(Double factoryLongitude) {
        this.factoryLongitude = factoryLongitude;
    }

    public Double getFactoryLatitude() {
        return factoryLatitude;
    }

    public void setFactoryLatitude(Double factoryLatitude) {
        this.factoryLatitude = factoryLatitude;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Date getLastChangedTime() {
        return lastChangedTime;
    }

    public void setLastChangedTime(Date lastChangedTime) {
        this.lastChangedTime = lastChangedTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getFillingTime() {
        return fillingTime;
    }

    public void setFillingTime(Date fillingTime) {
        this.fillingTime = fillingTime;
    }

    public Integer getYearDays() {
        return yearDays;
    }

    public void setYearDays(Integer yearDays) {
        this.yearDays = yearDays;
    }

    public Integer getDaysHours() {
        return daysHours;
    }

    public void setDaysHours(Integer daysHours) {
        this.daysHours = daysHours;
    }

    public Double getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Double totalOutput) {
        this.totalOutput = totalOutput;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone == null ? null : principalPhone.trim();
    }

    public String getPrincipalMobile() {
        return principalMobile;
    }

    public void setPrincipalMobile(String principalMobile) {
        this.principalMobile = principalMobile == null ? null : principalMobile.trim();
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail == null ? null : principalEmail.trim();
    }

    public Double getLat1() {
        return lat1;
    }

    public void setLat1(Double lat1) {
        this.lat1 = lat1;
    }

    public Double getLon1() {
        return lon1;
    }

    public void setLon1(Double lon1) {
        this.lon1 = lon1;
    }

    public Double getLat2() {
        return lat2;
    }

    public void setLat2(Double lat2) {
        this.lat2 = lat2;
    }

    public Double getLon2() {
        return lon2;
    }

    public void setLon2(Double lon2) {
        this.lon2 = lon2;
    }

    public Double getLat3() {
        return lat3;
    }

    public void setLat3(Double lat3) {
        this.lat3 = lat3;
    }

    public Double getLon3() {
        return lon3;
    }

    public void setLon3(Double lon3) {
        this.lon3 = lon3;
    }

    public Double getLat4() {
        return lat4;
    }

    public void setLat4(Double lat4) {
        this.lat4 = lat4;
    }

    public Double getLon4() {
        return lon4;
    }

    public void setLon4(Double lon4) {
        this.lon4 = lon4;
    }

    public Double getLat5() {
        return lat5;
    }

    public void setLat5(Double lat5) {
        this.lat5 = lat5;
    }

    public Double getLon5() {
        return lon5;
    }

    public void setLon5(Double lon5) {
        this.lon5 = lon5;
    }

    public Double getLat6() {
        return lat6;
    }

    public void setLat6(Double lat6) {
        this.lat6 = lat6;
    }

    public Double getLon6() {
        return lon6;
    }

    public void setLon6(Double lon6) {
        this.lon6 = lon6;
    }

    public Double getLat7() {
        return lat7;
    }

    public void setLat7(Double lat7) {
        this.lat7 = lat7;
    }

    public Double getLon7() {
        return lon7;
    }

    public void setLon7(Double lon7) {
        this.lon7 = lon7;
    }

    public Integer getExhaustCount() {
        return exhaustCount;
    }

    public void setExhaustCount(Integer exhaustCount) {
        this.exhaustCount = exhaustCount;
    }

    public Integer getBoilerCount() {
        return boilerCount;
    }

    public void setBoilerCount(Integer boilerCount) {
        this.boilerCount = boilerCount;
    }

    public Integer getKilnCount() {
        return kilnCount;
    }

    public void setKilnCount(Integer kilnCount) {
        this.kilnCount = kilnCount;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getDeviceProductCount() {
        return deviceProductCount;
    }

    public void setDeviceProductCount(Integer deviceProductCount) {
        this.deviceProductCount = deviceProductCount;
    }

    public Integer getDeviceRawCount() {
        return deviceRawCount;
    }

    public void setDeviceRawCount(Integer deviceRawCount) {
        this.deviceRawCount = deviceRawCount;
    }

    public Integer getRongjiProductCount() {
        return rongjiProductCount;
    }

    public void setRongjiProductCount(Integer rongjiProductCount) {
        this.rongjiProductCount = rongjiProductCount;
    }

    public Integer getRongjiRawCount() {
        return rongjiRawCount;
    }

    public void setRongjiRawCount(Integer rongjiRawCount) {
        this.rongjiRawCount = rongjiRawCount;
    }

    public Integer getFeiqiCount() {
        return feiqiCount;
    }

    public void setFeiqiCount(Integer feiqiCount) {
        this.feiqiCount = feiqiCount;
    }

    public Integer getSoilDustCount() {
        return soilDustCount;
    }

    public void setSoilDustCount(Integer soilDustCount) {
        this.soilDustCount = soilDustCount;
    }

    public Integer getConDustCount() {
        return conDustCount;
    }

    public void setConDustCount(Integer conDustCount) {
        this.conDustCount = conDustCount;
    }

    public Integer getRoadDustCount() {
        return roadDustCount;
    }

    public void setRoadDustCount(Integer roadDustCount) {
        this.roadDustCount = roadDustCount;
    }

    public Integer getYardDustCount() {
        return yardDustCount;
    }

    public void setYardDustCount(Integer yardDustCount) {
        this.yardDustCount = yardDustCount;
    }

    public Integer getNoOrgWorkCount() {
        return noOrgWorkCount;
    }

    public void setNoOrgWorkCount(Integer noOrgWorkCount) {
        this.noOrgWorkCount = noOrgWorkCount;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getImportant() {
        return important;
    }

    public void setImportant(Integer important) {
        this.important = important;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}