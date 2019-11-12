package nankai.xl.business.model.vo;

import nankai.xl.business.model.Exhaust;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExhaustVo {
    
    private Integer[] exfId;

    private Integer[] nkNo;

    private Integer[] factoryId;

    private String[] exfMaterial;

    private Double[] exfHeight;

    private Double[] smokeOutd;

    private Double[] smokeOUtteM;

    private Double[] smokeOuta;

    private Double[] smokeOutv;

    private Double[] exfLongitude;

    private Double[] exfLatitude;

    public Integer[] getExfId() {
        return exfId;
    }

    public void setExfId(Integer[] exfId) {
        this.exfId = exfId;
    }

    public Integer[] getNkNo() {
        return nkNo;
    }

    public void setNkNo(Integer[] nkNo) {
        this.nkNo = nkNo;
    }

    public Integer[] getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer[] factoryId) {
        this.factoryId = factoryId;
    }

    public String[] getExfMaterial() {
        return exfMaterial;
    }

    public void setExfMaterial(String[] exfMaterial) {
        this.exfMaterial = exfMaterial;
    }

    public Double[] getExfHeight() {
        return exfHeight;
    }

    public void setExfHeight(Double[] exfHeight) {
        this.exfHeight = exfHeight;
    }

    public Double[] getSmokeOutd() {
        return smokeOutd;
    }

    public void setSmokeOutd(Double[] smokeOutd) {
        this.smokeOutd = smokeOutd;
    }

    public Double[] getSmokeOUtteM() {
        return smokeOUtteM;
    }

    public void setSmokeOUtteM(Double[] smokeOUtteM) {
        this.smokeOUtteM = smokeOUtteM;
    }

    public Double[] getSmokeOuta() {
        return smokeOuta;
    }

    public void setSmokeOuta(Double[] smokeOuta) {
        this.smokeOuta = smokeOuta;
    }

    public Double[] getSmokeOutv() {
        return smokeOutv;
    }

    public void setSmokeOutv(Double[] smokeOutv) {
        this.smokeOutv = smokeOutv;
    }

    public Double[] getExfLongitude() {
        return exfLongitude;
    }

    public void setExfLongitude(Double[] exfLongitude) {
        this.exfLongitude = exfLongitude;
    }

    public Double[] getExfLatitude() {
        return exfLatitude;
    }

    public void setExfLatitude(Double[] exfLatitude) {
        this.exfLatitude = exfLatitude;
    }

    public static List<Exhaust> recoverExhaustList(ExhaustVo exhaustVo) {
        List<Exhaust> exhaustList=new ArrayList<>();
        for (int i = 0; i < exhaustVo.exfId.length; i++) {
            Exhaust exhaust=new Exhaust();
            if (exhaustVo.exfId != null) {
                exhaust.setExfId(exhaustVo.exfId[i]);
            }
            if (exhaustVo.nkNo != null) {
                exhaust.setNkNo(exhaustVo.nkNo[i]);
            }
            if (exhaustVo.factoryId != null) {
                exhaust.setFactoryId(exhaustVo.factoryId[i]);
            }
            if (exhaustVo.exfMaterial != null) {
                exhaust.setExfMaterial(exhaustVo.exfMaterial[i]);
            }
            if (exhaustVo.exfHeight != null) {
                exhaust.setExfHeight(exhaustVo.exfHeight[i]);
            }
            if (exhaustVo.smokeOutd != null) {
                exhaust.setSmokeOutd(exhaustVo.smokeOutd[i]);
            }
            if (exhaustVo.smokeOUtteM != null) {
                exhaust.setSmokeOUtteM(exhaustVo.smokeOUtteM[i]);
            }
            if (exhaustVo.smokeOuta != null) {
                exhaust.setSmokeOuta(exhaustVo.smokeOuta[i]);
            }
            if (exhaustVo.smokeOutv != null) {
                exhaust.setSmokeOutv(exhaustVo.smokeOutv[i]);
            }
            if (exhaustVo.exfLongitude != null) {
                exhaust.setExfLongitude(exhaustVo.exfLongitude[i]);
            }
            if (exhaustVo.exfLatitude != null) {
                exhaust.setExfLatitude(exhaustVo.exfLatitude[i]);
            }
            exhaustList.add(exhaust);
        }
       return exhaustList;
    }
}