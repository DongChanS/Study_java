package Tutorial;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MonitorTakeTest {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        OutputStream os = System.out;
        byte[] bytes = new byte[6];
        is.read(bytes);

//        for (byte bt : bytes) {
//            os.write(bt);
//            System.out.println();
//        }
        for (byte bt : bytes){
            System.out.println(bt);
        }
    }
}
