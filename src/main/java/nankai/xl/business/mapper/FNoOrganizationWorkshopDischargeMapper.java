package nankai.xl.business.mapper;

import java.util.List;
import nankai.xl.business.model.FNoOrganizationWorkshopDischarge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FNoOrganizationWorkshopDischargeMapper {
    List<FNoOrganizationWorkshopDischarge> selectByFactoryId(Integer factoryId);
    FNoOrganizationWorkshopDischarge selectById(Integer wsid);
    int updateById(FNoOrganizationWorkshopDischarge fNoOrganizationWorkshopDischarge);
}