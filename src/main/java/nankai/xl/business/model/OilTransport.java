package nankai.xl.business.model;

public class OilTransport {
    private Integer id;

    private Integer companyId;

    private String year;

    private String oilType;

    private String scccode;

    private String sourceDiscrip;

    private Double yearVolume;

    private Integer controlRate;

    private Double emission;

    private Integer flag;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType == null ? null : oilType.trim();
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public String getSourceDiscrip() {
        return sourceDiscrip;
    }

    public void setSourceDiscrip(String sourceDiscrip) {
        this.sourceDiscrip = sourceDiscrip == null ? null : sourceDiscrip.trim();
    }

    public Double getYearVolume() {
        return yearVolume;
    }

    public void setYearVolume(Double yearVolume) {
        this.yearVolume = yearVolume;
    }

    public Integer getControlRate() {
        return controlRate;
    }

    public void setControlRate(Integer controlRate) {
        this.controlRate = controlRate;
    }

    public Double getEmission() {
        return emission;
    }

    public void setEmission(Double emission) {
        this.emission = emission;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}