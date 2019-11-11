package nankai.xl.business.model;

import java.util.Date;

public class FConstructionDustSource {
    private Integer constructDustid;

    private String scccode;

    private Integer factoryid;

    private String constructState;

    private Double constructArea;

    private String constructMonths;

    private String controlMeasures;

    private Double finisharea;

    private Double nowkgarea;

    private Date startdate;

    private Double pm10Emission;

    private Double pm25Emission;

    private Double ocEmission;

    private Double bcEmission;

    private Double longitude1;

    private Double latitude1;

    private Double longitude2;

    private Double latitude2;

    private Double longitude3;

    private Double latitude3;

    private Double longitude4;

    private Double latitude4;

    private String constructionType;

    private Date finishdate;

    private String note;

    public Integer getConstructDustid() {
        return constructDustid;
    }

    public void setConstructDustid(Integer constructDustid) {
        this.constructDustid = constructDustid;
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

    public String getConstructState() {
        return constructState;
    }

    public void setConstructState(String constructState) {
        this.constructState = constructState == null ? null : constructState.trim();
    }

    public Double getConstructArea() {
        return constructArea;
    }

    public void setConstructArea(Double constructArea) {
        this.constructArea = constructArea;
    }

    public String getConstructMonths() {
        return constructMonths;
    }

    public void setConstructMonths(String constructMonths) {
        this.constructMonths = constructMonths == null ? null : constructMonths.trim();
    }

    public String getControlMeasures() {
        return controlMeasures;
    }

    public void setControlMeasures(String controlMeasures) {
        this.controlMeasures = controlMeasures == null ? null : controlMeasures.trim();
    }

    public Double getFinisharea() {
        return finisharea;
    }

    public void setFinisharea(Double finisharea) {
        this.finisharea = finisharea;
    }

    public Double getNowkgarea() {
        return nowkgarea;
    }

    public void setNowkgarea(Double nowkgarea) {
        this.nowkgarea = nowkgarea;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
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

    public Double getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(Double longitude1) {
        this.longitude1 = longitude1;
    }

    public Double getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(Double latitude1) {
        this.latitude1 = latitude1;
    }

    public Double getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(Double longitude2) {
        this.longitude2 = longitude2;
    }

    public Double getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(Double latitude2) {
        this.latitude2 = latitude2;
    }

    public Double getLongitude3() {
        return longitude3;
    }

    public void setLongitude3(Double longitude3) {
        this.longitude3 = longitude3;
    }

    public Double getLatitude3() {
        return latitude3;
    }

    public void setLatitude3(Double latitude3) {
        this.latitude3 = latitude3;
    }

    public Double getLongitude4() {
        return longitude4;
    }

    public void setLongitude4(Double longitude4) {
        this.longitude4 = longitude4;
    }

    public Double getLatitude4() {
        return latitude4;
    }

    public void setLatitude4(Double latitude4) {
        this.latitude4 = latitude4;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType == null ? null : constructionType.trim();
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}