package nankai.xl.business.model.vo;

import nankai.xl.business.model.House;

public class HouseVo extends House {
    private String countyName;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}
