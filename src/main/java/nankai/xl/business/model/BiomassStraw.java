package nankai.xl.business.model;

public class BiomassStraw {
    private Integer id;

    private String countyId;

    private String sccCode;

    private String sourceDescrip;

    private String crops;

    private Double cropsOutput;

    private Double grassValleyRatio;

    private Double openBurningRatio;

    private Double burningRatio;

    private String note;

    private String year;

    private Double pm10Emission;

    private Double pm25Emission;

    private Double coEmission;

    private Double vocEmission;

    private Double pmEmission;

    private Double so2Emission;

    private Double noxEmission;

    private Double nh3Emission;

    private Double ocEmission;

    private Double bcEmission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCrops() {
        return crops;
    }

    public void setCrops(String crops) {
        this.crops = crops == null ? null : crops.trim();
    }

    public Double getCropsOutput() {
        return cropsOutput;
    }

    public void setCropsOutput(Double cropsOutput) {
        this.cropsOutput = cropsOutput;
    }

    public Double getGrassValleyRatio() {
        return grassValleyRatio;
    }

    public void setGrassValleyRatio(Double grassValleyRatio) {
        this.grassValleyRatio = grassValleyRatio;
    }

    public Double getOpenBurningRatio() {
        return openBurningRatio;
    }

    public void setOpenBurningRatio(Double openBurningRatio) {
        this.openBurningRatio = openBurningRatio;
    }

    public Double getBurningRatio() {
        return burningRatio;
    }

    public void setBurningRatio(Double burningRatio) {
        this.burningRatio = burningRatio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
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

    public Double getPmEmission() {
        return pmEmission;
    }

    public void setPmEmission(Double pmEmission) {
        this.pmEmission = pmEmission;
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
}