package nankai.xl.business.model.vo;

import nankai.xl.business.model.Kiln;

public class KilnSumVo extends Kiln {

    private String year;

    private String factoryNo;

    private String factoryName;

    private String countyName;

    private String cityName;

    private String countyId;

    private String cityCode;

    private Integer status;

    private String statusdec;

    private Integer factoryId;

    private String exfMaterial;

    private Double smokeOuta;

    private String sccDec;

    private String sulphurremoveDec;

    private String dustremoveDec;

    private String nitreremoveDec;

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

    public String getStatusdec() {
        return statusdec;
    }

    public void setStatusdec(String statusdec) {
        this.statusdec = statusdec;
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

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getExfMaterial() {
        return exfMaterial;
    }

    public void setExfMaterial(String exfMaterial) {
        this.exfMaterial = exfMaterial;
    }

    public Double getSmokeOuta() {
        return smokeOuta;
    }

    public void setSmokeOuta(Double smokeOuta) {
        this.smokeOuta = smokeOuta;
    }

    public String getSccDec() {
        return sccDec;
    }

    public void setSccDec(String sccDec) {
        this.sccDec = sccDec;
    }

    public String getSulphurremoveDec() {
        return sulphurremoveDec;
    }

    public void setSulphurremoveDec(String sulphurremoveDec) {
        this.sulphurremoveDec = sulphurremoveDec;
    }

    public String getDustremoveDec() {
        return dustremoveDec;
    }

    public void setDustremoveDec(String dustremoveDec) {
        this.dustremoveDec = dustremoveDec;
    }

    public String getNitreremoveDec() {
        return nitreremoveDec;
    }

    public void setNitreremoveDec(String nitreremoveDec) {
        this.nitreremoveDec = nitreremoveDec;
    }
}
