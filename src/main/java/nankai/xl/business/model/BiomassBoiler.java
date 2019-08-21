package nankai.xl.business.model;

public class BiomassBoiler {
    private Integer id;

    private String sccCode;

    private Integer comId;

    private String sourceDescrip;

    private Integer boilerNo;

    private String fuelType;

    private Double fuelConsumption;

    private String dustRemoveTech;

    private Double pm10RemoveRatio;

    private Double pm25RemoveRatio;

    private String desulphurRemoveTech;

    private Double so2RemoveRatio;

    private String denitrificRemoveTech;

    private Double noxRemoveRatio;

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

    public String getSccCode() {
        return sccCode;
    }

    public void setSccCode(String sccCode) {
        this.sccCode = sccCode == null ? null : sccCode.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getSourceDescrip() {
        return sourceDescrip;
    }

    public void setSourceDescrip(String sourceDescrip) {
        this.sourceDescrip = sourceDescrip == null ? null : sourceDescrip.trim();
    }

    public Integer getBoilerNo() {
        return boilerNo;
    }

    public void setBoilerNo(Integer boilerNo) {
        this.boilerNo = boilerNo;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType == null ? null : fuelType.trim();
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getDustRemoveTech() {
        return dustRemoveTech;
    }

    public void setDustRemoveTech(String dustRemoveTech) {
        this.dustRemoveTech = dustRemoveTech == null ? null : dustRemoveTech.trim();
    }

    public Double getPm10RemoveRatio() {
        return pm10RemoveRatio;
    }

    public void setPm10RemoveRatio(Double pm10RemoveRatio) {
        this.pm10RemoveRatio = pm10RemoveRatio;
    }

    public Double getPm25RemoveRatio() {
        return pm25RemoveRatio;
    }

    public void setPm25RemoveRatio(Double pm25RemoveRatio) {
        this.pm25RemoveRatio = pm25RemoveRatio;
    }

    public String getDesulphurRemoveTech() {
        return desulphurRemoveTech;
    }

    public void setDesulphurRemoveTech(String desulphurRemoveTech) {
        this.desulphurRemoveTech = desulphurRemoveTech == null ? null : desulphurRemoveTech.trim();
    }

    public Double getSo2RemoveRatio() {
        return so2RemoveRatio;
    }

    public void setSo2RemoveRatio(Double so2RemoveRatio) {
        this.so2RemoveRatio = so2RemoveRatio;
    }

    public String getDenitrificRemoveTech() {
        return denitrificRemoveTech;
    }

    public void setDenitrificRemoveTech(String denitrificRemoveTech) {
        this.denitrificRemoveTech = denitrificRemoveTech == null ? null : denitrificRemoveTech.trim();
    }

    public Double getNoxRemoveRatio() {
        return noxRemoveRatio;
    }

    public void setNoxRemoveRatio(Double noxRemoveRatio) {
        this.noxRemoveRatio = noxRemoveRatio;
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