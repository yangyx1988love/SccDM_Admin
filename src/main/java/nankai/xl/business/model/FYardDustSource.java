package nankai.xl.business.model;

import java.util.Date;

public class FYardDustSource {
    private Integer windDustid;

    private Integer factoryid;

    private String scccode;

    private Double longitude1;

    private Double latitude1;

    private Double longitude2;

    private Double latitude2;

    private Double longitude3;

    private Double latitude3;

    private Double longitude4;

    private Double latitude4;

    private String materialType;

    private Double windSpeed;

    private Double materialCapacity;

    private Double loadingCount;

    private Date loadingStart;

    private Date loadingTime;

    private Double loadingCapacity;

    private String controlMeasures;

    private Double moistureMateria;

    private Double pm25Emission;

    private Double pm10Emission;

    private Double bcEmission;

    private Double ocEmission;

    private Double heapArea;

    private Double heapCovered;

    private Double heapHeigh;

    private String note;

    public Integer getWindDustid() {
        return windDustid;
    }

    public void setWindDustid(Integer windDustid) {
        this.windDustid = windDustid;
    }

    public Integer getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Integer factoryid) {
        this.factoryid = factoryid;
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
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

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getMaterialCapacity() {
        return materialCapacity;
    }

    public void setMaterialCapacity(Double materialCapacity) {
        this.materialCapacity = materialCapacity;
    }

    public Double getLoadingCount() {
        return loadingCount;
    }

    public void setLoadingCount(Double loadingCount) {
        this.loadingCount = loadingCount;
    }

    public Date getLoadingStart() {
        return loadingStart;
    }

    public void setLoadingStart(Date loadingStart) {
        this.loadingStart = loadingStart;
    }

    public Date getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(Date loadingTime) {
        this.loadingTime = loadingTime;
    }

    public Double getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(Double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public String getControlMeasures() {
        return controlMeasures;
    }

    public void setControlMeasures(String controlMeasures) {
        this.controlMeasures = controlMeasures == null ? null : controlMeasures.trim();
    }

    public Double getMoistureMateria() {
        return moistureMateria;
    }

    public void setMoistureMateria(Double moistureMateria) {
        this.moistureMateria = moistureMateria;
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

    public Double getHeapArea() {
        return heapArea;
    }

    public void setHeapArea(Double heapArea) {
        this.heapArea = heapArea;
    }

    public Double getHeapCovered() {
        return heapCovered;
    }

    public void setHeapCovered(Double heapCovered) {
        this.heapCovered = heapCovered;
    }

    public Double getHeapHeigh() {
        return heapHeigh;
    }

    public void setHeapHeigh(Double heapHeigh) {
        this.heapHeigh = heapHeigh;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}