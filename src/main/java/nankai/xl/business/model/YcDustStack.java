package nankai.xl.business.model;

public class YcDustStack extends Company{
    private Integer id;

    private Integer comId;

    private Integer stackId;

    private String year;

    private Integer sarea;

    private String materialType;

    private Double windfThresh;

    private Double windFriction;

    private Double groundRough;

    private Double materialRough;

    private Double groundWindhigh;

    private Integer mWindnum;

    private Double groundWind;

    private String controlname;

    private String scccode;

    private Integer flag;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getStackId() {
        return stackId;
    }

    public void setStackId(Integer stackId) {
        this.stackId = stackId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getSarea() {
        return sarea;
    }

    public void setSarea(Integer sarea) {
        this.sarea = sarea;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public Double getWindfThresh() {
        return windfThresh;
    }

    public void setWindfThresh(Double windfThresh) {
        this.windfThresh = windfThresh;
    }

    public Double getWindFriction() {
        return windFriction;
    }

    public void setWindFriction(Double windFriction) {
        this.windFriction = windFriction;
    }

    public Double getGroundRough() {
        return groundRough;
    }

    public void setGroundRough(Double groundRough) {
        this.groundRough = groundRough;
    }

    public Double getMaterialRough() {
        return materialRough;
    }

    public void setMaterialRough(Double materialRough) {
        this.materialRough = materialRough;
    }

    public Double getGroundWindhigh() {
        return groundWindhigh;
    }

    public void setGroundWindhigh(Double groundWindhigh) {
        this.groundWindhigh = groundWindhigh;
    }

    public Integer getmWindnum() {
        return mWindnum;
    }

    public void setmWindnum(Integer mWindnum) {
        this.mWindnum = mWindnum;
    }

    public Double getGroundWind() {
        return groundWind;
    }

    public void setGroundWind(Double groundWind) {
        this.groundWind = groundWind;
    }

    public String getControlname() {
        return controlname;
    }

    public void setControlname(String controlname) {
        this.controlname = controlname == null ? null : controlname.trim();
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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
}