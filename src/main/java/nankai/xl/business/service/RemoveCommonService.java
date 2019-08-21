package nankai.xl.business.service;

import nankai.xl.business.model.Dustremove;
import nankai.xl.business.model.Nitreremove;
import nankai.xl.business.model.Sulphurremove;

public interface RemoveCommonService {
    //所有排放物去除方法公共查询类，包括：除尘、脱销
    public Dustremove getDustremoveById(Integer id);
    public Nitreremove getNitrremoveById(Integer id);
    public Sulphurremove getSulphurremoveById(Integer id);
}
