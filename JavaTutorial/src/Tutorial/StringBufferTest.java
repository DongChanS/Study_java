package Tutorial;
import java.lang.StringBuffer;

public class StringBufferTest {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append('2');
        sb.append(" Hello World! ");
        System.out.println(sb.toString());
        sb.insert(6, "Good");
        System.out.println(sb.toString());
        System.out.println(sb.substring(0, 3));
    }
}
