package nankai.xl.business.model;

public class Nitreremove {
    private Integer id;

    private String nitreRemoveId;

    private String nitreMethod;

    private Double noxRemoveEffi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNitreRemoveId() {
        return nitreRemoveId;
    }

    public void setNitreRemoveId(String nitreRemoveId) {
        this.nitreRemoveId = nitreRemoveId == null ? null : nitreRemoveId.trim();
    }

    public String getNitreMethod() {
        return nitreMethod;
    }

    public void setNitreMethod(String nitreMethod) {
        this.nitreMethod = nitreMethod == null ? null : nitreMethod.trim();
    }

    public Double getNoxRemoveEffi() {
        return noxRemoveEffi;
    }

    public void setNoxRemoveEffi(Double noxRemoveEffi) {
        this.noxRemoveEffi = noxRemoveEffi;
    }
}