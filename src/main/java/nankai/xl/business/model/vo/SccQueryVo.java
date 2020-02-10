package nankai.xl.business.model.vo;

public class SccQueryVo {
    private String scc1;

    private String scc2;

    private String scc3;

    private String scc4;

    private String sccCode;

    public String getScc1() {
        return scc1;
    }

    public void setScc1(String scc1) {
        this.scc1 = scc1;
    }

    public String getScc2() {
        return scc2;
    }

    public void setScc2(String scc2) {
        this.scc2 = scc2;
    }

    public String getScc3() {
        return scc3;
    }

    public void setScc3(String scc3) {
        this.scc3 = scc3;
    }

    public String getScc4() {
        return scc4;
    }

    public void setScc4(String scc4) {
        this.scc4 = scc4;
    }

    public String getSccCode() {
        if (scc1!=null){
            this.sccCode=scc1;
        }
        if (scc2!=null){
            this.sccCode+=scc2;
        }
        if (scc3!=null){
            this.sccCode+=scc3;
        }
        if (scc4!=null){
            this.sccCode+=scc4;
        }
        return sccCode;
    }

    public void setSccCode(String sccCode) {
        this.sccCode = sccCode;
    }
}
