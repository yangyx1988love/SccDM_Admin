package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.SccVo;
import nankai.xl.business.service.FileService;
import nankai.xl.common.exception.DuplicateNameException;
import nankai.xl.common.util.Arith;
import nankai.xl.common.util.DateUtils;
import nankai.xl.common.util.NumberUtil;
import nankai.xl.system.mapper.MenuMapper;
import nankai.xl.system.model.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private Scc4Mapper scc4Mapper;
    @Resource
    private ScatteredCoalMapper scatteredCoalMapper;
    @Resource
    private ShGasemissionMapper shGasemissionMapper;
    @Resource
    private ShSealpointMapper shSealpointMapper;
    @Resource
    private ShEffluentemissionMapper shEffluentemissionMapper;
    @Resource
    private ShVocdeviceeffiMapper shVocdeviceeffiMapper;

    private int integerNum=8;

    private int decimalName=8;
    @Override
    public int importTempleFileToSource(String soureId, List<String[]> list,boolean isCul) {
        Menu menu=menuMapper.selectByPrimaryKey(Integer.parseInt(soureId));
        String sourceName=menu.getMenuName();
        int num=0;
        if (sourceName.contains("散煤")){
            num=importScatteredCoal(list,isCul);
        }
        if (sourceName.contains("石化有组织废气")){
            num=importShGasemission(list,isCul);
        }
        if (sourceName.contains("装置密封点")){
            num=importShSealpoint(list,isCul);
        }
        if (sourceName.contains("废水无组织")){
            num=importShEffluentemission(list,isCul);
        }
        if (sourceName.contains("VOC处理装置")){
            num=importShVocdeviceeffi(list,isCul);
        }
        return num;
    }
    public String getSccDescribe(String sccCode){
        if (!NumberUtil.isNumeric(sccCode,16)){
            return null;
        }
        SccVo sccVo=scc4Mapper.selectBySccCode(sccCode);
        if (sccVo==null){
            return null;
        }
        return sccVo.getDescription();
    }
    public int getCompanyId(Company company){
        int comId=0;
        Company co= companyMapper.selectByFullName(company.getCompanyName());
        if(co==null){
            companyMapper.insertSelective(company);
            comId=company.getComId();
        }else{
            comId=co.getComId();
        }
        return comId;
    }
    public Double getDecimal(String str){
        return Arith.round(str,decimalName);
    }
    public int importScatteredCoal(List<String[]> list,boolean isCul){
        List<ScatteredCoal> scatteredCoalList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            ScatteredCoal scatteredCoal=new ScatteredCoal();
            String sccDescribe=getSccDescribe(strs[0]);
            if (sccDescribe==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            scatteredCoal.setSccCode(strs[0]);
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            scatteredCoal.setYear(strs[1]);
            scatteredCoal.setCountyId(strs[2]);
            scatteredCoal.setActivityLevel(strs[3]);
            scatteredCoal.setFuelMeteringUnit(strs[4]);
            if (!NumberUtil.isPosDouble(strs[5],integerNum)&&!NumberUtil.isPosDouble(strs[7],integerNum)&&!NumberUtil.isPosDouble(strs[8],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            scatteredCoal.setActivityLevelNum(getDecimal(strs[5]));
            scatteredCoal.setControlMeasure(strs[6]);
            scatteredCoal.setSulfurContent(getDecimal(strs[7]));
            scatteredCoal.setAshContent(getDecimal(strs[8]));
            for (int j = 9; j <18 ; j++) {
                if(!NumberUtil.isPosDouble(strs[j],integerNum)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
                }
            }
            if (isCul){
                scatteredCoal.setPm10Emission(getDecimal(strs[9]));
                scatteredCoal.setPm25Emission(getDecimal(strs[10]));
                scatteredCoal.setCoEmission(getDecimal(strs[11]));
                scatteredCoal.setVocEmission(getDecimal(strs[12]));
                scatteredCoal.setSo2Emission(getDecimal(strs[13]));
                scatteredCoal.setNoxEmission(getDecimal(strs[14]));
                scatteredCoal.setNh3Emission(getDecimal(strs[15]));
                scatteredCoal.setOcEmission(getDecimal(strs[16]));
                scatteredCoal.setBcEmission(getDecimal(strs[17]));
            }else{
                //计算
            }
            scatteredCoal.setSourceDescription(sccDescribe);
            scatteredCoalList.add(scatteredCoal);
        }
        scatteredCoalMapper.insertList(scatteredCoalList);
        return i;
    }
    public int importShGasemission(List<String[]> list,boolean isCul){
        List<ShGasemission> shGasemissionList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);

            ShGasemission shGasemission=new ShGasemission();
            String sccDescribe=getSccDescribe(strs[0]);
            if (sccDescribe==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            shGasemission.setScccode(strs[0]);
            shGasemission.setYear(strs[1]);
            shGasemission.setFactoryId(getCompanyId(company));
            shGasemission.setGyName(strs[9]);
            shGasemission.setActivityNote(strs[10]);
            if (!NumberUtil.isPosDouble(strs[11],integerNum)&&!NumberUtil.isPosDouble(strs[12],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            shGasemission.setDensity(getDecimal(strs[11]));
            shGasemission.setActivity(getDecimal(strs[12]));
            shGasemission.setActivityUnit(strs[13]);
            if (!NumberUtil.isRatio(strs[14],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            shGasemission.setEfficency(getDecimal(strs[14]));
            shGasemission.setEmissionUnit(strs[15]);
            for (int j = 16; j <25 ; j++) {
                if(!NumberUtil.isPosDouble(strs[j],integerNum)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
                }
            }
            if (isCul){
                shGasemission.setPm10Emission(getDecimal(strs[16]));
                shGasemission.setPm25Emission(getDecimal(strs[17]));
                shGasemission.setCoEmission(getDecimal(strs[18]));
                shGasemission.setVocEmission(getDecimal(strs[19]));
                shGasemission.setSo2Emission(getDecimal(strs[20]));
                shGasemission.setNoxEmission(getDecimal(strs[21]));
                shGasemission.setNh3Emission(getDecimal(strs[22]));
                shGasemission.setOcEmission(getDecimal(strs[23]));
                shGasemission.setBcEmission(getDecimal(strs[24]));
            }else {
                //计算
            }
            shGasemission.setSourceDiscrip(sccDescribe);
            shGasemissionList.add(shGasemission);
        }
        shGasemissionMapper.insertList(shGasemissionList);
        return i;
    }
    public int importShSealpoint(List<String[]> list,boolean isCul){
        List<ShSealpoint> shSealpointList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);

            ShSealpoint shSealpoint=new ShSealpoint();
            String sccDescribe=getSccDescribe(strs[0]);
            if (sccDescribe==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            shSealpoint.setScccode(strs[0]);
            shSealpoint.setYear(strs[1]);
            shSealpoint.setFactoryId(getCompanyId(company));
            shSealpoint.setUnitType(strs[9]);
            if (!NumberUtil.isPosDouble(strs[10],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            shSealpoint.setActivity(getDecimal(strs[10]));
            shSealpoint.setActivityUnit(strs[11]);
            for (int j = 12; j <21 ; j++) {
                if(!NumberUtil.isPosDouble(strs[j],integerNum)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
                }
            }
            if (isCul){
                shSealpoint.setPm10Emission(getDecimal(strs[12]));
                shSealpoint.setPm25Emission(getDecimal(strs[13]));
                shSealpoint.setCoEmission(getDecimal(strs[14]));
                shSealpoint.setVocEmission(getDecimal(strs[15]));
                shSealpoint.setSo2Emission(getDecimal(strs[16]));
                shSealpoint.setNoxEmission(getDecimal(strs[17]));
                shSealpoint.setNh3Emission(getDecimal(strs[18]));
                shSealpoint.setOcEmission(getDecimal(strs[19]));
                shSealpoint.setBcEmission(getDecimal(strs[20]));
            }else {
                //计算
            }
            shSealpoint.setSourceDiscrip(sccDescribe);
            shSealpointList.add(shSealpoint);
        }
        shSealpointMapper.insertList(shSealpointList);
        return i;
    }
    public int importShEffluentemission(List<String[]> list,boolean isCul){
        List<ShEffluentemission> shEffluentemissionList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);

            ShEffluentemission shEffluentemission=new ShEffluentemission();
            String sccDescribe=getSccDescribe(strs[0]);
            if (sccDescribe==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            shEffluentemission.setScccode(strs[0]);
            shEffluentemission.setYear(strs[1]);
            shEffluentemission.setFactoryId(getCompanyId(company));
            shEffluentemission.setActivityNote(strs[9]);
            if (!NumberUtil.isPosDouble(strs[10],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            shEffluentemission.setActivity(getDecimal(strs[10]));
            shEffluentemission.setActivityUnit(strs[11]);
            if (!NumberUtil.isRatio(strs[12],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            shEffluentemission.setEmissionUnit(strs[13]);
            shEffluentemission.setVocEfficency(getDecimal(strs[12]));
            for (int j = 14; j <23 ; j++) {
                if(!NumberUtil.isPosDouble(strs[j],integerNum)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
                }
            }
            if (isCul){
                shEffluentemission.setPm10Emission(getDecimal(strs[14]));
                shEffluentemission.setPm25Emission(getDecimal(strs[15]));
                shEffluentemission.setCoEmission(getDecimal(strs[16]));
                shEffluentemission.setVocEmission(getDecimal(strs[17]));
                shEffluentemission.setSo2Emission(getDecimal(strs[18]));
                shEffluentemission.setNoxEmission(getDecimal(strs[19]));
                shEffluentemission.setNh3Emission(getDecimal(strs[20]));
                shEffluentemission.setOcEmission(getDecimal(strs[21]));
                shEffluentemission.setBcEmission(getDecimal(strs[22]));
            }else {
                //计算
            }
            shEffluentemission.setSourceDiscrip(sccDescribe);
            shEffluentemissionList.add(shEffluentemission);
        }
        shEffluentemissionMapper.insertList(shEffluentemissionList);
        return i;
    }
    public int importShVocdeviceeffi(List<String[]> list,boolean isCul){
        List<ShVocdeviceeffi> shVocdeviceeffiList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);

            ShVocdeviceeffi shVocdeviceeffi=new ShVocdeviceeffi();
            String sccDescribe=getSccDescribe(strs[0]);
            if (sccDescribe==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            shVocdeviceeffi.setScccode(strs[0]);
            shVocdeviceeffi.setYear(strs[1]);
            shVocdeviceeffi.setFactoryId(getCompanyId(company));
            shVocdeviceeffi.setWorkshopSection(strs[9]);
            shVocdeviceeffi.setGyName(strs[10]);
            if (!NumberUtil.isPosDouble(strs[11],integerNum)&&!NumberUtil.isPosDouble(strs[12],integerNum)&&!NumberUtil.isPosDouble(strs[13],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            shVocdeviceeffi.setAnnualRuntime(getDecimal(strs[11]));
            shVocdeviceeffi.setExitAirvolume(getDecimal(strs[12]));
            shVocdeviceeffi.setExitConcentration(getDecimal(strs[13]));
            if (!NumberUtil.isRatio(strs[14],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            shVocdeviceeffi.setEfficency(getDecimal(strs[14]));
            shVocdeviceeffi.setEmissionUnit(strs[15]);
            for (int j = 16; j <25 ; j++) {
                if(!NumberUtil.isPosDouble(strs[j],integerNum)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
                }
            }
            if (isCul){
                shVocdeviceeffi.setPm10Emission(getDecimal(strs[16]));
                shVocdeviceeffi.setPm25Emission(getDecimal(strs[17]));
                shVocdeviceeffi.setCoEmission(getDecimal(strs[18]));
                shVocdeviceeffi.setVocEmission(getDecimal(strs[19]));
                shVocdeviceeffi.setSo2Emission(getDecimal(strs[20]));
                shVocdeviceeffi.setNoxEmission(getDecimal(strs[21]));
                shVocdeviceeffi.setNh3Emission(getDecimal(strs[22]));
                shVocdeviceeffi.setOcEmission(getDecimal(strs[23]));
                shVocdeviceeffi.setBcEmission(getDecimal(strs[24]));
            }else {
                //计算
            }
            shVocdeviceeffi.setSourceDiscrip(sccDescribe);
            shVocdeviceeffiList.add(shVocdeviceeffi);
        }
        shVocdeviceeffiMapper.insertList(shVocdeviceeffiList);
        return i;
    }
}
