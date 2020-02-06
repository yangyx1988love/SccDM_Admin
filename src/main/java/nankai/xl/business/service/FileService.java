package nankai.xl.business.service;

import nankai.xl.business.model.vo.FactoryQuery;

import java.util.List;

public interface FileService {
    public int importTempleFileToSource(String soureId, List<String[]> list,boolean isCul);
    public int importTempleFileToFactory(FactoryQuery factoryQuery, List<String[]> list);
}
