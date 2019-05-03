package Tutorial;
import java.io.*;
import java.util.*;

public class TryCatchTest {
    FileInputStream fls;
    public TryCatchTest (String filename) throws FileNotFoundException {
        fls = new FileInputStream(filename);
        // java.io.FileNotFoundException 을 핸들하지 않음.
    }

    void readLine() {
        String s;
        BufferedReader buf = new BufferedReader(new InputStreamReader(fls));
        try {
            while ( (s = buf.readLine()) != null ){
                // java.io.IOException 을 핸들하지 않음.
                System.out.println(s);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        TryCatchTest inputFile = new TryCatchTest("data.txt");
        inputFile.readLine();
        System.out.println("성공적?");
    }
}
