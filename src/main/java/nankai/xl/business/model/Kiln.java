package nankai.xl.business.model;

public class Kiln {
    private Integer id;

    private Integer exhustId;

    private Integer tkilnId;

    private Integer nkNo;

    private String kilnNo;

    private String functionDec;

    private String functio;

    private String modelDec;

    private String kilnModel;

    private String model;

    private String fueltypeDec;

    private String fueltype;

    private Double kilnFuelAusage;

    private String kilnFuelAusageunit;

    private String nitreremovedec;

    private Integer nitreremoveid;

    private String dustremovedec;

    private Integer dustremoveid;

    private String sulphurremovedec;

    private Integer sulphurremoveid;

    private Byte exfNo;

    private Double coalash;

    private Double coalVolatilisation;

    private Double coalsulfur;

    private Double factorPm10;

    private Byte factorStatus;

    private Double pm10;

    private Double factorPm25;

    private Double pm25;

    private Double factorCo;

    private Double co;

    private Double factorVoc;

    private Double voc;

    private Double factorPm;

    private Double pm;

    private Double factorSo2;

    private Double so2;

    private Double factorNox;

    private Double nox;

    private Double factorNh3;

    private Double nh3;

    private Double factorOc;

    private Double oc;

    private Double factorBc;

    private Double bc;

    private String scccode;

    private Double feiqiti;

    private Double so2out;

    private Double pmout;

    private Double noxout;

    private Double janUseamount;

    private Double febUseamount;

    private Double marUseamount;

    private Double aprUseamount;

    private Double mayUseamount;

    private Double juneUseamount;

    private Double julyUseamount;

    private Double augUseamount;

    private Double septUseamount;

    private Double octUseAmount;

    private Double novUseamount;

    private Double decUseamount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExhustId() {
        return exhustId;
    }

    public void setExhustId(Integer exhustId) {
        this.exhustId = exhustId;
    }

    public Integer getTkilnId() {
        return tkilnId;
    }

    public void setTkilnId(Integer tkilnId) {
        this.tkilnId = tkilnId;
    }

    public Integer getNkNo() {
        return nkNo;
    }

    public void setNkNo(Integer nkNo) {
        this.nkNo = nkNo;
    }

    public String getKilnNo() {
        return kilnNo;
    }

    public void setKilnNo(String kilnNo) {
        this.kilnNo = kilnNo == null ? null : kilnNo.trim();
    }

    public String getFunctionDec() {
        return functionDec;
    }

    public void setFunctionDec(String functionDec) {
        this.functionDec = functionDec == null ? null : functionDec.trim();
    }

    public String getFunctio() {
        return functio;
    }

    public void setFunctio(String functio) {
        this.functio = functio == null ? null : functio.trim();
    }

    public String getModelDec() {
        return modelDec;
    }

    public void setModelDec(String modelDec) {
        this.modelDec = modelDec == null ? null : modelDec.trim();
    }

    public String getKilnModel() {
        return kilnModel;
    }

