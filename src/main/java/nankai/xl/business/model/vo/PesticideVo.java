package nankai.xl.business.model.vo;

import nankai.xl.business.model.Pesticide;

public class PesticideVo extends Pesticide {
    private String countyName;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}
