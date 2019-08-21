package nankai.xl.business.model.vo;

import java.util.Date;

public class FactoryResult {
    private Integer factoryId;

    private String factoryNo1;

    private String factoryNo2;

    private String factoryName;

    private String countyName;

    private String countyId;

    private Double factoryLongitude;

    private Double factoryLatitude;

    private String sourceType;

    private String year;

    private String cityName;

    private String statusdec;


    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }


    public String getFactoryNo1() {
        return factoryNo1;
    }

    public void setFactoryNo1(String factoryNo1) {
        this.factoryNo1 = factoryNo1 == null ? null : factoryNo1.trim();
    }

    public String getFactoryNo2() {
        return factoryNo2;
    }

    public void setFactoryNo2(String factoryNo2) {
        this.factoryNo2 = factoryNo2 == null ? null : factoryNo2.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getStatusdec() {
        return statusdec;
    }

    public void setStatusdec(String statusdec) {
        this.statusdec = statusdec == null ? null : statusdec.trim();
    }

}