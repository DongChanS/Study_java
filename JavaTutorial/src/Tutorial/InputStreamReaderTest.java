package Tutorial;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        char[] cbuf = new char[4];
        isr.read(cbuf);

        for (char c:cbuf){
            System.out.println(c);
        }
    }

}
