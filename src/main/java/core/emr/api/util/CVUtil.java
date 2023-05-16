package core.emr.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CVUtil {
    public static LocalDate convertToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime convertToLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String getStrValue(String value, String retValue){
        if(value == null){
            return retValue;
        }else if(value.trim().isEmpty()){
            return retValue;
        }else{
            return value;
        }
    }
}
