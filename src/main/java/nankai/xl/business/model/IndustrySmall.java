package nankai.xl.business.model;

public class IndustrySmall {
    private Integer id;

    private String industryBig;

    private String industrySmall;

    private String industryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryBig() {
        return industryBig;
    }

    public void setIndustryBig(String industryBig) {
        this.industryBig = industryBig == null ? null : industryBig.trim();
    }

    public String getIndustrySmall() {
        return industrySmall;
    }

    public void setIndustrySmall(String industrySmall) {
        this.industrySmall = industrySmall == null ? null : industrySmall.trim();
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }
}