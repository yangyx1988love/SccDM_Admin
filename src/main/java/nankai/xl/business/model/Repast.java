package nankai.xl.business.model;

public class Repast {
    private Integer id;

    private Integer factoryid;

    private String year;

    private Integer cookingNum;

    private Integer cleanerNum;

    private String scccode;

    private Double smokeRate;

    private Integer annualRuntime;

    private Double removalEffi;

    private Integer householdNum;

    private Double pmEmf;

    private String pmEmfunit;

    private Double pm10Emf;

    private String pm10Emfunit;

    private Double pm25Emf;

    private String pm25Emfunit;

    private Double so2Emf;

    private String so2Emfunit;

    private Double noxEmf;

    private String noxEmfunit;

    private Double coEmf;

    private String coEmfunit;

    private Double nh3Emf;

    private String nh3Emfunit;

    private Double vocEmf;

    private String vocEmfunit;

    private Double ocEmf;

    private String ocEmfunit;

    private Double bcEmf;

    private String bcEmfunit;

    private Double pmEmission;

    private String pmEmiunit;

    private Double pm10Emission;

    private String pm10Emiunit;

    private Double pm25Emission;

    private String pm25Emiunit;

    private Double so2Emission;

    private String so2Emiunit;

    private Double noxEmission;

    private String noxEmiunit;

    private Double coEmission;

    private String coEmiunit;

    private Double nh3Emission;

    private String nh3Emiunit;

    private Double vocEmission;

    private String vocEmiunit;

    private Double ocEmission;

    private String ocEmiunit;

    private Double bcEmission;

    private String bcEmiunit;

    private Boolean flag;

    private Double gasConsumption;

    private Double coalConsumption;

    private Double coalgasConsumption;

    private Double powerConsumption;

    private Double methanolConsumption;

    private Double otherConsumption;

    private String otherConunit;

    private Double oilConsumption;

