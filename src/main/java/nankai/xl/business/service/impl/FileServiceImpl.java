package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.CompanyMapper;
import nankai.xl.business.mapper.ScatteredCoalMapper;
import nankai.xl.business.mapper.Scc4Mapper;
import nankai.xl.business.mapper.ShGasemissionMapper;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.SccVo;
import nankai.xl.business.service.FileService;
import nankai.xl.common.exception.DuplicateNameException;
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


    private int length=18;
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
    public boolean isLongitude(String longitude,int length){
        if(!NumberUtil.isLongitude(longitude)){
            return false;
        }
        if(String.valueOf(Double.valueOf(longitude)).length()>length){
            return false;
        }
        return true;
    }
    public boolean isLatitude(String latitude,int length){
        if(!NumberUtil.isLatitude(latitude)){
            return false;
        }
        if(String.valueOf(Double.valueOf(latitude)).length()>length){
            return false;
        }
        return true;
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
            if (!NumberUtil.isDouble(strs[5],length)&&!NumberUtil.isDouble(strs[7],length)&&!NumberUtil.isDouble(strs[8],length)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+length+"位正浮点数！");
            }
            scatteredCoal.setActivityLevelNum(Double.valueOf(strs[5]));
            scatteredCoal.setControlMeasure(strs[6]);
            scatteredCoal.setSulfurContent(Double.valueOf(strs[7]));
            scatteredCoal.setAshContent(Double.valueOf(strs[8]));
            for (int j = 9; j <18 ; j++) {
                if(!NumberUtil.isDouble(strs[j],length)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+length+"位正浮点数！");
                }
            }
            if (isCul){
                scatteredCoal.setPm10Emission(Double.valueOf(strs[9]));
                scatteredCoal.setPm25Emission(Double.valueOf(strs[10]));
                scatteredCoal.setCoEmission(Double.valueOf(strs[11]));
                scatteredCoal.setVocEmission(Double.valueOf(strs[12]));
                scatteredCoal.setSo2Emission(Double.valueOf(strs[13]));
                scatteredCoal.setNoxEmission(Double.valueOf(strs[14]));
                scatteredCoal.setNh3Emission(Double.valueOf(strs[15]));
                scatteredCoal.setOcEmission(Double.valueOf(strs[16]));
                scatteredCoal.setBcEmission(Double.valueOf(strs[17]));
            }else{
                //计算
            }
            scatteredCoal.setSourceDescription(sccDescribe);
            scatteredCoalList.add(scatteredCoal);
        }
        scatteredCoalMapper.insertList(scatteredCoalList);
        return i+1;
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
            if (!isLongitude(strs[6],length)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!isLatitude(strs[7],length)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            company.setLongitude(Double.valueOf(strs[6]));
            company.setLatitude(Double.valueOf(strs[7]));
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
            shGasemission.setGyName(strs[8]);
            shGasemission.setActivityNote(strs[9]);
            if (!NumberUtil.isDouble(strs[10],length)&&!NumberUtil.isDouble(strs[11],length)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+length+"位正浮点数！");
            }
            shGasemission.setDensity(Double.valueOf(strs[10]));
            shGasemission.setActivity(Double.valueOf(strs[11]));
            shGasemission.setActivityUnit(strs[12]);
            if (!NumberUtil.isRatio(strs[13],length)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+length+"位正浮点数！");
            }
            shGasemission.setEfficency(Double.valueOf(strs[13]));
            shGasemission.setEmissionUnit(strs[14]);
            for (int j = 15; j <24 ; j++) {
                if(!NumberUtil.isDouble(strs[j],length)){
                    throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+length+"位正浮点数！");
                }
            }
            if (isCul){
                shGasemission.setPm10Emission(Double.valueOf(strs[15]));
                shGasemission.setPm25Emission(Double.valueOf(strs[16]));
                shGasemission.setCoEmission(Double.valueOf(strs[17]));
                shGasemission.setVocEmission(Double.valueOf(strs[18]));
                shGasemission.setSo2Emission(Double.valueOf(strs[19]));
                shGasemission.setNoxEmission(Double.valueOf(strs[20]));
                shGasemission.setNh3Emission(Double.valueOf(strs[21]));
                shGasemission.setOcEmission(Double.valueOf(strs[22]));
                shGasemission.setBcEmission(Double.valueOf(strs[23]));
            }else {
                //计算
            }
            shGasemission.setSourceDiscrip(sccDescribe);
            shGasemissionList.add(shGasemission);
        }
        for (ShGasemission shGasemission:shGasemissionList) {
            shGasemissionMapper.insertSelective(shGasemission);
        }
        return i+1;
    }
}
