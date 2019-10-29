package nankai.xl.common.util;

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
        if (isNumber) {
            return isNumber;
        }
        regx = "^[-\\+]?[.\\d]*$";
        pattern = Pattern.compile(regx);
        return pattern.matcher(str).matches();
    }
    //验证正浮点数
    public static boolean isDouble(String num,int length){
        if (!NumberUtil.isFloat(num)){
            return false;
        }
        if(String.valueOf(Double.valueOf(num)).length()>length||Double.valueOf(num)<0){
            return false;
        }
        return true;
    }
    public static boolean isRatio(String num,int length){
        if (!NumberUtil.isFloat(num)){
            return false;
        }
        if(String.valueOf(Double.valueOf(num)).length()>length||Double.valueOf(num)<0||Double.valueOf(num)>1){
            return false;
        }
        return true;
    }
    //检验经纬度
    public static boolean isLongitude(String longitude){
        String reglo = "((?:[0-9]|[1-9][0-9]|1[0-7][0-9])\\.([0-9]{0,6}))|((?:180)\\.([0]{0,6}))";
        longitude = longitude.trim();
        return longitude.matches(reglo);
    }
    public static boolean isLatitude(String latitude){
        String regla = "((?:[0-9]|[1-8][0-9])\\.([0-9]{0,6}))|((?:90)\\.([0]{0,6}))";
        latitude = latitude.trim();
        return latitude.matches(regla);
    }
}
