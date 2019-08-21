package nankai.xl.system.service;

import nankai.xl.system.mapper.RoleOperatorMapper;
import nankai.xl.system.model.RoleOperator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleOperatorService{

    @Resource
    private RoleOperatorMapper roleOperatorMapper;

    public int insert(RoleOperator roleOperator){
        return roleOperatorMapper.insert(roleOperator);
    }

    public int insertSelective(RoleOperator roleOperator){
        return roleOperatorMapper.insertSelective(roleOperator);
    }

}
