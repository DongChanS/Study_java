package Tutorial;

public class SleepTest {

    public static void main(String[] args) throws InterruptedException{
        String infos[] = {"first","second","third","fourth"};

        for (int i=0; i<infos.length; i++){
            Thread.sleep(2000);
            System.out.println(infos[i]);
        }
    }
}
