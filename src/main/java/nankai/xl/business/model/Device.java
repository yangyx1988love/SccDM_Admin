package nankai.xl.business.model;

public class Device {
    private Integer id;

    private Integer nkNo;

    private Integer productrawtotalId;

    private String name;

    private String deviceNo;

    private String deviceFlow;

    private Double designPower;

    private Double practicalPower;

    private Integer exhustNo;

    private Integer exhustId;

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

    public Integer getProductrawtotalId() {
        return productrawtotalId;
    }

    public void setProductrawtotalId(Integer productrawtotalId) {
        this.productrawtotalId = productrawtotalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
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

    public Integer getExhustNo() {
        return exhustNo;
    }

    public void setExhustNo(Integer exhustNo) {
        this.exhustNo = exhustNo;
    }

    public Integer getExhustId() {
        return exhustId;
    }

    public void setExhustId(Integer exhustId) {
        this.exhustId = exhustId;
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