package nankai.xl.business.model.vo;

public class FactoryVo {

    private String factoryNo1;

    private String factoryName;

    private String countyName;

    private String cityName;

    private Double factoryLongitude;

    private Double factoryLatitude;

    public String getFactoryNo1() {
        return factoryNo1;
    }

    public void setFactoryNo1(String factoryNo1) {
        this.factoryNo1 = factoryNo1 == null ? null : factoryNo1.trim();
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

}