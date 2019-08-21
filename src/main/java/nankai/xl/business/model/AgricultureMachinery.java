package nankai.xl.business.model;

public class AgricultureMachinery {
    private Integer id;

    private String year;

    private String countyId;

    private String sccCode;

    private String sourceDescrip;

    private String fuelType;

    private Integer holdings;

    private Double fuelUsage;

    private Double fuelAnnualUsage;

    private Double annalAverageMilage;

    private Double fuelSulfurContent;

    private Double pm10Emission;

    private Double pm25Emission;

    private Double vocsEmission;

    private Double coEmission;

    private Double noxEmission;

    private Double so2Emission;

    private Double bcEmission;

    private Double ocEmission;

    private Double nh3Emission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
    }

    public String getSccCode() {
        return sccCode;
    }

    public void setSccCode(String sccCode) {
        this.sccCode = sccCode == null ? null : sccCode.trim();
    }

    public String getSourceDescrip() {
        return sourceDescrip;
    }

    public void setSourceDescrip(String sourceDescrip) {
        this.sourceDescrip = sourceDescrip == null ? null : sourceDescrip.trim();
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType == null ? null : fuelType.trim();
    }

    public Integer getHoldings() {
        return holdings;
    }

    public void setHoldings(Integer holdings) {
        this.holdings = holdings;
    }

    public Double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(Double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public Double getFuelAnnualUsage() {
        return fuelAnnualUsage;
    }

    public void setFuelAnnualUsage(Double fuelAnnualUsage) {
        this.fuelAnnualUsage = fuelAnnualUsage;
    }

    public Double getAnnalAverageMilage() {
        return annalAverageMilage;
    }

    public void setAnnalAverageMilage(Double annalAverageMilage) {
        this.annalAverageMilage = annalAverageMilage;
    }

    public Double getFuelSulfurContent() {
        return fuelSulfurContent;
    }

    public void setFuelSulfurContent(Double fuelSulfurContent) {
        this.fuelSulfurContent = fuelSulfurContent;
    }

    public Double getPm10Emission() {
        return pm10Emission;
    }

    public void setPm10Emission(Double pm10Emission) {
        this.pm10Emission = pm10Emission;
    }

    public Double getPm25Emission() {
        return pm25Emission;
    }

    public void setPm25Emission(Double pm25Emission) {
        this.pm25Emission = pm25Emission;
    }

    public Double getVocsEmission() {
        return vocsEmission;
    }

    public void setVocsEmission(Double vocsEmission) {
        this.vocsEmission = vocsEmission;
    }

    public Double getCoEmission() {
        return coEmission;
    }

    public void setCoEmission(Double coEmission) {
        this.coEmission = coEmission;
    }

    public Double getNoxEmission() {
        return noxEmission;
    }

    public void setNoxEmission(Double noxEmission) {
        this.noxEmission = noxEmission;
    }

    public Double getSo2Emission() {
        return so2Emission;
    }

    public void setSo2Emission(Double so2Emission) {
        this.so2Emission = so2Emission;
    }

    public Double getBcEmission() {
        return bcEmission;
    }

    public void setBcEmission(Double bcEmission) {
        this.bcEmission = bcEmission;
    }

    public Double getOcEmission() {
        return ocEmission;
    }

    public void setOcEmission(Double ocEmission) {
        this.ocEmission = ocEmission;
    }

    public Double getNh3Emission() {
        return nh3Emission;
    }

    public void setNh3Emission(Double nh3Emission) {
        this.nh3Emission = nh3Emission;
    }
}