package Tutorial;
import java.io.IOException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class FileTest {
    public static void main(String[] args) throws IOException, URISyntaxException{
        String dirName = "c:" + File.separator + "Temp" + File.separator + "mydir";
        File file1 = new File(dirName);
        File file2 = new File(dirName, "test2.txt");
        File file3 = new File(new URI("file:///c:/Temp/test4.txt"));
        file1.mkdir();
        file2.createNewFile();
        file3.createNewFile();
        file3.deleteOnExit(); // 어플이 종료되면서 삭제됨.
    }
}
