package nankai.xl.business.model;

public class Dustremove {
    private Integer id;

    private String dustRemoveId;

    private String dustRemoveName;

    private Double pmRemoveEffi;

    private Double pm10RemoveEffi;

    private Double pm25RemoveEffi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDustRemoveId() {
        return dustRemoveId;
    }

    public void setDustRemoveId(String dustRemoveId) {
        this.dustRemoveId = dustRemoveId == null ? null : dustRemoveId.trim();
    }

    public String getDustRemoveName() {
        return dustRemoveName;
    }

    public void setDustRemoveName(String dustRemoveName) {
        this.dustRemoveName = dustRemoveName == null ? null : dustRemoveName.trim();
    }

    public Double getPmRemoveEffi() {
        return pmRemoveEffi;
    }

    public void setPmRemoveEffi(Double pmRemoveEffi) {
        this.pmRemoveEffi = pmRemoveEffi;
    }

    public Double getPm10RemoveEffi() {
        return pm10RemoveEffi;
    }

    public void setPm10RemoveEffi(Double pm10RemoveEffi) {
        this.pm10RemoveEffi = pm10RemoveEffi;
    }

    public Double getPm25RemoveEffi() {
        return pm25RemoveEffi;
    }

    public void setPm25RemoveEffi(Double pm25RemoveEffi) {
        this.pm25RemoveEffi = pm25RemoveEffi;
    }
}