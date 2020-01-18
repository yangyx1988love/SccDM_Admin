package nankai.xl.business.model.vo;

import nankai.xl.business.model.Company;

public class CompanyVo extends Company {
    private String cityName;

    private String cityCode;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
