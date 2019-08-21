package nankai.xl.business.mapper;

import nankai.xl.business.model.RoleAudit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleAuditMapper {
    RoleAudit selectByRodeId(Integer roleId);
}