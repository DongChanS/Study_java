package Tutorial;
import java.util.Collection;
import java.util.Calendar;

public class CalenderTest {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        System.out.println(hour);
    }
}
