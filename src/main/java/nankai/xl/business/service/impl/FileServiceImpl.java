package nankai.xl.business.service.impl;

import nankai.xl.business.mapper.*;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.FactoryQuery;
import nankai.xl.business.model.vo.SccVo;
import nankai.xl.business.service.FileService;
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
    private CountyMapper countyMapper;
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
    @Resource
    private DryCleanerMapper dryCleanerMapper;
    @Resource
    private CarRepairMapper carRepairMapper;
    @Resource
    private RoadPaveMapper roadPaveMapper;
    @Resource
    private BuildingSmearMapper buildingSmearMapper;
    @Resource
    private HouseMapper houseMapper;
    @Resource
    private DeoilMapper deoilMapper;
    @Resource
    private YcSoildustMapper ycsoildustMapper;
    @Resource
    private YcRoaddustMapper ycroaddustMapper;
    @Resource
    private YcConstructdustMapper ycconstructdustMapper;
    @Resource
    private YcDustLoadMapper ycdustLoadMapper;
    @Resource
    private YcDustStackMapper ycdustStackMapper;
    @Resource
    private TankSourceMapper tankSourceMapper;
    @Resource
    private GasSourceMapper gasSourceMapper;
    @Resource
    private OilSourceMapper oilSourceMapper;
    @Resource
    private OilTransportMapper oilTransportMapper;
    @Resource
    private PesticideMapper pesticideMapper;
    @Resource
    private CollectbreedingMapper collectbreedingMapper;
    @Resource
    private FreeStockbreedingMapper freeStockbreedingMapper;
    @Resource
    private FertilizationMapper fertilizationMapper;
    @Resource
    private BaseSoilMapper baseSoilMapper;
    @Resource
    private NPlantMapper nPlantMapper;
    @Resource
    private StrawCompostMapper strawCompostMapper;
    @Resource
    private BiomassBoilerMapper biomassBoilerMapper;
    @Resource
    private BiomassStoveMapper biomassStoveMapper;
    @Resource
    private BiomassStrawMapper biomassStrawMapper;
    @Resource
    private BiomassForestGrasslandMapper biomassForestGrasslandMapper;
    @Resource
    private RoadMoveMapper roadMoveMapper;
    @Resource
    private AgricultureMachineryMapper agricultureMachineryMapper;
    @Resource
    private AirplaneMapper airplaneMapper;
    @Resource
    private NonroadMachineryMapper nonroadMachineryMapper;
    @Resource
    private RailwayEngineMapper railwayEngineMapper;
    @Resource
    private SmallMachineryMapper smallMachineryMapper;
    @Resource
    private RepastMapper repastMapper;
    @Resource
    private RepastFamilyMapper repastFamilyMapper;
    @Resource
    private RepastBarbecueMapper repastBarbecueMapper;
    @Resource
    private FactoryMapper factoryMapper;
    @Resource
    private UserMapper userMapper;

    private int integerNum=8;

    private int decimalNum=5;

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
        if (sourceName.contains("干洗店")){
            num=importDryCleaner(list,isCul);
        }
        if (sourceName.contains("汽修店")){
            num=importCarRepair(list,isCul);
        }
        if (sourceName.contains("道路铺装")){
            num=importRoadPave(list,isCul);
        }
        if (sourceName.contains("建筑涂装二手房")){
            num=importBuildingSmear(list,isCul);
        }
        if (sourceName.contains("家庭家居")){
            num=importHouse(list,isCul);
        }
        if (sourceName.contains("家庭家居")){
            num=importDeoil(list,isCul);
        }
        if (sourceName.contains("土壤扬尘源")){
            num=importYcSoildust(list,isCul);
        }
        if (sourceName.contains("道路扬尘源")){
            num=importYcRoaddust(list,isCul);
        }
        if (sourceName.contains("施工扬尘源")){
            num=importYcConstructdust(list,isCul);
        }
        if (sourceName.contains("堆场装卸扬尘源")){
            num=importYcDustLoad(list,isCul);
        }
        if (sourceName.contains("堆场风蚀扬尘源")){
            num=importYcDustStack(list,isCul);
        }
        if (sourceName.contains("储罐存储")){
            num=importTankSource(list,isCul);
        }
        if (sourceName.contains("加气站")){
            num=importGasSource(list,isCul);
        }
        if (sourceName.contains("加油站")){
            num=importOilSource(list,isCul);
        }
        if (sourceName.contains("装载过程排放")){
            num=importOilTransport(list,isCul);
        }
        if (sourceName.contains("农药施用")){
            num=importPesticide(list,isCul);
        }
        if (sourceName.contains("畜牧集约化养殖")){
            num=importCollectbreeding(list,isCul);
        }
        if (sourceName.contains("畜牧散养")){
            num=importFreeStockbreeding(list,isCul);
        }
        if (sourceName.contains("农业施肥")){
            num=importFertilization(list,isCul);
        }
        if (sourceName.contains("土壤本低")){
            num=importBaseSoil(list,isCul);
        }
        if (sourceName.contains("固氮植物")){
            num=importNPlant(list,isCul);
        }
        if (sourceName.contains("秸秆堆肥")){
            num=importstrawCompost(list,isCul);
        }
        if (sourceName.contains("生物质锅炉")){
            num=importBiomassBoiler(list,isCul);
        }
        if (sourceName.contains("户用生物质炉具")){
            num=importBiomassStove(list,isCul);
        }
        if (sourceName.contains("秸秆露天焚烧")){
            num=importBiomassStraw(list,isCul);
        }
        if (sourceName.contains("森林、草原火灾")){
            num=importBiomassForestGrassland(list,isCul);
        }
        if (sourceName.contains("道路移动")){
            num=importRoadMove(list,isCul);
        }
        if (sourceName.contains("农运运输车")){
            num=importAgricultureMachinery(list,isCul);
        }
        if (sourceName.contains("民航飞机")){
            num=importAirplane(list,isCul);
        }
        if (sourceName.contains("非道路机械")){
            num=importNonroadMachinery(list,isCul);
        }
        if (sourceName.contains("铁路内燃机")){
            num=importRailwayEngine(list,isCul);
        }
        if (sourceName.contains("小型通用机械")){
            num=importSmallMachinery(list,isCul);
        }
        if (sourceName.contains("社会餐饮")){
            num=importRepast(list,isCul);
        }
        if (sourceName.contains("家庭餐饮")){
            num=importRepastFamily(list,isCul);
        }
        if (sourceName.contains("烧烤餐饮")){
            num=importRepastBarbecue(list,isCul);
        }
        return num;
    }

    @Override
    public int importTempleFileToFactory(FactoryQuery factoryQuery, List<String[]> list) {
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (!NumberUtil.isLongitude(strs[4],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[5],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
        }
        List<Factory> factoryList=new ArrayList<>();
        for (String[] strs:list) {
            Factory factory=new Factory();
            factory.setYear(factoryQuery.getYear());
            factory.setCountyId(factoryQuery.getCountyId());
            factory.setFactoryNo(strs[0]);
            factory.setFactoryName(strs[1]);
            factory.setAddress(strs[2]);
            factory.setAddressRegister(strs[3]);
            factory.setFactoryLongitude(Double.parseDouble(strs[4]));
            factory.setFactoryLatitude(Double.parseDouble(strs[5]));
            factoryList.add(factory);
            factoryMapper.insertOrUpdate(factory);
            User user=new User();
            user.setPassword("123456");
            user.setFacNo(strs[0]);
            userMapper.insertOrUpdate(user);
        }
        //factoryMapper.insertOrUpdateList(factoryList);
        return i;
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
    public boolean checkCounty(String countyId){
        if (countyMapper.selectCountyById(countyId)==null){
            return false;
        }
        return true;
    }
    public boolean checkRatio(String[] strs,int start,int end){
        for (int i = start; i <end ; i++) {
            if (!NumberUtil.isRatio(strs[i],integerNum)){
                return false;
            }
        }
        return true;
    }
    public boolean checkPosDouble(String[] strs,int start,int end){
        for (int i = start; i <end ; i++) {
            if(!NumberUtil.isPosDouble(strs[i],integerNum)){
                return false;
            }
        }
        return true;
    }
    public boolean checkInteger(String[] strs,int start,int end){
        for (int i = start; i <end ; i++) {
            if(!NumberUtil.checkNumber(strs[i],"0+")){
                return false;
            }
        }
        return true;
    }
    public Double getDecimal(String str){
        return Arith.round(str,decimalNum);
    }
    public int importScatteredCoal(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,5,6)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,7,18)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<ScatteredCoal> scatteredCoalList=new ArrayList<>();
        for (String[] strs:list) {
            ScatteredCoal scatteredCoal=new ScatteredCoal();
            scatteredCoal.setSccCode(strs[0]);
            scatteredCoal.setYear(strs[1]);
            scatteredCoal.setCountyId(strs[2]);
            scatteredCoal.setActivityLevel(strs[3]);
            scatteredCoal.setFuelMeteringUnit(strs[4]);
            scatteredCoal.setActivityLevelNum(getDecimal(strs[5]));
            scatteredCoal.setControlMeasure(strs[6]);
            scatteredCoal.setSulfurContent(getDecimal(strs[7]));
            scatteredCoal.setAshContent(getDecimal(strs[8]));
            if (!isCul){
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
            scatteredCoal.setSourceDescription(getSccDescribe(strs[0]));
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
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,11,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,14,15)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,16,25)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            ShGasemission shGasemission=new ShGasemission();
            shGasemission.setScccode(strs[0]);
            shGasemission.setYear(strs[1]);
            shGasemission.setFactoryId(getCompanyId(company));
            shGasemission.setGyName(strs[9]);
            shGasemission.setActivityNote(strs[10]);
            shGasemission.setDensity(getDecimal(strs[11]));
            shGasemission.setActivity(getDecimal(strs[12]));
            shGasemission.setActivityUnit(strs[13]);
            shGasemission.setEfficency(getDecimal(strs[14]));
            shGasemission.setEmissionUnit(strs[15]);
            if (!isCul){
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
            shGasemission.setSourceDiscrip(getSccDescribe(strs[0]));
            shGasemissionList.add(shGasemission);
        }
        shGasemissionMapper.insertList(shGasemissionList);
        return i;
    }
    public int importShSealpoint(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,10,11)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,12,21)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<ShSealpoint> shSealpointList=new ArrayList<>();
        for (String [] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            ShSealpoint shSealpoint=new ShSealpoint();
            shSealpoint.setScccode(strs[0]);
            shSealpoint.setYear(strs[1]);
            shSealpoint.setFactoryId(getCompanyId(company));
            shSealpoint.setUnitType(strs[9]);
            shSealpoint.setActivity(getDecimal(strs[10]));
            shSealpoint.setActivityUnit(strs[11]);
            if (!isCul){
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
            shSealpoint.setSourceDiscrip(getSccDescribe(strs[0]));
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
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,10,11)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,12,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,14,23)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list)   {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            ShEffluentemission shEffluentemission=new ShEffluentemission();
            shEffluentemission.setScccode(strs[0]);
            shEffluentemission.setYear(strs[1]);
            shEffluentemission.setFactoryId(getCompanyId(company));
            shEffluentemission.setActivityNote(strs[9]);
            shEffluentemission.setActivity(getDecimal(strs[10]));
            shEffluentemission.setActivityUnit(strs[11]);
            shEffluentemission.setVocEfficency(getDecimal(strs[12]));
            shEffluentemission.setEmissionUnit(strs[13]);
            if (!isCul){
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
            shEffluentemission.setSourceDiscrip(getSccDescribe(strs[0]));
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
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,11,14)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,14,15)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,16,25)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);

            ShVocdeviceeffi shVocdeviceeffi=new ShVocdeviceeffi();
            shVocdeviceeffi.setScccode(strs[0]);
            shVocdeviceeffi.setYear(strs[1]);
            shVocdeviceeffi.setFactoryId(getCompanyId(company));
            shVocdeviceeffi.setWorkshopSection(strs[9]);
            shVocdeviceeffi.setGyName(strs[10]);
            shVocdeviceeffi.setAnnualRuntime(getDecimal(strs[11]));
            shVocdeviceeffi.setExitAirvolume(getDecimal(strs[12]));
            shVocdeviceeffi.setExitConcentration(getDecimal(strs[13]));
            shVocdeviceeffi.setEfficency(getDecimal(strs[14]));
            shVocdeviceeffi.setEmissionUnit(strs[15]);
            if (!isCul){
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
            shVocdeviceeffi.setSourceDiscrip(getSccDescribe(strs[0]));
            shVocdeviceeffiList.add(shVocdeviceeffi);
        }
        shVocdeviceeffiMapper.insertList(shVocdeviceeffiList);
        return i;
    }
    public int importDryCleaner(List<String[]> list,boolean isCul){
        List<DryCleaner> dryCleanerList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,9,19)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            DryCleaner dryCleaner=new DryCleaner();
            dryCleaner.setScccode(strs[0]);
            dryCleaner.setYear(strs[1]);
            dryCleaner.setCompanyId(getCompanyId(company));
            dryCleaner.setYearAmount(getDecimal(strs[9]));
            if (!isCul){
                dryCleaner.setPm10Emission(getDecimal(strs[10]));
                dryCleaner.setPm25Emission(getDecimal(strs[11]));
                dryCleaner.setCoEmission(getDecimal(strs[12]));
                dryCleaner.setVocEmission(getDecimal(strs[13]));
                dryCleaner.setSo2Emission(getDecimal(strs[14]));
                dryCleaner.setNoxEmission(getDecimal(strs[15]));
                dryCleaner.setNh3Emission(getDecimal(strs[16]));
                dryCleaner.setOcEmission(getDecimal(strs[17]));
                dryCleaner.setBcEmission(getDecimal(strs[18]));
            }else {
                //计算
            }
            dryCleaner.setSourceDescrip(getSccDescribe(strs[0]));
            dryCleanerList.add(dryCleaner);
        }
        dryCleanerMapper.insertList(dryCleanerList);
        return i;
    }
    public int importCarRepair(List<String[]> list,boolean isCul){
        List<CarRepair> carRepairList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,9,19)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);

            CarRepair carRepair=new CarRepair();
            carRepair.setScccode(strs[0]);
            carRepair.setYear(strs[1]);
            carRepair.setCompanyId(getCompanyId(company));
            carRepair.setSolventAmount(getDecimal(strs[9]));
            if (!isCul){
                carRepair.setPm10Emission(getDecimal(strs[10]));
                carRepair.setPm25Emission(getDecimal(strs[11]));
                carRepair.setCoEmission(getDecimal(strs[12]));
                carRepair.setVocEmission(getDecimal(strs[13]));
                carRepair.setSo2Emission(getDecimal(strs[14]));
                carRepair.setNoxEmission(getDecimal(strs[15]));
                carRepair.setNh3Emission(getDecimal(strs[16]));
                carRepair.setOcEmission(getDecimal(strs[17]));
                carRepair.setBcEmission(getDecimal(strs[18]));
            }else {
                //计算
            }
            carRepair.setSourceDescrip(getSccDescribe(strs[0]));
            carRepairList.add(carRepair);
        }
        carRepairMapper.insertList(carRepairList);
        return i;
    }
    public int importRoadPave(List<String[]> list,boolean isCul){
        List<RoadPave> roadPaveList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            RoadPave roadPave=new RoadPave();
            roadPave.setScccode(strs[0]);
            roadPave.setYear(strs[1]);
            roadPave.setCountyId(strs[2]);
            roadPave.setAsphalt(getDecimal(strs[3]));
            if (!isCul){
                roadPave.setPm10Emission(getDecimal(strs[4]));
                roadPave.setPm25Emission(getDecimal(strs[5]));
                roadPave.setCoEmission(getDecimal(strs[6]));
                roadPave.setVocEmission(getDecimal(strs[7]));
                roadPave.setSo2Emission(getDecimal(strs[8]));
                roadPave.setNoxEmission(getDecimal(strs[9]));
                roadPave.setNh3Emission(getDecimal(strs[10]));
                roadPave.setOcEmission(getDecimal(strs[11]));
                roadPave.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            roadPave.setSourceDescrip(getSccDescribe(strs[0]));
            roadPaveList.add(roadPave);
        }
        roadPaveMapper.insertList(roadPaveList);
        return i;
    }
    public int importBuildingSmear(List<String[]> list,boolean isCul){
        List<BuildingSmear> buildingSmearList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            BuildingSmear buildingSmear=new BuildingSmear();
            buildingSmear.setScccode(strs[0]);
            buildingSmear.setYear(strs[1]);
            buildingSmear.setCountyId(strs[2]);
            buildingSmear.setPaintAmount(getDecimal(strs[3]));
            if (!isCul){
                buildingSmear.setPm10Emission(getDecimal(strs[4]));
                buildingSmear.setPm25Emission(getDecimal(strs[5]));
                buildingSmear.setCoEmission(getDecimal(strs[6]));
                buildingSmear.setVocEmission(getDecimal(strs[7]));
                buildingSmear.setSo2Emission(getDecimal(strs[8]));
                buildingSmear.setNoxEmission(getDecimal(strs[9]));
                buildingSmear.setNh3Emission(getDecimal(strs[10]));
                buildingSmear.setOcEmission(getDecimal(strs[11]));
                buildingSmear.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            buildingSmear.setSourceDescrip(getSccDescribe(strs[0]));
            buildingSmearList.add(buildingSmear);
        }
        buildingSmearMapper.insertList(buildingSmearList);
        return i;
    }
    public int importHouse(List<String[]> list,boolean isCul){
        List<House> houseList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            House house=new House();
            house.setScccode(strs[0]);
            house.setYear(strs[1]);
            house.setCountyId(strs[2]);
            house.setSolventAmount(getDecimal(strs[3]));
            if (!isCul){
                house.setPm10Emission(getDecimal(strs[4]));
                house.setPm25Emission(getDecimal(strs[5]));
                house.setCoEmission(getDecimal(strs[6]));
                house.setVocEmission(getDecimal(strs[7]));
                house.setSo2Emission(getDecimal(strs[8]));
                house.setNoxEmission(getDecimal(strs[9]));
                house.setNh3Emission(getDecimal(strs[10]));
                house.setOcEmission(getDecimal(strs[11]));
                house.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            house.setSourceDescrip(getSccDescribe(strs[0]));
            houseList.add(house);
        }
        houseMapper.insertList(houseList);
        return i;
    }
    public int importDeoil(List<String[]> list,boolean isCul){
        List<Deoil> deoilList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Deoil deoil=new Deoil();
            deoil.setScccode(strs[0]);
            deoil.setYear(strs[1]);
            deoil.setCountyId(strs[2]);
            deoil.setPeoplenumber(Integer.parseInt(strs[3]));
            if (!isCul){
                deoil.setPm10Emission(getDecimal(strs[4]));
                deoil.setPm25Emission(getDecimal(strs[5]));
                deoil.setCoEmission(getDecimal(strs[6]));
                deoil.setVocEmission(getDecimal(strs[7]));
                deoil.setSo2Emission(getDecimal(strs[8]));
                deoil.setNoxEmission(getDecimal(strs[9]));
                deoil.setNh3Emission(getDecimal(strs[10]));
                deoil.setOcEmission(getDecimal(strs[11]));
                deoil.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            deoil.setSourceDescrip(getSccDescribe(strs[0]));
            deoilList.add(deoil);
        }
        deoilMapper.insertList(deoilList);
        return i;
    }
    public int importYcSoildust(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,4)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,6,11)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,12,21)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<YcSoildust> ycSoildustList =new ArrayList<>();
        for (String[] strs:list) {
            YcSoildust ycSoildust =new YcSoildust();
            ycSoildust.setScccode(strs[0]);
            ycSoildust.setSdYear(strs[1]);
            ycSoildust.setCountyId(strs[2]);
            ycSoildust.setSdArea(getDecimal(strs[3]));
            ycSoildust.setSdUtype(strs[4]);
            ycSoildust.setSdSoiltype(strs[5]);
            ycSoildust.setSoilindexpm25(getDecimal(strs[6]));
            ycSoildust.setSoilindexpm10(getDecimal(strs[7]));
            ycSoildust.setSurindex(getDecimal(strs[8]));
            ycSoildust.setNoindex(getDecimal(strs[9]));
            ycSoildust.setPindex(getDecimal(strs[10]));
            ycSoildust.setSdTakemeasures(strs[11]);
            if (!isCul){
                ycSoildust.setPm10Emission(getDecimal(strs[12]));
                ycSoildust.setPm25Emission(getDecimal(strs[13]));
                ycSoildust.setCoEmission(getDecimal(strs[14]));
                ycSoildust.setVocEmission(getDecimal(strs[15]));
                ycSoildust.setSo2Emission(getDecimal(strs[16]));
                ycSoildust.setNoxEmission(getDecimal(strs[17]));
                ycSoildust.setNh3Emission(getDecimal(strs[18]));
                ycSoildust.setOcEmission(getDecimal(strs[19]));
                ycSoildust.setBcEmission(getDecimal(strs[20]));
            }else{
                //计算
            }
            ycSoildust.setSccDescribe(getSccDescribe(strs[0]));
            ycSoildustList.add(ycSoildust);
        }
        ycsoildustMapper.insertList(ycSoildustList);
        return i;
    }
    public int importYcRoaddust(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,5,12)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,12,14)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,15,24)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");            }
        }
        List<YcRoaddust> ycRoaddustList =new ArrayList<>();
        for (String[] strs:list) {
            YcRoaddust ycRoaddust =new YcRoaddust();
            ycRoaddust.setScccode(strs[0]);
            ycRoaddust.setYear(strs[1]);
            ycRoaddust.setCountyId(strs[2]);
            ycRoaddust.setIspave(strs[3]);
            ycRoaddust.setRoadtype(strs[4]);
            ycRoaddust.setPathlength(getDecimal(strs[5]));
            ycRoaddust.setAverwidth(getDecimal(strs[6]));
            ycRoaddust.setCarflow(getDecimal(strs[7]));
            ycRoaddust.setAverspeed(getDecimal(strs[8]));
            ycRoaddust.setAverweight(getDecimal(strs[9]));
            ycRoaddust.setNodustday(Integer.parseInt(strs[10]));
            ycRoaddust.setRoadload(getDecimal(strs[11]));
            ycRoaddust.setWaterratio(getDecimal(strs[12]));
            ycRoaddust.setDirtratio(getDecimal(strs[13]));
            ycRoaddust.setControlname(strs[14]);
            if (!isCul){
                ycRoaddust.setPm10Emission(getDecimal(strs[15]));
                ycRoaddust.setPm25Emission(getDecimal(strs[16]));
                ycRoaddust.setCoEmission(getDecimal(strs[17]));
                ycRoaddust.setVocEmission(getDecimal(strs[18]));
                ycRoaddust.setSo2Emission(getDecimal(strs[19]));
                ycRoaddust.setNoxEmission(getDecimal(strs[20]));
                ycRoaddust.setNh3Emission(getDecimal(strs[21]));
                ycRoaddust.setOcEmission(getDecimal(strs[22]));
                ycRoaddust.setBcEmission(getDecimal(strs[23]));
            }else{
                //计算
            }
            ycRoaddust.setSccDescribe(getSccDescribe(strs[0]));
            ycRoaddustList.add(ycRoaddust);
        }
        ycroaddustMapper.insertList(ycRoaddustList);
        return i;
    }
    public int importYcConstructdust(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkInteger(strs,9,10)){
                throw new NullPointerException("第"+(i+1)+"行第9列数字转换错误，请填写0~"+integerNum+"位正整数！");
            }
            if (!checkInteger(strs,11,12)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkInteger(strs,12,13)){
                throw new NullPointerException("第"+(i+1)+"行第9列数字转换错误，请填写0~"+integerNum+"位正整数！");
            }
            if (!checkPosDouble(strs,14,23)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<YcConstructdust> ycConstructdustList =new ArrayList<>();
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            YcConstructdust ycConstructdust =new YcConstructdust();
            ycConstructdust.setComId(getCompanyId(company));
            ycConstructdust.setScccode(strs[0]);
            ycConstructdust.setYear(strs[1]);
            ycConstructdust.setXjconstructid(Integer.parseInt(strs[9]));
            ycConstructdust.setConstructType(strs[10]);
            ycConstructdust.setThisyearArea(getDecimal(strs[11]));
            ycConstructdust.setMonths(Integer.parseInt(strs[12]));
            ycConstructdust.setControlname(strs[13]);
            if (!isCul){
                ycConstructdust.setPm10Emission(getDecimal(strs[14]));
                ycConstructdust.setPm25Emission(getDecimal(strs[15]));
                ycConstructdust.setCoEmission(getDecimal(strs[16]));
                ycConstructdust.setVocEmission(getDecimal(strs[17]));
                ycConstructdust.setSo2Emission(getDecimal(strs[18]));
                ycConstructdust.setNoxEmission(getDecimal(strs[19]));
                ycConstructdust.setNh3Emission(getDecimal(strs[20]));
                ycConstructdust.setOcEmission(getDecimal(strs[21]));
                ycConstructdust.setBcEmission(getDecimal(strs[22]));
            }else{
                //计算
            }
            ycConstructdust.setSccDescribe(getSccDescribe(strs[0]));
            ycConstructdustList.add(ycConstructdust);
        }
        ycconstructdustMapper.insertList(ycConstructdustList);
        return i;
    }
    public int importYcDustLoad(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkInteger(strs,9,10)){
                throw new NullPointerException("第"+(i+1)+"行第9列数字转换错误，请填写0~"+integerNum+"位正整数！");
            }
            if (!checkPosDouble(strs,11,12)){
                throw new NullPointerException("第"+(i+1)+"行第11列数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,13,14)){
                throw new NullPointerException("第"+(i+1)+"行第13列数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,14,15)){
                throw new NullPointerException("第"+(i+1)+"行第14列数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,16,25)){
                throw new NullPointerException("第"+(i+1)+"行第16~24列数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<YcDustLoad> ycDustLoadList =new ArrayList<>();
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            YcDustLoad ycDustLoad =new YcDustLoad();
            ycDustLoad.setComId(getCompanyId(company));
            ycDustLoad.setScccode(strs[0]);
            ycDustLoad.setYear(strs[1]);
            ycDustLoad.setLoadId(Integer.parseInt(strs[9]));
            ycDustLoad.setMaterialType(strs[10]);
            ycDustLoad.setMaterialLoad(Integer.parseInt(strs[11]));
            ycDustLoad.setMloadUnit(strs[12]);
            ycDustLoad.setMaterialWater(getDecimal(strs[13]));
            ycDustLoad.setUwindValue(getDecimal(strs[14]));
            ycDustLoad.setControlname(strs[15]);
            if (!isCul){
                ycDustLoad.setPm10Emission(getDecimal(strs[16]));
                ycDustLoad.setPm25Emission(getDecimal(strs[17]));
                ycDustLoad.setCoEmission(getDecimal(strs[18]));
                ycDustLoad.setVocEmission(getDecimal(strs[19]));
                ycDustLoad.setSo2Emission(getDecimal(strs[20]));
                ycDustLoad.setNoxEmission(getDecimal(strs[21]));
                ycDustLoad.setNh3Emission(getDecimal(strs[22]));
                ycDustLoad.setOcEmission(getDecimal(strs[23]));
                ycDustLoad.setBcEmission(getDecimal(strs[24]));
            }else{
                //计算
            }
            ycDustLoad.setSccDescribe(getSccDescribe(strs[0]));
            ycDustLoadList.add(ycDustLoad);
        }
        ycdustLoadMapper.insertList(ycDustLoadList);
        return i;
    }
    public int importYcDustStack(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkInteger(strs,9,10)){
                throw new NullPointerException("第"+(i+1)+"行第9列数字转换错误，请填写0~"+integerNum+"位正整数！");
            }
            if (!checkPosDouble(strs,11,17)){
                throw new NullPointerException("第"+(i+1)+"行第11~16列数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,18,27)){
                throw new NullPointerException("第"+(i+1)+"行第18~26列数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<YcDustStack> ycDustStackList =new ArrayList<>();
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            YcDustStack ycDustStack =new YcDustStack();
            ycDustStack.setComId(getCompanyId(company));
            ycDustStack.setScccode(strs[0]);
            ycDustStack.setYear(strs[1]);
            ycDustStack.setStackId(Integer.parseInt(strs[9]));
            ycDustStack.setMaterialType(strs[10]);
            ycDustStack.setSarea(Integer.parseInt(strs[11]));
            ycDustStack.setmWindnum(Integer.parseInt(strs[12]));
            ycDustStack.setGroundWindhigh(getDecimal(strs[13]));
            ycDustStack.setGroundRough(getDecimal(strs[14]));
            ycDustStack.setGroundWind(getDecimal(strs[15]));
            ycDustStack.setWindFriction(getDecimal(strs[16]));
            ycDustStack.setControlname(strs[17]);
            if (!isCul){
                ycDustStack.setPm10Emission(getDecimal(strs[18]));
                ycDustStack.setPm25Emission(getDecimal(strs[19]));
                ycDustStack.setCoEmission(getDecimal(strs[20]));
                ycDustStack.setVocEmission(getDecimal(strs[21]));
                ycDustStack.setSo2Emission(getDecimal(strs[22]));
                ycDustStack.setNoxEmission(getDecimal(strs[23]));
                ycDustStack.setNh3Emission(getDecimal(strs[24]));
                ycDustStack.setOcEmission(getDecimal(strs[25]));
                ycDustStack.setBcEmission(getDecimal(strs[26]));
            }else{
                //计算
            }
            ycDustStack.setSccDescribe(getSccDescribe(strs[0]));
            ycDustStackList.add(ycDustStack);
        }
        ycdustStackMapper.insertList(ycDustStackList);
        return i;
    }
    public int importTankSource(List<String[]> list,boolean isCul){
        List<TankSource> tankSourceList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkInteger(strs,9,10)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正整数！");
            }
            if (!checkPosDouble(strs,14,15)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            TankSource tankSource=new TankSource();
            tankSource.setScccode(strs[0]);
            tankSource.setYear(strs[1]);
            tankSource.setCompanyId(getCompanyId(company));
            tankSource.settId(Integer.parseInt(strs[9]));
            tankSource.setTankName(strs[10]);
            tankSource.setTankType(strs[11]);
            tankSource.setMaterialName(strs[12]);
            tankSource.setMaterialType(strs[13]);
            if (!isCul){
                tankSource.setEmission(getDecimal(strs[14]));
            }else {
                //计算
            }
            tankSource.setSourceDiscrip(getSccDescribe(strs[0]));
           // tankSourceMapper.insertSelective(tankSource);
            tankSourceList.add(tankSource);
        }
        tankSourceMapper.insertList(tankSourceList);
        return i;
    }
    public int importGasSource(List<String[]> list,boolean isCul){
        List<GasSource> gasSourceList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,10,17)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            GasSource gasSource=new GasSource();
            gasSource.setScccode(strs[0]);
            gasSource.setYear(strs[1]);
            gasSource.setCompanyId(getCompanyId(company));
            gasSource.setGasType(strs[9]);
            gasSource.setSalesVolume(getDecimal(strs[10]));
            gasSource.setTankNum(Integer.parseInt(strs[11]));
            gasSource.setVolume(getDecimal(strs[12]));
            gasSource.setEveryVolume(getDecimal(strs[13]));
            gasSource.setVolumeCount(Integer.parseInt(strs[14]));
            gasSource.setGunNum(Integer.parseInt(strs[15]));
            if (!isCul){
                gasSource.setEmission(getDecimal(strs[16]));
            }else {
                //计算
            }
            gasSource.setSourceDiscrip(getSccDescribe(strs[0]));
            gasSourceList.add(gasSource);
        }
        gasSourceMapper.insertList(gasSourceList);
        return i;
    }
    public int importOilSource(List<String[]> list,boolean isCul){
        List<OilSource> oilSourceList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,11,17)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            OilSource oilSource=new OilSource();
            oilSource.setScccode(strs[0]);
            oilSource.setYear(strs[1]);
            oilSource.setCompanyId(getCompanyId(company));
            oilSource.setOilType(strs[9]);
            oilSource.setSalesVolume(getDecimal(strs[10]));
            oilSource.setTankNum(Integer.parseInt(strs[11]));
            oilSource.setVolume(getDecimal(strs[12]));
            oilSource.setEveryVolume(getDecimal(strs[13]));
            oilSource.setVolumeCount(getDecimal(strs[14]));
            oilSource.setGunNum(Integer.parseInt(strs[15]));
            if (!isCul){
                oilSource.setEmission(getDecimal(strs[16]));
            }else {
                //计算
            }
            oilSource.setSourceDiscrip(getSccDescribe(strs[0]));
            //oilSourceMapper.insertOrUpdate(oilSource);
            oilSourceList.add(oilSource);
        }
        oilSourceMapper.insertList(oilSourceList);
        return i;
    }
    public int importOilTransport(List<String[]> list,boolean isCul){
        List<OilTransport> oilTransportList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkInteger(strs,10,11)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,11,12)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            OilTransport oilTransport=new OilTransport();
            oilTransport.setScccode(strs[0]);
            oilTransport.setYear(strs[1]);
            oilTransport.setCompanyId(getCompanyId(company));
            oilTransport.setOilType(strs[9]);
            oilTransport.setControlRate(Integer.parseInt(strs[10]));
            oilTransport.setYearVolume(getDecimal(strs[11]));
            if (!isCul){
                oilTransport.setEmission(getDecimal(strs[12]));
            }else {
                //计算
            }
            oilTransport.setSourceDiscrip(getSccDescribe(strs[0]));
            oilTransportList.add(oilTransport);
        }
        oilTransportMapper.insertList(oilTransportList);
        return i;
    }
    public int importPesticide(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<Pesticide> pesticideList=new ArrayList<>();
        for (String[] strs:list) {
            Pesticide pesticide=new Pesticide();
            pesticide.setScccode(strs[0]);
            pesticide.setYear(strs[1]);
            pesticide.setCountyId(strs[2]);
            pesticide.setPesticideamount(getDecimal(strs[3]));
            if (!isCul){
                pesticide.setPm10Emission(getDecimal(strs[4]));
                pesticide.setPm25Emission(getDecimal(strs[5]));
                pesticide.setCoEmission(getDecimal(strs[6]));
                pesticide.setVocEmission(getDecimal(strs[7]));
                pesticide.setSo2Emission(getDecimal(strs[8]));
                pesticide.setNoxEmission(getDecimal(strs[9]));
                pesticide.setNh3Emission(getDecimal(strs[10]));
                pesticide.setOcEmission(getDecimal(strs[11]));
                pesticide.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            pesticide.setSourceDescrip(getSccDescribe(strs[0]));
            pesticideList.add(pesticide);
        }
        pesticideMapper.insertList(pesticideList);
        return i;
    }
    public int importCollectbreeding(List<String[]> list,boolean isCul){
        List<Collectbreeding> collectbreedingList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,9,20)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            Collectbreeding collectbreeding=new Collectbreeding();
            collectbreeding.setScccode(strs[0]);
            collectbreeding.setYear(strs[1]);
            collectbreeding.setCompanyId(getCompanyId(company));
            collectbreeding.setActivityLevel(getDecimal(strs[9]));
            collectbreeding.setComputeCycle(Integer.parseInt(strs[10]));
            if (!isCul){
                collectbreeding.setPm10Emission(getDecimal(strs[11]));
                collectbreeding.setPm25Emission(getDecimal(strs[12]));
                collectbreeding.setCoEmission(getDecimal(strs[13]));
                collectbreeding.setVocEmission(getDecimal(strs[14]));
                collectbreeding.setSo2Emission(getDecimal(strs[15]));
                collectbreeding.setNoxEmission(getDecimal(strs[16]));
                collectbreeding.setNh3Emission(getDecimal(strs[17]));
                collectbreeding.setOcEmission(getDecimal(strs[18]));
                collectbreeding.setBcEmission(getDecimal(strs[19]));
            }else {
                //计算
            }
            collectbreeding.setSourceDiscrip(getSccDescribe(strs[0]));
            collectbreedingList.add(collectbreeding);
        }
        collectbreedingMapper.insertList(collectbreedingList);
        return i;
    }
    public int importFreeStockbreeding(List<String[]> list,boolean isCul){
        List<FreeStockbreeding> freeStockbreedingList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,14)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            FreeStockbreeding freeStockbreeding=new FreeStockbreeding();
            freeStockbreeding.setScccode(strs[0]);
            freeStockbreeding.setYear(strs[1]);
            freeStockbreeding.setCountyId(strs[2]);
            freeStockbreeding.setActivityLevel(getDecimal(strs[3]));
            freeStockbreeding.setComputeCycle(Integer.parseInt(strs[4]));
            if (!isCul){
                freeStockbreeding.setPm10Emission(getDecimal(strs[5]));
                freeStockbreeding.setPm25Emission(getDecimal(strs[6]));
                freeStockbreeding.setCoEmission(getDecimal(strs[7]));
                freeStockbreeding.setVocEmission(getDecimal(strs[8]));
                freeStockbreeding.setSo2Emission(getDecimal(strs[9]));
                freeStockbreeding.setNoxEmission(getDecimal(strs[10]));
                freeStockbreeding.setNh3Emission(getDecimal(strs[11]));
                freeStockbreeding.setOcEmission(getDecimal(strs[12]));
                freeStockbreeding.setBcEmission(getDecimal(strs[13]));
            }else {
                //计算
            }
            freeStockbreeding.setSourceDiscrip(getSccDescribe(strs[0]));
            freeStockbreedingList.add(freeStockbreeding);
        }
        freeStockbreedingMapper.insertList(freeStockbreedingList);
        return i;
    }
    public int importFertilization(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<Fertilization> fertilizationList=new ArrayList<>();
        for (String[] strs:list) {
            Fertilization fertilization=new Fertilization();
            fertilization.setScccode(strs[0]);
            fertilization.setYear(strs[1]);
            fertilization.setCountyId(strs[2]);
            fertilization.setActivityLevel(getDecimal(strs[3]));
            if (!isCul){
                fertilization.setPm10Emission(getDecimal(strs[4]));
                fertilization.setPm25Emission(getDecimal(strs[5]));
                fertilization.setCoEmission(getDecimal(strs[6]));
                fertilization.setVocEmission(getDecimal(strs[7]));
                fertilization.setSo2Emission(getDecimal(strs[8]));
                fertilization.setNoxEmission(getDecimal(strs[9]));
                fertilization.setNh3Emission(getDecimal(strs[10]));
                fertilization.setOcEmission(getDecimal(strs[11]));
                fertilization.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            fertilization.setSourceDescrip(getSccDescribe(strs[0]));
            fertilizationList.add(fertilization);
        }
        fertilizationMapper.insertList(fertilizationList);
        return i;
    }
    public int importBaseSoil(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<BaseSoil> baseSoilList=new ArrayList<>();
        for (String[] strs:list) {
            BaseSoil baseSoil=new BaseSoil();
            baseSoil.setScccode(strs[0]);
            baseSoil.setYear(strs[1]);
            baseSoil.setCountyId(strs[2]);
            baseSoil.setCultivateArea(getDecimal(strs[3]));
            if (!isCul){
                baseSoil.setPm10Emission(getDecimal(strs[4]));
                baseSoil.setPm25Emission(getDecimal(strs[5]));
                baseSoil.setCoEmission(getDecimal(strs[6]));
                baseSoil.setVocEmission(getDecimal(strs[7]));
                baseSoil.setSo2Emission(getDecimal(strs[8]));
                baseSoil.setNoxEmission(getDecimal(strs[9]));
                baseSoil.setNh3Emission(getDecimal(strs[10]));
                baseSoil.setOcEmission(getDecimal(strs[11]));
                baseSoil.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            baseSoil.setSourceDescrip(getSccDescribe(strs[0]));
            baseSoilList.add(baseSoil);
        }
        baseSoilMapper.insertList(baseSoilList);
        return i;
    }
    public int importNPlant(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<NPlant> nPlantList=new ArrayList<>();
        for (String[] strs:list) {
            NPlant nPlant=new NPlant();
            nPlant.setScccode(strs[0]);
            nPlant.setYear(strs[1]);
            nPlant.setCountyId(strs[2]);
            nPlant.setPlantArea(getDecimal(strs[3]));
            if (!isCul){
                nPlant.setPm10Emission(getDecimal(strs[4]));
                nPlant.setPm25Emission(getDecimal(strs[5]));
                nPlant.setCoEmission(getDecimal(strs[6]));
                nPlant.setVocEmission(getDecimal(strs[7]));
                nPlant.setSo2Emission(getDecimal(strs[8]));
                nPlant.setNoxEmission(getDecimal(strs[9]));
                nPlant.setNh3Emission(getDecimal(strs[10]));
                nPlant.setOcEmission(getDecimal(strs[11]));
                nPlant.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            nPlant.setSourceDescrip(getSccDescribe(strs[0]));
            nPlantMapper.insertSelective(nPlant);
            //nPlantList.add(nPlant);
        }
        //nPlantMapper.insertList(nPlantList);
        return i;
    }
    public int importstrawCompost(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<StrawCompost> strawCompostList=new ArrayList<>();
        for (String[] strs:list) {
            StrawCompost strawCompost=new StrawCompost();
            strawCompost.setScccode(strs[0]);
            strawCompost.setYear(strs[1]);
            strawCompost.setCountyId(strs[2]);
            strawCompost.setActivityLevel(getDecimal(strs[3]));
            if (!isCul){
                strawCompost.setPm10Emission(getDecimal(strs[4]));
                strawCompost.setPm25Emission(getDecimal(strs[5]));
                strawCompost.setCoEmission(getDecimal(strs[6]));
                strawCompost.setVocEmission(getDecimal(strs[7]));
                strawCompost.setSo2Emission(getDecimal(strs[8]));
                strawCompost.setNoxEmission(getDecimal(strs[9]));
                strawCompost.setNh3Emission(getDecimal(strs[10]));
                strawCompost.setOcEmission(getDecimal(strs[11]));
                strawCompost.setBcEmission(getDecimal(strs[12]));
            }else{
                //计算
            }
            strawCompost.setSourceDescrip(getSccDescribe(strs[0]));
            strawCompostList.add(strawCompost);
        }
        strawCompostMapper.insertList(strawCompostList);
        return i;
    }
    public int importBiomassBoiler(List<String[]> list,boolean isCul){
        List<BiomassBoiler> biomassBoilerList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,10,11)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,14,18)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,18,27)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            BiomassBoiler biomassBoiler=new BiomassBoiler();
            biomassBoiler.setSccCode(strs[0]);
            biomassBoiler.setYear(strs[1]);
            biomassBoiler.setComId(getCompanyId(company));
            biomassBoiler.setFuelType(strs[9]);
            biomassBoiler.setFuelConsumption(getDecimal(strs[10]));
            biomassBoiler.setDustRemoveTech(strs[11]);
            biomassBoiler.setDesulphurRemoveTech(strs[12]);
            biomassBoiler.setDenitrificRemoveTech(strs[13]);
            biomassBoiler.setPm10RemoveRatio(getDecimal(strs[14]));
            biomassBoiler.setPm25RemoveRatio(getDecimal(strs[15]));
            biomassBoiler.setSo2RemoveRatio(getDecimal(strs[16]));
            biomassBoiler.setNoxRemoveRatio(getDecimal(strs[17]));
            if (!isCul){
                biomassBoiler.setPm10Emission(getDecimal(strs[18]));
                biomassBoiler.setPm25Emission(getDecimal(strs[19]));
                biomassBoiler.setCoEmission(getDecimal(strs[20]));
                biomassBoiler.setVocEmission(getDecimal(strs[21]));
                biomassBoiler.setSo2Emission(getDecimal(strs[22]));
                biomassBoiler.setNoxEmission(getDecimal(strs[23]));
                biomassBoiler.setNh3Emission(getDecimal(strs[24]));
                biomassBoiler.setOcEmission(getDecimal(strs[25]));
                biomassBoiler.setBcEmission(getDecimal(strs[26]));
            }else {
                //计算
            }
            biomassBoiler.setSourceDescrip(getSccDescribe(strs[0]));
            biomassBoilerList.add(biomassBoiler);
        }
        biomassBoilerMapper.insertList(biomassBoilerList);
        return i;
    }
    public int importBiomassStove(List<String[]> list,boolean isCul){
        List<BiomassStove> biomassStoveList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,4,5)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,6,7)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,7,17)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            BiomassStove biomassStove=new BiomassStove();
            biomassStove.setSccCode(strs[0]);
            biomassStove.setYear(strs[1]);
            biomassStove.setCountyId(strs[2]);
            biomassStove.setCropType(strs[3]);
            biomassStove.setCropYield(getDecimal(strs[4]));
            biomassStove.setStoveType(strs[5]);
            biomassStove.setBurningRatioStove(getDecimal(strs[6]));
            biomassStove.setGrassValleyRatio(getDecimal(strs[7]));
            if (!isCul){
                biomassStove.setPm10Emission(getDecimal(strs[8]));
                biomassStove.setPm25Emission(getDecimal(strs[9]));
                biomassStove.setCoEmission(getDecimal(strs[10]));
                biomassStove.setVocEmission(getDecimal(strs[11]));
                biomassStove.setSo2Emission(getDecimal(strs[12]));
                biomassStove.setNoxEmission(getDecimal(strs[13]));
                biomassStove.setNh3Emission(getDecimal(strs[14]));
                biomassStove.setOcEmission(getDecimal(strs[15]));
                biomassStove.setBcEmission(getDecimal(strs[16]));
            }else {
                //计算
            }
            biomassStove.setSourceDescrip(getSccDescribe(strs[0]));
            biomassStoveList.add(biomassStove);
        }
        biomassStoveMapper.insertList(biomassStoveList);
        return i;
    }
    public int importBiomassStraw(List<String[]> list,boolean isCul){
        List<BiomassStraw> biomassStrawList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,4,5)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,5,7)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,7,17)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            BiomassStraw biomassStraw=new BiomassStraw();
            biomassStraw.setSccCode(strs[0]);
            biomassStraw.setYear(strs[1]);
            biomassStraw.setCountyId(strs[2]);
            biomassStraw.setCrops(strs[3]);
            biomassStraw.setCropsOutput(getDecimal(strs[4]));
            biomassStraw.setOpenBurningRatio(getDecimal(strs[5]));
            biomassStraw.setBurningRatio(getDecimal(strs[6]));
            biomassStraw.setGrassValleyRatio(getDecimal(strs[7]));
            if (!isCul){
                biomassStraw.setPm10Emission(getDecimal(strs[8]));
                biomassStraw.setPm25Emission(getDecimal(strs[9]));
                biomassStraw.setCoEmission(getDecimal(strs[10]));
                biomassStraw.setVocEmission(getDecimal(strs[11]));
                biomassStraw.setSo2Emission(getDecimal(strs[12]));
                biomassStraw.setNoxEmission(getDecimal(strs[13]));
                biomassStraw.setNh3Emission(getDecimal(strs[14]));
                biomassStraw.setOcEmission(getDecimal(strs[15]));
                biomassStraw.setBcEmission(getDecimal(strs[16]));
            }else {
                //计算
            }
            biomassStraw.setSourceDescrip(getSccDescribe(strs[0]));
            biomassStrawList.add(biomassStraw);
        }
        biomassStrawMapper.insertList(biomassStrawList);
        return i;
    }
    public int importBiomassForestGrassland(List<String[]> list,boolean isCul){
        List<BiomassForestGrassland> biomassForestGrasslandList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkRatio(strs,4,5)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,5,16)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            BiomassForestGrassland biomassForestGrassland=new BiomassForestGrassland();
            biomassForestGrassland.setSccCode(strs[0]);
            biomassForestGrassland.setYear(strs[1]);
            biomassForestGrassland.setCountyId(strs[2]);
            biomassForestGrassland.setVegetationTypes(strs[3]);
            biomassForestGrassland.setBurningRatio(getDecimal(strs[4]));
            biomassForestGrassland.setFireArea(getDecimal(strs[5]));
            biomassForestGrassland.setDryBiomass(getDecimal(strs[6]));
            if (!isCul){
                biomassForestGrassland.setPm10Emission(getDecimal(strs[7]));
                biomassForestGrassland.setPm25Emission(getDecimal(strs[8]));
                biomassForestGrassland.setCoEmission(getDecimal(strs[9]));
                biomassForestGrassland.setVocEmission(getDecimal(strs[10]));
                biomassForestGrassland.setSo2Emission(getDecimal(strs[11]));
                biomassForestGrassland.setNoxEmission(getDecimal(strs[12]));
                biomassForestGrassland.setNh3Emission(getDecimal(strs[13]));
                biomassForestGrassland.setOcEmission(getDecimal(strs[14]));
                biomassForestGrassland.setBcEmission(getDecimal(strs[15]));
            }else {
                //计算
            }
            biomassForestGrassland.setSourceDescrip(getSccDescribe(strs[0]));
            biomassForestGrasslandList.add(biomassForestGrassland);
        }
        biomassForestGrasslandMapper.insertList(biomassForestGrasslandList);
        return i;
    }
    public int importRoadMove(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkRatio(strs,4,5)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,5,19)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<RoadMove> roadMoveList=new ArrayList<>();
        for (String[] strs:list) {
            RoadMove roadMove=new RoadMove();
            roadMove.setScccode(strs[0]);
            roadMove.setYear(strs[1]);
            roadMove.setCountyId(strs[2]);
            roadMove.setFuelType(strs[3]);
            roadMove.setOrvrPercentage(getDecimal(strs[4]));
            roadMove.setCarFuelamount(getDecimal(strs[5]));
            roadMove.setAverageMile(getDecimal(strs[6]));
            roadMove.setCarAmount(getDecimal(strs[7]));
            roadMove.setCarSpeed(getDecimal(strs[8]));
            roadMove.setAverageSamount(getDecimal(strs[9]));
            if (!isCul){
                roadMove.setPm10Emission(getDecimal(strs[10]));
                roadMove.setPm25Emission(getDecimal(strs[11]));
                roadMove.setCoEmission(getDecimal(strs[12]));
                roadMove.setVocsEmission(getDecimal(strs[13]));
                roadMove.setSo2Emission(getDecimal(strs[14]));
                roadMove.setNoxEmission(getDecimal(strs[15]));
                roadMove.setNh3Emission(getDecimal(strs[16]));
                roadMove.setOcEmission(getDecimal(strs[17]));
                roadMove.setEcEmission(getDecimal(strs[18]));
            }else{
                //计算
            }
            roadMove.setSourceDiscrip(getSccDescribe(strs[0]));
            roadMoveList.add(roadMove);
        }
        roadMoveMapper.insertList(roadMoveList);
        return i;
    }
    public int importAgricultureMachinery(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkInteger(strs,4,5)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正整数！");
            }
            if (!checkPosDouble(strs,5,18)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<AgricultureMachinery> agricultureMachineryList=new ArrayList<>();
        for (String[] strs:list) {
            AgricultureMachinery agricultureMachinery=new AgricultureMachinery();
            agricultureMachinery.setSccCode(strs[0]);
            agricultureMachinery.setYear(strs[1]);
            agricultureMachinery.setCountyId(strs[2]);
            agricultureMachinery.setFuelType(strs[3]);
            agricultureMachinery.setHoldings(Integer.parseInt(strs[4]));
            agricultureMachinery.setFuelUsage(getDecimal(strs[5]));
            agricultureMachinery.setFuelAnnualUsage(getDecimal(strs[6]));
            agricultureMachinery.setAnnalAverageMilage(getDecimal(strs[7]));
            agricultureMachinery.setFuelSulfurContent(getDecimal(strs[8]));
            if (!isCul){
                agricultureMachinery.setPm10Emission(getDecimal(strs[9]));
                agricultureMachinery.setPm25Emission(getDecimal(strs[10]));
                agricultureMachinery.setCoEmission(getDecimal(strs[11]));
                agricultureMachinery.setVocsEmission(getDecimal(strs[12]));
                agricultureMachinery.setSo2Emission(getDecimal(strs[13]));
                agricultureMachinery.setNoxEmission(getDecimal(strs[14]));
                agricultureMachinery.setNh3Emission(getDecimal(strs[15]));
                agricultureMachinery.setOcEmission(getDecimal(strs[16]));
                agricultureMachinery.setBcEmission(getDecimal(strs[17]));
            }else{
                //计算
            }
            agricultureMachinery.setSourceDescrip(getSccDescribe(strs[0]));
            agricultureMachineryList.add(agricultureMachinery);
        }
        agricultureMachineryMapper.insertList(agricultureMachineryList);
        return i;
    }
    public int importAirplane(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,4,16)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<Airplane> airplaneList=new ArrayList<>();
        for (String[] strs:list) {
            Airplane airplane=new Airplane();
            airplane.setSccCode(strs[0]);
            airplane.setYear(strs[1]);
            airplane.setCountyId(strs[2]);
            airplane.setFuelType(strs[3]);
            airplane.setActivityLevel(getDecimal(strs[4]));
            airplane.setFuelAnnualUsage(getDecimal(strs[5]));
            airplane.setFuelSulfurUsage(getDecimal(strs[6]));
            if (!isCul){
                airplane.setPm10Emission(getDecimal(strs[7]));
                airplane.setPm25Emission(getDecimal(strs[8]));
                airplane.setCoEmission(getDecimal(strs[9]));
                airplane.setVocsEmission(getDecimal(strs[10]));
                airplane.setSo2Emission(getDecimal(strs[11]));
                airplane.setNoxEmission(getDecimal(strs[12]));
                airplane.setNh3Emission(getDecimal(strs[13]));
                airplane.setOcEmission(getDecimal(strs[14]));
                airplane.setBcEmission(getDecimal(strs[15]));
            }else{
                //计算
            }
            airplane.setSourceDescrip(getSccDescribe(strs[0]));
            airplaneList.add(airplane);
        }
        airplaneMapper.insertList(airplaneList);
        return i;
    }
    public int importNonroadMachinery(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,5,9)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,9,10)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,10,19)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<NonroadMachinery> nonroadMachineryList=new ArrayList<>();
        for (String[] strs:list) {
            NonroadMachinery nonroadMachinery=new NonroadMachinery();
            nonroadMachinery.setSccCode(strs[0]);
            nonroadMachinery.setYear(strs[1]);
            nonroadMachinery.setCountyId(strs[2]);
            nonroadMachinery.setFuelType(strs[3]);
            nonroadMachinery.setNonroadType(strs[4]);
            nonroadMachinery.setHoldings(Integer.parseInt(strs[5]));
            nonroadMachinery.setUseHours(getDecimal(strs[6]));
            nonroadMachinery.setAnnalAverageMileage(getDecimal(strs[7]));
            nonroadMachinery.setFuelAnnualUsage(getDecimal(strs[8]));
            nonroadMachinery.setFuelSulfurContent(getDecimal(strs[9]));
            if (!isCul){
                nonroadMachinery.setPm10Emission(getDecimal(strs[10]));
                nonroadMachinery.setPm25Emission(getDecimal(strs[11]));
                nonroadMachinery.setCoEmission(getDecimal(strs[12]));
                nonroadMachinery.setVocsEmission(getDecimal(strs[13]));
                nonroadMachinery.setSo2Emission(getDecimal(strs[14]));
                nonroadMachinery.setNoxEmission(getDecimal(strs[15]));
                nonroadMachinery.setNh3Emission(getDecimal(strs[16]));
                nonroadMachinery.setOcEmission(getDecimal(strs[17]));
                nonroadMachinery.setBcEmission(getDecimal(strs[18]));
            }else{
                //计算
            }
            nonroadMachinery.setSourceDescrip(getSccDescribe(strs[0]));
            nonroadMachineryList.add(nonroadMachinery);
        }
        nonroadMachineryMapper.insertList(nonroadMachineryList);
        return i;
    }
    public int importRailwayEngine(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,4,6)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,6,7)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,7,16)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<RailwayEngine> railwayEngineList=new ArrayList<>();
        for (String[] strs:list) {
            RailwayEngine railwayEngine=new RailwayEngine();
            railwayEngine.setSccCode(strs[0]);
            railwayEngine.setYear(strs[1]);
            railwayEngine.setCountyId(strs[2]);
            railwayEngine.setFuelType(strs[3]);
            railwayEngine.setFuelAnnualUsage(getDecimal(strs[4]));
            railwayEngine.setAnnalAverageMileage(getDecimal(strs[5]));
            railwayEngine.setFuelSulfurContent(getDecimal(strs[6]));
            if (!isCul){
                railwayEngine.setPm10Emission(getDecimal(strs[7]));
                railwayEngine.setPm25Emission(getDecimal(strs[8]));
                railwayEngine.setCoEmission(getDecimal(strs[9]));
                railwayEngine.setVocsEmission(getDecimal(strs[10]));
                railwayEngine.setSo2Emission(getDecimal(strs[11]));
                railwayEngine.setNoxEmission(getDecimal(strs[12]));
                railwayEngine.setNh3Emission(getDecimal(strs[13]));
                railwayEngine.setOcEmission(getDecimal(strs[14]));
                railwayEngine.setBcEmission(getDecimal(strs[15]));
            }else{
                //计算
            }
            railwayEngine.setSourceDescrip(getSccDescribe(strs[0]));
            railwayEngineList.add(railwayEngine);
        }
        railwayEngineMapper.insertList(railwayEngineList);
        return i;
    }
    public int importSmallMachinery(List<String[]> list,boolean isCul){
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,4,8)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,8,9)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,9,18)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        List<SmallMachinery> smallMachineryList=new ArrayList<>();
        for (String[] strs:list) {
            SmallMachinery smallMachinery=new SmallMachinery();
            smallMachinery.setSccCode(strs[0]);
            smallMachinery.setYear(strs[1]);
            smallMachinery.setCountyId(strs[2]);
            smallMachinery.setFuelType(strs[3]);
            smallMachinery.setHoldings(Integer.parseInt(strs[4]));
            smallMachinery.setFuelAnnualUsage(getDecimal(strs[5]));
            smallMachinery.setAnnalAverageMileage(getDecimal(strs[6]));
            smallMachinery.setUseHours(getDecimal(strs[7]));
            smallMachinery.setFuelSulfurContent(getDecimal(strs[8]));
            if (!isCul){
                smallMachinery.setPm10Emission(getDecimal(strs[9]));
                smallMachinery.setPm25Emission(getDecimal(strs[10]));
                smallMachinery.setCoEmission(getDecimal(strs[11]));
                smallMachinery.setVocsEmission(getDecimal(strs[12]));
                smallMachinery.setSo2Emission(getDecimal(strs[13]));
                smallMachinery.setNoxEmission(getDecimal(strs[14]));
                smallMachinery.setNh3Emission(getDecimal(strs[15]));
                smallMachinery.setOcEmission(getDecimal(strs[16]));
                smallMachinery.setBcEmission(getDecimal(strs[17]));
            }else{
                //计算
            }
            smallMachinery.setSourceDescrip(getSccDescribe(strs[0]));
            smallMachineryList.add(smallMachinery);
        }
        smallMachineryMapper.insertList(smallMachineryList);
        return i;
    }
    public int importRepast(List<String[]> list,boolean isCul){
        List<Repast> repastList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,9,19)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,19,20)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,20,29)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            Repast repast=new Repast();
            repast.setScccode(strs[0]);
            repast.setYear(strs[1]);
            repast.setFactoryid(getCompanyId(company));
            repast.setCookingNum(Integer.parseInt(strs[9]));
            repast.setSmokeRate(getDecimal(strs[10]));
            repast.setAnnualRuntime(Integer.parseInt(strs[11]));
            repast.setGasConsumption(getDecimal(strs[12]));
            repast.setCoalConsumption(getDecimal(strs[13]));
            repast.setCoalgasConsumption(getDecimal(strs[14]));
            repast.setPowerConsumption(getDecimal(strs[15]));
            repast.setMethanolConsumption(getDecimal(strs[16]));
            repast.setOtherConsumption(getDecimal(strs[17]));
            repast.setOilConsumption(getDecimal(strs[18]));
            repast.setRemovalEffi(getDecimal(strs[19]));
            if (!isCul){
                repast.setPm10Emission(getDecimal(strs[20]));
                repast.setPm25Emission(getDecimal(strs[21]));
                repast.setCoEmission(getDecimal(strs[22]));
                repast.setVocEmission(getDecimal(strs[23]));
                repast.setSo2Emission(getDecimal(strs[24]));
                repast.setNoxEmission(getDecimal(strs[25]));
                repast.setNh3Emission(getDecimal(strs[26]));
                repast.setOcEmission(getDecimal(strs[27]));
                repast.setBcEmission(getDecimal(strs[28]));
            }else {
                //计算
            }
            repast.setSourceDiscrip(getSccDescribe(strs[0]));
            repastList.add(repast);
        }
        repastMapper.insertList(repastList);
        return i;
    }
    public int importRepastFamily(List<String[]> list,boolean isCul){
        List<RepastFamily> repastFamilyList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!checkPosDouble(strs,3,12)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
            if (!checkRatio(strs,12,13)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~1小于"+integerNum+"位正浮点数！");
            }
            if (!checkPosDouble(strs,13,22)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            RepastFamily repastFamily=new RepastFamily();
            repastFamily.setScccode(strs[0]);
            repastFamily.setYear(strs[1]);
            repastFamily.setCountyId(strs[2]);
            repastFamily.setNonfarmNum(getDecimal(strs[3]));
            repastFamily.setFarmNum(getDecimal(strs[4]));
            repastFamily.setTotalNum(getDecimal(strs[5]));
            repastFamily.setSmokeRate(getDecimal(strs[6]));
            repastFamily.setAnnualRuntime(Integer.parseInt(strs[7]));
            repastFamily.setGasConsumption(getDecimal(strs[8]));
            repastFamily.setCoalConsumption(getDecimal(strs[9]));
            repastFamily.setOtherConsumption(getDecimal(strs[10]));
            repastFamily.setOilConsumption(getDecimal(strs[11]));
            repastFamily.setRemovalEffi(getDecimal(strs[12]));
            if (!isCul){
                repastFamily.setPm10Emission(getDecimal(strs[13]));
                repastFamily.setPm25Emission(getDecimal(strs[14]));
                repastFamily.setCoEmission(getDecimal(strs[15]));
                repastFamily.setVocEmission(getDecimal(strs[16]));
                repastFamily.setSo2Emission(getDecimal(strs[17]));
                repastFamily.setNoxEmission(getDecimal(strs[18]));
                repastFamily.setNh3Emission(getDecimal(strs[19]));
                repastFamily.setOcEmission(getDecimal(strs[20]));
                repastFamily.setBcEmission(getDecimal(strs[21]));
            }else {
                //计算
            }
            repastFamily.setSourceDiscrip(getSccDescribe(strs[0]));
            repastFamilyList.add(repastFamily);
        }
        repastFamilyMapper.insertList(repastFamilyList);
        return i;
    }
    public int importRepastBarbecue(List<String[]> list,boolean isCul){
        List<RepastBarbecue> repastBarbecueList=new ArrayList<>();
        int i=0;
        for (i=0;i<list.size();i++)   {
            String[] strs=list.get(i);
            if (getSccDescribe(strs[0])==null){
                throw new NullPointerException("第"+(i+1)+"行SCC编码错误，请仔细查验！");
            }
            if (!DateUtils.checkYear(strs[1])){
                throw new NullPointerException("第"+(i+1)+"行年份填写错误请查看！");
            }
            if (!checkCounty(strs[2])){
                throw new NullPointerException("第"+(i+1)+"行区县编码填写错误，请仔细查验！");
            }
            if (!NumberUtil.isLongitude(strs[6],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行经度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!NumberUtil.isLatitude(strs[7],integerNum)){
                throw new NullPointerException("第"+(i+1)+"行纬度错误，请填写正确的经纬度范围,且在0^18位！");
            }
            if (!checkPosDouble(strs,9,26)){
                throw new NullPointerException("第"+(i+1)+"行数字转换错误，请填写0~"+integerNum+"位正浮点数！");
            }
        }
        for (String[] strs:list) {
            Company company=new Company();
            company.setCountyId(strs[2]);
            company.setCompanyName(strs[3]);
            company.setCompanyCode(strs[4]);
            company.setAddress(strs[5]);
            company.setLongitude(getDecimal(strs[6]));
            company.setLatitude(getDecimal(strs[7]));
            company.setDomain(strs[8]);
            RepastBarbecue repastBarbecue=new RepastBarbecue();
            repastBarbecue.setScccode(strs[0]);
            repastBarbecue.setYear(strs[1]);
            repastBarbecue.setFactoryid(getCompanyId(company));
            repastBarbecue.setAnnualRuntime(Integer.parseInt(strs[9]));
            repastBarbecue.setGasConsumption(getDecimal(strs[10]));
            repastBarbecue.setCoalConsumption(getDecimal(strs[11]));
            repastBarbecue.setPowerConsumption(getDecimal(strs[12]));
            repastBarbecue.setMethanolConsumption(getDecimal(strs[13]));
            repastBarbecue.setOtherConsumption(getDecimal(strs[14]));
            repastBarbecue.setMealConsumption(getDecimal(strs[15]));
            repastBarbecue.setDayRunntime(getDecimal(strs[16]));
            if (!isCul){
                repastBarbecue.setPm10Emission(getDecimal(strs[17]));
                repastBarbecue.setPm25Emission(getDecimal(strs[18]));
                repastBarbecue.setCoEmission(getDecimal(strs[19]));
                repastBarbecue.setVocEmission(getDecimal(strs[20]));
                repastBarbecue.setSo2Emission(getDecimal(strs[21]));
                repastBarbecue.setNoxEmission(getDecimal(strs[22]));
                repastBarbecue.setNh3Emission(getDecimal(strs[23]));
                repastBarbecue.setOcEmission(getDecimal(strs[24]));
                repastBarbecue.setBcEmission(getDecimal(strs[25]));
            }else {
                //计算
            }
            repastBarbecue.setSourceDiscrip(getSccDescribe(strs[0]));
            repastBarbecueList.add(repastBarbecue);
        }
        repastBarbecueMapper.insertList(repastBarbecueList);
        return i;
    }
}
