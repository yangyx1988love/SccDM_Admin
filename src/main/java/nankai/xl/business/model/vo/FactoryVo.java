package nankai.xl.business.model.vo;

import nankai.xl.business.model.Factory;

public class FactoryVo extends Factory {
    private String countyName;

    private String cityCode;

    private String cityName;

    private String registerCity;

    private String statusdec;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegisterCity() {
        return registerCity;
    }

    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity;
    }

    public String getStatusdec() {
        return statusdec;
    }

    public void setStatusdec(String statusdec) {
        this.statusdec = statusdec;
    }
}
