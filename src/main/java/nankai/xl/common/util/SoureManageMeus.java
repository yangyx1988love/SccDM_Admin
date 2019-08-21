package nankai.xl.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SoureManageMeus {
    public static Map<Integer,String> sourcenames;
    public static Map<Integer,String> getSourcenames() {
        sourcenames.put(1,"散煤");
        sourcenames.put(2,"石化有组织废气排放");
        sourcenames.put(3,"装置密封点");
        sourcenames.put(4,"废水无组织排放");
        sourcenames.put(5,"VOC处理装置");
        sourcenames.put(6,"干洗店");
        sourcenames.put(7,"汽修店");
        sourcenames.put(8,"道路铺装");
        sourcenames.put(9,"建筑涂装二手房");
        sourcenames.put(10,"家庭家居");
        sourcenames.put(11,"去污油脂");
        sourcenames.put(12,"土壤扬尘源");
        sourcenames.put(13,"道路扬尘源");
        sourcenames.put(14,"施工扬尘源");
        sourcenames.put(15,"堆场装卸扬尘源");
        sourcenames.put(16,"堆场风蚀扬尘源");
        sourcenames.put(17,"储罐存储");
        sourcenames.put(18,"加气站");
        sourcenames.put(19,"加油站");
        sourcenames.put(20,"装载过程排放");
        sourcenames.put(21,"农药施用");
        sourcenames.put(22,"畜牧集约化养殖源");
        sourcenames.put(23,"畜牧散养源");
        sourcenames.put(24,"农业施肥源");
        sourcenames.put(25,"土壤本低源");
        sourcenames.put(26,"固氮植物源");
        sourcenames.put(27,"秸秆堆肥源");
        sourcenames.put(28,"天然源");
        sourcenames.put(29,"道路移动源");
        sourcenames.put(30,"农运运输车");
        sourcenames.put(31,"铁路内燃机");
        sourcenames.put(32,"小型通用机械");
        sourcenames.put(33,"非道路机械");
        sourcenames.put(34,"民航飞机");
        sourcenames.put(35,"社会餐饮");
        sourcenames.put(36,"家庭餐饮");
        sourcenames.put(37,"烧烤餐饮");

        return sourcenames;
    }
}
