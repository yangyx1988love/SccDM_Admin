package nankai.xl.business.model.vo;

import nankai.xl.business.model.DryCleaner;

public class DryCleanerVo extends DryCleaner {
    private String countyId;

    private String companyName;

    private String countyName;

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}
