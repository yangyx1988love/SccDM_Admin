package nankai.xl.business.model;

public class FNoOrganizationWorkshopDischarge {
    private Integer wsid;

    private Integer workshopid;

    private Integer factoryid;

    private String scccode;

    private Double longitude;

    private Double latitude;

    private String productionUse;

    private Double workshopArea;

    private Double pm10Emission;

    private Double ocEmission;

    private Double pm25Emission;

    private Double ecEmission;

    private Double so2Emission;

    private Double noxEmission;

    private Double coEmission;

    private Double nh3Emission;

    private Double vocsEmission;

    public Integer getWsid() {
        return wsid;
    }

    public void setWsid(Integer wsid) {
        this.wsid = wsid;
    }

    public Integer getWorkshopid() {
        return workshopid;
    }

    public void setWorkshopid(Integer workshopid) {
        this.workshopid = workshopid;
    }

    public Integer getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Integer factoryid) {
        this.factoryid = factoryid;
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getProductionUse() {
        return productionUse;
    }

    public void setProductionUse(String productionUse) {
        this.productionUse = productionUse == null ? null : productionUse.trim();
    }

    public Double getWorkshopArea() {
        return workshopArea;
    }

    public void setWorkshopArea(Double workshopArea) {
        this.workshopArea = workshopArea;
    }

    public Double getPm10Emission() {
        return pm10Emission;
    }

    public void setPm10Emission(Double pm10Emission) {
        this.pm10Emission = pm10Emission;
    }

    public Double getOcEmission() {
        return ocEmission;
    }

    public void setOcEmission(Double ocEmission) {
        this.ocEmission = ocEmission;
    }

    public Double getPm25Emission() {
        return pm25Emission;
    }

    public void setPm25Emission(Double pm25Emission) {
        this.pm25Emission = pm25Emission;
    }

    public Double getEcEmission() {
        return ecEmission;
    }

    public void setEcEmission(Double ecEmission) {
        this.ecEmission = ecEmission;
    }

    public Double getSo2Emission() {
        return so2Emission;
    }

    public void setSo2Emission(Double so2Emission) {
        this.so2Emission = so2Emission;
    }

    public Double getNoxEmission() {
        return noxEmission;
    }

    public void setNoxEmission(Double noxEmission) {
        this.noxEmission = noxEmission;
    }

    public Double getCoEmission() {
        return coEmission;
    }

    public void setCoEmission(Double coEmission) {
        this.coEmission = coEmission;
    }

    public Double getNh3Emission() {
        return nh3Emission;
    }

    public void setNh3Emission(Double nh3Emission) {
        this.nh3Emission = nh3Emission;
    }

    public Double getVocsEmission() {
        return vocsEmission;
    }

    public void setVocsEmission(Double vocsEmission) {
        this.vocsEmission = vocsEmission;
    }
}