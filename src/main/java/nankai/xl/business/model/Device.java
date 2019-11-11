package nankai.xl.business.model;

public class Device {
    private Integer id;

    private Integer nkNo;

    private Integer exhustId;

    private String name;

    private String deviceFlow;

    private Double designPower;

    private Double practicalPower;

    private Integer yearrunDays;

    private String designUnit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNkNo() {
        return nkNo;
    }

    public void setNkNo(Integer nkNo) {
        this.nkNo = nkNo;
    }

    public Integer getExhustId() {
        return exhustId;
    }

    public void setExhustId(Integer exhustId) {
        this.exhustId = exhustId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeviceFlow() {
        return deviceFlow;
    }

    public void setDeviceFlow(String deviceFlow) {
        this.deviceFlow = deviceFlow == null ? null : deviceFlow.trim();
    }

    public Double getDesignPower() {
        return designPower;
    }

    public void setDesignPower(Double designPower) {
        this.designPower = designPower;
    }

    public Double getPracticalPower() {
        return practicalPower;
    }

    public void setPracticalPower(Double practicalPower) {
        this.practicalPower = practicalPower;
    }

    public Integer getYearrunDays() {
        return yearrunDays;
    }

    public void setYearrunDays(Integer yearrunDays) {
        this.yearrunDays = yearrunDays;
    }

    public String getDesignUnit() {
        return designUnit;
    }

    public void setDesignUnit(String designUnit) {
        this.designUnit = designUnit == null ? null : designUnit.trim();
    }
}