package nankai.xl.business.model.vo;

import nankai.xl.business.model.*;

import java.util.List;

public class FactoryMessSumVo {
    private Integer factoryId;

    private List<Exhaust> exhausts;

    private List<Boiler> boilers;

    private List<Kiln> kilns;

    private List<Device> devices;

    private List<DeviceRaw> deviceRaws;

    private List<DeviceProduct> deviceProducts;

    private List<RongjiRaw> rongjiRaws;

    private List<RongjiProduct> rongjiProducts;

    private List<Feiqi> feiqis;

    private List<FBareSoilDustSource> fBareSoilDustSources;

    private  List<FConstructionDustSource> fConstructionDustSources;

    private List<FRoadDustSource> fRoadDustSources;

    private  List<FYardDustSource> fYardDustSources;

    private List<FNoOrganizationWorkshopDischarge> fNoOrgs;

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public List<Exhaust> getExhausts() {
        return exhausts;
    }

    public void setExhausts(List<Exhaust> exhausts) {
        this.exhausts = exhausts;
    }

    public List<Boiler> getBoilers() {
        return boilers;
    }

    public void setBoilers(List<Boiler> boilers) {
        this.boilers = boilers;
    }

    public List<Kiln> getKilns() {
        return kilns;
    }

    public void setKilns(List<Kiln> kilns) {
        this.kilns = kilns;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<DeviceRaw> getDeviceRaws() {
        return deviceRaws;
    }

    public void setDeviceRaws(List<DeviceRaw> deviceRaws) {
        this.deviceRaws = deviceRaws;
    }

    public List<DeviceProduct> getDeviceProducts() {
        return deviceProducts;
    }

    public void setDeviceProducts(List<DeviceProduct> deviceProducts) {
        this.deviceProducts = deviceProducts;
    }

    public List<RongjiRaw> getRongjiRaws() {
        return rongjiRaws;
    }

    public void setRongjiRaws(List<RongjiRaw> rongjiRaws) {
        this.rongjiRaws = rongjiRaws;
    }

    public List<RongjiProduct> getRongjiProducts() {
        return rongjiProducts;
    }

    public void setRongjiProducts(List<RongjiProduct> rongjiProducts) {
        this.rongjiProducts = rongjiProducts;
    }

    public List<Feiqi> getFeiqis() {
        return feiqis;
    }

    public void setFeiqis(List<Feiqi> feiqis) {
        this.feiqis = feiqis;
    }

    public List<FBareSoilDustSource> getfBareSoilDustSources() {
        return fBareSoilDustSources;
    }

    public void setfBareSoilDustSources(List<FBareSoilDustSource> fBareSoilDustSources) {
        this.fBareSoilDustSources = fBareSoilDustSources;
    }

    public List<FConstructionDustSource> getfConstructionDustSources() {
        return fConstructionDustSources;
    }

    public void setfConstructionDustSources(List<FConstructionDustSource> fConstructionDustSources) {
        this.fConstructionDustSources = fConstructionDustSources;
    }

    public List<FRoadDustSource> getfRoadDustSources() {
        return fRoadDustSources;
    }

    public void setfRoadDustSources(List<FRoadDustSource> fRoadDustSources) {
        this.fRoadDustSources = fRoadDustSources;
    }

    public List<FYardDustSource> getfYardDustSources() {
        return fYardDustSources;
    }

    public void setfYardDustSources(List<FYardDustSource> fYardDustSources) {
        this.fYardDustSources = fYardDustSources;
    }

    public List<FNoOrganizationWorkshopDischarge> getfNoOrgs() {
        return fNoOrgs;
    }

    public void setfNoOrgs(List<FNoOrganizationWorkshopDischarge> fNoOrgs) {
        this.fNoOrgs = fNoOrgs;
    }
}
