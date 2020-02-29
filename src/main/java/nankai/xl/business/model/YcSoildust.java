package nankai.xl.business.model;

public class YcSoildust {
    private Integer sdId;

    private String scccode;

    private String countyId;

    private String sdYear;

    private String sdTakemeasures;

    private String sdUtype;

    private String sdSoiltype;

    private Double sdArea;

    private Double soilindexpm25;

    private Double soilindexpm10;

    private Double surindex;

    private Double noindex;

    private Double pindex;

    private Double pm25Emission;

    private Double pm10Emission;

    private Double vocEmission;

    private Double nh3Emission;

    private Double so2Emission;

    private Double coEmission;

    private Double ocEmission;

    private Double bcEmission;

    private Double noxEmission;

    private String sccDescribe;

    private Integer flag;

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
    }

    public String getSdYear() {
        return sdYear;
    }

    public void setSdYear(String sdYear) {
        this.sdYear = sdYear == null ? null : sdYear.trim();
    }

    public String getSdTakemeasures() {
        return sdTakemeasures;
    }

    public void setSdTakemeasures(String sdTakemeasures) {
        this.sdTakemeasures = sdTakemeasures == null ? null : sdTakemeasures.trim();
    }

    public String getSdUtype() {
        return sdUtype;
    }

    public void setSdUtype(String sdUtype) {
        this.sdUtype = sdUtype == null ? null : sdUtype.trim();
    }

    public String getSdSoiltype() {
        return sdSoiltype;
    }

    public void setSdSoiltype(String sdSoiltype) {
        this.sdSoiltype = sdSoiltype == null ? null : sdSoiltype.trim();
    }

    public Double getSdArea() {
        return sdArea;
    }

    public void setSdArea(Double sdArea) {
        this.sdArea = sdArea;
    }

    public Double getSoilindexpm25() {
        return soilindexpm25;
    }

    public void setSoilindexpm25(Double soilindexpm25) {
        this.soilindexpm25 = soilindexpm25;
    }

    public Double getSoilindexpm10() {
        return soilindexpm10;
    }

    public void setSoilindexpm10(Double soilindexpm10) {
        this.soilindexpm10 = soilindexpm10;
    }

    public Double getSurindex() {
        return surindex;
    }

    public void setSurindex(Double surindex) {
        this.surindex = surindex;
    }

    public Double getNoindex() {
        return noindex;
    }

    public void setNoindex(Double noindex) {
        this.noindex = noindex;
    }

    public Double getPindex() {
        return pindex;
    }

    public void setPindex(Double pindex) {
        this.pindex = pindex;
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

    public Double getVocEmission() {
        return vocEmission;
    }

    public void setVocEmission(Double vocEmission) {
        this.vocEmission = vocEmission;
    }

    public Double getNh3Emission() {
        return nh3Emission;
    }

    public void setNh3Emission(Double nh3Emission) {
        this.nh3Emission = nh3Emission;
    }

    public Double getSo2Emission() {
        return so2Emission;
    }

    public void setSo2Emission(Double so2Emission) {
        this.so2Emission = so2Emission;
    }

    public Double getCoEmission() {
        return coEmission;
    }

    public void setCoEmission(Double coEmission) {
        this.coEmission = coEmission;
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

    public Double getNoxEmission() {
        return noxEmission;
    }

    public void setNoxEmission(Double noxEmission) {
        this.noxEmission = noxEmission;
    }

    public String getSccDescribe() {
        return sccDescribe;
    }

    public void setSccDescribe(String sccDescribe) {
        this.sccDescribe = sccDescribe == null ? null : sccDescribe.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}