package nankai.xl.business.model;

public class YcDustLoad extends Company{
    private Integer id;

    private Integer loadId;

    private String year;

    private Integer comId;

    private Double materialWater;

    private String materialType;

    private Integer materialLoad;

    private Integer loadNum;

    private String mloadUnit;

    private Double uwindValue;

    private String controlname;

    private String scccode;

    private Double pm25Emission;

    private Double pm10Emission;

    private Double vocEmission;

    private Double nh3Emission;

    private Double so2Emission;

    private Double coEmission;

    private Double ocEmission;

    private Double bcEmission;

    private Double noxEmission;

    private Double pm25Max;

    private Double pm10Max;

    private Double vocMax;

    private Double nh3Max;

    private Double so2Max;

    private Double coMax;

    private Double ocMax;

    private Double bcMax;

    private Double noxMax;

    private String pm25Unit;

    private String pm10Unit;

    private String vocUnit;

    private String nh3Unit;

    private String so2Unit;

    private String coUnit;

    private String ocUnit;

    private String bcUnit;

    private String noxUnit;

    private String sccDescribe;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoadId() {
        return loadId;
    }

    public void setLoadId(Integer loadId) {
        this.loadId = loadId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Double getMaterialWater() {
        return materialWater;
    }

    public void setMaterialWater(Double materialWater) {
        this.materialWater = materialWater;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public Integer getMaterialLoad() {
        return materialLoad;
    }

    public void setMaterialLoad(Integer materialLoad) {
        this.materialLoad = materialLoad;
    }

    public Integer getLoadNum() {
        return loadNum;
    }

    public void setLoadNum(Integer loadNum) {
        this.loadNum = loadNum;
    }

    public String getMloadUnit() {
        return mloadUnit;
    }

    public void setMloadUnit(String mloadUnit) {
        this.mloadUnit = mloadUnit == null ? null : mloadUnit.trim();
    }

    public Double getUwindValue() {
        return uwindValue;
    }

    public void setUwindValue(Double uwindValue) {
        this.uwindValue = uwindValue;
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

    public Double getPm25Max() {
        return pm25Max;
    }

    public void setPm25Max(Double pm25Max) {
        this.pm25Max = pm25Max;
    }

    public Double getPm10Max() {
        return pm10Max;
    }

    public void setPm10Max(Double pm10Max) {
        this.pm10Max = pm10Max;
    }

    public Double getVocMax() {
        return vocMax;
    }

    public void setVocMax(Double vocMax) {
        this.vocMax = vocMax;
    }

    public Double getNh3Max() {
        return nh3Max;
    }

    public void setNh3Max(Double nh3Max) {
        this.nh3Max = nh3Max;
    }

    public Double getSo2Max() {
        return so2Max;
    }

    public void setSo2Max(Double so2Max) {
        this.so2Max = so2Max;
    }

    public Double getCoMax() {
        return coMax;
    }

    public void setCoMax(Double coMax) {
        this.coMax = coMax;
    }

    public Double getOcMax() {
        return ocMax;
    }

    public void setOcMax(Double ocMax) {
        this.ocMax = ocMax;
    }

    public Double getBcMax() {
        return bcMax;
    }

    public void setBcMax(Double bcMax) {
        this.bcMax = bcMax;
    }

    public Double getNoxMax() {
        return noxMax;
    }

    public void setNoxMax(Double noxMax) {
        this.noxMax = noxMax;
    }

    public String getPm25Unit() {
        return pm25Unit;
    }

    public void setPm25Unit(String pm25Unit) {
        this.pm25Unit = pm25Unit == null ? null : pm25Unit.trim();
    }

    public String getPm10Unit() {
        return pm10Unit;
    }

    public void setPm10Unit(String pm10Unit) {
        this.pm10Unit = pm10Unit == null ? null : pm10Unit.trim();
    }

    public String getVocUnit() {
        return vocUnit;
    }

    public void setVocUnit(String vocUnit) {
        this.vocUnit = vocUnit == null ? null : vocUnit.trim();
    }

    public String getNh3Unit() {
        return nh3Unit;
    }

    public void setNh3Unit(String nh3Unit) {
        this.nh3Unit = nh3Unit == null ? null : nh3Unit.trim();
    }

    public String getSo2Unit() {
        return so2Unit;
    }

    public void setSo2Unit(String so2Unit) {
        this.so2Unit = so2Unit == null ? null : so2Unit.trim();
    }

    public String getCoUnit() {
        return coUnit;
    }

    public void setCoUnit(String coUnit) {
        this.coUnit = coUnit == null ? null : coUnit.trim();
    }

    public String getOcUnit() {
        return ocUnit;
    }

    public void setOcUnit(String ocUnit) {
        this.ocUnit = ocUnit == null ? null : ocUnit.trim();
    }

    public String getBcUnit() {
        return bcUnit;
    }

    public void setBcUnit(String bcUnit) {
        this.bcUnit = bcUnit == null ? null : bcUnit.trim();
    }

    public String getNoxUnit() {
        return noxUnit;
    }

    public void setNoxUnit(String noxUnit) {
        this.noxUnit = noxUnit == null ? null : noxUnit.trim();
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