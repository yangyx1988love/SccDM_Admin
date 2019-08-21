package nankai.xl.business.model.vo;

public class FactoryQuery {
    private Integer factoryId;

    private String factoryName;

    private String countyId;

    private String factoryNo1;

    private String countyCity;

    private Integer status;

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryNo1() {
        return factoryNo1;
    }

    public void setFactoryNo1(String factoryNo1) {
        this.factoryNo1 = factoryNo1;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }
    public String getCountyCity() {
        return countyCity;
    }

    public void setCountyCity(String countyCity) {
        this.countyCity = countyCity;
    }
}