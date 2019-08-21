package nankai.xl.system.service;

import com.github.pagehelper.PageHelper;
import nankai.xl.system.mapper.SysLogMapper;
import nankai.xl.system.model.SysLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    public List<SysLog> selectAll(int page, int rows) {
        PageHelper.startPage(page, rows);
        return sysLogMapper.selectAll();
    }

    public int count() {
        return sysLogMapper.count();
    }
}