    public void setKilnModel(String kilnModel) {
        this.kilnModel = kilnModel == null ? null : kilnModel.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getFueltypeDec() {
        return fueltypeDec;
    }

    public void setFueltypeDec(String fueltypeDec) {
        this.fueltypeDec = fueltypeDec == null ? null : fueltypeDec.trim();
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype == null ? null : fueltype.trim();
    }

    public Double getKilnFuelAusage() {
        return kilnFuelAusage;
    }

    public void setKilnFuelAusage(Double kilnFuelAusage) {
        this.kilnFuelAusage = kilnFuelAusage;
    }

    public String getKilnFuelAusageunit() {
        return kilnFuelAusageunit;
    }

    public void setKilnFuelAusageunit(String kilnFuelAusageunit) {
        this.kilnFuelAusageunit = kilnFuelAusageunit == null ? null : kilnFuelAusageunit.trim();
    }

    public String getNitreremovedec() {
        return nitreremovedec;
    }

    public void setNitreremovedec(String nitreremovedec) {
        this.nitreremovedec = nitreremovedec == null ? null : nitreremovedec.trim();
    }

    public Integer getNitreremoveid() {
        return nitreremoveid;
    }

    public void setNitreremoveid(Integer nitreremoveid) {
        this.nitreremoveid = nitreremoveid;
    }

    public String getDustremovedec() {
        return dustremovedec;
    }

    public void setDustremovedec(String dustremovedec) {
        this.dustremovedec = dustremovedec == null ? null : dustremovedec.trim();
    }

    public Integer getDustremoveid() {
        return dustremoveid;
    }

    public void setDustremoveid(Integer dustremoveid) {
        this.dustremoveid = dustremoveid;
    }

    public String getSulphurremovedec() {
        return sulphurremovedec;
    }

    public void setSulphurremovedec(String sulphurremovedec) {
        this.sulphurremovedec = sulphurremovedec == null ? null : sulphurremovedec.trim();
    }

    public Integer getSulphurremoveid() {
        return sulphurremoveid;
    }

    public void setSulphurremoveid(Integer sulphurremoveid) {
        this.sulphurremoveid = sulphurremoveid;
    }

    public Byte getExfNo() {
        return exfNo;
    }

    public void setExfNo(Byte exfNo) {
        this.exfNo = exfNo;
    }

    public Double getCoalash() {
        return coalash;
    }

    public void setCoalash(Double coalash) {
        this.coalash = coalash;
    }

    public Double getCoalVolatilisation() {
        return coalVolatilisation;
    }

    public void setCoalVolatilisation(Double coalVolatilisation) {
        this.coalVolatilisation = coalVolatilisation;
    }

    public Double getCoalsulfur() {
        return coalsulfur;
    }

    public void setCoalsulfur(Double coalsulfur) {
        this.coalsulfur = coalsulfur;
    }

    public Double getFactorPm10() {
        return factorPm10;
    }

    public void setFactorPm10(Double factorPm10) {
        this.factorPm10 = factorPm10;
    }

    public Byte getFactorStatus() {
        return factorStatus;
    }

    public void setFactorStatus(Byte factorStatus) {
        this.factorStatus = factorStatus;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getFactorPm25() {
        return factorPm25;
    }

    public void setFactorPm25(Double factorPm25) {
        this.factorPm25 = factorPm25;
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getFactorCo() {
        return factorCo;
    }

    public void setFactorCo(Double factorCo) {
        this.factorCo = factorCo;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getFactorVoc() {
        return factorVoc;
    }

    public void setFactorVoc(Double factorVoc) {
        this.factorVoc = factorVoc;
    }

    public Double getVoc() {
        return voc;
    }

    public void setVoc(Double voc) {
        this.voc = voc;
    }

    public Double getFactorPm() {
        return factorPm;
    }

    public void setFactorPm(Double factorPm) {
        this.factorPm = factorPm;
    }

    public Double getPm() {
        return pm;
    }

    public void setPm(Double pm) {
        this.pm = pm;
    }

    public Double getFactorSo2() {
        return factorSo2;
    }

    public void setFactorSo2(Double factorSo2) {
        this.factorSo2 = factorSo2;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getFactorNox() {
        return factorNox;
    }

    public void setFactorNox(Double factorNox) {
        this.factorNox = factorNox;
    }

    public Double getNox() {
        return nox;
    }

    public void setNox(Double nox) {
        this.nox = nox;
    }

    public Double getFactorNh3() {
        return factorNh3;
    }

    public void setFactorNh3(Double factorNh3) {
        this.factorNh3 = factorNh3;
    }

    public Double getNh3() {
        return nh3;
    }

    public void setNh3(Double nh3) {
        this.nh3 = nh3;
    }

    public Double getFactorOc() {
        return factorOc;
    }

    public void setFactorOc(Double factorOc) {
        this.factorOc = factorOc;
    }

    public Double getOc() {
        return oc;
    }

    public void setOc(Double oc) {
        this.oc = oc;
    }

    public Double getFactorBc() {
        return factorBc;
    }

    public void setFactorBc(Double factorBc) {
        this.factorBc = factorBc;
    }

    public Double getBc() {
        return bc;
    }

    public void setBc(Double bc) {
        this.bc = bc;
    }

    public String getScccode() {
        return scccode;
    }

    public void setScccode(String scccode) {
        this.scccode = scccode == null ? null : scccode.trim();
    }

    public Double getFeiqiti() {
        return feiqiti;
    }

    public void setFeiqiti(Double feiqiti) {
        this.feiqiti = feiqiti;
    }

    public Double getSo2out() {
        return so2out;
    }

    public void setSo2out(Double so2out) {
        this.so2out = so2out;
    }

    public Double getPmout() {
        return pmout;
    }

    public void setPmout(Double pmout) {
        this.pmout = pmout;
    }

    public Double getNoxout() {
        return noxout;
    }

    public void setNoxout(Double noxout) {
        this.noxout = noxout;
    }

    public Double getJanUseamount() {
        return janUseamount;
    }

    public void setJanUseamount(Double janUseamount) {
        this.janUseamount = janUseamount;
    }

    public Double getFebUseamount() {
        return febUseamount;
    }

    public void setFebUseamount(Double febUseamount) {
        this.febUseamount = febUseamount;
    }

    public Double getMarUseamount() {
        return marUseamount;
    }

    public void setMarUseamount(Double marUseamount) {
        this.marUseamount = marUseamount;
    }

    public Double getAprUseamount() {
        return aprUseamount;
    }

    public void setAprUseamount(Double aprUseamount) {
        this.aprUseamount = aprUseamount;
    }

    public Double getMayUseamount() {
        return mayUseamount;
    }

    public void setMayUseamount(Double mayUseamount) {
        this.mayUseamount = mayUseamount;
    }

    public Double getJuneUseamount() {
        return juneUseamount;
    }

    public void setJuneUseamount(Double juneUseamount) {
        this.juneUseamount = juneUseamount;
    }

    public Double getJulyUseamount() {
        return julyUseamount;
    }

    public void setJulyUseamount(Double julyUseamount) {
        this.julyUseamount = julyUseamount;
    }

    public Double getAugUseamount() {
        return augUseamount;
    }

    public void setAugUseamount(Double augUseamount) {
        this.augUseamount = augUseamount;
    }

    public Double getSeptUseamount() {
        return septUseamount;
    }

    public void setSeptUseamount(Double septUseamount) {
        this.septUseamount = septUseamount;
    }

    public Double getOctUseAmount() {
        return octUseAmount;
    }

    public void setOctUseAmount(Double octUseAmount) {
        this.octUseAmount = octUseAmount;
    }

    public Double getNovUseamount() {
        return novUseamount;
    }

    public void setNovUseamount(Double novUseamount) {
        this.novUseamount = novUseamount;
    }

    public Double getDecUseamount() {
        return decUseamount;
    }

    public void setDecUseamount(Double decUseamount) {
        this.decUseamount = decUseamount;
    }
}