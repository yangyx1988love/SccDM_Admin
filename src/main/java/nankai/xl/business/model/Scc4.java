package nankai.xl.business.model;

public class Scc4 {
    private Integer id;

    private String scc1;

    private String scc2;

    private String scc3;

    private String scc4;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScc1() {
        return scc1;
    }

    public void setScc1(String scc1) {
        this.scc1 = scc1 == null ? null : scc1.trim();
    }

    public String getScc2() {
        return scc2;
    }

    public void setScc2(String scc2) {
        this.scc2 = scc2 == null ? null : scc2.trim();
    }

    public String getScc3() {
        return scc3;
    }

    public void setScc3(String scc3) {
        this.scc3 = scc3 == null ? null : scc3.trim();
    }

    public String getScc4() {
        return scc4;
    }

    public void setScc4(String scc4) {
        this.scc4 = scc4 == null ? null : scc4.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}