    private String sourceDiscrip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Integer factoryid) {
        this.factoryid = factoryid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getCookingNum() {
        return cookingNum;
    }

    public void setCookingNum(Integer cookingNum) {
        this.cookingNum = cookingNum;
    }

    public Integer getCleanerNum() {
        return cleanerNum;
    }

    public void setCleanerNum(Integer cleanerNum) {
        this.cleanerNum = cleanerNum;
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public Double getSmokeRate() {
        return smokeRate;
    }

    public void setSmokeRate(Double smokeRate) {
        this.smokeRate = smokeRate;
    }

    public Integer getAnnualRuntime() {
        return annualRuntime;
    }

    public void setAnnualRuntime(Integer annualRuntime) {
        this.annualRuntime = annualRuntime;
    }

    public Double getRemovalEffi() {
        return removalEffi;
    }

    public void setRemovalEffi(Double removalEffi) {
        this.removalEffi = removalEffi;
    }

    public Integer getHouseholdNum() {
        return householdNum;
    }

    public void setHouseholdNum(Integer householdNum) {
        this.householdNum = householdNum;
    }

    public Double getPmEmf() {
        return pmEmf;
    }

    public void setPmEmf(Double pmEmf) {
        this.pmEmf = pmEmf;
    }

    public String getPmEmfunit() {
        return pmEmfunit;
    }

    public void setPmEmfunit(String pmEmfunit) {
        this.pmEmfunit = pmEmfunit == null ? null : pmEmfunit.trim();
    }

    public Double getPm10Emf() {
        return pm10Emf;
    }

    public void setPm10Emf(Double pm10Emf) {
        this.pm10Emf = pm10Emf;
    }

    public String getPm10Emfunit() {
        return pm10Emfunit;
    }

    public void setPm10Emfunit(String pm10Emfunit) {
        this.pm10Emfunit = pm10Emfunit == null ? null : pm10Emfunit.trim();
    }

    public Double getPm25Emf() {
        return pm25Emf;
    }

    public void setPm25Emf(Double pm25Emf) {
        this.pm25Emf = pm25Emf;
    }

    public String getPm25Emfunit() {
        return pm25Emfunit;
    }

    public void setPm25Emfunit(String pm25Emfunit) {
        this.pm25Emfunit = pm25Emfunit == null ? null : pm25Emfunit.trim();
    }

    public Double getSo2Emf() {
        return so2Emf;
    }

    public void setSo2Emf(Double so2Emf) {
        this.so2Emf = so2Emf;
    }

    public String getSo2Emfunit() {
        return so2Emfunit;
    }

    public void setSo2Emfunit(String so2Emfunit) {
        this.so2Emfunit = so2Emfunit == null ? null : so2Emfunit.trim();
    }

    public Double getNoxEmf() {
        return noxEmf;
    }

    public void setNoxEmf(Double noxEmf) {
        this.noxEmf = noxEmf;
    }

    public String getNoxEmfunit() {
        return noxEmfunit;
    }

    public void setNoxEmfunit(String noxEmfunit) {
        this.noxEmfunit = noxEmfunit == null ? null : noxEmfunit.trim();
    }

    public Double getCoEmf() {
        return coEmf;
    }

    public void setCoEmf(Double coEmf) {
        this.coEmf = coEmf;
    }

    public String getCoEmfunit() {
        return coEmfunit;
    }

    public void setCoEmfunit(String coEmfunit) {
        this.coEmfunit = coEmfunit == null ? null : coEmfunit.trim();
    }

    public Double getNh3Emf() {
        return nh3Emf;
    }

    public void setNh3Emf(Double nh3Emf) {
        this.nh3Emf = nh3Emf;
    }

    public String getNh3Emfunit() {
        return nh3Emfunit;
    }

    public void setNh3Emfunit(String nh3Emfunit) {
        this.nh3Emfunit = nh3Emfunit == null ? null : nh3Emfunit.trim();
    }

    public Double getVocEmf() {
        return vocEmf;
    }

    public void setVocEmf(Double vocEmf) {
        this.vocEmf = vocEmf;
    }

    public String getVocEmfunit() {
        return vocEmfunit;
    }

    public void setVocEmfunit(String vocEmfunit) {
        this.vocEmfunit = vocEmfunit == null ? null : vocEmfunit.trim();
    }

    public Double getOcEmf() {
        return ocEmf;
    }

    public void setOcEmf(Double ocEmf) {
        this.ocEmf = ocEmf;
    }

    public String getOcEmfunit() {
        return ocEmfunit;
    }

    public void setOcEmfunit(String ocEmfunit) {
        this.ocEmfunit = ocEmfunit == null ? null : ocEmfunit.trim();
    }

    public Double getBcEmf() {
        return bcEmf;
    }

    public void setBcEmf(Double bcEmf) {
        this.bcEmf = bcEmf;
    }

    public String getBcEmfunit() {
        return bcEmfunit;
    }

    public void setBcEmfunit(String bcEmfunit) {
        this.bcEmfunit = bcEmfunit == null ? null : bcEmfunit.trim();
    }

    public Double getPmEmission() {
        return pmEmission;
    }

    public void setPmEmission(Double pmEmission) {
        this.pmEmission = pmEmission;
    }

    public String getPmEmiunit() {
        return pmEmiunit;
    }

    public void setPmEmiunit(String pmEmiunit) {
        this.pmEmiunit = pmEmiunit == null ? null : pmEmiunit.trim();
    }

    public Double getPm10Emission() {
        return pm10Emission;
    }

    public void setPm10Emission(Double pm10Emission) {
        this.pm10Emission = pm10Emission;
    }

    public String getPm10Emiunit() {
        return pm10Emiunit;
    }

    public void setPm10Emiunit(String pm10Emiunit) {
        this.pm10Emiunit = pm10Emiunit == null ? null : pm10Emiunit.trim();
    }

    public Double getPm25Emission() {
        return pm25Emission;
    }

    public void setPm25Emission(Double pm25Emission) {
        this.pm25Emission = pm25Emission;
    }

    public String getPm25Emiunit() {
        return pm25Emiunit;
    }

    public void setPm25Emiunit(String pm25Emiunit) {
        this.pm25Emiunit = pm25Emiunit == null ? null : pm25Emiunit.trim();
    }

    public Double getSo2Emission() {
        return so2Emission;
    }

    public void setSo2Emission(Double so2Emission) {
        this.so2Emission = so2Emission;
    }

    public String getSo2Emiunit() {
        return so2Emiunit;
    }

    public void setSo2Emiunit(String so2Emiunit) {
        this.so2Emiunit = so2Emiunit == null ? null : so2Emiunit.trim();
    }

    public Double getNoxEmission() {
        return noxEmission;
    }

    public void setNoxEmission(Double noxEmission) {
        this.noxEmission = noxEmission;
    }

    public String getNoxEmiunit() {
        return noxEmiunit;
    }

    public void setNoxEmiunit(String noxEmiunit) {
        this.noxEmiunit = noxEmiunit == null ? null : noxEmiunit.trim();
    }

    public Double getCoEmission() {
        return coEmission;
    }

    public void setCoEmission(Double coEmission) {
        this.coEmission = coEmission;
    }

    public String getCoEmiunit() {
        return coEmiunit;
    }

    public void setCoEmiunit(String coEmiunit) {
        this.coEmiunit = coEmiunit == null ? null : coEmiunit.trim();
    }

    public Double getNh3Emission() {
        return nh3Emission;
    }

    public void setNh3Emission(Double nh3Emission) {
        this.nh3Emission = nh3Emission;
    }

    public String getNh3Emiunit() {
        return nh3Emiunit;
    }

    public void setNh3Emiunit(String nh3Emiunit) {
        this.nh3Emiunit = nh3Emiunit == null ? null : nh3Emiunit.trim();
    }

    public Double getVocEmission() {
        return vocEmission;
    }

    public void setVocEmission(Double vocEmission) {
        this.vocEmission = vocEmission;
    }

    public String getVocEmiunit() {
        return vocEmiunit;
    }

    public void setVocEmiunit(String vocEmiunit) {
        this.vocEmiunit = vocEmiunit == null ? null : vocEmiunit.trim();
    }

    public Double getOcEmission() {
        return ocEmission;
    }

    public void setOcEmission(Double ocEmission) {
        this.ocEmission = ocEmission;
    }

    public String getOcEmiunit() {
        return ocEmiunit;
    }

    public void setOcEmiunit(String ocEmiunit) {
        this.ocEmiunit = ocEmiunit == null ? null : ocEmiunit.trim();
    }

    public Double getBcEmission() {
        return bcEmission;
    }

    public void setBcEmission(Double bcEmission) {
        this.bcEmission = bcEmission;
    }

    public String getBcEmiunit() {
        return bcEmiunit;
    }

    public void setBcEmiunit(String bcEmiunit) {
        this.bcEmiunit = bcEmiunit == null ? null : bcEmiunit.trim();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Double getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(Double gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public Double getCoalConsumption() {
        return coalConsumption;
    }

    public void setCoalConsumption(Double coalConsumption) {
        this.coalConsumption = coalConsumption;
    }

    public Double getCoalgasConsumption() {
        return coalgasConsumption;
    }

    public void setCoalgasConsumption(Double coalgasConsumption) {
        this.coalgasConsumption = coalgasConsumption;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Double getMethanolConsumption() {
        return methanolConsumption;
    }

    public void setMethanolConsumption(Double methanolConsumption) {
        this.methanolConsumption = methanolConsumption;
    }

    public Double getOtherConsumption() {
        return otherConsumption;
    }

    public void setOtherConsumption(Double otherConsumption) {
        this.otherConsumption = otherConsumption;
    }

    public String getOtherConunit() {
        return otherConunit;
    }

    public void setOtherConunit(String otherConunit) {
        this.otherConunit = otherConunit == null ? null : otherConunit.trim();
    }

    public Double getOilConsumption() {
        return oilConsumption;
    }

    public void setOilConsumption(Double oilConsumption) {
        this.oilConsumption = oilConsumption;
    }

    public String getSourceDiscrip() {
        return sourceDiscrip;
    }

    public void setSourceDiscrip(String sourceDiscrip) {
        this.sourceDiscrip = sourceDiscrip == null ? null : sourceDiscrip.trim();
    }
}