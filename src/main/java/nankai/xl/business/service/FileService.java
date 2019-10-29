package nankai.xl.business.service;

import java.util.List;

public interface FileService {
    public int importTempleFileToSource(String soureId, List<String[]> list,boolean isCul);
}
