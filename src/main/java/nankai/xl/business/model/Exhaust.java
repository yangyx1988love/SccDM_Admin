package nankai.xl.business.model;

public class Exhaust {
    private Integer exfId;

    private Integer nkNo;

    private Integer factoryId;

    private String exfMaterial;

    private Double exfHeight;

    private Double smokeOutd;

    private Double smokeOUtteM;

    private Double smokeOuta;

    private Double smokeOutv;

    private Double exfLongitude;

    private Double exfLatitude;

    public Integer getExfId() {
        return exfId;
    }

    public void setExfId(Integer exfId) {
        this.exfId = exfId;
    }

    public Integer getNkNo() {
        return nkNo;
    }

    public void setNkNo(Integer nkNo) {
        this.nkNo = nkNo;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getExfMaterial() {
        return exfMaterial;
    }

    public void setExfMaterial(String exfMaterial) {
        this.exfMaterial = exfMaterial == null ? null : exfMaterial.trim();
    }

    public Double getExfHeight() {
        return exfHeight;
    }

    public void setExfHeight(Double exfHeight) {
        this.exfHeight = exfHeight;
    }

    public Double getSmokeOutd() {
        return smokeOutd;
    }

    public void setSmokeOutd(Double smokeOutd) {
        this.smokeOutd = smokeOutd;
    }

    public Double getSmokeOUtteM() {
        return smokeOUtteM;
    }

    public void setSmokeOUtteM(Double smokeOUtteM) {
        this.smokeOUtteM = smokeOUtteM;
    }

    public Double getSmokeOuta() {
        return smokeOuta;
    }

    public void setSmokeOuta(Double smokeOuta) {
        this.smokeOuta = smokeOuta;
    }

    public Double getSmokeOutv() {
        return smokeOutv;
    }

    public void setSmokeOutv(Double smokeOutv) {
        this.smokeOutv = smokeOutv;
    }

    public Double getExfLongitude() {
        return exfLongitude;
    }

    public void setExfLongitude(Double exfLongitude) {
        this.exfLongitude = exfLongitude;
    }

    public Double getExfLatitude() {
        return exfLatitude;
    }

    public void setExfLatitude(Double exfLatitude) {
        this.exfLatitude = exfLatitude;
    }
}