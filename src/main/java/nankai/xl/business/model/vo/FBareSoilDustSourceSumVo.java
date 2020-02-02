package nankai.xl.business.model.vo;

import nankai.xl.business.model.FBareSoilDustSource;

public class FBareSoilDustSourceSumVo extends FBareSoilDustSource {
    private String year;

    private String factoryNo;

    private String factoryName;

    private String countyName;

    private String cityName;

    private String countyId;

    private String cityCode;

    private Integer status;

    private String statusdec;

    private String sccDec;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusdec() {
        return statusdec;
    }

    public void setStatusdec(String statusdec) {
        this.statusdec = statusdec;
    }

    public String getSccDec() {
        return sccDec;
    }

    public void setSccDec(String sccDec) {
        this.sccDec = sccDec;
    }
}
