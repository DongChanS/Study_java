package Tutorial;
import java.util.Collection;
import java.util.Calendar;

public class CalenderTest {
    public static void main(String[] args) throws InterruptedException{
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.SECOND);
        Thread.sleep(3000);
        Calendar cal2 = Calendar.getInstance();
        System.out.println(cal.SECOND);
        System.out.println(cal2.SECOND);
        // 왜 전부 13이 출력될까?
    }
}
