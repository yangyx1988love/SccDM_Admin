package nankai.xl.business.model;

public class OilSource extends Company{
    private Integer id;

    private Integer companyId;

    private String year;

    private String oilType;

    private String scccode;

    private String sourceDiscrip;

    private Double salesVolume;

    private Double emission;

    private Integer flag;

    private Double volume;

    private Double everyVolume;

    private Double volumeCount;

    private Integer gunNum;

    private Integer tankNum;

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

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
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

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getEveryVolume() {
        return everyVolume;
    }

    public void setEveryVolume(Double everyVolume) {
        this.everyVolume = everyVolume;
    }

    public Double getVolumeCount() {
        return volumeCount;
    }

    public void setVolumeCount(Double volumeCount) {
        this.volumeCount = volumeCount;
    }

    public Integer getGunNum() {
        return gunNum;
    }

    public void setGunNum(Integer gunNum) {
        this.gunNum = gunNum;
    }

    public Integer getTankNum() {
        return tankNum;
    }

    public void setTankNum(Integer tankNum) {
        this.tankNum = tankNum;
    }
}