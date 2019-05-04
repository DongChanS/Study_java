package Tutorial;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class CopyTest {
    public static void main(String[] args){
        String src_path = "C:" + File.separator + "Windows" + File.separator + "explorer.exe";
        String tg_path = "C:" + File.separator + "temp" + File.separator + "explorer.exe";
        File source = new File(src_path);
        File target = new File(tg_path);

        try {
            FileInputStream input = new FileInputStream(source);
            FileOutputStream output = new FileOutputStream(target);
            byte[] buffer = new byte[100];
            int read;
            while ((read = input.read(buffer)) > 0 ){
                output.write(buffer, 0, read);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
