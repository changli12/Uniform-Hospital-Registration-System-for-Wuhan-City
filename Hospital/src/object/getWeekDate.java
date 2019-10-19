package object;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class getWeekDate {
	public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) ;
        if (w < 0)
            w = 0;
       int hour=cal.get(Calendar.HOUR_OF_DAY);
       if(hour<=12)
        return weekDays[w]+"1";
       else
    	   return weekDays[w]+"2";
    }
	
}
