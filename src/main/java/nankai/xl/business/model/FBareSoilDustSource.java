package nankai.xl.business.model;

public class FBareSoilDustSource {
    private Integer bareSoilid;

    private String scccode;

    private Integer factoryid;

    private Double bareSoilArea;

    private Double pm25Emission;

    private Double pm10Emission;

    private Double ocEmission;

    private Double bcEmission;

    public Integer getBareSoilid() {
        return bareSoilid;
    }

    public void setBareSoilid(Integer bareSoilid) {
        this.bareSoilid = bareSoilid;
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public Integer getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Integer factoryid) {
        this.factoryid = factoryid;
    }

    public Double getBareSoilArea() {
        return bareSoilArea;
    }

    public void setBareSoilArea(Double bareSoilArea) {
        this.bareSoilArea = bareSoilArea;
    }

    public Double getPm25Emission() {
        return pm25Emission;
    }

    public void setPm25Emission(Double pm25Emission) {
        this.pm25Emission = pm25Emission;
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

    public Double getBcEmission() {
        return bcEmission;
    }

    public void setBcEmission(Double bcEmission) {
        this.bcEmission = bcEmission;
    }
}