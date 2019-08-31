package nankai.xl.business.model.vo;

import nankai.xl.business.model.StrawCompost;

public class StrawCompostVo extends StrawCompost {
    private String scc1;

    private String scc2;

    private String scc3;

    private String scc4;

    private String countyName;

    private String cityName;

    private String cityCode;

    public String getScc1() {
        return scc1;
    }

    public void setScc1(String scc1) {
        this.scc1 = scc1;
    }

    public String getScc2() {
        return scc2;
    }

    public void setScc2(String scc2) {
        this.scc2 = scc2;
    }

    public String getScc3() {
        return scc3;
    }

    public void setScc3(String scc3) {
        this.scc3 = scc3;
    }

    public String getScc4() {
        return scc4;
    }

    public void setScc4(String scc4) {
        this.scc4 = scc4;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

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
