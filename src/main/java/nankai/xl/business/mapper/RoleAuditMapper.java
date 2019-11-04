package nankai.xl.business.mapper;

import nankai.xl.business.model.RoleAudit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleAuditMapper {
    List<RoleAudit> selectAll();
    RoleAudit selectByRodeId(Integer roleId);
}