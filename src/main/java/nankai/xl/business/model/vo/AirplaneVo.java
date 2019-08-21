package nankai.xl.business.model.vo;

import nankai.xl.business.model.Airplane;

public class AirplaneVo extends Airplane {
    private String countyName;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}
