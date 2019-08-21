package nankai.xl.business.model;

import java.io.Serializable;

public class Exhaust implements Serializable{

    private static final long serialVersionUID = -4001326422264853695L;

    private Integer exfId;

    private Integer nkNo;

    private String exfNo;

    private String exfMaterial;

    private Double exfHeight;

    private Double smokeOutd;

    private Double smokeOUtteM;

    private Double smokeOuta;

    private Double smokeOutv;

    private Double exfLongitude;

    private Double exfLatitude;

    private Double exfPm10;

    private Double exfPm25;

    private Double exfNh3;

    private Double exfCo;

    private Double exfVoc;

    private Double measureNh3;

    private Double measureBc;

    private Double measureOc;

    private Double measureVoc;

    private Double exfPm;

    private Double exfSo2;

    private Double exfNox;

    private Double exfOc;

    private Double exfBc;

    private Integer factoryId;

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

    public String getExfNo() {
        return exfNo;
    }

    public void setExfNo(String exfNo) {
        this.exfNo = exfNo == null ? null : exfNo.trim();
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

    public Double getExfPm10() {
        return exfPm10;
    }

    public void setExfPm10(Double exfPm10) {
        this.exfPm10 = exfPm10;
    }

    public Double getExfPm25() {
        return exfPm25;
    }

    public void setExfPm25(Double exfPm25) {
        this.exfPm25 = exfPm25;
    }

    public Double getExfNh3() {
        return exfNh3;
    }

    public void setExfNh3(Double exfNh3) {
        this.exfNh3 = exfNh3;
    }

    public Double getExfCo() {
        return exfCo;
    }

    public void setExfCo(Double exfCo) {
        this.exfCo = exfCo;
    }

    public Double getExfVoc() {
        return exfVoc;
    }

    public void setExfVoc(Double exfVoc) {
        this.exfVoc = exfVoc;
    }

    public Double getMeasureNh3() {
        return measureNh3;
    }

    public void setMeasureNh3(Double measureNh3) {
        this.measureNh3 = measureNh3;
    }

    public Double getMeasureBc() {
        return measureBc;
    }

    public void setMeasureBc(Double measureBc) {
        this.measureBc = measureBc;
    }

    public Double getMeasureOc() {
        return measureOc;
    }

    public void setMeasureOc(Double measureOc) {
        this.measureOc = measureOc;
    }

    public Double getMeasureVoc() {
        return measureVoc;
    }

    public void setMeasureVoc(Double measureVoc) {
        this.measureVoc = measureVoc;
    }

    public Double getExfPm() {
        return exfPm;
    }

    public void setExfPm(Double exfPm) {
        this.exfPm = exfPm;
    }

    public Double getExfSo2() {
        return exfSo2;
    }

    public void setExfSo2(Double exfSo2) {
        this.exfSo2 = exfSo2;
    }

    public Double getExfNox() {
        return exfNox;
    }

    public void setExfNox(Double exfNox) {
        this.exfNox = exfNox;
    }

    public Double getExfOc() {
        return exfOc;
    }

    public void setExfOc(Double exfOc) {
        this.exfOc = exfOc;
    }

    public Double getExfBc() {
        return exfBc;
    }

    public void setExfBc(Double exfBc) {
        this.exfBc = exfBc;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }
}