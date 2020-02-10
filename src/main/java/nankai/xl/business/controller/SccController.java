package nankai.xl.business.controller;

import com.github.pagehelper.PageInfo;
import nankai.xl.business.model.*;
import nankai.xl.business.model.vo.SccQueryVo;
import nankai.xl.business.model.vo.SccResultVo;
import nankai.xl.business.service.SccService;
import nankai.xl.business.service.SelectCommonService;
import nankai.xl.common.annotation.OperationLog;
import nankai.xl.common.util.PageResultBean;
import nankai.xl.common.util.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/factoryAuth")
public class SccController {
    @Resource
    private SelectCommonService selectCommonService;
    @Resource
    private SccService sccService;

    @OperationLog("排放因子管理")
    @GetMapping("/scc")
    public String scc(Model model) {
        model.addAttribute("scc1s", selectCommonService.getAllScc1s());
        return "scc/index";
    }
    @OperationLog("排放因子管理-列表")
    @GetMapping("/scc/list")
    @ResponseBody
    public PageResultBean<SccResultVo> seleScc(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "50")int limit,
                                               SccQueryVo sccQueryVo) {
        List<SccResultVo> results=sccService.getBySccQuery(sccQueryVo,page,limit);
        PageInfo<SccResultVo> PageInfo = new PageInfo<>(results);
        return new PageResultBean<>(PageInfo.getTotal(), PageInfo.getList());
    }
    @OperationLog("排放因子-界面")
    @GetMapping("/scc/{scc}/edit")
    public String scc(@PathVariable("scc") String scc,Model model) {
        model.addAttribute("scc", sccService.getSccById(scc));
        return "scc/scc";
    }
    @OperationLog("排放因子-修改")
    @PostMapping("/scc/{scc}/update")
    @ResponseBody
    public ResultBean updateScc(@PathVariable("scc") String scc, Scc sccc) {
        sccService.updateSccById(sccc);
        return ResultBean.success();
    }
    @OperationLog("排放因子-增加")
    @GetMapping("/scc/{level}/add")
    public String sccAdd(@PathVariable("level") String level,SccQueryVo sccQueryVo,Model model) {
        //model.addAttribute("scc", sccService.getSccById(scc));
        return "scc/scc-add";
    }
}
