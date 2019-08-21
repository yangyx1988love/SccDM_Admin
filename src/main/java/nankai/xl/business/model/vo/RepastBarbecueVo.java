package nankai.xl.business.model.vo;

import nankai.xl.business.model.RepastBarbecue;

public class RepastBarbecueVo extends RepastBarbecue {
    private String countyId;

    private String companyName;

    private String countyName;

    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
