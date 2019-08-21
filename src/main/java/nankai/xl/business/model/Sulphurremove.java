package nankai.xl.business.model;

public class Sulphurremove {
    private Integer id;

    private String sulphurRemoveId;

    private String sulphurClassify;

    private String sulphurMethod;

    private Double sulphurRemoveEffi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSulphurRemoveId() {
        return sulphurRemoveId;
    }

    public void setSulphurRemoveId(String sulphurRemoveId) {
        this.sulphurRemoveId = sulphurRemoveId == null ? null : sulphurRemoveId.trim();
    }

    public String getSulphurClassify() {
        return sulphurClassify;
    }

    public void setSulphurClassify(String sulphurClassify) {
        this.sulphurClassify = sulphurClassify == null ? null : sulphurClassify.trim();
    }

    public String getSulphurMethod() {
        return sulphurMethod;
    }

    public void setSulphurMethod(String sulphurMethod) {
        this.sulphurMethod = sulphurMethod == null ? null : sulphurMethod.trim();
    }

    public Double getSulphurRemoveEffi() {
        return sulphurRemoveEffi;
    }

    public void setSulphurRemoveEffi(Double sulphurRemoveEffi) {
        this.sulphurRemoveEffi = sulphurRemoveEffi;
    }
}