package nankai.xl.business.model;

public class RoadMove {
    private Integer id;

    private String scccode;

    private String sourceDiscrip;

    private String year;

    private String countyCity;

    private String countyId;

    private Double averageMile;

    private Double carAmount;

    private Double carSpeed;

    private String fuelType;

    private Double carFuelamount;

    private Double orvrPercentage;

    private Double averageSamount;

    private Double pm25Emission;

    private Double pm10Emission;

    private Double ocEmission;

    private Double ecEmission;

    private Double so2Emission;

    private Double noxEmission;

    private Double coEmission;

    private Double nh3Emission;

    private Double vocsEmission;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getCountyCity() {
        return countyCity;
    }

    public void setCountyCity(String countyCity) {
        this.countyCity = countyCity == null ? null : countyCity.trim();
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
    }

    public Double getAverageMile() {
        return averageMile;
    }

    public void setAverageMile(Double averageMile) {
        this.averageMile = averageMile;
    }

    public Double getCarAmount() {
        return carAmount;
    }

    public void setCarAmount(Double carAmount) {
        this.carAmount = carAmount;
    }

    public Double getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(Double carSpeed) {
        this.carSpeed = carSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType == null ? null : fuelType.trim();
    }

    public Double getCarFuelamount() {
        return carFuelamount;
    }

    public void setCarFuelamount(Double carFuelamount) {
        this.carFuelamount = carFuelamount;
    }

    public Double getOrvrPercentage() {
        return orvrPercentage;
    }

    public void setOrvrPercentage(Double orvrPercentage) {
        this.orvrPercentage = orvrPercentage;
    }

    public Double getAverageSamount() {
        return averageSamount;
    }

    public void setAverageSamount(Double averageSamount) {
        this.averageSamount = averageSamount;
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

    public Double getOcEmission() {
        return ocEmission;
    }

    public void setOcEmission(Double ocEmission) {
        this.ocEmission = ocEmission;
    }

    public Double getEcEmission() {
        return ecEmission;
    }

    public void setEcEmission(Double ecEmission) {
        this.ecEmission = ecEmission;
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

    public Double getCoEmission() {
        return coEmission;
    }

    public void setCoEmission(Double coEmission) {
        this.coEmission = coEmission;
    }

    public Double getNh3Emission() {
        return nh3Emission;
    }

    public void setNh3Emission(Double nh3Emission) {
        this.nh3Emission = nh3Emission;
    }

    public Double getVocsEmission() {
        return vocsEmission;
    }

    public void setVocsEmission(Double vocsEmission) {
        this.vocsEmission = vocsEmission;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}