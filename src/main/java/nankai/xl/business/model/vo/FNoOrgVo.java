package nankai.xl.business.model.vo;

import nankai.xl.business.model.FNoOrganizationWorkshopDischarge;

import java.util.ArrayList;
import java.util.List;

public class FNoOrgVo {

    private Integer[] wsid;

    private Integer[] workshopid;

    private Double[] longitude;

    private Double[] latitude;

    private String[] productionUse;

    private Double[] workshopArea;

    public Integer[] getWsid() {
        return wsid;
    }

    public void setWsid(Integer[] wsid) {
        this.wsid = wsid;
    }

    public Integer[] getWorkshopid() {
        return workshopid;
    }

    public void setWorkshopid(Integer[] workshopid) {
        this.workshopid = workshopid;
    }

    public Double[] getLongitude() {
        return longitude;
    }

    public void setLongitude(Double[] longitude) {
        this.longitude = longitude;
    }

    public Double[] getLatitude() {
        return latitude;
    }

    public void setLatitude(Double[] latitude) {
        this.latitude = latitude;
    }

    public String[] getProductionUse() {
        return productionUse;
    }

    public void setProductionUse(String[] productionUse) {
        this.productionUse = productionUse;
    }

    public Double[] getWorkshopArea() {
        return workshopArea;
    }

    public void setWorkshopArea(Double[] workshopArea) {
        this.workshopArea = workshopArea;
    }
    public static List<FNoOrganizationWorkshopDischarge> recover(FNoOrgVo fNoOrgVo) {
        List<FNoOrganizationWorkshopDischarge> list=new ArrayList<>();
        for (int i = 0; i < fNoOrgVo.wsid.length; i++) {
            FNoOrganizationWorkshopDischarge f=new FNoOrganizationWorkshopDischarge();
            if (fNoOrgVo.getWsid()!=null){
                f.setWsid(fNoOrgVo.getWsid()[i]);
            }
            if (fNoOrgVo.getWorkshopid()!=null){
                f.setWorkshopid(fNoOrgVo.getWorkshopid()[i]);
            }
            if (fNoOrgVo.getLatitude()!=null){
                f.setLatitude(fNoOrgVo.getLatitude()[i]);
            }
            if (fNoOrgVo.getLongitude()!=null){
                f.setLongitude(fNoOrgVo.getLongitude()[i]);
            }
            if (fNoOrgVo.getProductionUse()!=null){
                f.setProductionUse(fNoOrgVo.getProductionUse()[i]);
            }
            if (fNoOrgVo.getWorkshopArea()!=null){
                f.setWorkshopArea(fNoOrgVo.getWorkshopArea()[i]);
            }
            list.add(f);
        }
        return list;
    }
}