package nankai.xl.common.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {
        /**
     * @Description:检测是否为整数
     */
    public final static boolean isNumeric(String s,int length) {
        if (s != null && !"".equals(s.trim())&& s.length()<length )
            return s.matches("^[0-9]*$");
        else
            return false;
    }
    /**
     * 检查整数
     * @param num
     * @param type "0+":非负整数 "+":正整数 "-0":非正整数 "-":负整数 "":整数
     * @return
     */
    public static boolean checkNumber(String num,String type){
        String eL = "";
        if(type.equals("0+"))eL = "^\\d+$";//非负整数
        else if(type.equals("+"))eL = "^\\d*[1-9]\\d*$";//正整数
        else if(type.equals("-0"))eL = "^((-\\d+)|(0+))$";//非正整数
        else if(type.equals("-"))eL = "^-\\d*[1-9]\\d*$";//负整数
        else eL = "^-?\\d+$";//整数
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(num);
        boolean b = m.matches();
        return b;
    }
    /**
     * 检查浮点数
     * @param num
     * @param type "0+":非负浮点数 "+":正浮点数 "-0":非正浮点数 "-":负浮点数 "":浮点数
     * @return 不包括科学计数法
     */
    public static boolean checkFloat(String num,String type){
        String eL = "";
        if(type.equals("0+"))eL = "^\\d+(\\.\\d+)?$";//非负浮点数
        else if(type.equals("+"))eL = "^((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*))$";//正浮点数
        else if(type.equals("-0"))eL = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";//非正浮点数
        else if(type.equals("-"))eL = "^(-((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*)))$";//负浮点数
        else eL = "^(-?\\d+)(\\.\\d+)?$";//浮点数
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(num);
        boolean b = m.matches();
        return b;
    }
    //包括科学计数法
    public static boolean isFloat(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        String regx = "[+-]*\\d+\\.?\\d*[Ee]*[+-]*\\d+";
        Pattern pattern = Pattern.compile(regx);
        boolean isNumber = pattern.matcher(str).matches();
        if (!isNumber) {
            return false;
        }
        regx = "^[-\\+]?[.\\d]*$";
        pattern = Pattern.compile(regx);
        return pattern.matcher(str).matches();
    }
    //验证正浮点数
    public static boolean isPosDouble(String num,int integerNum){
        if (!NumberUtil.isFloat(num)){
            return false;
        }
        if (num.indexOf(".")>integerNum){
            return false;
        }
        if (Double.valueOf(num)<0){
            return false;
        }
        return true;
    }
    public static boolean isRatio(String num,int integerNum){
        if (!NumberUtil.isFloat(num)){
            return false;
        }
        if (num.indexOf(".")>integerNum){
            return false;
        }
        if (Double.valueOf(num)<0){
            return false;
        }
        return true;
    }
    //检验经纬度
    public static boolean isLongitude(String longitude,int integerNum){
        if (!NumberUtil.isFloat(longitude)){
            return false;
        }
        if (longitude.indexOf(".")>integerNum){
            return false;
        }
        if (73>Double.valueOf(longitude)||Double.valueOf(longitude)>135){
            return false;
        }
        return true;
    }
    public static boolean isLatitude(String latitude,int integerNum){
        if (!NumberUtil.isFloat(latitude)){
            return false;
        }
        if (latitude.indexOf(".")>integerNum){
            return false;
        }
        if (3>Double.valueOf(latitude)||Double.valueOf(latitude)>53){
            return false;
        }
        return true;
    }
    public static double significand(double oldDouble, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "scale指定的精度为非负值");
        }
        /**
         * RoundingMode：舍入模式
         * UP：远离零方向舍入的舍入模式；
         * DOWN：向零方向舍入的舍入模式；
         * CEILING： 向正无限大方向舍入的舍入模式；
         * FLOOR：向负无限大方向舍入的舍入模式；
         * HALF_DOWN：向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向下舍入；
         * HALF_UP：向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向上舍入；
         * HALF_EVEN：向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入;(在重复进行一系列计算时,此舍入模式可以将累加错误减到最小)
         * UNNECESSARY：用于断言请求的操作具有精确结果的舍入模式，因此不需要舍入。
         */
        RoundingMode rMode =null;
        //rMode=RoundingMode.FLOOR;
        //下面这种情况，其实和FLOOR一样的。
        if(oldDouble>0){
            rMode=RoundingMode.DOWN;
        }else{
            rMode=RoundingMode.UP;
        }
        //此处的scale表示的是，几位有效位数
        BigDecimal b = new BigDecimal(Double.toString(oldDouble),new MathContext(scale,rMode));
        return b.doubleValue();
    }
    /**小数点之后保留几位小数(此处，我们用BigDecimal提供的（除以div）方法实现)
     * @param oldDouble
     * @param scale
     * @return
     */
    public static double decimal(double oldDouble, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(oldDouble));
        BigDecimal one = new BigDecimal("1");
        //return b.divide(one, scale, BigDecimal.ROUND_FLOOR).doubleValue();
        if(oldDouble>0){
            //此处的scale表示的是，小数点之后的精度。
            return b.divide(one, scale, BigDecimal.ROUND_DOWN).doubleValue();
        }else{
            return b.divide(one, scale, BigDecimal.ROUND_UP).doubleValue();
        }
    }
//    public static void main(String[] args) {
////        double d = 100000.54500000001;
////        int scale = 18;
////        double d1 = significand(d,scale);
////        double d2 = decimal(d,0);
////        System.out.println(d+"保留"+scale+"位有效数字："+d1);
////        System.out.println(d+"保留小数点之后"+scale+"位小数："+d2);
////        DecimalFormat df = new DecimalFormat("###");
////        BigDecimal b1 = new BigDecimal("288888888.010999999999");
////        BigDecimal b2 = new BigDecimal("288888888.010999999999");
////        System.out.println("小数格式化：" + df.format(b1));
////        System.out.println("整数格式化：" + df.format(b2));
//        System.out.println(Arith.round("1.888888888",2));
//    }
}
