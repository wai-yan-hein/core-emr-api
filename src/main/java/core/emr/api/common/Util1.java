/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.emr.api.common;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author WSwe
 */

public class Util1 {
    public static String isNull(String strValue, String value) {
        if (strValue == null) {
            return value;
        } else if (strValue.isEmpty()) {
            return value;
        } else {
            return strValue;
        }
    }
    public static String toDateStr(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = null;

        try {
            strDate = formatter.format(date);
        } catch (Exception ex) {
            System.out.println("toDateStr Error : " + ex.getMessage());
        }

        return strDate;
    }

    public static Date getTodayDate() {
        return Calendar.getInstance().getTime();
    }
    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || obj.toString().isEmpty();
    }

}
