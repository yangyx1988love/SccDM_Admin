package nankai.xl.business.service;

import nankai.xl.business.model.Scc;
import nankai.xl.business.model.Scc2;

import java.util.List;

public interface SccService {
    public Scc getSccByScc(String scc);
    public <T> T culByscc(String sccCode,Class<T> tClass);
}
