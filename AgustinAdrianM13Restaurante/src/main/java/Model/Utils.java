package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author adrian
 */
public class Utils {
    private static SimpleDateFormat inSDF = new SimpleDateFormat("dd/mm/yyyy");
    private static SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
  
    public static String formatDateToBD(String inDate) {
        String outDate = "";
        if (inDate != null) {
            try {
                Date date = inSDF.parse(inDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){ 
            }
        }
        return outDate;
  }
    public static String formatDateToTable(String inDate) {
        String outDate = "";
        if (inDate != null) {
            try {
                Date date = outSDF.parse(inDate);
                outDate = inSDF.format(date);
            } catch (ParseException ex){ 
            }
        }
        return outDate;
  }    
}
