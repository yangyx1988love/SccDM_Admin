package nankai.xl.business.model;

public class ScatteredCoal {
    private Integer id;

    private String sccCode;

    private String year;

    private String countyId;

    private String activityLevel;

    private String fuelMeteringUnit;

    private Double activityLevelNum;

    private String controlMeasure;

    private Double sulfurContent;

    private Double ashContent;

    private Double pm25Emission;

    private Double pm10Emission;

    private Double coEmission;

    private Double vocEmission;

    private Double so2Emission;

    private Double noxEmission;

    private Double nh3Emission;

    private Double ocEmission;

    private Double bcEmission;

    private String sourceDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSccCode() {
        return sccCode;
    }

    public void setSccCode(String sccCode) {
        this.sccCode = sccCode == null ? null : sccCode.trim();
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

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel == null ? null : activityLevel.trim();
    }

    public String getFuelMeteringUnit() {
        return fuelMeteringUnit;
    }

    public void setFuelMeteringUnit(String fuelMeteringUnit) {
        this.fuelMeteringUnit = fuelMeteringUnit == null ? null : fuelMeteringUnit.trim();
    }

    public Double getActivityLevelNum() {
        return activityLevelNum;
    }

    public void setActivityLevelNum(Double activityLevelNum) {
        this.activityLevelNum = activityLevelNum;
    }

    public String getControlMeasure() {
        return controlMeasure;
    }

    public void setControlMeasure(String controlMeasure) {
        this.controlMeasure = controlMeasure == null ? null : controlMeasure.trim();
    }

    public Double getSulfurContent() {
        return sulfurContent;
    }

    public void setSulfurContent(Double sulfurContent) {
        this.sulfurContent = sulfurContent;
    }

    public Double getAshContent() {
        return ashContent;
    }

    public void setAshContent(Double ashContent) {
        this.ashContent = ashContent;
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

    public Double getCoEmission() {
        return coEmission;
    }

    public void setCoEmission(Double coEmission) {
        this.coEmission = coEmission;
    }

    public Double getVocEmission() {
        return vocEmission;
    }

    public void setVocEmission(Double vocEmission) {
        this.vocEmission = vocEmission;
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

    public Double getNh3Emission() {
        return nh3Emission;
    }

    public void setNh3Emission(Double nh3Emission) {
        this.nh3Emission = nh3Emission;
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

    public String getSourceDescription() {
        return sourceDescription;
    }

    public void setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription == null ? null : sourceDescription.trim();
    }
}