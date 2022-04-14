package design_1.utils;

public class CommonUtil {
    //all millis within a day should be equal
    public static Long getDateEquivalent(Long millis){
        return millis/1000/60/60/24;
    }
    public static Long getMillisForDays(Long days){
        return days*24*60*60*1000;
    }
}
