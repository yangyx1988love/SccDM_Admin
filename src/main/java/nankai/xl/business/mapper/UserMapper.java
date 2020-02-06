package nankai.xl.business.mapper;
import nankai.xl.business.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertSelective(User user);
    User selectByFactoryId(Integer factoryId);
    int insertOrUpdate(User user);
}