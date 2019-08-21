package nankai.xl.business.model.vo;

import nankai.xl.business.model.ScatteredCoal;

public class ScatteredCoalVo extends ScatteredCoal {
    private String countyName;
    private String cityName;

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
}
