package nankai.xl.business.model.vo;

import nankai.xl.business.model.DeviceRaw;

public class DeviceRawSumVo extends DeviceRaw {
    private String year;

    private String factoryNo;

    private String factoryName;

    private String countyName;

    private String cityName;

    private String countyId;

    private String cityCode;

    private Integer status;

    private String statusdec;

    private Integer deviceId;

    private String deviceName;

    private String deviceFlow;

    private Double practicalPower;

    private Integer yearrunDays;

    private String designUnit;

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

    @Override
    public Integer getDeviceId() {
        return deviceId;
    }

    @Override
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceFlow() {
        return deviceFlow;
    }

    public void setDeviceFlow(String deviceFlow) {
        this.deviceFlow = deviceFlow;
    }

    public Double getPracticalPower() {
        return practicalPower;
    }

    public void setPracticalPower(Double practicalPower) {
        this.practicalPower = practicalPower;
    }

    public Integer getYearrunDays() {
        return yearrunDays;
    }

    public void setYearrunDays(Integer yearrunDays) {
        this.yearrunDays = yearrunDays;
    }

    public String getDesignUnit() {
        return designUnit;
    }

    public void setDesignUnit(String designUnit) {
        this.designUnit = designUnit;
    }

    public String getSccDec() {
        return sccDec;
    }

    public void setSccDec(String sccDec) {
        this.sccDec = sccDec;
    }
}
